package edu.txstate.cs3320.Huff;
import com.google.gson.*;
import java.io.*;
import java.util.*;

public class PlayWriter {
	
	
	
	public static void writePlay(String thePlay, String outputFile) {
		
			
			
			JsonElement jelement = new JsonParser().parse(thePlay);
			
			JsonObject thePlayJsonObject = (JsonObject)jelement;
			
			
		
			
			String fileName = "play.txt";

	        try {
	        	
	        	
	        	// Assume default encoding.
	            FileWriter fileWriter =
	                new FileWriter(fileName);

	            // Always wrap FileWriter in BufferedWriter.
	            BufferedWriter bufferedWriter =
	                new BufferedWriter(fileWriter);

	            // Note that write() does not automatically
	            // append a newline character.
	            bufferedWriter.write(AccessorUtils.getPlayTitle(thePlayJsonObject));
	            
	            bufferedWriter.newLine();
	            bufferedWriter.newLine();
	            
	            bufferedWriter.write(AccessorUtils.getPlayYear(thePlayJsonObject));
	            
	            bufferedWriter.newLine();
	            bufferedWriter.newLine();
	            
	            
	            
	        	
	        	
	        		ArrayList<String> namesOfAct = AccessorUtils.getActsOfPlayByName(thePlayJsonObject);
	        		 
	        		int x = 1;
	        		
	        		for(String act: namesOfAct) {
	        			
	        			JsonObject ACT = AccessorUtils.getActOfPlay(thePlayJsonObject, act);
	        			
	        			ArrayList<String> namesOfScene = AccessorUtils.getScenesOfActByName(ACT);
	        			
	        			bufferedWriter.write("Act");
	        			
	        			
	        			bufferedWriter.write(String.valueOf(x));
	        			x++;
	        			
	        			bufferedWriter.newLine();
        	            bufferedWriter.newLine();
	        			
	        			
	        			bufferedWriter.write(act);
	        			bufferedWriter.write(", ");
	        			
	        			for(String scene : namesOfScene) {
	        				
	        				JsonObject sceneObject = AccessorUtils.getSceneOfAct(ACT, scene);
	        				
	        				String Location = AccessorUtils.getSceneLocation(sceneObject);
	        				
	        				JsonArray paragraphArray = AccessorUtils.getSceneParagraphs(sceneObject);
	        				
	        				bufferedWriter.write(scene);
	        				
	        				bufferedWriter.newLine();
	        	            bufferedWriter.newLine();
	        	            
	        	            bufferedWriter.write(Location);
	        	            
	        	            bufferedWriter.newLine();
	        	            bufferedWriter.newLine();
	        				
	        				
	        				for(JsonElement paragraph : paragraphArray) {
	        					
	        					JsonObject paragraphObject = paragraph.getAsJsonObject();
	        					
	        					String person = AccessorUtils.getCharacterFromParagraph(paragraphObject);
	        					
	        					String text = AccessorUtils.getTextFromParagraph(paragraphObject);
	        					
	        					bufferedWriter.write(person);
	        					
	        					bufferedWriter.newLine();
		        	            bufferedWriter.newLine();
	        					
	        					bufferedWriter.write(text);
	        					
	        					bufferedWriter.newLine();
		        	            bufferedWriter.newLine();
	        					
	        				
	        					
	        					
	        				}
	        				
	        			}
	        			
	        			
	        		}
	            
	           

	            // Always close files.
	            bufferedWriter.close();
	        }
	        catch(IOException ex) {
	            System.out.println(
	                "Error writing to file '"
	                + fileName + "'");
	           
	        }
			
					
		
	}
	
	

}
