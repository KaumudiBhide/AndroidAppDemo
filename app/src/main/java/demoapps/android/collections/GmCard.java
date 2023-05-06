package demoapps.android.collections;

public class GmCard extends Object {

    private int mRank;
    private CardSuit mSuit;
    private int mFace;
    private int mFaceIndex;

    public GmCard() {
        mRank = Constants.ACE;
        mSuit = new CardSuit();
        setFace();
    }

    public GmCard(int rank, CardSuit suit) {
        mRank = rank;
        mSuit = suit;
        setFace();
    }

    private void setFace() {
        if(mRank>=Constants.JACK)
        {
            // this is a face card
            mFaceIndex = mRank - Constants.JACK;
            int suitIndx = mSuit.getIndex();
            mFace = Constants.FACE_CARDS[suitIndx][mFaceIndex];
        }
        else {
            // nonrmal card : face is suit
            mFace = mSuit.getShape();
        }
    }

    public int getRank() {
        return mRank;
    }

    public CardSuit getSuit() {
        return mSuit;
    }

    public void setRank(int rank) {
        mRank = rank;
    }

    public void setSuit(CardSuit suit) {
        mSuit = suit;
    }

    public String getRankTxt() {
        return Constants.CARD_RANK_TXT[mRank];
    }

    public int getFace() {
        return mFace;
    }
}
