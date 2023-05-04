package demoapps.android.bookcab.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import demoapps.android.bookcab.R;
import demoapps.android.bookcab.data.models.HistoryCard;
import demoapps.android.bookcab.ui.models.HistoryCardView;

public class HistoryCardAdapater extends RecyclerView.Adapter<HistoryCardView> {

    List<HistoryCard> list;
    Context context;

    public HistoryCardAdapater(List<HistoryCard> list,
                               Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public HistoryCardView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context
                = parent.getContext();
        LayoutInflater inflater
                = LayoutInflater.from(context);

        // Inflate the layout
        View viewCountryCard
                = inflater
                .inflate(R.layout.view_history_card,
                        parent, false);

        return new HistoryCardView(viewCountryCard);
    }

    @Override
    public void onBindViewHolder(@NonNull final HistoryCardView viewHolder,
                                 final int position) {
        HistoryCard cardData = this.list.get(position);
        viewHolder.bindData(cardData);
    }

    @Override
    public int getItemCount() {
        return this.list.size();
    }

    @Override
    public void onViewAttachedToWindow(@NonNull HistoryCardView holder) {
        super.onViewAttachedToWindow(holder);
    }
}
