package lexcourse.android.bookcab.data.models;

import lexcourse.android.bookcab.Globals;
import lexcourse.android.bookcab.base.RideName;

public class RideCard {

    private int rideCarImg;
    private final RideName rideName;

    public RideCard() {
        rideCarImg = Globals.RIDE_CARS[0];
        rideName = new RideName();
        rideName.value = Globals.RIDE_NAMES[0];
    }

    public RideCard(int rideCarImg, String rideName) {
        this.rideCarImg = rideCarImg;
        this.rideName = new RideName();
        this.rideName.value = rideName;
    }

    public int getRideCarImg() {
        return rideCarImg;
    }

    public void setRideCarImg(int rideCarImg) {
        this.rideCarImg = rideCarImg;
    }

    public String getRideName() {
        return rideName.toString();
    }

    public void setRideName(String rideName) {
        this.rideName.value = rideName;
    }
}
