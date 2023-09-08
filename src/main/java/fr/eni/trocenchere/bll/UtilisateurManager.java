package fr.eni.trocenchere.bll;

import java.util.List;

import fr.eni.trocenchere.bo.Utilisateur;
import fr.eni.trocenchere.dal.DAO.DAOFactory;

public class UtilisateurManager {
	
	//SINGLETON
	private static UtilisateurManager instance = null;
	
	public static UtilisateurManager getInstance() {
		if(instance == null) {
			instance = new UtilisateurManager();
		}
		return instance;
	}
	
	//FIN SINGLETON
	
	
	private UtilisateurManager() {};//CONSTRUCTEUR PAR DEFAUT EN PRIVATE POUR PAS INSTANCIER DE L EXTERIEUR
	
	public void insert(Utilisateur nouveauUtilisateur){
		DAOFactory.getDAOUtilisateur().insert(nouveauUtilisateur);
	}
	
	public boolean verifIdentifiant(String pseudo, String motdePasse) {
		return DAOFactory.getDAOUtilisateur().verifMotDePasse(pseudo, motdePasse);	
	}

	public static Utilisateur selectionnerUtilisateur(String pseudo) {
		return DAOFactory.getDAOUtilisateur().selectByPseudo(pseudo);
	}


}
