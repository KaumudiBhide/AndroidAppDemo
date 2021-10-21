package lexcourse.android.infycabs;

import android.content.DialogInterface;
import android.content.Intent;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
    implements GridView.OnItemClickListener,
    View.OnClickListener {

    public static final String LOG_TAG = "InfyCabs";

    public static final String[] LABELS = { "Profile", "Ride",
                                            "History", "Offers" };
    public static final int[] ICONS
            = { R.drawable.ic_profile, R.drawable.ic_ride,
                R.drawable.ic_history, R.drawable.ic_offers };

    public static boolean isUserLoggedIn = false;

    private View dialogLayout;
    private AlertDialog alert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(R.string.titleHome);

        populateGridView();

        if(!isUserLoggedIn)
            showAlertDialog();

        TextView txtRegister = findViewById(R.id.txtRegister);
        //txtRegister.setOnClickListener(this::onRegister);
    }

    private void showAlertDialog() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
        dialogLayout = getLayoutInflater().inflate(R.layout.view_login, null);
        alertDialog.setView(dialogLayout);
        Button btnLogin = dialogLayout.findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);
        alert = alertDialog.create();
        alert.setCanceledOnTouchOutside(false);
        alert.show();
    }

    private void populateGridView() {
        GridView gridView = findViewById(R.id.gridCards);

        CardAdapater adapater = new CardAdapater(this, getCards());
        gridView.setAdapter(adapater);
        gridView.setOnItemClickListener(this);
    }

    private ArrayList<Card> getCards() {
        ArrayList<Card> cards = new ArrayList<Card>();

        Card card = new Card();
        card.setLabel(LABELS[0]);
        card.setIcon(ICONS[0]);
        cards.add(card);

        card = new Card();
        card.setLabel(LABELS[1]);
        card.setIcon(ICONS[1]);
        cards.add(card);

        card = new Card();
        card.setLabel(LABELS[2]);
        card.setIcon(ICONS[2]);
        cards.add(card);

        card = new Card();
        card.setLabel(LABELS[3]);
        card.setIcon(ICONS[3]);
        cards.add(card);

        return cards;
    }

    public void onItemClick(AdapterView<?> parent,
                            View view,
                            int position,
                            long id) {
        String label = (String)((TextView)view
                            .findViewById(R.id.cardLabel)).getText();

        Class activityClass = null;

        if(label.equals(LABELS[0]))
        {
            activityClass = ProfileActivity.class;
        }
        else if(label.equals(LABELS[1]))
        {
            activityClass = RideActivity.class;
        }
        else if(label.equals(LABELS[2]))
        {
            activityClass = HistoryActivity.class;
        }
        else if(label.equals(LABELS[3]))
        {
            activityClass = OffersActivity.class;
        }

        Log.d(LOG_TAG, label);

        Intent intent = new Intent(this, activityClass);
        startActivity(intent);
    }

    public void onClick(View view) {
        // send data from the AlertDialog to the Activity
        EditText editUserName = dialogLayout.findViewById(R.id.editUserName);
        EditText editPassword = dialogLayout.findViewById(R.id.editPassword);
        String strCredentials = "User " + editUserName.getText().toString() + " logged in";
        Toast.makeText(MainActivity.this, strCredentials,Toast.LENGTH_LONG).show();
        isUserLoggedIn = true;
        alert.cancel();
    }

    private void onRegister(View view) {
        Intent intent = new Intent(this, OffersActivity.class);
        startActivity(intent);
    }
}
