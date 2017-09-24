package com.topfactory.leewoo5629.mychattingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LaunchActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mButtonSignUp;
    private Button mButtonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        mButtonSignUp = (Button) findViewById(R.id.button_SignUp);
        mButtonLogin = (Button) findViewById(R.id.button_Login);

        mButtonSignUp.setOnClickListener(this);
        mButtonLogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(LaunchActivity.this, AuthActivity.class);
        switch (view.getId()){
            case (R.id.button_SignUp):
                intent.putExtra("isSignUp", true);
                break;
            case (R.id.button_Login):

                break;
            default:
                intent.putExtra("isSignUp", false);
                break;
        }
        startActivity(intent);
    }
}
