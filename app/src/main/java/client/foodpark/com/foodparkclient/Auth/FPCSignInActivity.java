package client.foodpark.com.foodparkclient.Auth;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

import client.foodpark.com.foodparkclient.Model.User;
import client.foodpark.com.foodparkclient.R;
import client.foodpark.com.foodparkclient.Utils.Constants;

public class FPCSignInActivity extends AppCompatActivity implements View.OnClickListener{

    private MaterialEditText etPhoneNumber;
    private MaterialEditText etPassword;
    private Button btnLoginIn;
    private FirebaseDatabase userDatabase;
    private DatabaseReference userTableReference;
    private String phoneNumber;
    private String password;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fpc_sign_in);
        userDatabase = FirebaseDatabase.getInstance();
        userTableReference = userDatabase.getReference().child(Constants.KEY_USER);
        etPhoneNumber=findViewById(R.id.et_phone_number);
        etPassword=findViewById(R.id.et_password);
        btnLoginIn=findViewById(R.id.btnLogIn);
        btnLoginIn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int Id = v.getId();

        switch (Id){
            case R.id.btnLogIn:
                progressDialog = new ProgressDialog(this);
                progressDialog.setMessage("Loading...");
                progressDialog.show();
                phoneNumber = etPhoneNumber.getText().toString();
                password = etPassword.getText().toString();
                userTableReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        if (dataSnapshot.child(phoneNumber).exists()){
                            progressDialog.dismiss();
                            User user = dataSnapshot.child(phoneNumber).getValue(User.class);
                            user.setPhone(phoneNumber);
                            if (Boolean.parseBoolean(user.getIsStaff())){
                                if (user.getPassword().equals(password)){

                                }else {
                                    progressDialog.dismiss();
                                    Toast.makeText(FPCSignInActivity.this, "Worng Password !", Toast.LENGTH_SHORT).show(); 
                                }
                            }else {
                                progressDialog.dismiss();
                                Toast.makeText(FPCSignInActivity.this, "Please login with Staff account", Toast.LENGTH_SHORT).show();
                            }
                        }else {
                            progressDialog.dismiss();
                            Toast.makeText(FPCSignInActivity.this, "User not exist in Database", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                        Log.d("ERROR",""+databaseError.getMessage());
                    }
                });
                break;
        }
    }
}
