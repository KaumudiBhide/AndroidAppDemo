package demoapps.android.collections;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import demoapps.android.bookcab.R;

public class GmCardView extends CardView {

    protected ImageView mCardBack;
    protected RelativeLayout mCardFront;
    protected ImageView mIcon;
    protected ImageView mFace;
    protected TextView mRankTxt;
    // visibility flag
    protected boolean mIsBackSide;

    // card data
    protected GmCard mGmCard;

    public GmCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    protected void setUI() {
        // back side
        mIsBackSide = false;
        mCardBack = (ImageView) findViewById(R.id.cardBack);
        // black card design
        //mCardBack.setImageResource(R.drawable.card_back);
        mCardBack.setImageResource(R.drawable.card_back_black);
        mCardBack.setVisibility(INVISIBLE);

        // front side
        mCardFront = (RelativeLayout) findViewById(R.id.cardFront);
        mCardFront.setVisibility(VISIBLE);
        mIcon = (ImageView) findViewById(R.id.smallIcon);
        mFace = (ImageView) findViewById(R.id.bigIcon);
        mRankTxt = (TextView) findViewById(R.id.rankTxt);
    }

    protected void setData() {
        // set color
        int color = mGmCard.getSuit().getColor();
        int resColor = getResources().getColor(color);
        mRankTxt.setTextColor(resColor);
        // set text
        String rankTxt = mGmCard.getRankTxt();
        mRankTxt.setText(rankTxt);
        // set icon
        int resId = mGmCard.getSuit().getShape();
        mIcon.setImageResource(resId);
        // set face
        resId = mGmCard.getFace();
        mFace.setImageResource(resId);
    }

    public void turnSide() {
        mIsBackSide = !mIsBackSide;
        if(mIsBackSide) {
            // show back side
            mCardBack.setVisibility(VISIBLE);
            mCardFront.setVisibility(INVISIBLE);
        }
        else {
            // hide back side
            mCardBack.setVisibility(INVISIBLE);
            mCardFront.setVisibility(VISIBLE);
        }
    }

    public void setGmCard(GmCard gmCard) {
        mGmCard = gmCard;
        setData();
    }

    public void clear() {
        this.turnSide();
    }

    public void showBackSide() {
        mIsBackSide = true;
        mCardBack.setVisibility(VISIBLE);
        mCardFront.setVisibility(INVISIBLE);
    }

    public void showFrontSide() {
        mIsBackSide = false;
        mCardBack.setVisibility(INVISIBLE);
        mCardFront.setVisibility(VISIBLE);
    }

    public GmCard getGmCard() {
        return mGmCard;
    }
}
