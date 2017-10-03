package com.topfactory.leewoo5629.mychattingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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
    private ArrayAdapter<String> mAdapter;
    private ArrayList<String> mFriendsList;
    private ArrayList<String> mFriendsKeyList;

    private String mUserKey;
    private String mMyKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend);

        setFirebase();
        setFriendListView();
        setLogoutButton();
        setChildEvent();
    }
    private void setFirebase() {
        mAuth = FirebaseAuth.getInstance();
        mFirebaseDatabaseReference = FirebaseDatabase.getInstance().getReference();
    }
    private void setFriendListView() {
        mFriendListView = (ListView) findViewById(R.id.FriendListView);
        mFriendsList = new ArrayList<>();
        mFriendsKeyList = new ArrayList<>();

        mAdapter = new ArrayAdapter<>(this, R.layout.list_item, mFriendsList);
        mFriendListView.setAdapter(mAdapter);
        mFriendListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(FriendActivity.this, MainActivity.class);
                intent.putExtra("email", mFriendsList.get(position));
                intent.putExtra("key", mFriendsKeyList.get(position));
                intent.putExtra("myKey", mAuth.getCurrentUser().getUid());
                startActivity(intent);
            }
        });
    }
    private void setLogoutButton() {
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
    }
    private void setChildEvent() {
        ChildEventListener childEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Friend friend = dataSnapshot.getValue(Friend.class);
                mFriendsList.add(friend.getEmail());
                mFriendsKeyList.add(dataSnapshot.getKey());
                //mAdapter.add(friend.getEmail());
                mAdapter.notifyDataSetChanged();
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
