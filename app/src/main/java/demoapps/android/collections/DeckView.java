package demoapps.android.collections;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.cardview.widget.CardView;

import java.util.Collections;
import java.util.LinkedList;

import demoapps.android.bookcab.R;

public class DeckView extends CardView {

    private LinkedList<GmCard> mSuitDeck;
    private GmCardView mGmCardView;
    private boolean mEndofDeck, mIsOpenView;
    //private CardPlayedListener mCardPlayedListener;

    public DeckView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void init() {
        setUI();
        fillSuitDeck();
        setDeckView();
    }

    public void init(boolean isOpenView) {
        mIsOpenView = isOpenView;
        init();
    }

    protected void setUI() {
        // set background
        mGmCardView = (GmCardView) findViewById(R.id.deckCard);
        mGmCardView.setUI();
        mGmCardView.setVisibility(INVISIBLE);
        //mGmCardView.setOnClickListener(this::onClick);
    }

    private void fillSuitDeck() {
        mSuitDeck = new LinkedList<GmCard>();
        for(int j=0; j<Constants.SUITS; j++) {
            // select suit
            CardSuit suit = new CardSuit(j);
            // fill all ranks
            for(int i=0; i<Constants.RANK_SET_SIZE; i++) {
                GmCard gmCard = new GmCard(i, suit);
                mSuitDeck.add(gmCard);
            }
        }

        Collections.shuffle(mSuitDeck);
        mEndofDeck = false;
    }

    private void setDeckView() {
        if(!mEndofDeck) {
            mGmCardView.setVisibility(VISIBLE);
            if (mIsOpenView) {
                GmCard nextCard = mSuitDeck.peek();
                mGmCardView.setGmCard(nextCard);
                mGmCardView.showFrontSide();
            } else {
                mGmCardView.showBackSide();
            }
        }
        else
        {
            mGmCardView.setVisibility(INVISIBLE);
        }
    }

    public GmCard nextCard() {
        GmCard nextCard = mSuitDeck.poll();
        if(nextCard!=null) {
            if(mIsOpenView)
            {
                GmCard curCard = mSuitDeck.peek();
                if(curCard!=null) {
                    mGmCardView.setGmCard(curCard);
                    mGmCardView.showFrontSide();
                }
                else {
                    mEndofDeck = true;
                    mGmCardView.setVisibility(INVISIBLE);
                }
            }
        }

        return nextCard;
    }

    private void onClick(View v) {
        if(!mEndofDeck) {
            GmCard curCard = nextCard();
            if (curCard != null)
            {
                fireCardPlayedEvent(curCard);
            }
        }
    }

    public void refillDeck() {
        mSuitDeck.clear();
        fillSuitDeck();
        setDeckView();
    }

    public void fireCardPlayedEvent(GmCard gmCard) {
       /* CardPlayedEvent event = new CardPlayedEvent(gmCard);
        if(mCardPlayedListener!=null)
            mCardPlayedListener.onCardPlayed(event);*/
    }

    /*public void setCardPlayedListener(CardPlayedListener listener) {
        mCardPlayedListener = listener;
    }*/

    public LinkedList<GmCard> getDeck() { return mSuitDeck; }
}
