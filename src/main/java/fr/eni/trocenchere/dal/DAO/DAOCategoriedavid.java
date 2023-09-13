package fr.eni.trocenchere.dal.DAO;

import java.util.ArrayList;

import fr.eni.trocenchere.bo.Categorie;
import fr.eni.trocenchere.bo.Categoriedavid;

public interface DAOCategoriedavid {

	void insert(Categoriedavid nouvelleCategorie);

	ArrayList<Categoriedavid> selectALLLibelle();
	
}
