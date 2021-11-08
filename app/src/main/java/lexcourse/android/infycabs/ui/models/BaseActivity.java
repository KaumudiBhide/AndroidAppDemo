package lexcourse.android.infycabs.ui.models;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import lexcourse.android.infycabs.Globals;
import lexcourse.android.infycabs.R;
import lexcourse.android.infycabs.data.models.User;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadPreferences();
    }

    public void clearPreferences() {
        SharedPreferences preferences = getSharedPreferences(
                Globals.PREF_FILE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.apply();
        editor.commit();
    }

    public void deletePreferences() {
        getBaseContext().deleteSharedPreferences(
                Globals.PREF_FILE);
    }

    public void loadPreferences() {
        Globals.rideUser = new User();
        SharedPreferences preferences = getSharedPreferences(
                Globals.PREF_FILE, Context.MODE_PRIVATE);
        Globals.isUserLoggedIn = preferences.getBoolean(Globals.LOGGED_IN, false);
        if(Globals.isUserLoggedIn) {
            Globals.rideUser.name = preferences.getString(
                    Globals.USER_NAME, User.DEFAULT_USER);
            Globals.rideUser.email = preferences.getString(
                    Globals.EMAIL, User.DEFAULT_EMAIL);
            Globals.rideUser.phone = preferences.getString(
                    Globals.PHONE, User.DEFAULT_PHONE);
            Globals.rideUser.address = preferences.getString(
                    Globals.ADDRESS, User.DEFAULT_ADDR);
        }
    }

    public void updatePreferences() {
        SharedPreferences preferences = getSharedPreferences(
                Globals.PREF_FILE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(Globals.LOGGED_IN, true);
        editor.putString(
                Globals.USER_NAME, Globals.rideUser.name);
        editor.putString(
                Globals.EMAIL, Globals.rideUser.email);
        editor.putString(
                Globals.PHONE, Globals.rideUser.phone);
        editor.putString(
                Globals.ADDRESS, Globals.rideUser.address);
        editor.apply();
    }
}