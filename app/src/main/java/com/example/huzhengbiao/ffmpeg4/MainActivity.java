package com.example.huzhengbiao.ffmpeg4;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

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

        findViewById(R.id.btn_play).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                play(v);
            }
        });

        findViewById(R.id.btn_stop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop(v);
            }
        });
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();


    public void play(View view) {

        final String path = "https://baobab.kaiyanapp.com/api/v1/playUrl?vid=132872&resourceType=video&editionType=default&source=aliyun&ptl=true";
        if (!TextUtils.isEmpty(path)) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    PlayerNative.paly(path, mVideo.getHolder().getSurface());
                }
            });
        } else {
            System.out.println("文件不存在");
            Toast.makeText(this, " 文件不存在", Toast.LENGTH_LONG).show();
        }
    }

    public void stop(View view) {
        PlayerNative.stop();
    }
}
