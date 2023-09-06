package fr.eni.trocenchere.bo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Article {

	private int idArticle;
	private String nomArticle;
	private String description;
	private LocalDate dateDebutEncheres;
	private LocalDate dateFinEncheres;
	private int miseAPrix;
	private int prixVente;
	private Utilisateur possesseurArticle;
	private Categorie catArticle;
	private ArrayList<Enchere> listeEnchere = new ArrayList<>();
	
	// CONSTRUCTORS
	
	public Article() {
	}


	public Article(String nomArticle, String description, LocalDate dateDebutEncheres, LocalDate dateFinEncheres,
			int miseAPrix, int prixVente, Utilisateur possesseurArticle, Categorie catArticle) {
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.possesseurArticle = possesseurArticle;
		this.catArticle = catArticle;
	}


	public Article(int idArticle, String nomArticle, String description, LocalDate dateDebutEncheres,
			LocalDate dateFinEncheres, int miseAPrix, int prixVente, Utilisateur possesseurArticle,
			Categorie catArticle) {
		this.idArticle = idArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.possesseurArticle = possesseurArticle;
		this.catArticle = catArticle;
	}


	@Override
	public String toString() {
		return "ArticleVendu [idArticle=" + idArticle + ", nomArticle=" + nomArticle + ", description=" + description
				+ ", dateDebutEncheres=" + dateDebutEncheres + ", dateFinEncheres=" + dateFinEncheres + ", miseAPrix="
				+ miseAPrix + ", prixVente=" + prixVente + ", possesseurArticle=" + possesseurArticle + ", catArticle="
				+ catArticle + "]";
	}
	
	
	// GETTERS SETTERS
	
	public int getNoArticle() {
		return idArticle;
	}
	public void setNoArticle(int idArticle) {
		this.idArticle = idArticle;
	}
	public String getNomArticle() {
		return nomArticle;
	}
	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getDateDebutEncheres() {
		return dateDebutEncheres;
	}
	public void setDateDebutEncheres(LocalDate dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}
	public LocalDate getDateFinEncheres() {
		return dateFinEncheres;
	}
	public void setDateFinEncheres(LocalDate dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
	}
	public int getMiseAPrix() {
		return miseAPrix;
	}
	public void setMiseAPrix(int miseAPrix) {
		this.miseAPrix = miseAPrix;
	}
	public int getPrixVente() {
		return prixVente;
	}
	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
	}
	public Utilisateur getPossesseurArticle() {
		return possesseurArticle;
	}
	public void setPossesseurArticle(Utilisateur possesseurArticle) {
		this.possesseurArticle = possesseurArticle;
	}
	public Categorie getCatArticle() {
		return catArticle;
	}
	public void setCatArticle(Categorie catArticle) {
		this.catArticle = catArticle;
	}

	public ArrayList<Enchere> getListeEnchere() {
		return listeEnchere;
	}

	public void ajouterEnchere(Enchere enchere) {
		this.listeEnchere.add(enchere);
	}
	
}
