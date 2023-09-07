package fr.eni.trocenchere.dal.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import fr.eni.trocenchere.bo.Article;
import fr.eni.trocenchere.dal.DALException;
import fr.eni.trocenchere.dal.DAO.DAOArticle;

public class DAOArticleJDBCImpl implements DAOArticle{

	private static final String INSERTION_ARTICLE = "INSERT INTO ARTICLES(nom_article, description,"
			+ " date_debut_enchere, date_fin_enchere, prix_initial, id_utilisateur, id_categorie)"
			+ " VALUES (? , ? , ? , ? , ? , ? , ?);";
	
	@Override
	public void insertArticle(Article article) throws DALException{
		
		try(Connection cnx = ConnexionProvider.getConnection()){
			
			PreparedStatement p = cnx.prepareStatement(INSERTION_ARTICLE, PreparedStatement.RETURN_GENERATED_KEYS);
			p.setString(1, article.getNomArticle());
			p.setString(2, article.getDescription());
			p.setDate(3, Date.valueOf(article.getDateDebutEncheres()));
			p.setDate(4, Date.valueOf(article.getDateFinEncheres()));
			p.setInt(5, article.getMiseAPrix());
			p.setInt(6, article.getPossesseurArticle().getIdUtilisateur());
			p.setInt(7, article.getCatArticle().getIdCategorie());
			p.executeUpdate();
			
			ResultSet rs = p.getGeneratedKeys();
			
			if(rs.next()) {
				article.setIdArticle(rs.getInt(1));
			}
			
			System.out.println("ARTICLE INSERED");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("INSERTION ARTICLE DE OUF");
	}

	@Override
	public void verifArticle(String articleName, String descriptionArticle, String articleCategorie,
		    String miseAPrix, String debutEnchere, String finEnchere, String rueDepot,
			String codePostalDepot, String villeDepot) {
		// TODO Auto-generated method stub
		System.out.println("VERIFICATION ARTICLE DE OUF");
	}

}
