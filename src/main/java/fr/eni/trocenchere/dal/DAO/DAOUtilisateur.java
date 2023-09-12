package fr.eni.trocenchere.dal.DAO;



import fr.eni.trocenchere.bo.Utilisateur;


public interface DAOUtilisateur {
	

	Boolean verifMotDePasse(String pseudo, String motdePasse) ;

	void insert(Utilisateur utilisateur);

	Utilisateur selectByPseudo(String pseudo);
	

}


