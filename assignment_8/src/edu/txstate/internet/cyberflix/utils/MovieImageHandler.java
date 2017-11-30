package edu.txstate.internet.cyberflix.utils;

import java.util.ArrayList;

public class MovieImageHandler {
	private static int count = -1;
	
	private static ArrayList <String> movies = new ArrayList<String>();
    
	public static String nextMovieTitle () {
		if (count == -1) {
			movies.add("darktower.jpg");
			movies.add("hungergames.jpg");
			movies.add("johnwick.jpg");
			movies.add("newmoon.jpg");
			movies.add("valerianmovie.jpg");
			movies.add("warcraft.jpg");
			movies.add("warplanetapesmovie.jpg");
			count = 0;
		}
		if (count == movies.size()-1) count = 0;
		int indexToReturn = count;
		count ++;
		return movies.get(indexToReturn);
	}

}
