package fr.eni.trocenchere.bo;

import java.util.ArrayList;

public enum Categorie {

	INFORMATIQUE,
	AMEUBLEMENT,
	VETEMENTS,
	SPORTSLOISIRS;
	
	private int noCategorie;
	private String libelle;
	private ArrayList<ArticleVendu> listeArticle = new ArrayList<>();
	
	
	// GETTERS SETTERS
	
	public int getNoCategorie() {
		return noCategorie;
	}
	public void setNoCategorie(int noCategorie) {
		this.noCategorie = noCategorie;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public ArrayList<ArticleVendu> getListeArticle() {
		return listeArticle;
	}
	public void ajouterArticleVendu(ArticleVendu articleVendu) {
		this.listeArticle.add(articleVendu);
	}
	
	
}
