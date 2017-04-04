package ad;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import entite.Atelier;
import entite.Enfant;

public class AtelierDAOImpl extends AtelierDAOcon implements IntAtelierDAO {

	// Singleton
	private static IntAtelierDAO instance = null;

	private AtelierDAOImpl() {
	}

	public static synchronized IntAtelierDAO getInstance() {
		if (instance == null) {
			instance = new AtelierDAOImpl();
		}
		return instance;
	}

	
	////////////////////////////////////////////////////////////

	@Override
	public void ajoutAtelier(Atelier a) throws DAOException {

		Connection con = AtelierDAOcon.getConnection();

		// creation et execution de la requete
		String requete = "INSERT INTO ATELIER (identifiantAtelier, identifiantEnfant, nom, nombreMax, ageMinimum) " + "VALUES (?,?,?,?,?)";

		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(requete);
			
			stmt.setString(1, a.getIdentifiantAtelier());
			stmt.setString(2, a.getIdentifiantEnfant());
			stmt.setString(3, a.getNomAtelier());
			stmt.setInt(4, a.getNbMax());
			stmt.setInt(5, a.getAgeMin());
			
			stmt.executeUpdate();
		} catch (SQLException ex) {
			throw new DAOException();
		}

		closeConnection();
	}

	@Override
	public List<Atelier> listeAtelier() throws DAOException {
		List<Atelier> listeAtelier = new ArrayList<Atelier>();

		Connection con1 = getConnection();
		ResultSet rs = null;

		// creation et execution de la requete
		String requete = "SELECT DISTINCT * from atelier";

		Statement stmt = null;
		try {
			
			stmt = con1.createStatement();
			
			rs = stmt.executeQuery(requete);
			
		} catch (SQLException ex) {
			throw new DAOException();
		}

		// parcours du résultat
		try {
			while (rs.next()) {
				Atelier a = new Atelier();
				
				a.setIdentifiantAtelier(rs.getString("identifiantAtelier"));
				
				a.setIdentifiantEnfant(rs.getString("identifiantEnfant"));
				
				a.setNomAtelier(rs.getString("nom"));
				
				
				a.setNbMax(rs.getInt("nombreMax"));
				a.setAgeMin(rs.getInt("ageMinimum"));
				
				listeAtelier.add(a);
			}
		} catch (SQLException ex) {
			throw new DAOException();
		}

		closeConnection();

		return listeAtelier;
	}

	
	
	
	
	public void ajouterEnfantDansAtelier(Atelier a, Enfant e) throws DAOException {
		Connection con = getConnection();

		// creation et execution de la requete
		String requete = "INSERT INTO ENFANT (identifiantEnfant, nom, prenom, age) " + "VALUES (?,?,?,?)";

		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(requete);
			stmt.setString(1, e.getNumeroEnfant());
			stmt.executeUpdate();
			
		} catch (SQLException ex) {
			throw new DAOException();
		}

		closeConnection();
	}
	
	
	public List<Enfant> enfantsParticipant() throws DAOException {
		List<Enfant> enfantsParticipant = new ArrayList<Enfant>();

		Connection con = getConnection();
		ResultSet rs = null;

		// creation et execution de la requete
		String requete = "SELECT identifiantEnfant, nom, prenom, age from ATELIER";

		Statement stmt = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(requete);
		} catch (SQLException ex) {
			throw new DAOException();
		}

		// parcours du résultat
				try {
					while (rs.next()) {
						Enfant e = new Enfant();
						e.setNumeroEnfant(rs.getString("identifiantEnfant"));
						e.setNomEnfant(rs.getString("nom"));
						e.setPrenomEnfant(rs.getString("prenom"));
						e.setAgeEnfant(rs.getInt("age"));
						enfantsParticipant.add(e);
					}
				} catch (SQLException ex) {
					throw new DAOException();
				}
				closeConnection();

				return enfantsParticipant;

			}

	
	
}
