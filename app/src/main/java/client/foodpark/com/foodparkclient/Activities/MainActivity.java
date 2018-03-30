package client.foodpark.com.foodparkclient.Activities;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import client.foodpark.com.foodparkclient.Auth.FPCSignInActivity;
import client.foodpark.com.foodparkclient.R;
import client.foodpark.com.foodparkclient.Utils.IntentMethods;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button signIn;
    private TextView tvSlogan;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        signIn=findViewById(R.id.btnSignIn);
        tvSlogan=findViewById(R.id.tvSlogan);
        signIn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int Id = v.getId();
        switch (Id){
            case R.id.btnSignIn:
                IntentMethods.callIntent(context, FPCSignInActivity.class);
                break;
        }
    }
}
