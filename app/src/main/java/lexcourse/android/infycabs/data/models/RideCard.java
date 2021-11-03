package lexcourse.android.infycabs.data.models;

import lexcourse.android.infycabs.Globals;

public class RideCard {

    private int rideCarImg;
    private String rideName;

    public RideCard() {
        rideCarImg = Globals.RIDE_CARS[0];
        rideName = Globals.RIDE_NAMES[0];
    }

    public RideCard(int rideCarImg, String rideName) {
        this.rideCarImg = rideCarImg;
        this.rideName = rideName;
    }

    public int getRideCarImg() {
        return rideCarImg;
    }

    public void setRideCarImg(int rideCarImg) {
        this.rideCarImg = rideCarImg;
    }

    public String getRideName() {
        return rideName;
    }

    public void setRideName(String rideName) {
        this.rideName = rideName;
    }
}
