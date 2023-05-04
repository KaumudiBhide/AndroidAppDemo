package lexcourse.android.bookcab.base;

import androidx.annotation.NonNull;

public class RideAmount {
    public int value;

    public RideAmount() {
        value = 10;
    }

    @NonNull
    @Override
    public String toString() {
        String strAmount = "$" + value;
        return strAmount;
    }
}
