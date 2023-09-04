package fr.eni.trocenchere.bo;

public enum Categorie {

	INFORMATIQUE,
	AMEUBLEMENT,
	VETEMENTS,
	SPORTSLOISIRS;
	
	private int noCategorie;
	private String libelle;
	
	
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
	
	
}
