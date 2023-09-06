package fr.eni.trocenchere.dal.DAO;


import fr.eni.trocenchere.dal.jdbc.DAOArticleJDBCImpl;
import fr.eni.trocenchere.dal.jdbc.DAOCategorieJDBCImpl;
import fr.eni.trocenchere.dal.jdbc.DAOEnchereJDBCImpl;
import fr.eni.trocenchere.dal.jdbc.UtilisateurDAOJdbcImpl;

public class DAOFactory {
	
    public static DAOUtilisateur getDAOUtilisateur() {
        return new UtilisateurDAOJdbcImpl();
    }
    
    public static DAOArticle getDAOArticleJDBCIpml() {
    	return new DAOArticleJDBCImpl();
    }
    
    public static DAOEnchere getDAOEnchereJDBCImpl() {
    	return new DAOEnchereJDBCImpl();
    }
    
    public static DAOCategorie getDAOCategorieJDBCImpl() {
    	return new DAOCategorieJDBCImpl();
    }
    
}
