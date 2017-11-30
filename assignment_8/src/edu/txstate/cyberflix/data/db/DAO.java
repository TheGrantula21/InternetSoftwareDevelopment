package edu.txstate.cyberflix.data.db;

import edu.txstate.internet.cyberflix.data.film.*;

import java.sql.Connection;
import edu.txstate.cyberflix.data.db.FilmDAO;
import java.util.logging.Logger;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public abstract class DAO {

	private static final String DB_NAME = "sakila";
	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/sakila";

	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "1jessohh";   // fill this in with your root pw

	public static Connection getDBConnection() {
		Connection dbConnection = null;
		try {
			Class.forName(DB_DRIVER).newInstance();
			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DAO.getDBPassword());
			dbConnection.setAutoCommit(true);
		} catch (ClassNotFoundException e) {
			System.err.println(e.toString());
		} catch (InstantiationException | IllegalAccessException e) {
			System.err.println(e.toString());
		} catch (SQLException e) {
			System.err.println("DAO SQLException " + e.toString());
		}
		return dbConnection;
	}

	String getDBName() {
		return DB_NAME;
	}

	String getDBUserName() {
		return DB_USER;
	}

	static String getDBPassword() {
		return DB_PASSWORD;
	}

	public static void closeQuietly(Connection dbConnection) {
		try {
			dbConnection.close();
		} catch (SQLException e) {

		}

	}

	abstract public void save(Object anObject) throws SQLException;
	
	
		
	

}