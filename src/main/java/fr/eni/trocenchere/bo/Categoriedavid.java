package fr.eni.trocenchere.bo;

import java.util.ArrayList;

public class Categoriedavid {

	private String nom;
	private ArrayList<Categoriedavid> listeCategorie = new ArrayList<>();

	public String getNom() {
		return nom;
	}

	public void setArtEtFenetre(String nom) {
	this.nom = nom;
	}


	public Categoriedavid(String nom) {
		
	this.nom = nom;
	}

	public ArrayList<Categoriedavid> getListeCategorie() {
		return listeCategorie;
	}

	public void setListeCategorie(ArrayList<Categoriedavid> listeCategorie) {
		this.listeCategorie = listeCategorie;
	}




	
}
