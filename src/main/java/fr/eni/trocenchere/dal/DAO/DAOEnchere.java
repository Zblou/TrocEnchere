package fr.eni.trocenchere.dal.DAO;

import java.util.ArrayList;

import fr.eni.trocenchere.bo.Enchere;

public interface DAOEnchere {

	ArrayList<Enchere> selectEncheresByIdArticle(int idArticle);

	// A VOIR SI L'AJOUT DE L'ENCHERE DOIS AJOUTER L'ENCHERE A LA LISTE D'ENCHERE DE L'ARTICLE DANS LE PROGRAMME
	void insertEnchere(Integer montantNouvelleEnchere, int idArticle, int idUtilisateur);

	
}
