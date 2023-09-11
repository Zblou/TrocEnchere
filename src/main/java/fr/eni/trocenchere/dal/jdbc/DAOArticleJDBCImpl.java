package fr.eni.trocenchere.dal.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import fr.eni.trocenchere.bo.Article;
import fr.eni.trocenchere.bo.Categorie;
import fr.eni.trocenchere.bo.Utilisateur;
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
	
	private static final String SELECT_ALL_ARTICLES = "SELECT A.id_article, A.nom_article, A.description, A.date_debut_encheres, A.date_fin_encheres, "
			+ "		A.prix_initial, A.prix_vente, A.id_categorie, U.id_utilisateur, U.pseudo, U.nom, U.prenom, U.email, "
			+ "		U.telephone, U.rue, U.code_postal, U.ville, U.credit "
			+ "FROM ARTICLES A, UTILISATEURS U "
			+ "WHERE A.id_utilisateur = U.id_utilisateur "
			+ "ORDER BY U.id_utilisateur ASC;";
	
	// UTILE SEULEMENT SI ON NE FAIT PAS LE ON DELETE CASCADE DANS LA BDD
	// private static final String SUPPRESSION_RETRAIT = "DELETE FROM RETRAITS WHERE id_article=?;";
	
	@Override
	public void insertArticle(Article article, String RueDepot, String CodePostalDepot, String VilleDepot) throws DALException{
		
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

	@Override
	public ArrayList<Article> selectAllArticles() {
		
		ArrayList<Article> listeArticle = new ArrayList<>();
		ArrayList<Utilisateur> listeUsers = new ArrayList<>();
		
		try(Connection cnx = ConnexionProvider.getConnection()){
			
			Statement s = cnx.createStatement();
			ResultSet rs = s.executeQuery(SELECT_ALL_ARTICLES);
			int possesseurArticlePrecedent = -1;
			
			while(rs.next()) {
				// UTILISATEUR ET CATEGORIE ID A TRANSFORMER EN OBJETS
				
				// ON PARCOURS LA LISTE DES CATEGORIES POUR TROUVER LA CATEGORIE CORRESPONDANT A L'ID
				// VALEUR PAR DEFAULT SINON PAS CONTENT
				Categorie catArticle = Categorie.INFORMATIQUE;
				
				for(Categorie c : Categorie.values()) {
					if(c.getIdCategorie() == rs.getInt("id_categorie")) {
						catArticle = c;
					}
				}
				
				if(possesseurArticlePrecedent != rs.getInt("id_utilisateur")) {
					listeUsers.add(new Utilisateur(rs.getInt("id_utilisateur"),
															rs.getString("pseudo"),
															rs.getString("nom"),
															rs.getString("prenom"),
															rs.getString("email"),
															rs.getString("telephone"),
															rs.getString("rue"),
															rs.getString("code_postal"),
															rs.getString("ville"),
															rs.getInt("credit")));
					possesseurArticlePrecedent = rs.getInt("id_utilisateur");
				}
				
				listeArticle.add(new Article(rs.getInt("id_article"),
											rs.getString("nom_article"),
											rs.getString("description"),
											rs.getDate("date_debut_encheres").toLocalDate(),
											rs.getDate("date_fin_encheres").toLocalDate(),
											rs.getInt("prix_initial"),
											rs.getInt("prix_vente"),
											listeUsers.get(listeUsers.size()-1),
											catArticle
											));
				
				// ON AJOUTE AUSSI LA VENTE A l'UTILISATEUR, AVEC LE CONSTRUCTEUR SANS POSSESSEUR CAR REDONDANT SINON
				listeUsers.get(listeUsers.size()-1).ajouterVente(new Article(rs.getInt("id_article"),
											rs.getString("nom_article"),
											rs.getString("description"),
											rs.getDate("date_debut_encheres").toLocalDate(),
											rs.getDate("date_fin_encheres").toLocalDate(),
											rs.getInt("prix_initial"),
											rs.getInt("prix_vente"),
											catArticle
											));
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("ERREUR SELECT ALL ARTICLE");
		}
		
		return listeArticle;
	}

}
