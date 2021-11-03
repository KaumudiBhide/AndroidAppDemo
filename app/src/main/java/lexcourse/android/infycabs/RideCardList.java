package lexcourse.android.infycabs;

import java.util.ArrayList;

public class RideCardList extends ArrayList {

    private int selected = -1;

    public RideCardList() {
        super();
    }

    public int getSelected() {
        return selected;
    }

    public void setSelected(int selected) {
        this.selected = selected;
    }
}
