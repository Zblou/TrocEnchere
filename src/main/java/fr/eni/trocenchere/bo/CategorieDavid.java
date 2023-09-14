package fr.eni.trocenchere.bo;

import java.util.ArrayList;

public class CategorieDavid {
	private String nom;
	private ArrayList<String> listCategorie = new ArrayList<>();
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public ArrayList<String> getListCategorie() {
		return listCategorie;
	}
	public void setListCategorie(ArrayList<String> listCategorie) {
		this.listCategorie = listCategorie;
	}
	public CategorieDavid(String nom, ArrayList<String> listCategorie) {
		super();
		this.nom = nom;
		this.listCategorie = listCategorie;
	}
	public CategorieDavid(String nom) {
		super();
		this.nom = nom;
	}
	public CategorieDavid(int int1, String string) {
		// TODO Auto-generated constructor stub
	}
	public void setIdCategorie(int int1) {
		// TODO Auto-generated method stub
		
	}
	public String getLibelle() {
		// TODO Auto-generated method stub
		return null;
	}

}
