package fr.eni.trocenchere.dal.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import fr.eni.trocenchere.bo.Article;
import fr.eni.trocenchere.bo.Categorie;
import fr.eni.trocenchere.dal.DALException;
import fr.eni.trocenchere.dal.DAO.DAOArticle;

public class DAOArticleJDBCImpl implements DAOArticle{

	private static final String INSERTION_ARTICLE = "INSERT INTO ARTICLES(nom_article, description,"
			+ " date_debut_encheres, date_fin_encheres, prix_initial, id_utilisateur, id_categorie)"
			+ " VALUES (? , ? , ? , ? , ? , ? , ?);";
	
	private static final String INSERTION_RETRAIT = "INSERT INTO RETRAITS(id_article, rue, code_postal, ville) VALUES (?,?,?,?);";
	
	private static final String MODIFICATION_ARTICLE = "UPDATE ARTICLES SET nom_article=?, description=?,"
			+ "date_debut_encheres=?, date_fin_encheres=?, prix_initial=?, prix_vente=?,"
			+ " id_categorie=? WHERE id_article = ?;";
	
	private static final String MODIFICATION_RETRAIT = "UPDATE RETRAITS SET rue=?, code_postal=?, ville=?"
			+ " WHERE id_article=?;";
	
	private static final String SUPPRESSION_ARTICLE = "DELETE FROM ARTICLES WHERE id_article=?;";
	
	// UTILE SEULEMENT SI ON NE FAIT PAS LE ON DELETE CASCADE DANS LA BDD
	// private static final String SUPPRESSION_RETRAIT = "DELETE FROM RETRAITS WHERE id_article=?;";
	
	@Override
	public void insertArticle(Article article,  String RueDepot, String CodePostalDepot, String VilleDepot) throws DALException{
		
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
			
			PreparedStatement p2 = cnx.prepareStatement(INSERTION_RETRAIT);
			p2.setInt(1, article.getIdArticle());
			p2.setString(2, RueDepot);
			p2.setString(3, CodePostalDepot);
			p2.setString(4, VilleDepot);
			p2.executeUpdate();
			
			System.out.println("ARTICLE & RETRAIT INSERED DE OUF");
			
		}catch(Exception e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void verifArticle(String articleName, String descriptionArticle, String articleCategorie,
		    String miseAPrix, String debutEnchere, String finEnchere, String rueDepot,
			String codePostalDepot, String villeDepot) {
		// TODO Auto-generated method stub
		System.out.println("VERIFICATION ARTICLE DE OUF");
	}

	@Override
	public void modifArticleById(String idArticleModif, String articleName, String descriptionArticle, String ArticleCategorie, String miseAPrix,
			String debutEnchere, String finEnchere, String rueDepot, String codePostalDepot, String villeDepot) {

		try(Connection cnx = ConnexionProvider.getConnection()){
			
			PreparedStatement p = cnx.prepareStatement(MODIFICATION_ARTICLE);
			p.setString(1, articleName);
			p.setString(2, descriptionArticle);
			p.setDate(3, Date.valueOf(debutEnchere));
			p.setDate(4, Date.valueOf(finEnchere));
			p.setInt(5, Integer.valueOf(miseAPrix));
			p.setInt(6, Integer.valueOf(miseAPrix));
			p.setInt(7, Categorie.valueOf(ArticleCategorie).getIdCategorie());
			p.setInt(8, Integer.valueOf(idArticleModif));
			p.executeUpdate();
			
			PreparedStatement p2 = cnx.prepareStatement(MODIFICATION_RETRAIT);
			p2.setString(1, rueDepot);
			p2.setString(2, codePostalDepot);
			p2.setString(3, villeDepot);
			p2.setInt(4, Integer.valueOf(idArticleModif));
			p2.executeUpdate();
			
			System.out.println("MODIFICATION ARTICLE ET RETRAIT DE OUF");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteArticle(int idArticleDelete) {

		try(Connection cnx = ConnexionProvider.getConnection()){
			
			PreparedStatement p = cnx.prepareStatement(SUPPRESSION_ARTICLE);
			p.setInt(1, idArticleDelete);
			p.executeUpdate();
			
			// A FAIRE SEULEMENT SI ON NE FAIT PAS ON DELETE CASCADE DANS LA BDD
//			if() {
//			PreparedStatement p2 = cnx.prepareStatement(SUPPRESSION_RETRAIT);
//			p2.setInt(1, idArticleDelete);
//			p2.executeUpdate();
//			}
			
			System.out.println("MODIFICATION ARTICLE" + idArticleDelete + " ET RETRAIT DE OUF");
			
		}catch(Exception e) {
			e.printStackTrace();
		}		
	}

}
