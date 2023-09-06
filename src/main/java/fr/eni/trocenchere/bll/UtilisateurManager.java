package fr.eni.trocenchere.bll;

import java.util.List;

import fr.eni.trocenchere.bo.Utilisateur;
import fr.eni.trocenchere.dal.DAO.DAOFactory;

public class UtilisateurManager {
	
	//SINGLETON
	public static UtilisateurManager instance;
	
	public static UtilisateurManager getInstance() {
		if(instance == null) {
			instance = new UtilisateurManager();
		}
		return instance;
	}
	
	private UtilisateurManager() {};
	
	
	public List<Utilisateur> selectById(){
		return DAOFactory.getDAOUtilisateur().selectById();
	}

	public boolean verifIdentifiant(String pseudo, String motdePasse) {
		return DAOFactory.getDAOUtilisateur().verifMotDePasse(pseudo, motdePasse);	
	};
	
}
