package lexcourse.android.bookcab.ui.models;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import lexcourse.android.bookcab.R;
import lexcourse.android.bookcab.data.models.HistoryCard;

public class HistoryCardView
        extends RecyclerView.ViewHolder {
    TextView txtDateTime, txtRideCRN, txtRideName, txtAmount, txtDriverName;
    TextView txtLocPickUp, txtLocDropOff;
    ImageView imgRideHistory, imgDriver;
    View view;

    public HistoryCardView(@NonNull View itemView) {
        super(itemView);
        txtDateTime = itemView.findViewById(R.id.txtDateTime);
        txtRideCRN = itemView.findViewById(R.id.txtRideCRN);
        txtRideName = itemView.findViewById(R.id.txtRideName);
        txtAmount = itemView.findViewById(R.id.txtAmount);
        imgRideHistory = itemView.findViewById(R.id.imgRideHistory);
        txtLocPickUp = itemView.findViewById(R.id.txtLocPickUp);
        txtLocDropOff = itemView.findViewById(R.id.txtLocDropOff);
        //imgDriver = itemView.findViewById(R.id.imgDriver);
        view = itemView;
    }

    public TextView getTxtDateTime() {
        return txtDateTime;
    }

    public TextView getTxtRideCRN() {
        return txtRideCRN;
    }

    public TextView getTxtAmount() {
        return txtAmount;
    }

    public TextView getTxtLocPickUp() {
        return txtLocPickUp;
    }

    public TextView getTxtLocDropOff() {
        return txtLocDropOff;
    }

    public ImageView getImgRideHistory() {
        return imgRideHistory;
    }

    public ImageView getImgDriver() {
        return imgDriver;
    }

    public View getView() {
        return view;
    }

    public void bindData(HistoryCard cardData) {
        this.txtDateTime.setText(cardData.date.toString());
        this.txtRideName.setText(cardData.getRideName());
        this.txtRideCRN.setText(cardData.getCRN());
        this.txtAmount.setText(cardData.rideAmount.toString());
        this.txtLocPickUp.setText(cardData.strPickUpAddr);
        this.txtLocDropOff.setText(cardData.strDropOffAddr);

        /*Picasso.get()
                .load(cardData.getRideCarImg())
                .fit()
                .into(this.imgRideHistory);*/

        /*Picasso.get()
                .load(R.drawable.ic_profile)
                .fit()
                .into(this.imgDriver);*/

    }
}
