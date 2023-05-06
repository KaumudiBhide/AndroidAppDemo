package demoapps.android.collections;

import demoapps.android.bookcab.R;

public class CardColor {

    protected int mColor;

    CardColor() {
        mColor = R.color.red;
    }

    CardColor(int color) {
        mColor = Constants.CARD_COLORS[color];
    }

    public int getColor() {
        return mColor;
    }
}
