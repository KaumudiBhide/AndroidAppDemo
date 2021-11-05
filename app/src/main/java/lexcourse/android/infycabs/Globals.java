package lexcourse.android.infycabs;

public class Globals {
    public static boolean isNewUser = false;
    public static boolean isUserLoggedIn = true;

    // ride images
    public static final String[] RIDE_NAMES = new String[]{
            "Luxury Ride", "BMW Red", "DDLJ Eurail",
            "BMW White", "Batmobile",
    };

    // ride names
    public static final int[] RIDE_CARS = new int[]{
            R.drawable.ride_luxury_car, R.drawable.ride_bmw_red,
            R.drawable.ride_ddlj_car,
            R.drawable.ride_bmw_white, R.drawable.ride_batmobile,
    };

    // user rides
    public static final int[] USER_RIDES = new int[]{
            R.drawable.ride_luxury_car, R.drawable.ride_bmw_red,
            R.drawable.ride_ddlj_car,
            R.drawable.ride_bmw_white, R.drawable.ride_batmobile,
    };

    // country names
    public static final String[] COUNTRIES = new String[]{
            "America", "Emirates",
            "Switzerland", "India", "England",

    };

    // flag images
    public static final int[] FLAGS = new int[]{
            R.drawable.ic_flag_us, R.drawable.ic_flag_ae,
            R.drawable.ic_flag_ch, R.drawable.ic_flag_in,
            R.drawable.ic_flag_uk
    };

    public static final String LOG_TAG = "InfyCabs";
}
