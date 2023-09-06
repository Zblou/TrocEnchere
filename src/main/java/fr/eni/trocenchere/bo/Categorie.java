package fr.eni.trocenchere.bo;

import java.util.ArrayList;

public enum Categorie {

	INFORMATIQUE,
	AMEUBLEMENT,
	VETEMENTS,
	SPORTSLOISIRS;
	
	private int idCategorie;
	private String libelle;
	private ArrayList<ArticleVendu> listeArticle = new ArrayList<>();
	
	
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
	public ArrayList<ArticleVendu> getListeArticle() {
		return listeArticle;
	}
	public void ajouterArticleVendu(ArticleVendu articleVendu) {
		this.listeArticle.add(articleVendu);
	}
	
	
}
