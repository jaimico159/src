package com.aaron;

import java.io.IOException;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;


public class Main {

	public static void main(String args[]) throws IOException { 
		ProcessImage PI = new ProcessImage();
		//Loading the OpenCV core library  
		System.loadLibrary( Core.NATIVE_LIBRARY_NAME ); 

		//Reading the Image from the file  
		
		String fileA = "D:/preproces/prueba0.png";
		String fileB = "D:/preproces/pruebafinal.png";

		Mat imageA = Imgcodecs.imread(fileA, Imgcodecs.IMREAD_GRAYSCALE);
		Mat image4 = new Mat();
		//------aplication
		image4 = PI.cleanImage_A(fileA);
		
		//Guardado
		Imgcodecs.imwrite(fileB, image4);
		System.out.println("Finish");
	} 
}
