package lexcourse.android.infycabs;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

import lexcourse.android.infycabs.adapters.CardAdapater;
import lexcourse.android.infycabs.data.models.Card;
import lexcourse.android.infycabs.data.models.User;
import lexcourse.android.infycabs.events.NewUserEvent;
import lexcourse.android.infycabs.events.OnNewUserListener;
import lexcourse.android.infycabs.ui.models.BaseActivity;

public class MainActivity extends BaseActivity
    implements GridView.OnItemClickListener,
    View.OnClickListener,
        OnNewUserListener {

    public static final String[] LABELS = { "Profile", "Ride",
                                            "History", "Offers" };
    public static final int[] ICONS
            = { R.drawable.ic_profile, R.drawable.ic_ride,
                R.drawable.ic_history, R.drawable.ic_offers };

    public static final Class[] CLASS
            = new Class[]{ProfileActivity.class, RideActivity.class,
            HistoryActivity.class, OffersActivity.class};

    private View dialogLayout;
    private AlertDialog alert;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(R.string.titleHome);

        MaterialButton btnLogout = findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(this);

        populateGridView();

        loadLoginCredentials();
    }

    private void loadLoginCredentials() {
        if(!Globals.isUserLoggedIn) {
            LoginBottomSheet bottomSheet = new LoginBottomSheet(this);
            bottomSheet.setOnNewUserListener(this);
            bottomSheet.show(getSupportFragmentManager(),
                    "ModalBottomSheet");
        }
        else {
            Globals.rideUser = new User();
            SharedPreferences preferences = getSharedPreferences(
                    Globals.PREF_FILE, Context.MODE_PRIVATE);
            Globals.rideUser.name = preferences.getString(
                    Globals.USER_NAME, User.DEFAULT_USER);
            Globals.rideUser.email = preferences.getString(
                    Globals.EMAIL, User.DEFAULT_EMAIL);
            updatePreferences();
        }

    }

    private void populateGridView() {
        GridView gridView = findViewById(R.id.gridCards);

        CardAdapater adapater = new CardAdapater(this, getCards());
        gridView.setAdapter(adapater);
        gridView.setOnItemClickListener(this);
    }

    private ArrayList<Card> getCards() {
        ArrayList<Card> cards = new ArrayList<Card>();

        for(int i=0; i<LABELS.length; i++) {
            Card card = new Card();
            card.setLabel(LABELS[i]);
            card.setIcon(ICONS[i]);
            cards.add(card);
        }

        return cards;
    }

    public void onItemClick(AdapterView<?> parent,
                            View view,
                            int position,
                            long id) {
        String label = (String)((TextView)view
                            .findViewById(R.id.cardLabel)).getText();

        Class activityClass = null;

        for(int i=0; i<LABELS.length; i++) {
            if(label.equals(LABELS[i]))
                activityClass = CLASS[i];
        }

        if(activityClass!=null) {
            Log.d(Globals.LOG_TAG, label);
            Intent intent = new Intent(this, activityClass);
            startActivity(intent);
        }
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.txtRegisterLink) {
            Log.d(Globals.LOG_TAG, "Register new user");
            Globals.isNewUser = true;
            Intent intent = new Intent(this, RegisterActivity.class);
            startActivity(intent);
        }
        else if(view.getId() == R.id.btnLogout) {
            // clear prefernces
            clearPreferences();
            // clear global user data
            Globals.rideUser.clearProfile();

            // re-load preferences
            loadPreferences();
            // re-load login
            loadLoginCredentials();
        }
    }

    @Override
    public void onNewUser(NewUserEvent e) {
        Log.d(Globals.LOG_TAG, "New user wants to register");
        Globals.isNewUser = true;
        RegisterBottomSheet bottomSheet = new RegisterBottomSheet();
        bottomSheet.show(getSupportFragmentManager(),
                "ModalBottomSheet");
    }
}
