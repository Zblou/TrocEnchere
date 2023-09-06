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
	
	
	public List<Utilisateur> selectByPseudo(){
		return DAOFactory.getDAOUtilisateur().selectByPseudo();
	};
	
}
