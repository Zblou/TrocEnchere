package fr.eni.trocenchere.bo;

public class Categoriedavid {

	private String ArtEtFenetre;

	public String getArtEtFenetre() {
		return ArtEtFenetre;
	}

	public void setArtEtFenetre(String artEtFenetre) {
		ArtEtFenetre = artEtFenetre;
	}

	public Categoriedavid() {
		super();
	}

	public Categoriedavid(String artEtFenetre) {
		super();
		ArtEtFenetre = artEtFenetre;
	}

	@Override
	public String toString() {
		return "Categoriedavid [ArtEtFenetre=" + ArtEtFenetre + "]";
	}


	
}
