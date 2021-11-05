package lexcourse.android.infycabs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import lexcourse.android.infycabs.adapters.FlagAdapater;
import lexcourse.android.infycabs.adapters.HistoryCardAdapater;
import lexcourse.android.infycabs.data.models.FlagCard;
import lexcourse.android.infycabs.data.models.HistoryCard;

public class HistoryActivity extends AppCompatActivity {

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

        return list;
    }
}
