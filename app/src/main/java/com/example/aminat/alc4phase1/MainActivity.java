package com.example.aminat.alc4phase1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button abotAlc, myprofile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        abotAlc = (Button) findViewById(R.id.aboutAlc);
        myprofile = (Button) findViewById(R.id.myprofile);

        abotAlc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AboutALC.class);
                startActivity(intent);

            }
        });

        myprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MyProfile.class);
                startActivity(intent);
            }
        });
    }
}
