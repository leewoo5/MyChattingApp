package com.topfactory.leewoo5629.mychattingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AuthActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mIdEditText;
    private EditText mPasswordEditText;
    private Button mConfirm;
    private String mPageType;
    private Boolean mIsSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        mIdEditText = (EditText) findViewById(R.id.IdEditText);
        mPasswordEditText = (EditText) findViewById(R.id.PasswordEditText);
        mConfirm = (Button) findViewById(R.id.button_confirm);

        Intent intent = getIntent();
        Boolean isSignUp = intent.getBooleanExtra("isSignUp", false);
//        if (isSignUp) {
//            mPageType = "Sign Up";
//        } else {
//            mPageType = "LogIn";
//        }
        mPageType = isSignUp ? "Sign Up" : "Login";
        mIsSignUp = isSignUp;
        mConfirm.setText(mPageType);
        mConfirm.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(mIdEditText.getText().toString() != ""
                && mPasswordEditText.getText().toString() != "") {
            if(mIsSignUp) {

            } else {

            }
        }
    }
}
