package com.mafanwei.libvlc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends Activity implements OnClickListener {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);
        Button buttonVid1 = (Button) findViewById(R.id.vid1);
        Button  buttonVid2 = (Button) findViewById(R.id.vid2);
        buttonVid1.setOnClickListener(this);
        buttonVid2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.vid1:
                Intent intent_1 = new Intent(this, Video1.class);
                startActivity(intent_1);
                break;

            case R.id.vid2:
                Intent intent_2 = new Intent(this, Video2.class);
                startActivity(intent_2);
                break;

            default:
                break;
        }

    }
}