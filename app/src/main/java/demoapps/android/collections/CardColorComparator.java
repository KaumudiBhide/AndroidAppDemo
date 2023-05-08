package demoapps.android.collections;

import java.util.Comparator;

public class CardColorComparator
        implements Comparator<GmCard> {

    public int compare(GmCard card1, GmCard card2)
    {
        int ramkCompare = (card1.getRank() - card2.getRank());

        int color1 = card1.getSuit().getColor();
        int color2 = card2.getSuit().getColor();
        int colorCompare = color1 - color2;

        int compare = colorCompare;

        if(colorCompare == 0)
        {
            compare = ramkCompare;
        }

        return compare;
    }
}
