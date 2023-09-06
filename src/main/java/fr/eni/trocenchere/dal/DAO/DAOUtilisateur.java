package fr.eni.trocenchere.dal.DAO;


import java.util.List;

import fr.eni.trocenchere.bo.Utilisateur;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import fr.eni.trocenchere.bo.Utilisateur;
import fr.eni.trocenchere.dal.DALException;
import fr.eni.trocenchere.dal.ErrorCodeDAL;
import jakarta.servlet.RequestDispatcher;

public interface DAOUtilisateur {
	
    boolean checkForUniquePseudoAndMail(String pseudo, String mail) throws DALException;
    boolean checkForUniquePseudo(String pseudo) throws DALException;
    boolean checkForUniqueMail(String mail) throws DALException;
    Utilisateur selectUtilisateurByPseudo(String pseudo) throws DALException;
    HashMap<Integer, String> selectUtilisateursWithCurrentAuction() throws DALException;
    void updateCredit(int noUtilisateur, int newCredit) throws DALException;


	List<Utilisateur> selectById();

	Boolean verifMotDePasse(String pseudo, String motdePasse);

}


