package demoapps.android.collections;

import java.util.EventObject;

public class CardAddedEvent extends EventObject {

    private GmCard mNewCard;

    public CardAddedEvent(GmCard newCard) {
        super(newCard);
        mNewCard = newCard;
    }

    public GmCard getAddedCard() {
        return mNewCard;
    }
}
