package fr.eni.trocenchere.bll;

import fr.eni.trocenchere.bo.Utilisateur;
import fr.eni.trocenchere.dal.DAO.DAOFactory;

public class UtilisateurManager {

	// SINGLETON
	private static UtilisateurManager instance = null;

	public static UtilisateurManager getInstance() {
		if (instance == null) {
			instance = new UtilisateurManager();
		}
		return instance;
	}

	// FIN SINGLETON

	private UtilisateurManager() {
	};// CONSTRUCTEUR PAR DEFAUT EN PRIVATE POUR PAS INSTANCIER DE L EXTERIEUR

	public void insert(Utilisateur nouveauUtilisateur)  throws BusinessException{
		
		BusinessException be = new BusinessException();
		
		validationPseudo(nouveauUtilisateur.getPseudo(), be);
		
		//si une erreur lors de l'inscription on leve l'esception
		if(be.hasErreur()) {
			throw be;
		}
		
		DAOFactory.getDAOUtilisateur().insert(nouveauUtilisateur);
	}

	public boolean verifIdentifiant(String pseudo, String motdePasse) {
		return DAOFactory.getDAOUtilisateur().verifMotDePasse(pseudo, motdePasse);
	}

	public Utilisateur selectionnerUtilisateur(String pseudo) {
		return DAOFactory.getDAOUtilisateur().selectByPseudo(pseudo);
	}

	public void modifUtilisateur(String id_utilisateur, String pseudo, String nom, String prenom, String email, String telephone, String rue,
			String codePostal, String ville, String motdepasse) {
		DAOFactory.getDAOUtilisateur().modifUtilisateur(id_utilisateur ,pseudo, nom, prenom, email, telephone, rue, codePostal, ville,
				motdepasse);

	}

	public void suppresionUtilisateur(String id_utilisateur) {
		DAOFactory.getDAOUtilisateur().suppresionUtilisateur(id_utilisateur);
		
	}
	
	public void validationPseudo(String pseudo, BusinessException be) {
		if(pseudo == null || pseudo.isEmpty()) {
			be.ajouterCodeErreur(CodesErreurBLL.REGLE_UTILISATEUR_PSEUDO_ERREUR);
		}
	}

}
