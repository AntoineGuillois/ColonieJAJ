package ad;

import java.util.List;

import entite.Enfant;

public interface IntEnfantDAO {
	public void ajoutEnfant(Enfant e) throws DAOException;
	List<Enfant> listeEnfant() throws DAOException;
}
