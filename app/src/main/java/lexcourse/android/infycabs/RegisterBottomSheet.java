package lexcourse.android.infycabs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.textfield.TextInputLayout;

public class RegisterBottomSheet extends BottomSheetDialogFragment {

    TextInputLayout editUserName, editPassword;
    View bottomSheetView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        bottomSheetView = inflater.inflate(R.layout.view_login,
                container, false);

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
}
