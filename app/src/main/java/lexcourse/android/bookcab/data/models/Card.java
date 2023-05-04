package lexcourse.android.bookcab.data.models;

import lexcourse.android.bookcab.R;

public class Card {

    private int icon;
    private String label;

    public Card() {
        icon = R.drawable.ic_offers;
        label = "Label";
    }

    public Card(int icon, String label) {
        this.icon = icon;
        this.label = label;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
