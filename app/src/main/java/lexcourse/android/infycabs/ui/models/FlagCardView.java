package lexcourse.android.infycabs.ui.models;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import lexcourse.android.infycabs.R;

public class FlagCardView
        extends RecyclerView.ViewHolder {
    TextView txtCountry;
    ImageView imgFlag;
    View view;

    public FlagCardView(@NonNull View itemView) {
        super(itemView);
        txtCountry = itemView.findViewById(R.id.txtCountry);
        imgFlag = itemView.findViewById(R.id.imgFlag);
        view = itemView;
    }

    public View getView() {
        return view;
    }

    public TextView getTxtCountry() {
        return txtCountry;
    }

    public ImageView getImgFlag() {
        return imgFlag;
    }
}
