package demoapps.android.collections;

import java.util.Comparator;

public class CardRankComparator
    implements Comparator<GmCard> {

    public int compare(GmCard card1, GmCard card2)
    {
        int ramkCompare = (card1.getRank() - card2.getRank());

        int suit1 = card1.getSuit().getIndex();
        int suit2 = card2.getSuit().getIndex();
        int suitCompare = suit1 - suit2;

        int compare = ramkCompare;

        if(ramkCompare == 0)
        {
            compare = suitCompare;
        }

        return compare;
    }
}
