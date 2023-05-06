package demoapps.android.collections;

import android.content.Context;
import android.util.AttributeSet;

import androidx.cardview.widget.CardView;

import java.util.LinkedList;

import demoapps.android.bookcab.R;

public class TripleDeckView extends CardView
    implements CardAddedListener {

    private GmCardView mOpenView1;
    private GmCardView mOpenView2, mOpenView3;
    private LinkedList<GmCard> mSuitOpen;

    public TripleDeckView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init();
    }

    public void init() {
    //    setUI();
    //    fillSuitDeck();
    //    setDeckView();
        mSuitOpen = new LinkedList<GmCard>();
    //    setOpenView();
    }

    private void setOpenView() {
        //GmCard gmCard = mSuitOpen.get(0);
        mOpenView1 = (GmCardView) findViewById(R.id.openCard1);
        mOpenView1.setUI();
        mOpenView1.setVisibility(INVISIBLE);
        //mOpenView1.setGmCard(gmCard);

        //gmCard = mSuitOpen.get(1);
        mOpenView2 = (GmCardView) findViewById(R.id.openCard2);
        mOpenView2.setUI();
        mOpenView1.setVisibility(INVISIBLE);
        //mOpenView2.setGmCard(gmCard);

        GmCard gmCard = mSuitOpen.peek();
        mOpenView3 = (GmCardView) findViewById(R.id.openCard3);
        mOpenView3.setUI();
        if(gmCard!=null)
            mOpenView3.setGmCard(gmCard);
    }

    public void restart() {
        mSuitOpen.clear();
        //setOpenView();
    }

    public void onCardAdded(CardAddedEvent e) {
        GmCard curCard = e.getAddedCard();
        mSuitOpen.add(curCard);
        if (curCard != null) {
            // set first card
            //GmCard prevCard = mOpenView2.getGmCard();
            //mOpenView1.setGmCard(prevCard);
            // set second card
            //prevCard = mOpenView3.getGmCard();
            //mOpenView2.setGmCard(prevCard);
            // set third card
            //mOpenView3.setGmCard(curCard);
        }
        else {
            //mOpenView3.turnSide();
        }
    }
}
