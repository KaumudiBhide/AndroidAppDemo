package lexcourse.android.infycabs;

import java.util.EventListener;

public interface OnNewUserListener extends EventListener {

    public void onNewUser(NewUserEvent e);
}