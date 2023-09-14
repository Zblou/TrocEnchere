package fr.eni.trocenchere.bo;

import java.util.ArrayList;

public class CategorieDavid {

	private int idCategorie;
	private String libelle;
	private ArrayList<String> listCategorie = new ArrayList<>();
	
	public ArrayList<String> getListCategorie() {
		return listCategorie;
	}
	public void setListCategorie(ArrayList<String> listCategorie) {
		this.listCategorie = listCategorie;
	}
	public int getIdCategorie() {
		return idCategorie;
	}
	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	public CategorieDavid() {
		super();
	}
	
	public CategorieDavid(String libelle) {
		super();
		this.libelle = libelle;
	}
	
	public CategorieDavid(int idCategorie, String libelle) {
		super();
		this.idCategorie = idCategorie;
		this.libelle = libelle;
	}
}
