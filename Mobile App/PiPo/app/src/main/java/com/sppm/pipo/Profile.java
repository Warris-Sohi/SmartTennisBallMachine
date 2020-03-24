package com.sppm.pipo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Profile extends AppCompatActivity {
    TextView nameLabel,idLabel,emailLabel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        nameLabel=(TextView)findViewById(R.id.textViewname);
        idLabel=(TextView)findViewById(R.id.profileid);
        emailLabel=(TextView)findViewById(R.id.profile_email);
        String name = user.getDisplayName();
        String email = user.getEmail();
        String uid = user.getUid();
        nameLabel.setText("Name: "+name);
        idLabel.setText(uid);
        emailLabel.setText(email);
    }
}
