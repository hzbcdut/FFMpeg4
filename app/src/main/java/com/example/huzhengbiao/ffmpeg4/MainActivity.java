package com.example.huzhengbiao.ffmpeg4;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    private VideoView mVideo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        TextView tv = (TextView) findViewById(R.id.sample_text);
        tv.setText(stringFromJNI());


        mVideo = findViewById(R.id.video);
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();


    public void paly(View view) {
        final String dir = Environment.getExternalStorageDirectory() + File.separator + "Download";
        final String path = dir + File.separator + "1.mp4";
        final VideoView mVideo = (VideoView) findViewById(R.id.video);
        if (new File(path).exists()) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    PlayerNative.paly(path, mVideo.getHolder().getSurface());
                }
            });
        } else {
            System.out.println("文件不存在");
        }
    }

    public void stop(View view) {
        PlayerNative.stop();
    }
}
