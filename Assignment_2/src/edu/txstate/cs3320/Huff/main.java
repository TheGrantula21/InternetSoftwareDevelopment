package edu.txstate.cs3320.Huff;

import java.io.*;
import java.util.*;


public class main {

	public static void main(String[] args) {
		
		HTMLTags htmlTags = new HTMLTags();
		
		
		
		 String fileName = "paragraphs.txt";
		 String content = null;
		try {
			
			content = new Scanner(new File("paragraphs.txt")).useDelimiter("\\Z").next();
			
		} catch (FileNotFoundException e1) {
			
			e1.printStackTrace();
		} 
		
		
		String aNewString = content.substring(0,279);
		
		String aNewString1 = content.substring(280, 434);
		
		String aNewString2 = content.substring(435, 538);
		
		String aNewString3 = content.substring(539, 643);
		
		
	        
	        
	        
	      File f = new File("assignment_2.html");
	      try {
	    	  BufferedWriter bw = new BufferedWriter (new FileWriter(f));
	    	  
	    	  bw.write(htmlTags.HTML_HEADER_START);
	    	  bw.write(htmlTags.TITLE_START);
	    	  bw.write("Assignment 2");
	    	  bw.write(htmlTags.TITLE_END);
	    	  bw.write(htmlTags.HTML_HEADER_END);
	    	  bw.write(htmlTags.BODY_START);
	    	  
	    	  bw.write(htmlTags.H1_START);
	    	  bw.write("Who are you? What is your background? What CS courses have you taken? What computer languages do you know?");
	    	  bw.write(htmlTags.H1_END);
	    	  
	    	  bw.write(htmlTags.PARAGRAPH_START);
	    	  bw.write(aNewString);  	   
	    	  bw.write(htmlTags.PARAGRAPH_END);
	    	  
	    	  bw.write(htmlTags.H2_START);
	    	  bw.write("Why are you taking this class?");
	    	  bw.write(htmlTags.H2_END);
	    	  
	    	  bw.write(htmlTags.PARAGRAPH_START);
	    	  bw.write(aNewString1); 	  	  	   
	    	  bw.write(htmlTags.PARAGRAPH_END);
	    	  
	    	  bw.write(htmlTags.H3_START);
	    	  bw.write("What are your interests in Computer Science?");
	    	  bw.write(htmlTags.H3_END);
	    	  
	    	  bw.write(htmlTags.PARAGRAPH_START);
	    	  bw.write(aNewString2); 	  	  	   
	    	  bw.write(htmlTags.PARAGRAPH_END);
	    	  
	    	  bw.write(htmlTags.H4_START);
	    	  bw.write("What is your 5 year plan?");
	    	  bw.write(htmlTags.H4_END);
	    	  
	    	  bw.write(htmlTags.PARAGRAPH_START);
	    	  bw.write(aNewString3); 	  	  	   
	    	  bw.write(htmlTags.PARAGRAPH_END);
	    	  
	    	  
	    	  bw.write(htmlTags.BODY_END);
	    	  bw.write(htmlTags.HTML_END);
	    	  
	    	  
	    	  
	    	  
	    	  
	    	  bw.close();
	    	  
	      } catch (IOException e) {
	    	  e.printStackTrace();
	      }

	}
	
	
	
	
}
