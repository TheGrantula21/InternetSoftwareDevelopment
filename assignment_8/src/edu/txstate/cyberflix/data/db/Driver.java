package edu.txstate.cyberflix.data.db;

import java.util.ArrayList;
import java.util.List;

import edu.txstate.internet.cyberflix.data.actor.Actor;
import edu.txstate.internet.cyberflix.data.customer.Customer;
import edu.txstate.internet.cyberflix.data.film.Film;
import edu.txstate.internet.cyberflix.data.film.Film.FilmRating;
import edu.txstate.internet.cyberflix.data.film.FilmCategory;
import edu.txstate.cyberflix.data.db.FilmDAO;
import edu.txstate.cyberflix.data.db.CustomerDAO;

public class Driver {

	public static void main(String[] args) {
		
		//USE CASE 1: Land on CyberFlix Splash Page
		System.out.println("/////USE CASE 1/////");
		System.out.println("Welcome to CyberFlix!\n Here are the newest 5 films:");
		FilmDAO filmDao = new FilmDAO();
		
		List <Film> newestFilms = filmDao.findNewestFilms(5);
		for (Film film : newestFilms) {
			System.out.println(film.getTitle());
		}
		
		//USE CASE 2: Search for Films by Attribute
		System.out.println("/////USE CASE 2/////");
		System.out.println("Finding first 5 films by title = \"DOG\"");
		List <Film> films = filmDao.findFilmsByAttributes("DOG", "", 0, FilmRating.UR);
		int i = 0;
		for (Film film : films) {
			System.out.println(film.toString());
			i++;
			if(i > 4)
				break;
		}
		
		System.out.println("Finding first 5 films by description = \"Epic\"");
		films = filmDao.findFilmsByAttributes("", "Epic", 0, FilmRating.UR);
		i = 0;
		for (Film film : films) {
			System.out.println(film.toString());
			i++;
			if(i > 4)
				break;
		}
		
		System.out.println("Finding first 5 films by max length = 60");
		films = filmDao.findFilmsByAttributes("", "", 60, FilmRating.UR);
		i = 0;
		for (Film film : films) {
			System.out.println(film.toString());
			i++;
			if(i > 4)
				break;
		}
		
		System.out.println("Finding first 5 films by rating = \"G\"");
		films = filmDao.findFilmsByAttributes("", "", 0, FilmRating.G);
		i = 0;
		for (Film film : films) {
			System.out.println(film.toString());
			i++;
			if(i > 4)
				break;
		}
		
		//USE CASE 3: Browse Films by Category
		System.out.println("/////USE CASE 3/////");
		System.out.println("Finding first 5 films by category = \"Comedy\"");
		films = filmDao.findFilmsByCategory(FilmCategory.COMEDY);
		i = 0;
		for (Film film : films) {
			System.out.println(film.toString());
			i++;
			if(i > 4)
				break;
		}
		
		System.out.println("Finding first 5 films by category = \"DRAMA\"");
		films = filmDao.findFilmsByCategory(FilmCategory.DRAMA);
		i = 0;
		for (Film film : films) {
			System.out.println(film.toString());
			i++;
			if(i > 4)
				break;
		}
		
		//USE CASE 4: Browse Films Alphabetically
		System.out.println("/////USE CASE 4/////");
		System.out.println("Finding first 5 films that start with \'D\'");
		films = filmDao.findFilmsAlphabetically("D");
		i = 0;
		for (Film film : films) {
			System.out.println(film.toString());
			i++;
			if(i > 4)
				break;
		}
		
		System.out.println("Finding first 5 films that start with \'T\'");
		films = filmDao.findFilmsAlphabetically("T");
		i = 0;
		for (Film film : films) {
			System.out.println(film.toString());
			i++;
			if(i > 4)
				break;
		}
		
		//USE CASE 5: View Film Detail
		System.out.println("/////USE CASE 5/////");
		System.out.println("Finding details and first 5 actors of DANCING FEVER:");
		films = filmDao.findFilmsByAttributes("DANCING FEVER", "", 0, FilmRating.UR);
		Film dance = films.get(0);
		dance = filmDao.getFilmDetail(dance);
		System.out.println("Details: " + dance.toString());
		System.out.print("Actors ");
		i = 0;
		for(Actor actor : dance.getActors()) {
			System.out.print(actor.toString() + " ");
			if (i > 4)
				System.out.println("");
		} 
		
		//USE CASE 7: User Login
		System.out.print("\n");
		System.out.println("/////USE CASE 7/////");
		System.out.println("Finding customer with email = MARY.SMITH@sakilacustomer.org: ");
		CustomerDAO customerDao = new CustomerDAO();
		Customer george = customerDao.findCustomerByEmail("MARY.SMITH@sakilacustomer.org");
		System.out.println(george.toString());
		
		
	}

}

