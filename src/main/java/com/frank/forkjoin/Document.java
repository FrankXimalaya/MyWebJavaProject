package com.frank.forkjoin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 *在fork-join中首先应该尽量避免进行IO操作，应该是纯内存进行计算
 */

public class Document {
	
	 private final List<String> lines;
	    
	    Document(List<String> lines) {
	        this.lines = lines;
	    }
	    
	    List<String> getLines() {
	        return this.lines;
	    }
	    
	    static Document fromFile(File file) throws IOException {
	        List<String> lines = new LinkedList<>();
	        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
	            String line = reader.readLine();
	            while (line != null) {
	                lines.add(line);
	                line = reader.readLine();
	            }
	        }
	        return new Document(lines);
	    }

}
