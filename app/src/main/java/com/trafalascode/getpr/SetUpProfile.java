package com.trafalascode.getpr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SetUpProfile extends AppCompatActivity {

    Button saveProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_up_profile);

        saveProfile = (Button)findViewById(R.id.setUpProfileSaveProfileButton);

        saveProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSaveProfilePressed();
            }
        });
    }

    public void onSaveProfilePressed(){
        Intent intent = new Intent(this, EventList.class);
        startActivity(intent);
    }
}
