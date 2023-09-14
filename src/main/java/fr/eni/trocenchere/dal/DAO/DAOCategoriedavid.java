package fr.eni.trocenchere.dal.DAO;

import java.util.ArrayList;

import fr.eni.trocenchere.bo.CategorieDavid;


public interface DAOCategoriedavid {

	void insert(CategorieDavid nouvelleCategorie);

	ArrayList<CategorieDavid> selectALLLibelle();
	
}
