package lexcourse.android.infycabs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import lexcourse.android.infycabs.adapters.HistoryCardAdapater;
import lexcourse.android.infycabs.base.RideDate;
import lexcourse.android.infycabs.data.models.HistoryCard;
import lexcourse.android.infycabs.ui.models.BaseActivity;

public class HistoryActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        setTitle(R.string.titleHistory);

        RecyclerView recyclerView = (RecyclerView) findViewById(
                R.id.recyclerView);

        List<HistoryCard> list = new ArrayList<>();
        list = getData();

        HistoryCardAdapater adapter = new HistoryCardAdapater(list, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(this));
        recyclerView.addItemDecoration(
                new DividerItemDecoration(recyclerView.getContext(),
                        DividerItemDecoration.VERTICAL));
    }

    // History data for RecyclerView
    private List<HistoryCard> getData()
    {
        List<HistoryCard> list = new ArrayList<>();
        list.add(new HistoryCard());

        for(int i=0; i<5; i++) {
            HistoryCard card = new HistoryCard();
            card.setRideCarImg(Globals.RIDE_CARS[i]);
            card.setRideName(Globals.RIDE_NAMES[i]);

            card.strPickUpAddr = Globals.USER_RIDES_PICK_UPS[i/2];
            card.strDropOffAddr = Globals.USER_RIDES_DROP_OFFS[i/2];

            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.YEAR, 2021);
            cal.set(Calendar.MONTH, (i*2));
            cal.set(Calendar.DAY_OF_MONTH, i);
            cal.set(Calendar.HOUR, (i*10));
            cal.set(Calendar.MINUTE, (i*5));

            card.date = new RideDate();
            card.date.setValue(cal.getTime());
            card.rideAmount.value = 10 + (i * 3);

            list.add(card);
        }
        return list;
    }
}
