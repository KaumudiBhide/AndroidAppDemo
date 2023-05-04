package demoapps.android.bookcab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class RegisterBottomSheet extends BottomSheetDialogFragment {

    View bottomSheetView;
    LinearLayout layoutTitle;
    TextView txtTitle;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        bottomSheetView = inflater.inflate(R.layout.view_register,
                container, false);

        Button btnRegister = bottomSheetView.findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String strMessage = "New user registered successfully!";
                // show user registered
                Toast.makeText(getActivity(), strMessage,Toast.LENGTH_LONG).show();
                dismiss();
            }
        });

        layoutTitle = bottomSheetView.findViewById(R.id.layoutTitle);
        txtTitle = layoutTitle.findViewById(R.id.txtTitle);
        txtTitle.setText(R.string.register);

        return bottomSheetView;
    }

}
