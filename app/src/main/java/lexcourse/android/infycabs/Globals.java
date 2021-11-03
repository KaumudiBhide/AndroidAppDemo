package lexcourse.android.infycabs;

public class Globals {
    public static boolean isNewUser = false;
    public static boolean isUserLoggedIn = false;

    public static final String[] RIDE_NAMES = new String[]{
            "Luxury Ride", "BMW Red", "DDLJ Eurail",
            "BMW White", "Batmobile",
    };

    public static final int[] RIDE_CARS = new int[]{
            R.drawable.ride_luxury_car, R.drawable.ride_bmw_red,
            R.drawable.ride_ddlj_car,
            R.drawable.ride_bmw_white, R.drawable.ride_batmobile,
    };

    public static final String LOG_TAG = "InfyCabs";
}
