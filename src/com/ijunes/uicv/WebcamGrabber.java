package com.ijunes.uicv;

import com.googlecode.javacv.FrameGrabber;
import com.googlecode.javacv.cpp.opencv_core;

/**
 * // The available FrameGrabber classes include OpenCVFrameGrabber (opencv_highgui),
 // DC1394FrameGrabber, FlyCaptureFrameGrabber, OpenKinectFrameGrabber,
 // PS3EyeFrameGrabber, VideoInputFrameGrabber, and FFmpegFrameGrabber.
 * Created by ijunes on 12/14/13.
 */
public class WebcamGrabber extends FrameGrabber {
    protected FrameGrabber frameGrabber;

    
    @Override
    public void start() throws Exception {
        frameGrabber = FrameGrabber.createDefault(0);
        frameGrabber.start();
    }

    @Override
    public void stop() throws Exception {
        frameGrabber.stop();
    }

    @Override
    public void trigger() throws Exception {
        frameGrabber.trigger();
    }

    @Override
    public opencv_core.IplImage grab() throws Exception {
        return frameGrabber.grab();
    }

    @Override
    public void release() throws Exception {
        frameGrabber.release();
    }
}
