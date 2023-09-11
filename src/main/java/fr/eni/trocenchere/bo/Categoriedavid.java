package fr.eni.trocenchere.bo;

public class Categoriedavid {

	private String nom;

	public String getNom() {
		return nom;
	}

	public void setArtEtFenetre(String nom) {
	this.nom = nom;
	}

	public Categoriedavid() {
		
	}

	public Categoriedavid(String nom) {
		
	this.nom = nom;
	}

	@Override
	public String toString() {
		return "Categoriedavid [nom=" + nom + "]";
	}


	
}
