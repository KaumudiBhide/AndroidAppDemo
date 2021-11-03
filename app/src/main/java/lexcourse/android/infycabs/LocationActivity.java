package lexcourse.android.infycabs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class LocationActivity extends AppCompatActivity {

    LinearLayout layoutTitle;
    TextView txtTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_location_details);

        layoutTitle = findViewById(R.id.layoutTitle);
        txtTitle = layoutTitle.findViewById(R.id.txtTitle);
        txtTitle.setText(R.string.titleLocation);
    }
}