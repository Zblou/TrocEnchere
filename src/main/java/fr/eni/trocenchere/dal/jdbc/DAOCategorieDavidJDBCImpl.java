package fr.eni.trocenchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.eni.trocenchere.bo.CategorieDavid;
import fr.eni.trocenchere.dal.DAO.DAOCategoriedavid;

public class DAOCategorieDavidJDBCImpl implements DAOCategoriedavid {

	private static final String INSERT_CATEGORIE = "INSERT INTO CATEGORIES (libelle) VALUES (?)";
	private static final String SELECT_ALL_LIBELLE = "Select * From categories";
	
	
	public void insert(CategorieDavid categorie) {
		
		//connexion
		
		try (Connection cnx = ConnexionProvider.getConnection()){
			//requete
			PreparedStatement stmt = cnx.prepareStatement(INSERT_CATEGORIE, PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, categorie.getLibelle());
			stmt.executeUpdate();
			
			
			ResultSet rs = stmt.getGeneratedKeys ();
			
			if (rs.next ()) {
				categorie.setIdCategorie(rs.getInt(1));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public ArrayList<CategorieDavid> selectALLLibelle() {
		
		ArrayList<CategorieDavid> listeCategorie = new ArrayList<>();
		
		try(Connection cnx = ConnexionProvider.getConnection()){
			
			Statement s = cnx.createStatement();
			ResultSet rs = s.executeQuery(SELECT_ALL_LIBELLE);
			
			//il faut se servir du resultset pour remplir la listeCategorie
	
			
			
			while(rs.next()) {
				listeCategorie.add( new CategorieDavid (rs.getInt("id_categorie"),
													rs.getString("libelle")));
				}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERREUR SELECT ALL CATEGORIES");
		}
		return listeCategorie;
	}
}
