package fr.eni.trocenchere.bo;

import java.util.ArrayList;

public enum Categorie {

	INFORMATIQUE(1),
	AMEUBLEMENT(2),
	VETEMENTS(3),
	SPORTSLOISIRS(4);
	
	private int idCategorie;
	private String libelle;
	private ArrayList<Article> listeArticle = new ArrayList<>();
	
	
	private Categorie(int idCategorie) {
		this.idCategorie = idCategorie;
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
	public ArrayList<Article> getListeArticle() {
		return listeArticle;
	}
	public void ajouterArticle(Article article) {
		this.listeArticle.add(article);
	}
	
	
}
