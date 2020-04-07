package com.sppm.pipo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Play extends AppCompatActivity {
    String difficulty="easy";
    int LaunchAngle;
    int TimeInterval;
    RadioButton diff;
    RadioGroup radioGroup;
    private SeekBar LAseekBar;
    private SeekBar IDseekBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        radioGroup = (RadioGroup)findViewById(R.id.RadioGroup);
        LAseekBar = (SeekBar) findViewById(R.id.LA);
        IDseekBar = (SeekBar) findViewById(R.id.ID);
        LAseekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
                progress = progresValue;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        IDseekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
                progress = progresValue;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        final Button button = findViewById(R.id.nextButton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                diff=(RadioButton) findViewById(selectedId);
                if(selectedId==-1){
                    Toast.makeText(Play.this,"Nothing selected for difficulty", Toast.LENGTH_SHORT).show();
                }
                else{
                    difficulty=diff.getText().toString();
                }
                TimeInterval= IDseekBar.getProgress();
                LaunchAngle= LAseekBar.getProgress();

                Intent intent = new Intent(Play.this, Start.class);
                intent.putExtra("difficulty",difficulty);
                intent.putExtra("TI",TimeInterval);
                intent.putExtra("LA",LaunchAngle);

                startActivity(intent);
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu1, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
//respond to menu item selection
        switch (item.getItemId()) {
            case R.id.Profile:
                startActivity(new Intent(this, Profile.class));
                return true;
            case R.id.Settings:
                startActivity(new Intent(this, Settings.class));
                return true;
            case R.id.SignOut:
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(this, MainActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
