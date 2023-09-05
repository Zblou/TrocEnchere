package fr.eni.trocenchere.dal.DAO;


import fr.eni.trocenchere.dal.jdbc.UtilisateurDAOJdbcImpl;

public class DAOFactory {
	
    public static DAOUtilisateur getDAOUtilisateur() {
        return new UtilisateurDAOJdbcImpl();
    }
 

}
