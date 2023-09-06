package fr.eni.trocenchere.bll;

import fr.eni.trocenchere.bo.Article;

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
		
	}
}
