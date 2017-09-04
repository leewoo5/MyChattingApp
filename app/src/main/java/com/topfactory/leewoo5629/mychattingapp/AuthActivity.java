package com.topfactory.leewoo5629.mychattingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class AuthActivity extends AppCompatActivity {

    private EditText mIdEditText;
    private EditText mPasswordEditText;
    private Button mConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        mIdEditText = (EditText) findViewById(R.id.IdEditText);
        mPasswordEditText = (EditText) findViewById(R.id.PasswordEditText);
        mConfirm = (Button) findViewById(R.id.button_confirm);
    }
}
