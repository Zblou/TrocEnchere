package fr.eni.trocenchere.dal.DAO;


import java.util.HashMap;
import java.util.List;

import fr.eni.trocenchere.bll.BLLException;
import fr.eni.trocenchere.bo.Utilisateur;
import fr.eni.trocenchere.dal.DALException;

public interface DAOUtilisateur {
	
    boolean checkForUniquePseudoAndMail(String pseudo, String mail) throws DALException;
    boolean checkForUniquePseudo(String pseudo) throws DALException;
    boolean checkForUniqueMail(String mail) throws DALException;
    Utilisateur selectUtilisateurByPseudo(String pseudo) throws DALException;
    HashMap<Integer, String> selectUtilisateursWithCurrentAuction() throws DALException;
    void updateCredit(int noUtilisateur, int newCredit) throws DALException;


	List<Utilisateur> selectById();

	Boolean verifMotDePasse(String pseudo, String motdePasse);

	void insert(Utilisateur utilisateur);
	

}


