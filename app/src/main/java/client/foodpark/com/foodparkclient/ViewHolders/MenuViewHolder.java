package client.foodpark.com.foodparkclient.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import client.foodpark.com.foodparkclient.Interfaces.ItemOnClickListener;
import client.foodpark.com.foodparkclient.R;
import client.foodpark.com.foodparkclient.Utils.Constants;

/**
 * Created by dennis on 31/3/18.
 */

public class MenuViewHolder extends RecyclerView.ViewHolder implements
        View.OnClickListener,View.OnCreateContextMenuListener {
    public TextView txtItemName;
    public ImageView imageURL;
    public ItemOnClickListener itemOnClickListener;

    public MenuViewHolder(View itemView) {
        super(itemView);
        txtItemName = (TextView)itemView.findViewById(R.id.menu_text);
        imageURL = (ImageView)itemView.findViewById(R.id.menu_image);
        itemView.setOnCreateContextMenuListener(this);
        itemView.setOnClickListener(this);
    }

    public void setItemOnClickListener(ItemOnClickListener itemOnClickListener) {
        this.itemOnClickListener = itemOnClickListener;
    }

    @Override
    public void onClick(View v) {
        itemOnClickListener.OnClick(v,getAdapterPosition(),false);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.setHeaderTitle("Select the action");
        menu.add(0,0,getAdapterPosition(), Constants.KEY_UPDATE);
        menu.add(0,1,getAdapterPosition(),Constants.KEY_DELETE);
    }
}
