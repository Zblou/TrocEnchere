package fr.eni.trocenchere.bll;

import java.util.ArrayList;
import java.util.List;

public class BLLException extends Exception {
	
	private static final long serialVersionUID = 1L;

	private List<Integer> listeCodesErreur = new ArrayList<Integer>();

	public BLLException() {
		super();
	}
	
	public BLLException(int code) {
		super();
		listeCodesErreur.add(code);
	}
	
	public void BLLException(int code) {
		listeCodesErreur.add(code);
	}
	
	public List<Integer> getListeCodesErreur() {
		return listeCodesErreur;
	}
	
	public boolean hasErreur() {
		return !listeCodesErreur.isEmpty();
	}
}

