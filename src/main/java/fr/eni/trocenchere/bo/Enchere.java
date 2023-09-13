package fr.eni.trocenchere.bo;

import java.time.LocalDate;

public class Enchere {

	private LocalDate dateEnchere;
	private int montantEnchere;
	private int idArticle;
	private int idUtilisateur;

	// CONSTRUCTORS
	
	public Enchere() {
	}


	public Enchere(LocalDate dateEnchere, int montantEnchere) {
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
	}

	
	public Enchere(LocalDate dateEnchere, int montantEnchere, int idArticle, int idUtilisateur) {
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
		this.idArticle = idArticle;
		this.idUtilisateur = idUtilisateur;
	}


	@Override
	public String toString() {
		return "Enchere [dateEnchere=" + dateEnchere + ", montantEnchere=" + montantEnchere + "]";
	}
	
	
	
	// GETTERS SETTERS
	
	public LocalDate getDateEnchere() {
		return dateEnchere;
	}
	public void setDateEnchere(LocalDate dateEnchere) {
		this.dateEnchere = dateEnchere;
	}
	public int getMontantEnchere() {
		return montantEnchere;
	}
	public void setMontantEnchere(int montantEnchere) {
		this.montantEnchere = montantEnchere;
	}
	public int getIdArticle() {
		return idArticle;
	}
	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}
	public int getIdUtilisateur() {
		return idUtilisateur;
	}
	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}
}
