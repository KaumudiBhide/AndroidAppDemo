package lexcourse.android.infycabs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.textfield.TextInputLayout;

public class LoginBottomSheet extends BottomSheetDialogFragment {

    TextInputLayout editUserName, editPassword;
    TextView txtRegisterLink;
    View bottomSheetView;
    OnNewUserListener listener = null;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        bottomSheetView = inflater.inflate(R.layout.view_login,
                container, false);

        txtRegisterLink = bottomSheetView.findViewById(R.id.txtRegisterLink);
        txtRegisterLink.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Globals.isNewUser = true;
                        dismiss();
                        if(listener!=null)
                            listener.onNewUser(new NewUserEvent(this));
                    }
                }
        );

        Button btnLogin = bottomSheetView.findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                // retrieve entered credentials
                editUserName = bottomSheetView.findViewById(R.id.editUserName);
                editPassword = bottomSheetView.findViewById(R.id.editPassword);

                String strUser = editUserName.getEditText().getText().toString();
                String strCredentials = "User " + strUser + " logged in";
                // show user logged in
                Toast.makeText(getActivity(), strCredentials,Toast.LENGTH_LONG).show();

                Globals.isUserLoggedIn = true;
                dismiss();
            }
        });

        return bottomSheetView;
    }

    public void setOnNewUserListener(OnNewUserListener listener) {
        this.listener = listener;
    }
}
