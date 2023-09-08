package fr.eni.trocenchere.bll;

import fr.eni.trocenchere.bo.Article;
import fr.eni.trocenchere.dal.DALException;
import fr.eni.trocenchere.dal.DAO.DAOFactory;

public class ArticleManager {

	public static ArticleManager instance;
	
	public static ArticleManager getInstance() {
		if(instance == null) {
			instance = new ArticleManager();
		}
		return instance;
	}
	
	private ArticleManager() {};
	
	
	
	public void insertArticle(Article article, String RueDepot, String CodePostalDepot, String VilleDepot) {
		try {
			DAOFactory.getDAOArticleJDBCIpml().insertArticle(article, RueDepot, CodePostalDepot, VilleDepot);
		} catch (DALException e) {
			System.out.println("IMPOSSIBLE D'INSERER ARTICLE");
			e.printStackTrace();
		}
	}

	public void verifArticle(String ArticleName, String DescriptionArticle, String ArticleCategorie,
			String MiseAPrix, String DebutEnchere, String FinEnchere, String RueDepot, String CodePostalDepot,
			String VilleDepot) {
			DAOFactory.getDAOArticleJDBCIpml().verifArticle(ArticleName, DescriptionArticle, ArticleCategorie, MiseAPrix,
					DebutEnchere, FinEnchere, RueDepot, CodePostalDepot, VilleDepot);
	}

	public void deleteArticle(int idArticleDelete) {
		DAOFactory.getDAOArticleJDBCIpml().deleteArticle(idArticleDelete);
	}

	public void modifArticleById(String idArticleModif, String articleName, String descriptionArticle, String ArticleCategorie, String miseAPrix,
			String debutEnchere, String finEnchere, String rueDepot, String codePostalDepot, String villeDepot) {
		DAOFactory.getDAOArticleJDBCIpml().modifArticleById(idArticleModif, articleName,
				descriptionArticle, ArticleCategorie, miseAPrix, debutEnchere, finEnchere, rueDepot, codePostalDepot, villeDepot);
	}
}
