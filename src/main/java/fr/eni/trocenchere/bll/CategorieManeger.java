package fr.eni.trocenchere.bll;


import fr.eni.trocenchere.bo.Categoriedavid;
import fr.eni.trocenchere.dal.DAO.DAOFactory;

public class CategorieManeger {

	//SINGETON
	private static CategorieManeger instance = null;
	
	public static CategorieManeger getInstance() {
		if(instance == null) {
			instance = new CategorieManeger();
		}
	return instance;
	
	
}
	//FIN SINGETON
	
	
	public void insert(String nouvelleCategorie) {
		// TODO Auto-generated method stub
		
	}



}