package client.foodpark.com.foodparkclient.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import client.foodpark.com.foodparkclient.Interfaces.ItemOnClickListener;
import client.foodpark.com.foodparkclient.R;

/**
 * Created by dennis on 1/4/18.
 */

public class FoodListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView txtItemName;
    public ImageView imageURL;
    public ItemOnClickListener itemOnClickListener;

    public FoodListViewHolder(View itemView) {
        super(itemView);
        txtItemName = (TextView) itemView.findViewById(R.id.food_text);
        imageURL = (ImageView) itemView.findViewById(R.id.food_image);
        itemView.setOnClickListener(this);
    }

    public void setItemOnClickListener(ItemOnClickListener itemOnClickListener) {
        this.itemOnClickListener = itemOnClickListener;
    }

    @Override
    public void onClick(View v) {
        itemOnClickListener.OnClick(v, getAdapterPosition(), false);
    }
}
