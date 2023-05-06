package demoapps.android.collections;

import demoapps.android.bookcab.R;

public class Constants {

    // playing cards image constants
    public static final int ACE = 0;
    public static final int KING = 12;
    public static final int QUEEN = 11;
    public static final int JACK = 10;

    // playing cards suit constants
    public static final int CLUB = 0;
    public static final int DIAMOND = 1;
    public static final int HEART = 2;
    public static final int SPADE = 3;

    // playing cards color constants
    public static final int BLACK = 0;
    public static final int RED = 1;


    public static final String[] CARD_RANK_TXT
            = { "A", "2", "3", "4", "5",
                "6", "7", "8", "9", "10",
                "J", "Q", "K" };

    public static final String[] CARD_NAMES
            = { "Ace", "Two", "Three", "Four", "Five",
                "Six", "Seven", "Eight", "Nine", "Ten",
                "Jack", "Queen", "King" };
    public static final int[] CARD_SUITS
            = { R.drawable.club, R.drawable.diamond,
                R.drawable.heart, R.drawable.spade };

    public static final int[][] FACE_CARDS
            = { { R.drawable.j_club,
                    R.drawable.q_club,
                    R.drawable.k_club },
                { R.drawable.j_diamond,
                    R.drawable.q_diamond,
                    R.drawable.k_diamond },
                { R.drawable.j_heart,
                    R.drawable.q_heart,
                    R.drawable.k_heart },
                { R.drawable.j_spade,
                    R.drawable.q_spade,
                    R.drawable.k_spade } };

    public static final int[] CARD_COLORS
            = { R.color.black, R.color.red };

    // total color size
    public static final int SUITS = 4;

    // color card size
    public static final int RANK_SET_SIZE = 13;

    // empty string
    public static final String EMPTY = "";

    // player names
    public static final String PLAYER1 = "Erix";
    public static final String PLAYER2 = "Marvix";

    // Deck view or Open view
    public static final boolean DECK_VIEW = false;
    public static final boolean OPEN_VIEW = true;
}
