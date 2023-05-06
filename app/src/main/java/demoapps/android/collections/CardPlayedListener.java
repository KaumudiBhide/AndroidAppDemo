package demoapps.android.collections;

import java.util.EventListener;

public interface CardPlayedListener extends EventListener {

    public void onCardPlayed(CardPlayedEvent e);
}
