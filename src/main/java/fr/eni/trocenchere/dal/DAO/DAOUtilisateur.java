package fr.eni.trocenchere.dal.DAO;

import java.util.List;

import fr.eni.trocenchere.bo.Utilisateur;

public interface DAOUtilisateur  {

	List<Utilisateur> selectByPseudo();

}
