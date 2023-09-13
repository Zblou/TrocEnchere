package fr.eni.trocenchere.dal.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import fr.eni.trocenchere.bo.Enchere;
import fr.eni.trocenchere.dal.DAO.DAOEnchere;

public class EnchereDAOJdbcImpl implements DAOEnchere{

	public static final String SELECT_ENCHERE_BY_ARTICLE_ID = "SELECT * FROM ENCHERES WHERE id_article=?;";
	public static final String INSERT_ENCHERE = "INSERT INTO ENCHERES(date_enchere, montant_enchere, id_article, id_utilisateur) VALUES (?, ?, ?, ?);";
	
	@Override
	public ArrayList<Enchere> selectEncheresByIdArticle(int idArticle) {
		ArrayList<Enchere> listeEnchere = new ArrayList<>();
		
		try(Connection cnx = ConnexionProvider.getConnection()){
			
			PreparedStatement p = cnx.prepareStatement(SELECT_ENCHERE_BY_ARTICLE_ID);
			p.setInt(1, idArticle);
			ResultSet rs = p.executeQuery();
			
			if(rs.next()) {
				listeEnchere.add(new Enchere(rs.getDate("date_enchere").toLocalDate(),
											rs.getInt("montant_enchere"),
											rs.getInt("id_article"),
											rs.getInt("id_article")));
			}else {
				return listeEnchere;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("ERREUR SELECT ENCHERE BY ARTICLE ID");
		}
		
		return listeEnchere;
	}

	
	
	
	@Override
	public void insertEnchere(Integer montantNouvelleEnchere, int idArticle, int idUtilisateur) {

		try (Connection cnx = ConnexionProvider.getConnection()){
			
			PreparedStatement p = cnx.prepareStatement(INSERT_ENCHERE);
			p.setDate(1, Date.valueOf(LocalDate.now()));
			p.setInt(2, montantNouvelleEnchere);
			p.setInt(3, idArticle);
			p.setInt(4, idUtilisateur);
			p.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
