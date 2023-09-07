package fr.eni.trocenchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import fr.eni.trocenchere.bo.Utilisateur;
import fr.eni.trocenchere.dal.DALException;
import fr.eni.trocenchere.dal.DAO.DAOUtilisateur;

public class UtilisateurDAOJdbcImpl implements DAOUtilisateur {

	public void insert(Utilisateur utilisateur) {
		Connection cnx = JDBCTools.connect();
		try {
			String INSERT = "INSERT INTO UTILISATEURS "
					+ "(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement stmt = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, utilisateur.getPseudo());
			stmt.setString(2, utilisateur.getNom());
			stmt.setString(3, utilisateur.getPrenom());
			stmt.setString(4, utilisateur.getEmail());
			stmt.setString(5, utilisateur.getTelephone());
			stmt.setString(6, utilisateur.getRue());
			stmt.setString(7, utilisateur.getCodePostal());
			stmt.setString(8, utilisateur.getVille());
			stmt.setString(9, utilisateur.getMotDePasse());
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()) {

				utilisateur.setIdUtilisateur(rs.getInt(1));

			}

			cnx.close();
		} catch (SQLException e) {
			e.printStackTrace();

		}

	}

	
	


	private static final String SELECT_BY_MDP = "SELECT mot_de_passe FROM UTILISATEURS WHERE pseudo = ?";

	@Override
	public List<Utilisateur> selectById() {

		return null;
	}

	@Override
	public Boolean verifMotDePasse(String pseudo, String motdePasse) {

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
	public boolean checkForUniquePseudoAndMail(String pseudo, String mail) throws DALException {

		return false;
	}

	@Override
	public boolean checkForUniquePseudo(String pseudo) throws DALException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkForUniqueMail(String mail) throws DALException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Utilisateur selectUtilisateurByPseudo(String pseudo) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<Integer, String> selectUtilisateursWithCurrentAuction() throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateCredit(int noUtilisateur, int newCredit) throws DALException {
		// TODO Auto-generated method stub

	}



	@Override
	public Utilisateur insert() {
		// TODO Auto-generated method stub
		return null;
	}

}
