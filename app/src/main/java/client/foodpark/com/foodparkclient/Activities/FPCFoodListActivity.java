package client.foodpark.com.foodparkclient.Activities;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import client.foodpark.com.foodparkclient.Interfaces.ItemOnClickListener;
import client.foodpark.com.foodparkclient.Model.Food;
import client.foodpark.com.foodparkclient.R;
import client.foodpark.com.foodparkclient.Utils.Constants;
import client.foodpark.com.foodparkclient.ViewHolders.FoodListViewHolder;

public class FPCFoodListActivity extends AppCompatActivity {

    private RecyclerView rvFoodList;
    private String categoryId;
    private FirebaseDatabase foodDataBase;
    private DatabaseReference foodRef;
    private FirebaseStorage firebaseStorage;
    private StorageReference storageReference;
    private FirebaseRecyclerAdapter<Food,FoodListViewHolder> adapter;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fpcfood_list);
        context = this;
        foodDataBase = FirebaseDatabase.getInstance();
        foodRef = foodDataBase.getReference(Constants.KEY_FOOD);
        firebaseStorage = FirebaseStorage.getInstance();
        storageReference = firebaseStorage.getReference();
        rvFoodList = findViewById(R.id.fpc_rv_foodlist);
        rvFoodList.setHasFixedSize(true);
        rvFoodList.setLayoutManager(new LinearLayoutManager(this));

        if (getIntent()!=null){
            categoryId = getIntent().getStringExtra(Constants.KEY_CATEGORY_ID);
            Log.d("CATEGORY",""+categoryId);
        }

        if (categoryId!=null && !categoryId.isEmpty()){
            loadCategories(categoryId);
        }
    }

    private void loadCategories(String categoryId) {

        adapter = new FirebaseRecyclerAdapter<Food, FoodListViewHolder>(
                Food.class,
                R.layout.food_item_layout,
                FoodListViewHolder.class,
                foodRef.orderByChild("menuId").equalTo(categoryId)
        ) {
            @Override
            protected void populateViewHolder(FoodListViewHolder viewHolder, Food model, int position) {
                Log.d("TEXT",""+model.getName());
                viewHolder.txtItemName.setText(model.getName());
                Picasso.with(context).load(model.getImage()).into(viewHolder.imageURL);

                viewHolder.setItemOnClickListener(new ItemOnClickListener() {
                    @Override
                    public void OnClick(View view, int position, boolean isLongClick) {

                    }
                });
            }
        };
        adapter.notifyDataSetChanged();
        rvFoodList.setAdapter(adapter);

    }

}
