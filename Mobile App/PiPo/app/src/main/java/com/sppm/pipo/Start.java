package com.sppm.pipo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Start extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference diffRef = database.getReference("Difficulty");
        final DatabaseReference LARef = database.getReference("LaunchAngle");
        final DatabaseReference TIRef = database.getReference("TimeInterval");
        TextView labeldiff=(TextView)findViewById(R.id.textView5);
        TextView labelLA=(TextView)findViewById(R.id.textView6);
        TextView labelTI=(TextView)findViewById(R.id.textView7);
        Bundle bundle = getIntent().getExtras();
        final String difficulty = bundle.getString("difficulty","easy");
        final int LA=bundle.getInt("LA",50);
        final int TI=bundle.getInt("TI",2);
        labeldiff.setText("Difficulty="+difficulty);
        labelLA.setText("Launch Angle="+LA);
        labelTI.setText("Time Interval="+TI);
        Button button = findViewById(R.id.LaunchButton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                diffRef.setValue(difficulty);
                LARef.setValue(LA);
                TIRef.setValue(TI);
            }
        });

    }
}
