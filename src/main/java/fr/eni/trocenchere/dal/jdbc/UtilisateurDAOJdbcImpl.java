package fr.eni.trocenchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.trocenchere.bll.BusinessException;
import fr.eni.trocenchere.bo.Utilisateur;
import fr.eni.trocenchere.dal.DAO.DAOUtilisateur;

public class UtilisateurDAOJdbcImpl implements DAOUtilisateur {

	private static final String SELECT_BY_MDP = "SELECT mot_de_passe FROM UTILISATEURS WHERE pseudo = ?;";
	private static final String SELECT_BY_PSEUDOS = "SELECT * FROM UTILISATEURS WHERE pseudo = ?;";
	private static final String SELECT_BY_ID = "SELECT * FROM UTILISATEURS WHERE id_utilisateur=?;";
	private static final String INSERT_UTILISATEUR ="INSERT INTO UTILISATEURS (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) "
			+ "										VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
	private static final String UPDATE_UTILISATEUR = "UPDATE UTILISATEURS SET pseudo =?, nom=?, prenom=?, email=?, telephone=?, rue=?,"
			+ "										code_postal=?, ville=?, mot_de_passe=? WHERE id_utilisateur =?;";
	
	private static final String UPDATE_CREDIT_UTILISATEUR = "UPDATE UTILISATEURS SET credit=? WHERE id_utilisateur=?;";
	
	private static final String DELETE_UTILISATEUR ="DELETE FROM UTILISATEURS WHERE id_utilisateur = ?;";

	
	
	public void insert(Utilisateur utilisateur) throws BusinessException{
		
//		if((utilisateur.getPseudo().isEmpty() || utilisateur.getPseudo().isBlank()) || (utilisateur.getPrenom() == null) || (utilisateur.getEmail() == null)
//			|| (utilisateur.getTelephone() == null) || (utilisateur.getRue()== null) || (utilisateur.getCodePostal()== null)
//			|| (utilisateur.getVille()== null) || (utilisateur.getMotDePasse()== null)) {
//			
//			throw new BusinessException(CodesErreurDAL.ERREUR_INSERTION_UTILISATEUR);
//		}
		
		//connexion
		try (Connection cnx = ConnexionProvider.getConnection()){
			//requete
			PreparedStatement stmt = cnx.prepareStatement(INSERT_UTILISATEUR, PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, utilisateur.getPseudo());
			stmt.setString(2, utilisateur.getNom());
			stmt.setString(3, utilisateur.getPrenom());
			stmt.setString(4, utilisateur.getEmail());
			stmt.setString(5, utilisateur.getTelephone());
			stmt.setString(6, utilisateur.getRue());
			stmt.setString(7, utilisateur.getCodePostal());
			stmt.setString(8, utilisateur.getVille());
			stmt.setString(9, utilisateur.getMotDePasse());
			stmt.setInt(10, utilisateur.getCredit());
			stmt.setBoolean(11, utilisateur.getAdministrateur());
			stmt.executeUpdate();
			
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				utilisateur.setIdUtilisateur(rs.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}

	}

	@Override
	public Boolean verifMotDePasse(String pseudo, String motdePasse){

		boolean mdpIdentique = false;
		String mdpBDD = null;

		try (Connection cnx = ConnexionProvider.getConnection()) {

			PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_MDP);
			pstmt.setString(1, pseudo);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				mdpBDD = rs.getString(1);
				if (motdePasse.equals(mdpBDD)) {

					mdpIdentique = true;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		
		return mdpIdentique;
	}

	@Override
	public Utilisateur selectByPseudo(String pseudo) {
		Utilisateur utilisateur = null;
		
		try (Connection cnx = ConnexionProvider.getConnection()){
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_PSEUDOS);
			pstmt.setString(1, pseudo);
			
			ResultSet rs = pstmt.executeQuery();
			
			
					
			if(rs.next()) {
				utilisateur = new Utilisateur(
						rs.getInt("id_utilisateur"),
						rs.getString("pseudo"),
						rs.getString("nom"),
						rs.getString("prenom"),
						rs.getString("email"),
						rs.getString("telephone"),
						rs.getString("rue"),
						rs.getString("code_postal"),
						rs.getString("ville"),
						rs.getInt("credit"),
						rs.getString("mot_de_passe")
						);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return utilisateur;
	}

	@Override
	public void modifUtilisateur(String IdUtilisateur, String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String codePostal, String ville, String motdepasse) {
		
		try (Connection cnx = ConnexionProvider.getConnection()){
			
			PreparedStatement pstmt = cnx.prepareStatement(UPDATE_UTILISATEUR);
			
			pstmt.setString(1, pseudo);
			pstmt.setString(2, nom);
			pstmt.setString(3, prenom);
			pstmt.setString(4, email);
			pstmt.setString(5, telephone);
			pstmt.setString(6, rue);
			pstmt.setString(7, codePostal);
			pstmt.setString(8, ville);
			pstmt.setString(9, motdepasse);
			pstmt.setInt(10, Integer.valueOf(IdUtilisateur));
			
			pstmt.executeUpdate();
			
			System.out.println("Modif user ok");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void suppresionUtilisateur(String id_utilisateur) {
		try (Connection cnx = ConnexionProvider.getConnection()){
			
			PreparedStatement pstmt = cnx.prepareStatement(DELETE_UTILISATEUR);
			
			pstmt.setInt(1, Integer.valueOf(id_utilisateur));
			
			pstmt.executeUpdate();
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void debiterCreditUtilisateur(int idUtilisateur, int creditActuel, Integer montantNouvelleEnchere) {

		try (Connection cnx = ConnexionProvider.getConnection()){
			
			PreparedStatement pstmt = cnx.prepareStatement(UPDATE_CREDIT_UTILISATEUR);
			
			pstmt.setInt(1, creditActuel - montantNouvelleEnchere);
			pstmt.setInt(2, idUtilisateur);
			
			pstmt.executeUpdate();
			
			System.out.println("DEBIT CREDIT UTILISATEUR (-" + montantNouvelleEnchere + ") effectué !");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void ajouterCreditUtilisateur(int idUtilisateur, int creditActuel, Integer montantNouvelleEnchere) {
		
		try (Connection cnx = ConnexionProvider.getConnection()){
			
			PreparedStatement pstmt = cnx.prepareStatement(UPDATE_CREDIT_UTILISATEUR);
			
			pstmt.setInt(1, creditActuel + montantNouvelleEnchere);
			pstmt.setInt(2, idUtilisateur);
			
			pstmt.executeUpdate();
			
			System.out.println("DEBIT CREDIT UTILISATEUR (-" + montantNouvelleEnchere + ") effectué !");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Utilisateur selectUtilisateurById(int idUtilisateurAncienneEnchere) {
		Utilisateur utilisateur = null;
		
		try (Connection cnx = ConnexionProvider.getConnection()){
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_ID);
			pstmt.setInt(1, idUtilisateurAncienneEnchere);
			
			ResultSet rs = pstmt.executeQuery();
			
			
			if(rs.next()) {
				utilisateur = new Utilisateur(
						rs.getInt("id_utilisateur"),
						rs.getString("pseudo"),
						rs.getString("nom"),
						rs.getString("prenom"),
						rs.getString("email"),
						rs.getString("telephone"),
						rs.getString("rue"),
						rs.getString("code_postal"),
						rs.getString("ville"),
						rs.getInt("credit")
						);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return utilisateur;
	}


}
