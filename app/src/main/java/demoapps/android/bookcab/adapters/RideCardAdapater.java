package demoapps.android.bookcab.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import demoapps.android.bookcab.events.OnRideSelectedListener;
import demoapps.android.bookcab.R;
import demoapps.android.bookcab.data.models.RideCard;
import demoapps.android.bookcab.events.RideSelectedEvent;

public class RideCardAdapater extends BaseAdapter
        implements View.OnClickListener {

    private final Context mContext;
    private final ArrayList<RideCard> mRideCards;
    private OnRideSelectedListener listener = null;

    RideCardAdapater(Context c) {
        mContext = c;
        mRideCards = new ArrayList<RideCard>();
    }

    public RideCardAdapater(Context c, ArrayList<RideCard> rideCardList) {
        mContext = c;
        mRideCards = rideCardList;
    }

    public int getCount() {
        return mRideCards.size();
    }

    public Object getItem(int position) {
        return mRideCards.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(final int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.view_ride_card, parent, false);
        }

        convertView.setOnClickListener(this);

        final RideCard curCard = mRideCards.get(position);

        ImageView imgRide = convertView.findViewById(R.id.imgRide);
        imgRide.setImageResource(curCard.getRideCarImg());

        TextView txtRideName = convertView.findViewById(R.id.txtRideName);
        txtRideName.setText(curCard.getRideName());

        return convertView;
    }

    public void setOnRideSelectedListener(OnRideSelectedListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if(listener!=null)
            listener.onRideSelected(new RideSelectedEvent(view));
    }
}