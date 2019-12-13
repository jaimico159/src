package com.aaron

import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;
import org.opencv.imgcodecs.Imgcodecs;

public class ProcessImage {
	ProcessImage(){

	}


	public void Grayscale(String imagePath, String pathDestiny){
		//Transformacion a escala de Grises
		Mat srcImage = Imgcodecs.imread(imagePath, Imgcodecs.IMREAD_GRAYSCALE);		
		Imgproc.threshold(srcImage, srcImage, 255, 255, Imgproc.THRESH_OTSU);
		Imgcodecs.imwrite(pathDestiny, srcImage);
	}

	public void GaussianBlur(String imagePath, String pathDestiny){
		//Transformacion a escala de Grises
		Mat srcImage = Imgcodecs.imread(imagePath, Imgcodecs.IMREAD_GRAYSCALE);		
		Imgproc.threshold(srcImage, srcImage, 255, 255, Imgproc.THRESH_OTSU);
		Imgcodecs.imwrite(pathDestiny, srcImage);
	}

	public void DEProcess(String imagePath, String pathDestiny){
		//Dilatacion y erosion
		Mat srcImage = Imgcodecs.imread(imagePath, Imgcodecs.IMREAD_GRAYSCALE);		
		for(int i = 1; i < 10; i++){
			Imgproc.erode(srcImage, srcImage, new Mat());
			Imgproc.threshold(srcImage, srcImage, 0, 255, Imgproc.THRESH_OTSU);
			Imgproc.dilate(srcImage, srcImage, new Mat());
			Imgproc.threshold(srcImage, srcImage, 0, 255, Imgproc.THRESH_OTSU);
			//Imgproc.erode(srcImage, srcImage, new Mat());
		}
		for(int i = 1; i < 2; i++)
			Imgproc.dilate(srcImage, srcImage, new Mat());
		Imgcodecs.imwrite(pathDestiny, srcImage);
	}

	public void BineryThreshold(String imagePath, String pathDestiny){
		//Binarizacion
		Mat srcImage = Imgcodecs.imread(imagePath, Imgcodecs.IMREAD_GRAYSCALE);		
		Mat element = Imgproc.getStructuringElement(Imgproc.CV_SHAPE_RECT, new Size(2 * 0 + 1, 2 * 0 + 1), new Point(0, 0));
		Imgproc.morphologyEx(srcImage, srcImage, Imgproc.MORPH_CLOSE, element);			
		Imgproc.threshold(srcImage, srcImage, 0, 255, Imgproc.THRESH_OTSU);
		Imgcodecs.imwrite(pathDestiny, srcImage);
	}




	public Mat cleanImage_A (String fileA) {
		//Transformacion a escala de Grises
		Mat srcImage = Imgcodecs.imread(fileA, Imgcodecs.IMREAD_GRAYSCALE);		
		Imgproc.threshold(srcImage, srcImage, 255, 255, Imgproc.THRESH_OTSU);
		Imgcodecs.imwrite("D:/preproces/prueba1.png", srcImage);

		//Desenfoque Gaussiano
		Imgproc.GaussianBlur(srcImage, srcImage, new Size(0, 0), 1);
		Imgcodecs.imwrite("D:/preproces/prueba2.png", srcImage);

		//Erosion y Dilatacion de Imagen
		for(int i = 1; i < 10; i++){
			Imgproc.erode(srcImage, srcImage, new Mat());
			Imgproc.threshold(srcImage, srcImage, 0, 255, Imgproc.THRESH_OTSU);
			Imgproc.dilate(srcImage, srcImage, new Mat());
			Imgproc.threshold(srcImage, srcImage, 0, 255, Imgproc.THRESH_OTSU);
			//Imgproc.erode(srcImage, srcImage, new Mat());
		}
		for(int i = 1; i < 2; i++)
			Imgproc.dilate(srcImage, srcImage, new Mat());
		Imgcodecs.imwrite("D:/preproces/prueba3.png", srcImage);

		//Binarizacion de imagen
		Mat element = Imgproc.getStructuringElement(Imgproc.CV_SHAPE_RECT, new Size(2 * 0 + 1, 2 * 0 + 1), new Point(0, 0));
		Imgproc.morphologyEx(srcImage, srcImage, Imgproc.MORPH_CLOSE, element);		
		Imgcodecs.imwrite("D:/preproces/prueba4.png", srcImage);

		Imgproc.threshold(srcImage, srcImage, 0, 255, Imgproc.THRESH_OTSU);

		return srcImage;
	}	

	public String cleanImage_B (String fileA) {
		//Transformacion a escala de Grises
		Mat srcImage = Imgcodecs.imread(fileA, Imgcodecs.IMREAD_GRAYSCALE);		
		Imgproc.threshold(srcImage, srcImage, 255, 255, Imgproc.THRESH_OTSU);
		Imgcodecs.imwrite("D:/preproces/prueba1.png", srcImage);

		//Desenfoque Gaussiano
		Imgproc.GaussianBlur(srcImage, srcImage, new Size(0, 0), 1);
		Imgcodecs.imwrite("D:/preproces/prueba2.png", srcImage);

		//Erosion y Dilatacion de Imagen
		for(int i = 1; i < 10; i++){
			Imgproc.erode(srcImage, srcImage, new Mat());
			Imgproc.threshold(srcImage, srcImage, 0, 255, Imgproc.THRESH_OTSU);
			Imgproc.dilate(srcImage, srcImage, new Mat());
			Imgproc.threshold(srcImage, srcImage, 0, 255, Imgproc.THRESH_OTSU);
			//Imgproc.erode(srcImage, srcImage, new Mat());
		}
		Imgcodecs.imwrite("D:/preproces/prueba3.png", srcImage);

		//Binarizacion de imagen
		Mat element = Imgproc.getStructuringElement(Imgproc.CV_SHAPE_RECT, new Size(2 * 0 + 1, 2 * 0 + 1), new Point(0, 0));
		Imgproc.morphologyEx(srcImage, srcImage, Imgproc.MORPH_CLOSE, element);		
		Imgcodecs.imwrite("D:/preproces/prueba4.png", srcImage);

		Imgproc.threshold(srcImage, srcImage, 0, 255, Imgproc.THRESH_OTSU);

		Imgcodecs.imwrite("D:/preproces/pruebafinal.png", srcImage);

		return "D:/preproces/pruebafinal.png";
	}	
}
