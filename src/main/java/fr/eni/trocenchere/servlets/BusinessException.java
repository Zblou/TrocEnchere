package fr.eni.trocenchere.servlets;

import java.util.ArrayList;
import java.util.List;

public class BusinessException extends Exception{

	private List<Integer> listeCodesErreur = new ArrayList<Integer>();
	
	public BusinessException() {
		super();
	}
	
	public BusinessException(int code) {
		super();
		listeCodesErreur.add(code);
	}
	
	public void ajouterCodeErreur(int code) {
		listeCodesErreur.add(code);
	}
	
	public List<Integer> getListeCodesErreur() {
		return listeCodesErreur;
	}
	
	public boolean hasErreur() {
		return !listeCodesErreur.isEmpty();
	}
}
