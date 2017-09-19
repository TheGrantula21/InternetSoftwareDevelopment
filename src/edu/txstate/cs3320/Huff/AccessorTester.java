package edu.txstate.cs3320.Huff;


import java.util.*;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class AccessorTester {

	public static void main(String[] args) {
		
		
		
		
		
		
		
		PlayJSONReader play = new PlayJSONReader();
		
		PlayWriter playWriter = new PlayWriter();
		
		
		
		String thePlay = play.readPlay("MidsummerNightsDream.json");
		
		playWriter.writePlay(thePlay, thePlay);
		
		
		
		
		

	}

}
