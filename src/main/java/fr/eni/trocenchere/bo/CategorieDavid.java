package fr.eni.trocenchere.bo;

import java.util.ArrayList;

public class CategorieDavid {
	
	private int idCategorie;
	// libelle sert probablement à rien
	private String libelle;
	

	public CategorieDavid() {
	}

	public CategorieDavid(int idCategorie, String libelle) {
		this.idCategorie = idCategorie;
		this.libelle = libelle;
	}
	
	public CategorieDavid(String libelle) {
		this.libelle = libelle;
	}
	
	// GETTERS SETTERS
	
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

	@Override
	public String toString() {
		return "CategorieDavid [idCategorie=" + idCategorie + ", libelle=" + libelle + "]";
	}
	
}
