package lexcourse.android.infycabs;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lexcourse.android.infycabs.ui.models.BaseActivity;

public class ProfileActivity extends BaseActivity
    implements View.OnClickListener {

    LinearLayout layoutTitle;
    TextView txtTitle;

    TextInputLayout editEnterName, editContactNumber,
            editEmail, editEnterAddress;

    MaterialButton btnSave, btnHome;

    private int mode = Globals.MODE_READ;

    final String[] CITIES = {"Chennai", "Delhi", "Mumbai", "Pune"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        setTitle(R.string.titleProfile);

        layoutTitle = findViewById(R.id.layoutTitle);
        txtTitle = layoutTitle.findViewById(R.id.txtTitle);
        txtTitle.setText(R.string.titleProfile);

        editEnterName = findViewById(R.id.editEnterName);
        editEnterName.getEditText().setText(Globals.rideUser.name);
        editEnterName.setEnabled(false);

        editContactNumber = findViewById(R.id.editContactNumber);
        editContactNumber.getEditText().setText(Globals.rideUser.phone);
        editContactNumber.setEnabled(false);

        editEmail = findViewById(R.id.editEmail);
        editEmail.getEditText().setText(Globals.rideUser.email);
        editEmail.setEnabled(false);

        editEnterAddress = findViewById(R.id.editEnterAddress);
        editEnterAddress.getEditText().setText(Globals.rideUser.address);
        editEnterAddress.setEnabled(false);

        btnSave = findViewById(R.id.btnSave);
        btnSave.setText("Edit");
        btnSave.setOnClickListener(this);

        btnHome = findViewById(R.id.btnHome);
        btnHome.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnSave) {
            if (this.mode == Globals.MODE_READ) {
                this.mode = Globals.MODE_EDIT;
                btnSave.setText("Save");
                editEnterName.setEnabled(true);
                editContactNumber.setEnabled(true);
                editEmail.setEnabled(true);
                editEnterAddress.setEnabled(true);

            } else {
                Globals.rideUser.name = editEnterName.getEditText().getText().toString();
                Globals.rideUser.email = editEmail.getEditText().getText().toString();
                Globals.rideUser.phone = editContactNumber.getEditText().getText().toString();
                Globals.rideUser.address = editEnterAddress.getEditText().getText().toString();
                updatePreferences();
                finish();
            }
        }
        else if(view.getId() == R.id.btnHome) {
            finish();
        }
    }
}
