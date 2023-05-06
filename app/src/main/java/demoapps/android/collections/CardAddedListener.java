package demoapps.android.collections;

import java.util.EventListener;

public interface CardAddedListener extends EventListener {

    public void onCardAdded(CardAddedEvent e);
}
