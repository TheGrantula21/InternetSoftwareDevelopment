package edu.txstate.cyberflix.data.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import edu.txstate.internet.cyberflix.data.customer.Customer;
import edu.txstate.internet.cyberflix.data.film.Film;

/**
 * @author Michael Baum
 *
 */
public class CustomerDAO extends DAO {
	private final static Logger LOGGER = Logger.getLogger(FilmDAO.class.getName());
	
	private static final int    CUSTOMER_ID_COLUMN          = 1;
	private static final int    CUSTOMER_FIRST_NAME_COLUMN  = 2;
	private static final int    CUSTOMER_LAST_NAME_COLUMN   = 3;
	private static final int    CUSTOMER_EMAIL_COLUMN          = 4;
	private static final int    CUSTOMER_PASSWORD_COLUMN          = 5;
	
	public CustomerDAO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void save(Object anObject) throws SQLException {
		// TODO Auto-generated method stub
	}
	
	public Customer findCustomerByEmail(String email) {
		StringBuilder stringBuilder = new StringBuilder("SELECT customer_id, first_name, last_name, email, password FROM customer WHERE email = " +"'"  + email + "'" + ";");
		String selectString = stringBuilder.toString();
		
		
		Customer customer = null;
		Connection dbConnection = null;
		try {
			dbConnection = DAO.getDBConnection();
			Statement statement 	= dbConnection.createStatement();
			ResultSet results       = statement.executeQuery(selectString);
			while(results.next()) {
			int id                  =results.getInt(CUSTOMER_ID_COLUMN);
			String firstName       = results.getString(CUSTOMER_FIRST_NAME_COLUMN);
			String lastName       = results.getString(CUSTOMER_LAST_NAME_COLUMN);
			String password       = results.getString(CUSTOMER_PASSWORD_COLUMN);
			
			
			customer = new Customer(id,firstName,lastName,email,password);
			}
			dbConnection.close();
		} catch (SQLException e) {
			System.err.println("CustomerDAO.findCustomerByEmail: " + e.toString());
			LOGGER.severe(e.toString());
			closeQuietly(dbConnection);
		}	
		return customer;
	}

}

