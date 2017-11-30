package edu.txstate.cyberflix.data.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import edu.txstate.internet.cyberflix.data.actor.Actor;
import edu.txstate.internet.cyberflix.data.film.Film;
import edu.txstate.internet.cyberflix.data.helper.ActorFactory;

/**
 * @author Michael Baum
 *
 */
public class ActorDAO extends DAO {
	private final static Logger LOGGER = Logger.getLogger(FilmDAO.class.getName());
	
	private static final int    ACTOR_ID_COLUMN          = 1;
	private static final int    ACTOR_FIRST_NAME_COLUMN  = 2;
	private static final int    ACTOR_LAST_NAME_COLUMN   = 3;
	
	public ActorDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public List <Actor> findActorsInFilm (Film film){
		StringBuilder stringBuilder = new StringBuilder("select actor_id, first_name, last_name from actor " + 
			     "where actor_id in " +
			     "(select actor_id from film_actor where film_id = " + film.getFilmID() + ");");
		String selectString = stringBuilder.toString();
		
		List <Actor> actors = null;
		Connection dbConnection = null;
		try {
			dbConnection = DAO.getDBConnection();
			Statement statement 	= dbConnection.createStatement();
			ResultSet results       = statement.executeQuery(selectString);
			actors = buildResults (results);
			dbConnection.close();
		} catch (SQLException e) {
			System.err.println("ActorDAO.findActorsInFilm: " + e.toString());
			LOGGER.severe(e.toString());
			closeQuietly(dbConnection);
		}	
		return actors;
	}

	@Override
	public void save(Object anObject) throws SQLException {
		// TODO Auto-generated method stub
	}
	
	private List<Actor> buildResults (ResultSet results) {
		ArrayList <Actor> actors  = new ArrayList <Actor> ();
		ActorFactory actorFactory = new ActorFactory ();
		try {
			while (results.next()) {
				int    id             =  results.getInt   (ACTOR_ID_COLUMN );
				String firstName      = results.getString(ACTOR_FIRST_NAME_COLUMN );
				String lastName       = results.getString(ACTOR_LAST_NAME_COLUMN);
				Actor actor = actorFactory.makeActor(id, firstName, lastName);
				actors.add(actor);
			}
		} catch (SQLException e) {
			LOGGER.severe(e.toString());
		}
		return actors;
	}

}
