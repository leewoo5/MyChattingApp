package com.topfactory.leewoo5629.mychattingapp;

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

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case (R.id.button_SignUp):

                break;
            case (R.id.button_Login):
                break;
        }
    }
}
