package com.jypt.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;



public class ImageUtil {
	 public static FileInputStream readImage(String path) throws IOException {
		         return new FileInputStream(new File(path));
         }

}