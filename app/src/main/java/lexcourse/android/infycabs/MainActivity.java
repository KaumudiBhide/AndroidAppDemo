package lexcourse.android.infycabs;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
    implements GridView.OnItemClickListener {

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
            LoginBottomSheet bottomSheet = new LoginBottomSheet();
            bottomSheet.show(getSupportFragmentManager(),
                    "ModalBottomSheet");
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
            /*OffersBottomSheet bottomSheet = new OffersBottomSheet();
            bottomSheet.show(getSupportFragmentManager(),
                    "ModalBottomSheet");*/
        }

        Log.d(LOG_TAG, label);

        if(activityClass!=null) {
            Intent intent = new Intent(this, activityClass);
            startActivity(intent);
        }
    }
}
