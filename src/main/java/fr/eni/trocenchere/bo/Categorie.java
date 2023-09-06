package fr.eni.trocenchere.bo;

import java.util.ArrayList;

public enum Categorie {

	INFORMATIQUE,
	AMEUBLEMENT,
	VETEMENTS,
	SPORTSLOISIRS;
	
	private int idCategorie;
	private String libelle;
	private ArrayList<Article> listeArticle = new ArrayList<>();
	
	
	// GETTERS SETTERS
	
	public int getNoCategorie() {
		return idCategorie;
	}
	public void setNoCategorie(int noCategorie) {
		this.idCategorie = noCategorie;
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
