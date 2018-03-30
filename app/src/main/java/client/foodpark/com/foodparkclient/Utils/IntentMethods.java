package client.foodpark.com.foodparkclient.Utils;

import android.content.Context;
import android.content.Intent;

import client.foodpark.com.foodparkclient.Auth.FPCSignInActivity;

/**
 * Created by dennis on 30/3/18.
 */

public class IntentMethods {

    public static void callIntent (Context context, Class<?> destinationClass){
        Intent callIntent = new Intent(context,destinationClass);
        context.startActivity(callIntent);
    }
}
