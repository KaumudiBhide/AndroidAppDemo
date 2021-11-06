package lexcourse.android.infycabs.events;

import java.util.EventListener;

public interface OnNewUserListener extends EventListener {

    void onNewUser(NewUserEvent e);
}
