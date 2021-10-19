package lexcourse.android.infycabs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CardAdapater extends BaseAdapter {

    private Context mContext;
    private ArrayList<Card> mCards;

    CardAdapater(Context c) {
        mContext = c;
        mCards = new ArrayList<Card>();
    }

    CardAdapater(Context c, ArrayList<Card> cardList) {
        mContext = c;
        mCards = cardList;
    }

    public int getCount() {
        return mCards.size();
    }

    public Object getItem(int position) {
        return mCards.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(final int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.view_card, parent, false);
        }

        final Card curCard = mCards.get(position);

        ImageView cardIcon = convertView.findViewById(R.id.cardIcon);
        cardIcon.setImageResource(curCard.getIcon());

        TextView cardLabel = convertView.findViewById(R.id.cardLabel);
        cardLabel.setText(curCard.getLabel());

        return convertView;
    }
}