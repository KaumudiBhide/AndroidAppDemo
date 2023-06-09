package demoapps.android.bookcab;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

import demoapps.android.bookcab.adapters.RideCardAdapater;
import demoapps.android.bookcab.data.models.RideCard;
import demoapps.android.bookcab.events.OnRideSelectedListener;
import demoapps.android.bookcab.events.RideSelectedEvent;
import demoapps.android.bookcab.ui.models.BaseActivity;

public class RideActivity extends BaseActivity
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
