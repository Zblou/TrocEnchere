package fr.eni.trocenchere.dal.DAO;


import fr.eni.trocenchere.dal.jdbc.DAOArticleJDBCImpl;
import fr.eni.trocenchere.dal.jdbc.DAOCategorieJDBCImpl;
import fr.eni.trocenchere.dal.jdbc.EnchereDAOJdbcImpl;
import fr.eni.trocenchere.dal.jdbc.UtilisateurDAOJdbcImpl;

public class DAOFactory {
	
    public static DAOUtilisateur getDAOUtilisateur() {
        return new UtilisateurDAOJdbcImpl();
    }
    
    public static DAOArticle getDAOArticleJDBCIpml() {
    	return new DAOArticleJDBCImpl();
    }
   
    public static DAOCategoriedavid getDAOCategorieJDBCImpl() {
    	return new DAOCategorieJDBCImpl();
    }

    public static DAOEnchere getDAOEnchereJDBCImpl() {
    	return new EnchereDAOJdbcImpl();
    }
}
