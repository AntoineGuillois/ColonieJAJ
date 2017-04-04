package ad;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import entite.Enfant;

//LAAAAAAAAAAAAlala j'ai envie de chanter la al al al lal al al lal 

public class EnfantDAOImpl extends EnfantDAOcon implements IntEnfantDAO {

	// Singleton
	private static IntEnfantDAO instance = null;

	private EnfantDAOImpl() {
	}

	public static synchronized IntEnfantDAO getInstance() {
		if (instance == null) {
			instance = new EnfantDAOImpl();
		}
		return instance;
	}

<<<<<<< HEAD
	///////////////////////////////////////////////////////////
=======
<<<<<<< HEAD
	////////////////////////////////////////////////////////////////////////////////////////////////
=======
	///////////////////////////////////////////////////////////
>>>>>>> branch 'master' of https://github.com/AntoineGuillois/ColonieJAJ.git
>>>>>>> refs/remotes/origin/master

	@Override
	public void ajoutEnfant(Enfant e) throws DAOException {
		Connection con = getConnection();

		// creation et execution de la requete
		String requete = "INSERT INTO ENFANT (identifiantEnfant, nom, prenom, age) " + "VALUES (?,?,?,?)";

		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(requete);
			stmt.setString(1, e.getNumeroEnfant());
			stmt.setString(2, e.getNomEnfant());
			stmt.setString(3, e.getPrenomEnfant());
			stmt.setInt(4, e.getAgeEnfant());
			stmt.executeUpdate();
		} catch (SQLException ex) {
			throw new DAOException();
		}

		closeConnection();
	}

	@Override
	public List<Enfant> listeEnfant() throws DAOException {
		List<Enfant> listeEnfant = new ArrayList<Enfant>();

		Connection con = getConnection();
		ResultSet rs = null;

		// creation et execution de la requete
		String requete = "SELECT identifiantEnfant, nom, prenom, age from enfant";

		Statement stmt = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(requete);
		} catch (SQLException ex) {
			//throw new DAOException();
		}

		// parcours du résultat
		try {
			while (rs.next()) {
				Enfant e = new Enfant();
				e.setNumeroEnfant(rs.getString("identifiantEnfant"));
				e.setNomEnfant(rs.getString("nom"));
				e.setPrenomEnfant(rs.getString("prenom"));
				e.setAgeEnfant(rs.getInt("age"));
				listeEnfant.add(e);
			}
		} catch (SQLException ex) {
			throw new DAOException();
		}
		closeConnection();

		return listeEnfant;

	}

}
