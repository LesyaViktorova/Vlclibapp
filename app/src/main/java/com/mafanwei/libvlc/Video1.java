package com.mafanwei.libvlc;


import android.app.Activity;
import android.os.Bundle;
import android.view.SurfaceView;
import com.mafanwei.vlcLibrary.VlcVideoLibrary;


public class Video1 extends Activity {

    private SurfaceView surfaceView;
    private VlcVideoLibrary vlcVideoLibrary;
    private boolean first = true;
    private final String TAG = "Video1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video1);
        surfaceView = findViewById(R.id.sv);
        VlcVideoLibrary.Builder builder = new VlcVideoLibrary.Builder(this, true);
        builder.setSurfaceView(surfaceView);
        builder.useNoCache();
        builder.useFullScreen();
        vlcVideoLibrary = builder.create();
        vlcVideoLibrary.setPlayUrl("rtsp://95.161.155.170:30002/prlwpMdv_s/");
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
