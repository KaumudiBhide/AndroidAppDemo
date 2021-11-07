package lexcourse.android.infycabs;

import lexcourse.android.infycabs.data.models.HistoryCard;
import lexcourse.android.infycabs.data.models.User;

public class Globals {
    public static boolean isNewUser = false;
    public static boolean isUserLoggedIn = false;

    // shared preferences
    public static String LOGGED_IN = "LoggedIn";
    public static String USER_NAME = "UserName";
    public static String PASSWORD = "Password";
    public static String PHONE = "Phone";
    public static String EMAIL = "Email";
    public static String ADDRESS = "Address";

    // current user
    public static User rideUser;

    // shared preference file
    public static final String PREF_FILE = "InfyCabsPrefs";

    // modes
    public static final int MODE_READ = 0;
    public static final int MODE_EDIT = 1;

    // ride images
    public static final String[] RIDE_NAMES = new String[]{
            /*"Luxury Ride", "BMW Red", "MBenz SL",
            "BMW Silver", "Batmobile",*/
            "Ride 01", "Ride 02", "Ride 03"
    };

    // ride names
    public static final int[] RIDE_CARS = new int[]{
            /*R.drawable.ride_luxury_car, R.drawable.ride_bmw_red,
            R.drawable.ride_ddlj_car,
            R.drawable.ride_bmw_white, R.drawable.ride_batmobile,*/
            R.drawable.ride_01, R.drawable.ride_02, R.drawable.ride_03
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

    // user ride pick-up locations
    public static final String[] USER_RIDES_PICK_UPS
            = new String[]{
            "Saanenstrasse 15, 3770 Zweisimmen, Switzerland",
            "Bangunan Keretapi, Kuala Lumpur, Malaysia",
            "Agora, Perga, Antalya, Turkey"
    };

    public static final String[] USER_RIDES_DROP_OFFS
            = new String[]{
            "Alte Str. 8, 3777 Saanenmöser, Switzerland",
            "Jalan Sentral, Kuala Lumpur, Malaysia",
            "Çalkaya mah 28106, Antalya, Turkey"
    };

    public static final String LOG_TAG = "InfyCabs";
}
