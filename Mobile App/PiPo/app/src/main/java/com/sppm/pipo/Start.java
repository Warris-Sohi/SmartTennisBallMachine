package com.sppm.pipo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class Start extends AppCompatActivity {
    private static final String TAG = "CloudFireStore";
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference dRef = database.getReference("PiPo_DATA");
        TextView labeldiff=(TextView)findViewById(R.id.diffLabel);
        TextView labelLA=(TextView)findViewById(R.id.LALabel);
        TextView labelTI=(TextView)findViewById(R.id.TILabel);
        Bundle bundle = getIntent().getExtras();
        final String difficulty = bundle.getString("difficulty","easy");
        final int LA=bundle.getInt("LA",50);
        final int TI=bundle.getInt("TI",2);
        labeldiff.setText("Difficulty="+difficulty);
        labelLA.setText("Launch Angle="+LA);
        labelTI.setText("Time Interval="+TI);
        int time = (int) (System.currentTimeMillis());
        Timestamp tsTemp = new Timestamp(time);
        String ts =  tsTemp.toString();

        final Post post =new Post(difficulty,LA,TI);
        final Map<String, Object> playpost = new HashMap<>();
        playpost.put("Difficulty", difficulty);
        playpost.put("Launch", LA);
        playpost.put("Interval", TI);
        playpost.put("Timestamp",ts);
        Button button = findViewById(R.id.LaunchButton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(),
                        difficulty+TI+LA,
                        Toast.LENGTH_SHORT);
                toast.show();
                dRef.push().setValue(post);
                // Add a new document with a generated ID
                db.collection("playSettings")
                        .add(playpost)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                                Toast toast = Toast.makeText(getApplicationContext(),
                                        difficulty+TI+LA,
                                        Toast.LENGTH_SHORT);
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w(TAG, "Error adding document", e);
                                Toast toast = Toast.makeText(getApplicationContext(),
                                        "Cloud Firestore update failed",
                                        Toast.LENGTH_SHORT);
                            }
                        });
            }
        });

    }
}