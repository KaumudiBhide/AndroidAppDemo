package lexcourse.android.infycabs.ui.models;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import lexcourse.android.infycabs.R;

public class HistoryCardView
        extends RecyclerView.ViewHolder {
    TextView txtDateTime, txtRideCRN, txtAmount;
    TextView txtLocPickUp, txtLocDropOff;
    ImageView imgRideHistory, imgDriver;
    View view;

    public HistoryCardView(@NonNull View itemView) {
        super(itemView);
        txtDateTime = itemView.findViewById(R.id.txtDateTime);
        txtRideCRN = itemView.findViewById(R.id.txtRideCRN);
        txtAmount = itemView.findViewById(R.id.txtAmount);
        imgRideHistory = itemView.findViewById(R.id.imgRideHistory);
        txtLocPickUp = itemView.findViewById(R.id.txtLocPickUp);
        txtLocDropOff = itemView.findViewById(R.id.txtLocDropOff);
        imgDriver = itemView.findViewById(R.id.imgDriver);
        view = itemView;
    }
}
