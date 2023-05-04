package demoapps.android.bookcab.data.models;

import demoapps.android.bookcab.Globals;

public class FlagCard {

    private int flagImg;
    private String countryName;

    public FlagCard() {
        flagImg = Globals.FLAGS[0];
        countryName = Globals.COUNTRIES[0];
    }

    public FlagCard(int flagImg, String countryName) {
        this.flagImg = flagImg;
        this.countryName = countryName;
    }

    public int getFlagImg() {
        return flagImg;
    }

    public void setFlagImg(int flagImg) {
        this.flagImg = flagImg;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
