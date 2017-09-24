package com.topfactory.leewoo5629.mychattingapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class AuthActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mIdEditText;
    private EditText mPasswordEditText;
    private Button mConfirm;
    private String mPageType;
    private Boolean mIsSignUp;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        mIdEditText = (EditText) findViewById(R.id.IdEditText);
        mPasswordEditText = (EditText) findViewById(R.id.PasswordEditText);
        mConfirm = (Button) findViewById(R.id.button_confirm);

        mAuth = FirebaseAuth.getInstance();

        Intent intent = getIntent();
        Boolean isSignUp = intent.getBooleanExtra("isSignUp", false);
//        if (isSignUp) {
//            mPageType = "Sign Up";
//        } else {
//            mPageType = "LogIn";q
//        }
        mPageType = isSignUp ? "Sign Up" : "Login";
        mIsSignUp = isSignUp;
        mConfirm.setText(mPageType);
        mConfirm.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (mIdEditText.getText().toString() != ""
                && mPasswordEditText.getText().toString() != "") {
            if (mIsSignUp) {
                mAuth.createUserWithEmailAndPassword(
                        mIdEditText.getText().toString(),
                        mPasswordEditText.getText().toString()
                ).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(AuthActivity.this, "Authentication Success.",
                                    Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(AuthActivity.this, FriendActivity.class));

                        } else {
                            Toast.makeText(AuthActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            mIdEditText.setText("");
                            mPasswordEditText.setText("");
                        }
                    }
                });
            } else {
                mAuth.signInWithEmailAndPassword(
                        mIdEditText.getText().toString(),
                        mPasswordEditText.getText().toString()
                ).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(AuthActivity.this, "Login Success.",
                                    Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(AuthActivity.this, FriendActivity.class));

                        } else {
                            Toast.makeText(AuthActivity.this, "Login failed.",
                                    Toast.LENGTH_SHORT).show();
                            mIdEditText.setText("");
                            mPasswordEditText.setText("");
                        }
                    }
                });
            }
        }
    }
}