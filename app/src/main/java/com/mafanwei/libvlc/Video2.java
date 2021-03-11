package com.mafanwei.libvlc;


import android.app.Activity;
import android.os.Bundle;
import android.view.SurfaceView;
import com.mafanwei.vlcLibrary.VlcVideoLibrary;


public class Video2 extends Activity {

    private SurfaceView surfaceView;
    private VlcVideoLibrary vlcVideoLibrary;
    private boolean first = true;
    private final String TAG = "Video2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video2);
        surfaceView = findViewById(R.id.sv);
        VlcVideoLibrary.Builder builder = new VlcVideoLibrary.Builder(this, true);
        builder.setSurfaceView(surfaceView);
        builder.useNoCache();
        builder.useFullScreen();
        vlcVideoLibrary = builder.create();
        vlcVideoLibrary.setPlayUrl("https://videolegenda.homelifemanager.cloud/hls/geroev3.m3u8");
        vlcVideoLibrary.setVlcVout();
    }

    @Override
    protected void onPause() {
        super.onPause();
        vlcVideoLibrary.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!first) {
            vlcVideoLibrary.resumePlay();
        } else {
            vlcVideoLibrary.startPlay();
            first = false;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        vlcVideoLibrary.stop();
        vlcVideoLibrary.release();
    }
}