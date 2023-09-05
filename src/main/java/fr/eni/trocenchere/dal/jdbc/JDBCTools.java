package fr.eni.trocenchere.dal.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class JDBCTools {
	
	static Connection connect() {
        Connection cnx = null;
        try {
            cnx = ConnexionProvider.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cnx;
    }
}
