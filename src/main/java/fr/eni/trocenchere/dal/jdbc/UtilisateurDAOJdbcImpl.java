package fr.eni.trocenchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.trocenchere.bo.Utilisateur;
import fr.eni.trocenchere.dal.DALException;
import fr.eni.trocenchere.dal.DAO.DAOUtilisateur;

public class UtilisateurDAOJdbcImpl implements DAOUtilisateur {


	 public void insert(Utilisateur utilisateur) throws DALException {
	        Connection cnx = JDBCTools.connect();
	        try {
	            String INSERT = "INSERT INTO UTILISATEURS " +
	                    "(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe) " +
	                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	            PreparedStatement stmt = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
	           PreparedStatement(utilisateur, stmt);
	            stmt.executeUpdate();
	            ResultSet rs = stmt.getGeneratedKeys();
	            if (rs.next()) {
	                utilisateur.setNoUtilisateur(rs.getInt(1));
	            }
	           
	            cnx.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	           
	        }
	        
	        
	        
	        
	    }

	private void PreparedStatement(Utilisateur utilisateur, PreparedStatement stmt) {
		// TODO Auto-generated method stub
		
	}
	
	
}
