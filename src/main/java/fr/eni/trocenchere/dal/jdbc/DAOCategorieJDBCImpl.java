package fr.eni.trocenchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.trocenchere.bo.Categoriedavid;
import fr.eni.trocenchere.dal.DAO.DAOCategoriedavid;

public class DAOCategorieJDBCImpl implements DAOCategoriedavid {

	private static final String INSERT_CATEGORIE = "INSERT INTO CATEGORIE (ArtEtFenetre)"
												+ "VALUES (?)";
	
	public void insert(Categoriedavid categorie) {
		
		//connexion
		
		try (Connection cnx = ConnexionProvider.getConnection()){
			//requete
			PreparedStatement stmt = cnx.prepareStatement(INSERT_CATEGORIE,PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, categorie.getArtEtFenetre());
			stmt.executeUpdate();
			
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next() ) {
				categorie.setArtEtFenetre(rs.getString(1));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
