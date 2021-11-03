package lexcourse.android.infycabs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

import lexcourse.android.infycabs.adapters.RideCardAdapater;
import lexcourse.android.infycabs.data.models.RideCard;
import lexcourse.android.infycabs.events.OnRideSelectedListener;
import lexcourse.android.infycabs.events.RideSelectedEvent;

public class RideActivity extends AppCompatActivity
    implements OnRideSelectedListener {

    LinearLayout layoutTitle;
    TextView txtTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ride);
        setTitle(R.string.titleRide);

        layoutTitle = findViewById(R.id.layoutTitle);
        txtTitle = layoutTitle.findViewById(R.id.txtTitle);
        txtTitle.setText(R.string.select_ride);

        populateListView();
    }

    private void populateListView() {
        ListView listView = findViewById(R.id.listRide);

        RideCardAdapater adapater = new RideCardAdapater(this, getRideCards());
        adapater.setOnRideSelectedListener(this);
        listView.setAdapter(adapater);
    }

    private ArrayList<RideCard> getRideCards() {
        ArrayList<RideCard> rideCards = new ArrayList<RideCard>();

        for(int i=0; i<Globals.RIDE_CARS.length; i++) {
            RideCard rideCard = new RideCard();
            rideCard.setRideCarImg(Globals.RIDE_CARS[i]);
            rideCard.setRideName(Globals.RIDE_NAMES[i]);
            rideCards.add(rideCard);
        }

        return rideCards;
    }

    @Override
    public void onRideSelected(RideSelectedEvent e) {
        MaterialCardView materialCardView = ((MaterialCardView)e.getCardView());
        materialCardView.setChecked(true);
        Log.d(Globals.LOG_TAG, "Ride selected");
        Globals.isNewUser = true;
        Intent intent = new Intent(this, LocationActivity.class);
        startActivity(intent);
    }
}
