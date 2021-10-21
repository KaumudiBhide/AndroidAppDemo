package lexcourse.android.infycabs;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

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

    private View dialogLayout;
    private AlertDialog alert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(R.string.titleHome);

        populateGridView();

        if(!Globals.isUserLoggedIn) {
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bottomSheet.show(getSupportFragmentManager(),
                    "ModalBottomSheet");
        }

        //if(!isUserLoggedIn)
        //    showAlertDialog();

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
        // retrieve entered credentials
        TextInputLayout editUserName = dialogLayout.findViewById(R.id.editUserName);
        TextInputLayout editPassword = dialogLayout.findViewById(R.id.editPassword);

        // show user logged in
        String strUser = editUserName.getEditText().getText().toString();
        String strCredentials = "User " + strUser + " logged in";
        Toast.makeText(MainActivity.this, strCredentials,Toast.LENGTH_LONG).show();

        Globals.isUserLoggedIn = true;
        alert.cancel();
    }

    private void onRegister(View view) {
        Intent intent = new Intent(this, OffersActivity.class);
        startActivity(intent);
    }
}
