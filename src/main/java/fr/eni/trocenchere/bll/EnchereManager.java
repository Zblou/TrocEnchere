package fr.eni.trocenchere.bll;

import java.util.ArrayList;

import fr.eni.trocenchere.bo.Article;
import fr.eni.trocenchere.bo.Enchere;
import fr.eni.trocenchere.bo.Utilisateur;
import fr.eni.trocenchere.dal.DAO.DAOFactory;

public class EnchereManager {
	private static EnchereManager instance;
	
	public static EnchereManager getInstance() {
		if(instance == null) {
			instance = new EnchereManager();
		}
		return instance;
	}

	public boolean nouvelleEnchereUtilisateur(Integer montantNouvelleEnchere, Article articleVendu, Utilisateur acheteur) {
		
		if((acheteur.getCredit() >= montantNouvelleEnchere) && (montantNouvelleEnchere >= articleVendu.getPrixVente())) {
			try { // ON ESSAIE DE FAIRE TOUT, SI UN DES TRUCS BUG, CATCH ET ANNULE
				// ON UPDATE LE NOUVEAU PRIX DE VENTE
				DAOFactory.getDAOArticleJDBCIpml().modifPrixVenteArticle(articleVendu.getIdArticle(), montantNouvelleEnchere);
				// ON DEBITE LE CREDIT DE L'UTILISATEUR QUI A ENCHERIT
				DAOFactory.getDAOUtilisateur().debiterCreditUtilisateur(acheteur.getIdUtilisateur(), acheteur.getCredit(), montantNouvelleEnchere);
				
				// ON DOIS RECUP LA LISTE DES ENCHERES ASSOCIE A L'OBJET POUR VOIR SI ELLE EST NULLE -> ON AJOUTE CELLE CI A LA LISTE ET ON NE FAIT RIEN D'AUTRE
				// OU SI ELLE CONTIENT AU MOINS UNE ENCHERE, ON REMBOURSE DONC L'UTILISATEUR ASSOCIEE A L'ANCIENNE ENCHERE ET ON AJOUTE CELLE CI
				if(DAOFactory.getDAOEnchereJDBCImpl().selectEncheresByIdArticle(articleVendu.getIdArticle()).isEmpty()) {
					DAOFactory.getDAOEnchereJDBCImpl().insertEnchere(montantNouvelleEnchere, articleVendu.getIdArticle(), acheteur.getIdUtilisateur());
				}else {
					// ON REMBOURSE L'UTILISATEUR DONT LA VENTE A ETE SURPASSEE
					DAOFactory.getDAOEnchereJDBCImpl().insertEnchere(montantNouvelleEnchere, articleVendu.getIdArticle(), acheteur.getIdUtilisateur());
					
					ArrayList<Enchere> listeEnchere = DAOFactory.getDAOEnchereJDBCImpl().selectEncheresByIdArticle(articleVendu.getIdArticle());
					int idUtilisateurAncienneEnchere = listeEnchere.get(listeEnchere.size()-1).getIdUtilisateur();
					
					DAOFactory.getDAOUtilisateur().ajouterCreditUtilisateur(idUtilisateurAncienneEnchere,
							DAOFactory.getDAOUtilisateur().selectUtilisateurById(idUtilisateurAncienneEnchere).getCredit() ,montantNouvelleEnchere);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else {
			return false;
		}
		return true;
	}
	
	
}
