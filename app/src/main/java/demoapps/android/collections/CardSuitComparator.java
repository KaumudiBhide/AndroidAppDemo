package demoapps.android.collections;

import java.util.Comparator;

public class CardSuitComparator
        implements Comparator<GmCard> {

    public int compare(GmCard card1, GmCard card2)
    {
        int ramkCompare = (card1.getRank() - card2.getRank());

        int suit1 = card1.getSuit().getIndex();
        int suit2 = card2.getSuit().getIndex();
        int suitCompare = suit1 - suit2;

        int compare = suitCompare;

        if(suitCompare == 0)
        {
            compare = ramkCompare;
        }

        return compare;
    }
}
