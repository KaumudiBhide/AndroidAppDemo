package lexcourse.android.infycabs.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import lexcourse.android.infycabs.Globals;
import lexcourse.android.infycabs.R;
import lexcourse.android.infycabs.data.models.FlagCard;
import lexcourse.android.infycabs.data.models.HistoryCard;
import lexcourse.android.infycabs.ui.models.FlagCardView;

public class HistoryCardAdapater extends RecyclerView.Adapter<FlagCardView> {

    List<HistoryCard> list;
    Context context;

    public HistoryCardAdapater(List<HistoryCard> list,
                               Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public FlagCardView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context
                = parent.getContext();
        LayoutInflater inflater
                = LayoutInflater.from(context);

        // Inflate the layout
        View viewCountryCard
                = inflater
                .inflate(R.layout.view_history_card,
                        parent, false);

        return new FlagCardView(viewCountryCard);
    }

    @Override
    public void onBindViewHolder(@NonNull final FlagCardView viewHolder,
                                 final int position) {
        /*viewHolder.getTxtCountry().setText(Globals.COUNTRIES[position]);
        ImageView imageView = viewHolder.getImgFlag();
        int resId = Globals.FLAGS[position];
        Picasso.get()
                .load(resId)
                .fit()
                .into(imageView);*/
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    @Override
    public void onViewAttachedToWindow(@NonNull FlagCardView holder) {
        super.onViewAttachedToWindow(holder);
    }
}
