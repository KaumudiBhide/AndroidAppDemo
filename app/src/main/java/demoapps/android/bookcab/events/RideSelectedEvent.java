package demoapps.android.bookcab.events;

import com.google.android.material.card.MaterialCardView;

import java.util.EventObject;

public class RideSelectedEvent extends EventObject {

    MaterialCardView cardView = null;

    public RideSelectedEvent(Object source) {
        super(source);
        cardView = (MaterialCardView)source;
    }

    public MaterialCardView getCardView() {
        return cardView;
    }
}
