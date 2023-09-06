package fr.eni.trocenchere.dal.jdbc;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;

import fr.eni.trocenchere.bo.Utilisateur;
import fr.eni.trocenchere.dal.DALException;
import fr.eni.trocenchere.dal.DAO.DAOUtilisateur;

public class UtilisateurDAOJdbcImpl implements DAOUtilisateur {


private static final String SELECT_BY_MDP = "SELECT mot_de_passe FROM UTILISATEURS WHERE pseudo = '?'";

	@Override
	public List<Utilisateur> selectById() {
		
		return null;
	}

	@Override
	public Boolean verifMotDePasse(String pseudo, String motdePasse){
		
		boolean mdpIdentique = false;
		String mdpBDD = null;
		
		try (Connection cnx = ConnexionProvider.getConnection()){
			
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_MDP);
			pstmt.setString(1, pseudo);
			
			ResultSet rs  = pstmt.executeQuery();
			
			if(rs.next()) {
				mdpBDD = rs.getString(1);
				if(motdePasse.equals(mdpBDD)) {
					mdpIdentique = true;
				}
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return mdpIdentique;
	}

	@Override
	public boolean checkForUniquePseudoAndMail(String pseudo, String mail) throws DALException {
		// TODO Auto-generated method stub
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
}
