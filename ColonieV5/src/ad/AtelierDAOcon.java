package ad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AtelierDAOcon {

	 private static Connection con = null;

		public static Connection getConnection() throws DAOException{

		      // chargement du pilote
		      try {
		         Class.forName("com.mysql.jdbc.Driver");
		      } catch (ClassNotFoundException e) {
		        throw new DAOException();
		      }
		  
		      //connection a la base de données
		      try {
		         String DBurl = "jdbc:mysql://localhost:3306/colonie";
		         con = DriverManager.getConnection(DBurl,"root","root");
		      } catch (SQLException e) {
		    	 throw new DAOException();
		      }

		      return con;
		}
	
		protected void closeConnection() throws DAOException{
			try {
				con.close();
			} catch (SQLException e) {
				throw new DAOException();
			}
		}
	}

