package com.frank.thread;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GenerateSample {
	
	public static void main(String[] args) {
		
		File f = new File("/C:/Users/zy/Desktop/sample.txt");
		FileWriter writer;
		try {
			writer = new FileWriter(f, false);
			Random random1 = new Random(10);
			for (int i = 0; i < 10000000; i++) {
				writer.write(String.valueOf(random1.nextInt(20000)));
				writer.write("\r\n");
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}
	}

}
