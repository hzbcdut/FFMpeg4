package com.example.huzhengbiao.ffmpeg4;

/**
 * 主要功能:
 * author huzhengbiao
 * date : On 2018/10/26
 */
public class PlayerNative {

    /**
     * 这里加载有依赖关系
     */
    static {
        System.loadLibrary("avutil-55");
        System.loadLibrary("swresample-2");
        System.loadLibrary("avcodec-57");
        System.loadLibrary("avfilter-6");
        System.loadLibrary("swscale-4");
        System.loadLibrary("avdevice-57");
        System.loadLibrary("avformat-57");
        System.loadLibrary("postproc-54");
        System.loadLibrary("native-ffmpeg");
    }


    /**
     * 音视频解码播放
     *
     * @param path
     * @param view
     */
    public native static void paly(String path, Object view);

    /**
     * 音视频解码停止
     *
     */
    public native static void stop();

}