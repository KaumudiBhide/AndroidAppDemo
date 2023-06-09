package demoapps.android.bookcab;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import demoapps.android.bookcab.adapters.FlagAdapater;
import demoapps.android.bookcab.data.models.FlagCard;
import demoapps.android.bookcab.ui.models.BaseActivity;

public class FlagsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flags);

        RecyclerView recyclerView = (RecyclerView) findViewById(
                R.id.recyclerView);

        List<FlagCard> list = new ArrayList<>();
        list = getData();

        FlagAdapater adapter = new FlagAdapater(list, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(this));

    }

    // Flag data for RecyclerView
    private List<FlagCard> getData()
    {
        List<FlagCard> list = new ArrayList<>();
        for(int i=0; i<Globals.COUNTRIES.length; i++) {
            list.add(new FlagCard(Globals.FLAGS[i],
                    Globals.COUNTRIES[i]));
        }

        return list;
    }

}