package fr.eni.trocenchere.dal.DAO;



import java.util.List;

import fr.eni.trocenchere.bll.BLLException;
import fr.eni.trocenchere.bo.Utilisateur;


public interface DAOUtilisateur {
	
	List<Utilisateur> selectById();

	Boolean verifMotDePasse(String pseudo, String motdePasse) ;

	void insert(Utilisateur utilisateur);
	

}


