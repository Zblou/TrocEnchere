package fr.eni.trocenchere.bll;


import java.util.ArrayList;

import fr.eni.trocenchere.bo.CategorieDavid;
import fr.eni.trocenchere.dal.DAO.DAOFactory;

public class CategorieManegerDavid {

	//SINGETON
	private static CategorieManegerDavid instance = null;
	
	public static CategorieManegerDavid getInstance() {
		if(instance == null) {
			instance = new CategorieManegerDavid();
		}
	return instance;
	
	
}
	//FIN SINGETON
	
	private CategorieManegerDavid() {};
	
	public void insert(CategorieDavid nouvelleCategorie) {
		DAOFactory.getDAOCategorieDavidJDBCImpl().insert(nouvelleCategorie);
		
	}
	
	public ArrayList<CategorieDavid> selectALLLibelle() {
		return DAOFactory.getDAOCategorieDavidJDBCImpl().selectALLLibelle();
	}

}