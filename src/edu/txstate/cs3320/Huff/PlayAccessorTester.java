package edu.txstate.cs3320.Huff;

import java.util.ArrayList;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
//import com.ubiq.txstate.internet.assignment1.AccessorUtils;

public class PlayAccessorTester {

	public static void tryIt(String thePlay, String outputFile) {
		JsonElement jelement = new JsonParser().parse(thePlay);
		JsonObject thePlayJsonObject = (JsonObject) jelement;

		// write the play title and year, accessed using the AccessorUtils methods
		System.out.println(AccessorUtils.getPlayTitle(thePlayJsonObject));
		System.out.println(AccessorUtils.getPlayYear(thePlayJsonObject));

		// extract all the acts of the play by name from the 'attribute' "acts"
		ArrayList<String> allActsOfPlayByName = AccessorUtils.getActsOfPlayByName(thePlayJsonObject);
		for (int i = 0; i < allActsOfPlayByName.size(); i++) {
			// get the i'th act name from the JSON array of act names, print it
			String playActName = allActsOfPlayByName.get(i);
			System.out.println(playActName);

			// extract the act as a JSON object
			JsonObject aPlayAct = AccessorUtils.getActOfPlay(thePlayJsonObject, playActName);
			// get the names of the scenes in the JSON object as an ArrayList of strings
			ArrayList<String> sceneNames = AccessorUtils.getScenesOfActByName(aPlayAct);
			for (int j = 0; j < sceneNames.size(); j++) {
				String sceneName = sceneNames.get(j);
				System.out.println(playActName + ", " + sceneName);
				JsonObject scene = AccessorUtils.getSceneOfAct(aPlayAct, sceneName);
                                // exercise to student: how do we use the scene object to access each paragraph
				                // of character dialog and write it out? 
			}
		}
	}
}