package com.ijunes.uicv;

import com.googlecode.javacv.FrameRecorder;
import com.googlecode.javacv.cpp.opencv_core;

/**
 *   The OpenCVFrameRecorder class simply uses the CvVideoWriter of opencv_highgui,
    but FFmpegFrameRecorder also exists as a more versatile alternative.
 * Created by ijunes on 12/14/13.
 */
public class WebcamRecorder extends FrameRecorder {
    private int width, height;
    private FrameRecorder recorder;

    public WebcamRecorder(int width, int height){
        this.width = width ;
        this.height = height ;
        try {
            start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void start() throws Exception {
        recorder = FrameRecorder.createDefault("output.avi", width, height);
        recorder.start();
    }

    @Override
    public void stop() throws Exception {
        recorder.stop();
    }

    @Override
    public boolean record(opencv_core.IplImage image) throws Exception {
        return recorder.record(image);
    }

    @Override
    public void release() throws Exception {
        recorder.release();
    }
}
