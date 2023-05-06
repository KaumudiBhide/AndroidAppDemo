package demoapps.android.collections;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

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
    }

    public void onRestart(View v) {
        /*mCardDeck.refillDeck();
        mSuitOpen.clear();
        mAdapter.notifyDataSetChanged();*/
        shoToast("onRestart");
    }

    public void onRankSort(View v) {
        /*Collections.sort(mSuitOpen, new CardRankComparator());
        mAdapter.notifyDataSetChanged();*/
        shoToast("onRankSort");
    }

    public void onColorSort(View v) {
        /*Collections.sort(mSuitOpen, new CardColorComparator());
        mAdapter.notifyDataSetChanged();*/
        shoToast("onColorSort");
    }

    public void onSuitSort(View v) {
        /*Collections.sort(mSuitOpen, new CardSuitComparator());
        mAdapter.notifyDataSetChanged();*/
        shoToast("onSuitSort");
    }

    public void onAll(View v) {
        // get full deck
        //LinkedList<GmCard> cards = mCardDeck.getDeck();
        // add all
        /*mSuitOpen.addAll(cards);
        mAdapter.notifyDataSetChanged();*/
        shoToast("onAll");
    }

    public void onPick(View v) {
        // pick one card
        /*CardSuit suit1 = new CardSuit(Constants.DIAMOND);
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
        mAdapter.notifyDataSetChanged();*/
        shoToast("onPick");
    }

    public void onMax(View v) {
        // max
        /*GmCard g = Collections.max(mSuitOpen, new CardSuitComparator());
        mSuitOpen.add(g);
        mAdapter.notifyDataSetChanged();*/
        shoToast("onMax");
    }

    public void onSwap(View v) {
        /*int last = mSuitOpen.size();
        // swap two cards
        Collections.swap(mSuitOpen, 0, (last-1));
        mAdapter.notifyDataSetChanged();*/
        shoToast("onSwap");
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

    private void shoToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}