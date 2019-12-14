package com.sergio;

import marvin.io.*;
import marvin.image.*;
import marvin.math.*;
import static  marvin.MarvinPluginCollection.*;

import marvin.color.MarvinColorModelConverter;

public class Main {

	
	    public static void main(String[] args) {
	        String firstPath = "~/Desktop/temp.png";
	        String destinyPath = "~/Desktop/temp1.png";
	    	applyMorphologicalClosing(firstPath, destinyPath, 50);
	    	
	        System.exit(0);
	    }
	    
	    /**
	     * By Sergio Laureano
	     * @param pathSource
	     * @param pathDestiny
	     */
	    public static void applyMorphologicalClosing(String pathSource, String pathDestiny, int degree) {
	    	MarvinImage image = MarvinImageIO.loadImage(pathSource);
	        image = MarvinColorModelConverter.rgbToBinary(image, 127);
	        morphologicalClosing(image.clone(), image, MarvinMath.getTrueMatrix(degree, degree));
	        MarvinImageIO.saveImage(image, pathDestiny);
	    }
	    
	    
}

