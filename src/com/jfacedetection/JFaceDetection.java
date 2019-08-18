package com.jfacedetection;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

public class JFaceDetection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		String imgFile = "images/RonaldoAndMessi2.png";
		Mat src= Imgcodecs.imread(imgFile);
		
		String xmlFile = "xml/lbpcascade_frontalface.xml";
		CascadeClassifier cascadeClassifier =new CascadeClassifier(xmlFile);
		
		MatOfRect faceDetection = new MatOfRect();
		cascadeClassifier.detectMultiScale(src, faceDetection);
		System.out.println(String.format("Face detection %d:", faceDetection.toArray().length));
		
		for (Rect rect : faceDetection.toArray()) {
			Imgproc.rectangle(src, new Point(rect.x, rect.y), new Point(rect.x + rect.width,rect.y + rect.height), new Scalar(0, 0, 255),3);
			
		}
		Imgcodecs.imwrite("images/RonaldoAndMessi2_out.png",src);
		System.out.println("Face detection finished");
	}

}
