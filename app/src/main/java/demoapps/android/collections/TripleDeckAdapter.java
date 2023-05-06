package demoapps.android.collections;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.LinkedList;

import demoapps.android.bookcab.R;

public class TripleDeckAdapter extends BaseAdapter {

    private Context mContext;
    private LinkedList<GmCard> mSuitOpen;

    TripleDeckAdapter(Context c) {
        mContext = c;
        mSuitOpen = new LinkedList<GmCard>();
    }

    TripleDeckAdapter(Context c, LinkedList<GmCard> linkedList) {
        mContext = c;
        mSuitOpen = linkedList;
    }

    public int getCount() {
        return mSuitOpen.size();
    }

    public Object getItem(int position) {
        return mSuitOpen.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(final int position, View convertView, ViewGroup parent) {

        if(convertView==null)
        {
            convertView= LayoutInflater.from(mContext).inflate(R.layout.view_gm_card,parent,false);
        }

        final GmCard curCard = (GmCard) mSuitOpen.get(position);

        GmCardView gmCardView = (GmCardView)convertView;
        gmCardView.setUI();
        gmCardView.setGmCard(curCard);

        return convertView;
    }
}
