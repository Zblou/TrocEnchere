package fr.eni.trocenchere.dal.DAO;

import fr.eni.trocenchere.bo.Article;
import fr.eni.trocenchere.dal.DALException;

public interface DAOArticle {

	void insertArticle(Article article, String RueDepot, String CodePostalDepot, String VilleDepot) throws DALException;

	void verifArticle(String articleName, String descriptionArticle, String articleCategorie,
			String miseAPrix, String debutEnchere, String finEnchere, String rueDepot, String codePostalDepot,
			String villeDepot);

	void modifArticleById(String idArticleModif, String articleName, String descriptionArticle, String ArticleCategorie, String miseAPrix,
			String debutEnchere, String finEnchere, String rueDepot, String codePostalDepot, String villeDepot);

	void deleteArticle(int idArticleDelete);

}
