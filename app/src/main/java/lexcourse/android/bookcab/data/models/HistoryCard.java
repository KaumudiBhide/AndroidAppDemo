package lexcourse.android.bookcab.data.models;

import lexcourse.android.bookcab.Globals;
import lexcourse.android.bookcab.R;
import lexcourse.android.bookcab.base.RideAmount;
import lexcourse.android.bookcab.base.RideDate;

public class HistoryCard extends RideCard {
    // date & time
    public RideDate date;
    // CRN no.
    public String CRN;
    public RideAmount rideAmount;
    // pick-up & drop-off locations
    public String strPickUpAddr;
    public String strDropOffAddr;
    // driver details;
    public int driverPhoto;
    public String driverName;

    // CRN prefix
    private static final String CRN_PREFIX = "CRN: 5335";

    public HistoryCard() {
        // default values
        date = new RideDate();
        rideAmount = new RideAmount();
        this.generateCRN();

        strPickUpAddr = Globals.USER_RIDES_PICK_UPS[0];
        strDropOffAddr = Globals.USER_RIDES_DROP_OFFS[0];

        driverPhoto = R.drawable.driver_raj;
        driverName = "Raj";

        this.setRideCarImg(Globals.RIDE_CARS[0]);
        this.setRideName(Globals.RIDE_NAMES[0]);
    }

    public void generateCRN() {
        long lCRN = (long) Math.floor(Math.random() * 9_000L) + 1_000L;
        this.CRN = CRN_PREFIX + lCRN;
    }

    public String getCRN() {
        return CRN;
    }

    public RideDate getDate() {
        return date;
    }
}
