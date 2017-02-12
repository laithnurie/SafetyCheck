package com.laithlab.safetycheck.db;

import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.laithlab.safetycheck.LocationDataItem;
import com.laithlab.safetycheck.SafetyUserInfo;

import java.util.ArrayList;
import java.util.List;

public class SCDataBase {

    private final DatabaseReference userRef;

    public SCDataBase() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        userRef = database.getReference("users");
        userRef.child(user.getUid()).setValue(new SafetyUserInfo("Laith", user.getEmail(), null));
        // Read from the database
    }

    public List<String> getFriendsOfUser(String email) {
        return new ArrayList<>();
    }

    public void findUserLocation(String email) {
        Query findUserByEmailQuery = userRef.orderByChild("email").equalTo(email);

        findUserByEmailQuery.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot queryDataSnapShot) {
                for (DataSnapshot userInfoDataSnapshot : queryDataSnapShot.getChildren()) {
                    DataSnapshot locationDataSnapShot = userInfoDataSnapshot.child("locationData");
                    int indexOnNewLocation = (int) (locationDataSnapShot.getChildrenCount() - 1);
                    String indexOnNewLocationString = String.valueOf(indexOnNewLocation);
                    LocationDataItem locationDataItem = locationDataSnapShot.child(indexOnNewLocationString)
                            .getValue(LocationDataItem.class);
                    Log.v("lnln", "Location - " + locationDataItem.toString());
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void addListenerToUserLocationData(String userId) {
        userRef.child(userId).child("locationData").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Log.d("lnln", dataSnapshot.toString());
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
        });
    }
}
