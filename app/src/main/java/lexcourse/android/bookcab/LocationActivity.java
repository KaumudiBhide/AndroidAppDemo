package lexcourse.android.bookcab;

import androidx.appcompat.app.AlertDialog;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import lexcourse.android.bookcab.ui.models.BaseActivity;

public class LocationActivity extends BaseActivity
    implements View.OnClickListener {

    private static final String CHANNEL_ID = "RIDE_NOTIFICATION";

    LinearLayout layoutTitle;
    TextView txtTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_location_details);

        layoutTitle = findViewById(R.id.layoutTitle);
        txtTitle = layoutTitle.findViewById(R.id.txtTitle);
        txtTitle.setText(R.string.titleLocation);

        MaterialButton button = findViewById(R.id.btnConfirm);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnOK) {
            Toast.makeText(getApplicationContext(),"Ride Confirmed",Toast.LENGTH_LONG).show();
            sendNotification();
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        }
        else {
            // Create an alert builder
            AlertDialog.Builder builder
                    = new AlertDialog.Builder(this);

            // set the custom layout
            final View customLayout
                    = getLayoutInflater().inflate(R.layout.view_alert, null);
            MaterialButton btnOK = customLayout.findViewById(R.id.btnOK);
            btnOK.setOnClickListener(this);
            builder.setView(customLayout);

            // create and show the alert dialog
            AlertDialog dialog = builder.create();
            dialog.show();
        }
    }

    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.channel_name);
            String description = getString(R.string.channel_desc);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    public void sendNotification() {
        createNotificationChannel();
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder( this,  CHANNEL_ID)
                        .setSmallIcon(R.drawable.ic_ride)
                        .setContentTitle("Ride booked")
                        .setContentText("Driver will contact you on arrival of the ride ");

        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);

        // Add as notification
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());
    }
}