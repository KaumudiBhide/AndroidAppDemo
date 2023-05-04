package lexcourse.android.bookcab.base;

import androidx.annotation.NonNull;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class RideDate {
    private Date value;

    public RideDate() {
        this.value = Calendar.getInstance().getTime();
    }

    public Date getValue() {
        return value;
    }

    public void setValue(Date value) {
        this.value = value;
    }

    @NonNull
    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("E, MMM dd, yyyy, hh:mm a", Locale.ENGLISH);
        return (dateFormat.format(this.value));
    }
}
