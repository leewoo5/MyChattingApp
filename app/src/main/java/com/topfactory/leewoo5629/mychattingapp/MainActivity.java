package com.topfactory.leewoo5629.mychattingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static com.topfactory.leewoo5629.mychattingapp.R.id.editText;
import static com.topfactory.leewoo5629.mychattingapp.R.id.listView;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private EditText mEditText;
    private Button mButton;
    private DatabaseReference mFirebaseDatabaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirebaseDatabaseReference = FirebaseDatabase.getInstance().getReference();

        mListView = (ListView) findViewById(listView);
        mEditText = (EditText) findViewById(R.id.editText);
        mButton = (Button) findViewById(R.id.sendButton);

        String[] samples = {"test1", "test2", "test3"};
        mListView.setAdapter(new ArrayAdapter<String>(this, R.layout.list_item, samples));

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Message message = new Message("leewoo5", mEditText.getText().toString());
                mFirebaseDatabaseReference.child("Messages").push().setValue(message);
                mEditText.setText("");
            }
        });
    }
}
