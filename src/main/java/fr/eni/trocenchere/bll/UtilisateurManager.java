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
	
	public Utilisateur insert(){
		return DAOFactory.getDAOUtilisateur().insert();
	}
	
	public List<Utilisateur> selectById(){
		return DAOFactory.getDAOUtilisateur().selectById();
	}

	public boolean verifIdentifiant(String pseudo, String motdePasse) {
		return DAOFactory.getDAOUtilisateur().verifMotDePasse(pseudo, motdePasse);	
	}

}
