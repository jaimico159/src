package com.aaron

import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;
import org.opencv.imgcodecs.Imgcodecs;

public class ProcessImage {
	ProcessImage(){

	}

	public void Grayscale(String imagePathInput, String imagePathOutput){
		//Transformacion a escala de Grises
		Mat imageProcessing = Imgcodecs.imread(imagePathInput, Imgcodecs.IMREAD_GRAYSCALE);		
		Imgproc.threshold(imageProcessing, imageProcessing, 255, 255, Imgproc.THRESH_OTSU);
		Imgcodecs.imwrite(imagePathOutput, imageProcessing);
	}

	public void GaussianBlur(String imagePathInput, String imagePathOutput	){
		//Transformacion a escala de Grises
		Mat imageProcessing = Imgcodecs.imread(imagePathInput, Imgcodecs.IMREAD_GRAYSCALE);		
		Imgproc.threshold(imageProcessing, imageProcessing, 255, 255, Imgproc.THRESH_OTSU);
		Imgcodecs.imwrite(imagePathOutput, imageProcessing);
	}

	public void DEProcess(String imagePathInput, String imagePathOutput){
		//Dilatacion y erosion
		Mat imageProcessing = Imgcodecs.imread(imagePathInput, Imgcodecs.IMREAD_GRAYSCALE);		
		for(int i = 1; i < 10; i++){
			Imgproc.erode(imageProcessing, imageProcessing, new Mat());
			Imgproc.threshold(imageProcessing, imageProcessing, 0, 255, Imgproc.THRESH_OTSU);
			Imgproc.dilate(imageProcessing, imageProcessing, new Mat());
			Imgproc.threshold(imageProcessing, imageProcessing, 0, 255, Imgproc.THRESH_OTSU);
			//Imgproc.erode(srcImage, srcImage, new Mat());
		}
		for(int i = 1; i < 2; i++)
			Imgproc.dilate(imageProcessing, imageProcessing, new Mat());
		Imgcodecs.imwrite(imagePathOutput, imageProcessing);
	}

	public void BineryThreshold(String imagePathInput, String imagePathOutput){
		//Binarizacion
		Mat imageProcessing = Imgcodecs.imread(imagePathInput, Imgcodecs.IMREAD_GRAYSCALE);		
		Mat element = Imgproc.getStructuringElement(Imgproc.CV_SHAPE_RECT, new Size(2 * 0 + 1, 2 * 0 + 1), new Point(0, 0));
		Imgproc.morphologyEx(imageProcessing, imageProcessing, Imgproc.MORPH_CLOSE, element);			
		Imgproc.threshold(imageProcessing, imageProcessing, 0, 255, Imgproc.THRESH_OTSU);
		Imgcodecs.imwrite(imagePathOutput, imageProcessing);
	}




	public Mat cleanImage_A (String imagePathInput) {
		//Transformacion a escala de Grises
		Mat imageProcessing = Imgcodecs.imread(imagePathInput, Imgcodecs.IMREAD_GRAYSCALE);		
		Imgproc.threshold(imageProcessing, imageProcessing, 255, 255, Imgproc.THRESH_OTSU);
		Imgcodecs.imwrite("D:/preproces/prueba1.png", imageProcessing);

		//Desenfoque Gaussiano
		Imgproc.GaussianBlur(imageProcessing, imageProcessing, new Size(0, 0), 1);
		Imgcodecs.imwrite("D:/preproces/prueba2.png", imageProcessing);

		//Erosion y Dilatacion de Imagen
		for(int i = 1; i < 10; i++){
			Imgproc.erode(imageProcessing, imageProcessing, new Mat());
			Imgproc.threshold(imageProcessing, imageProcessing, 0, 255, Imgproc.THRESH_OTSU);
			Imgproc.dilate(imageProcessing, imageProcessing, new Mat());
			Imgproc.threshold(imageProcessing, imageProcessing, 0, 255, Imgproc.THRESH_OTSU);
			//Imgproc.erode(srcImage, srcImage, new Mat());
		}
		for(int i = 1; i < 2; i++)
			Imgproc.dilate(imageProcessing, imageProcessing, new Mat());
		Imgcodecs.imwrite("D:/preproces/prueba3.png", imageProcessing);

		//Binarizacion de imagen
		Mat imageKernel = Imgproc.getStructuringElement(Imgproc.CV_SHAPE_RECT, new Size(2 * 0 + 1, 2 * 0 + 1), new Point(0, 0));
		Imgproc.morphologyEx(imageProcessing, imageProcessing, Imgproc.MORPH_CLOSE, imageKernel);		
		Imgcodecs.imwrite("D:/preproces/prueba4.png", imageProcessing);

		Imgproc.threshold(imageProcessing, imageProcessing, 0, 255, Imgproc.THRESH_OTSU);

		return imageProcessing;
	}	

	public String cleanImage_B (String imagePathInput) {
		//Transformacion a escala de Grises
		Mat imageProcessing = Imgcodecs.imread(imagePathInput, Imgcodecs.IMREAD_GRAYSCALE);		
		Imgproc.threshold(imageProcessing, imageProcessing, 255, 255, Imgproc.THRESH_OTSU);
		Imgcodecs.imwrite("D:/preproces/prueba1.png", imageProcessing);

		//Desenfoque Gaussiano
		Imgproc.GaussianBlur(imageProcessing, imageProcessing, new Size(0, 0), 1);
		Imgcodecs.imwrite("D:/preproces/prueba2.png", imageProcessing);

		//Erosion y Dilatacion de Imagen
		for(int i = 1; i < 10; i++){
			Imgproc.erode(imageProcessing, imageProcessing, new Mat());
			Imgproc.threshold(imageProcessing, imageProcessing, 0, 255, Imgproc.THRESH_OTSU);
			Imgproc.dilate(imageProcessing, imageProcessing, new Mat());
			Imgproc.threshold(imageProcessing, imageProcessing, 0, 255, Imgproc.THRESH_OTSU);
			//Imgproc.erode(srcImage, srcImage, new Mat());
		}
		for(int i = 1; i < 2; i++)
			Imgproc.dilate(imageProcessing, imageProcessing, new Mat());
		Imgcodecs.imwrite("D:/preproces/prueba3.png", imageProcessing);

		//Binarizacion de imagen
		Mat imageKernel = Imgproc.getStructuringElement(Imgproc.CV_SHAPE_RECT, new Size(2 * 0 + 1, 2 * 0 + 1), new Point(0, 0));
		Imgproc.morphologyEx(imageProcessing, imageProcessing, Imgproc.MORPH_CLOSE, imageKernel);		
		Imgcodecs.imwrite("D:/preproces/prueba4.png", imageProcessing);

		Imgproc.threshold(imageProcessing, imageProcessing, 0, 255, Imgproc.THRESH_OTSU);

		Imgcodecs.imwrite("D:/preproces/pruebafinal.png", imageProcessing);

		return "D:/preproces/pruebafinal.png";
	}	
}
