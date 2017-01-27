package com.laithlab.safetycheck;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.ProviderQueryResult;

public class MainActivity extends AppCompatActivity {

    private static String PARAM_USER_NAME = "user_name";

    public static Intent getIntent(Context context, String userName) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra(PARAM_USER_NAME, userName);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, getIntent().getStringExtra(PARAM_USER_NAME), Toast.LENGTH_SHORT).show();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

    }

}
