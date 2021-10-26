package lexcourse.android.infycabs;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProfileActivity extends AppCompatActivity {

    LinearLayout layoutTitle;
    TextView txtTitle;

    final String[] CITIES = {"Chennai", "Delhi", "Mumbai", "Pune"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        setTitle(R.string.titleProfile);

        layoutTitle = findViewById(R.id.layoutTitle);
        txtTitle = layoutTitle.findViewById(R.id.txtTitle);
        txtTitle.setText(R.string.titleProfile);
    }
}
