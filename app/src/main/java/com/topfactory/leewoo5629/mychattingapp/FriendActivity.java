package com.topfactory.leewoo5629.mychattingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class FriendActivity extends AppCompatActivity {

    private final String CHILD_FRIENDS = "friends";
    private DatabaseReference mFirebaseDatabaseReference;
    private FirebaseAuth mAuth;

    private Button mLogout;
    private ListView mFriendListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend);

        mAuth = FirebaseAuth.getInstance();
        mFirebaseDatabaseReference = FirebaseDatabase.getInstance().getReference();

        mFriendListView = (ListView) findViewById(R.id.FriendListView);
        ArrayList<String> friends = new ArrayList<>();
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_item, friends);
        mFriendListView.setAdapter(adapter);



        mLogout = (Button) findViewById(R.id.button_logout);
        mLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                Intent intent = new Intent(FriendActivity.this, LaunchActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        ChildEventListener childEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Friend friend = dataSnapshot.getValue(Friend.class);
                adapter.add(friend.getEmail());
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
        mFirebaseDatabaseReference.child(CHILD_FRIENDS).addChildEventListener(childEventListener);

    }
}
