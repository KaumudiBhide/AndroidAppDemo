package lexcourse.android.infycabs.events;

import java.util.EventListener;

public interface OnRideSelectedListener extends EventListener {

    void onRideSelected(RideSelectedEvent e);
}
