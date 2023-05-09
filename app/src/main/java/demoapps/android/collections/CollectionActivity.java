package demoapps.android.collections;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.google.android.material.textview.MaterialTextView;

import java.util.Collections;
import java.util.LinkedList;

import demoapps.android.bookcab.R;

public class CollectionActivity extends AppCompatActivity
        implements CardAddedListener, CardPlayedListener,
        AdapterView.OnItemClickListener {

    private DeckView mCardDeck;
    private LinkedList<GmCard> mSuitOpen;
    private GridView mGridView;
    private TripleDeckAdapter mAdapter;
    private MaterialTextView mDescTxtView;
    private Toast mToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Java Collection Demo");
        init();
    }

    private void init() {
        mSuitOpen = new LinkedList<GmCard>();

        mCardDeck = findViewById(R.id.deckView);
        mCardDeck.init(Constants.OPEN_VIEW);
        mCardDeck.setCardPlayedListener(this);

        mGridView = findViewById(R.id.tripleDeckGrid);
        mAdapter = new TripleDeckAdapter(getBaseContext(),
                mSuitOpen);
        mGridView.setAdapter(mAdapter);
        mGridView.setOnItemClickListener(this);

        mDescTxtView = findViewById(R.id.txtDesc);
        mToast = Toast.makeText(this, "", Toast.LENGTH_SHORT);
        mToast.setGravity(Gravity.CENTER, 0, 0);
    }

    public void onRestart(View v) {
        mCardDeck.refillDeck();
        mSuitOpen.clear();
        mAdapter.notifyDataSetChanged();
        mDescTxtView.setText("Uses Collection method: clear() for open cards\nUses Collection method: shuffle() for cards in the Deck");
        showToast("Restart the Deck");
    }

    public void onRankSort(View v) {
        if(!validateOpenSuit())
            return;
        Collections.sort(mSuitOpen, new CardRankComparator());
        mAdapter.notifyDataSetChanged();
        mDescTxtView.setText("Uses Collection method: sort()\nWith Custom Comparator class: CardRankComparator");
        showToast("Sort cards by Rank: Ace to King");
    }

    public void onColorSort(View v) {
        if(!validateOpenSuit())
            return;
        Collections.sort(mSuitOpen, new CardColorComparator());
        mAdapter.notifyDataSetChanged();
        mDescTxtView.setText("Uses Collection method: sort()\nWith Custom Comparator class: CardColorComparator");
        showToast("Sort cards by Color: Black, Red");
    }

    public void onSuitSort(View v) {
        if(!validateOpenSuit())
            return;
        Collections.sort(mSuitOpen, new CardSuitComparator());
        mAdapter.notifyDataSetChanged();
        mDescTxtView.setText("Uses Collection method: sort()\nWith Custom Comparator class: CardSuitComparator");
        showToast("Sort cards by Suit: Club, Diamond, Heart, Spade");
    }

    public void onAll(View v) {
        // get full deck
        LinkedList<GmCard> cards = mCardDeck.getDeck();
        // add all
        mSuitOpen.addAll(cards);
        mAdapter.notifyDataSetChanged();
        mDescTxtView.setText("Uses Collection method: addAll()");
        showToast("Display all cards in the Deck");
    }

    public void onPick(View v) {
        // pick one card
        CardSuit suit1 = new CardSuit(Constants.DIAMOND);
        GmCard card1 = new GmCard(Constants.ACE, suit1);

        int index = Collections.binarySearch(
                mSuitOpen, card1, new CardSuitComparator());

        if(index >= 0) {
            GmCard newCard = mSuitOpen.get(index);
            mSuitOpen.clear();
            mSuitOpen.add(newCard);
        }
        else {
            CardSuit suit3 = new CardSuit(Constants.HEART);
            GmCard card3 = new GmCard(Constants.ACE, suit3);
            mSuitOpen.clear();
            mSuitOpen.add(card3);
        }

        // refresh adapter view
        mAdapter.notifyDataSetChanged();
        mDescTxtView.setText("");
        showToast("Pick the first card OR pick Ace of Heart");
    }

    public void onMax(View v) {
        // max
        GmCard g = Collections.max(mSuitOpen, new CardSuitComparator());
        mSuitOpen.add(g);
        mAdapter.notifyDataSetChanged();
        mDescTxtView.setText("Uses Collection method: max()\nWith Custom Comparator class: CardSuitComparator");
        showToast("Show the Card with Max Suit and Rank: Club, Diamond, Heart, Spade");
    }

    public void onSwap(View v) {
        int last = mSuitOpen.size();
        // swap two cards
        Collections.swap(mSuitOpen, 0, (last-1));
        mAdapter.notifyDataSetChanged();
        mDescTxtView.setText("Uses Collection method: swap()");
        showToast("Swap the First and Last Card");
    }

    public void onCardPlayed(CardPlayedEvent e) {
        GmCard curCard = e.getPlayedCard();
        CardAddedEvent event = new CardAddedEvent(curCard);
        onCardAdded(event);
    }

    public void onCardAdded(CardAddedEvent e) {
        GmCard curCard = e.getAddedCard();
        mSuitOpen.offerFirst(curCard);
        mAdapter.notifyDataSetChanged();
    }

    public void onItemClick
            (AdapterView<?> parent, View view,
             int position, long id) {
        GmCard g = mSuitOpen.remove(position);
        mAdapter.notifyDataSetChanged();
    }

    private void showToast(String message) {
        mToast.setText(message);
        View view = mToast.getView();
        view.setBackgroundColor(Color.YELLOW);
        mToast.setView(view);
        mToast.show();
    }

    private boolean validateOpenSuit() {
        String strMsg = null;
        if(mSuitOpen.size()>1)
            return true;
        else if(mSuitOpen.size()==0) {
            strMsg = "No cards to sort! Click on the card in the Deck...";
        }
        else {
            strMsg = "Too few cards to sort! Click on the card in the Deck...";
        }
        mDescTxtView.setText(strMsg);
        showToast(strMsg);
        return false;
    }
}