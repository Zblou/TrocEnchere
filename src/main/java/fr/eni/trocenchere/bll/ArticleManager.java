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
	
	
	
	public void insertArticle(Article article) {
		try {
			DAOFactory.getDAOArticleJDBCIpml().insertArticle(article);
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
}
