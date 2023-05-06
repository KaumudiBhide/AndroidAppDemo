package demoapps.android.collections;

import java.util.EventObject;

public class CardPlayedEvent extends EventObject {
    private GmCard mPlayedCard;

    public CardPlayedEvent(GmCard playedCard) {
        super(playedCard);
        mPlayedCard = playedCard;
    }

    public GmCard getPlayedCard() {
        return mPlayedCard;
    }
}
