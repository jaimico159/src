package com.sergio;
import marvin.io.*;
import marvin.image.*;
import marvin.math.*;
import static  marvin.MarvinPluginCollection.*;
import marvin.color.MarvinColorModelConverter;


public class Main {

    public static void main(String[] args) {
	        String firstPath = "C:\\Users\\sergi\\Desktop\\broken4.jpeg";
	        String destinyPath = "C:\\Users\\sergi\\Desktop\\output5.png";
	    	applyMorphologicalClosing(firstPath, destinyPath);
	    	
	        System.exit(0);
	    }
	    
	    /**
	     * By Sergio Laureano
	     * @param imagePath
	     * @param pathDestiny
	     */
	    public static void applyMorphologicalClosing(String imagePath, String pathDestiny) {
	    	MarvinImage image = MarvinImageIO.loadImage(imagePath);
	        image = MarvinColorModelConverter.rgbToBinary(image, 127);
	        morphologicalClosing(image.clone(), image, MarvinMath.getTrueMatrix(60, 60));
	        MarvinImageIO.saveImage(image, pathDestiny);
	    }

}
