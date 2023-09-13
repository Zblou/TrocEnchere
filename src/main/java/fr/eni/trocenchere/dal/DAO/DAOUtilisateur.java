package fr.eni.trocenchere.dal.DAO;



import fr.eni.trocenchere.bo.Utilisateur;


public interface DAOUtilisateur {
	

	Boolean verifMotDePasse(String pseudo, String motdePasse) ;

	void insert(Utilisateur utilisateur);

	Utilisateur selectByPseudo(String pseudo);

	void modifUtilisateur(String id_utilisateur,String pseudo, String nom, String prenom, String email, String telephone, String rue,
			String codePostal, String ville, String motdepasse);

	void suppresionUtilisateur(String id_utilisateur);

	void debiterCreditUtilisateur(int idUtilisateur, int creditActuel, Integer montantNouvelleEnchere);

	void ajouterCreditUtilisateur(int idUtilisateur, int creditActuel, Integer montantNouvelleEnchere);

	Utilisateur selectUtilisateurById(int idUtilisateurAncienneEnchere);
	

}


