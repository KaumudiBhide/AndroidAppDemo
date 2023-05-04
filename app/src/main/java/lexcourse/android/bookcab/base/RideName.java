package lexcourse.android.bookcab.base;

import androidx.annotation.NonNull;
import lexcourse.android.bookcab.Globals;

public class RideName {
    public String value;

    public static final int FIXED_LEN = 24;

    public RideName() {
        this.value = Globals.RIDE_NAMES[0];
    }

    @NonNull
    @Override
    public String toString() {
        return this.value;
    }
}
