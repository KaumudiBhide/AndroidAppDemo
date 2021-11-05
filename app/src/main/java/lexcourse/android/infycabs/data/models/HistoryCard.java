package lexcourse.android.infycabs.data.models;

import java.util.Date;

import lexcourse.android.infycabs.R;

public class HistoryCard extends RideCard {
    // date & time
    private Date date;
    // CRN no.
    private String CRN;
    private int amount;
    // pick-up & drop-off locations
    private String strPickUpAddr;
    private String strDropOffAddr;
    // driver details;
    private int driverPhoto;
    private String driverName;

    public HistoryCard() {
        // default values
        date = new Date();
        amount = 10;
        CRN = "533510908775";

        strPickUpAddr = "Pick up address";
        strDropOffAddr = "Drop Off address";

        driverPhoto = R.drawable.driver_raj;
        driverName = "Raj";
    }
}
