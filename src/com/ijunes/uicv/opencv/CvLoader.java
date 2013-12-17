package com.ijunes.uicv.opencv;

import com.googlecode.javacpp.Loader;
import com.googlecode.javacv.cpp.opencv_objdetect;
import com.googlecode.javacv.cpp.opencv_objdetect.*;

import java.io.File;
import java.net.URL;

import static com.googlecode.javacv.cpp.opencv_core.cvLoad;

/**
 * Created by gnak on 12/14/13.
 */
public class CvLoader extends Loader{

    public CvLoader(){
        try {
            main();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public CvLoader(String classifierName){
        this.classifierName = classifierName;
        try {
            main();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Classifier File Error");
        }
    }

    private String classifierName;
    private File file;
    private URL url;
    private CvObjectDetection cvObjectDetection;
    protected opencv_objdetect.CvHaarClassifierCascade haarClassifierCascade;


    public void main()throws Exception{

        if (classifierName==null) {
            url = new URL("https://raw.github.com/Itseez/opencv/master/data/haarcascades/haarcascade_frontalface_alt.xml");
            file = extractResource(url, null, "classifier", ".xml");
            file.deleteOnExit();
            this.classifierName = file.getAbsolutePath();
        } else {
           this.classifierName = classifierName;
        }

        // Preload the opencv_objdetect module to work around a known bug.
        Loader.load(opencv_objdetect.class);

        // We can "cast" Pointer objects by instantiating a new object of the desired class.
        this.haarClassifierCascade = new opencv_objdetect.CvHaarClassifierCascade(cvLoad(classifierName));
        if (this.haarClassifierCascade.isNull()) {
            System.err.println("Error loading classifier file \"" + classifierName + "\".");
            System.exit(1);
        }

    }

    public CvHaarClassifierCascade getHaarClassifier(){
        return this.haarClassifierCascade;
    }


}
