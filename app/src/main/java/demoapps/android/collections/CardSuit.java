package demoapps.android.collections;

import demoapps.android.bookcab.R;

public class CardSuit extends CardColor {

    private int mIndex;
    private int mShape;

    CardSuit() {
        super();
        mIndex = 0;
        mShape = R.drawable.diamond;
    }

    CardSuit(int shape) {
        super();
        mIndex = shape;
        mColor = decideColor();
        mShape = Constants.CARD_SUITS[shape];
    }

    private int decideColor() {
        int retVal = R.color.black;
        if((mIndex == Constants.DIAMOND)
                || (mIndex == Constants.HEART)   )
            retVal = R.color.red;
        return retVal;
    }

    public int getShape() {
        return mShape;
    }
    public int getIndex() {
        return mIndex;
    }
}
