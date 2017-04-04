package ad;

import java.util.List;

import entite.Atelier;
import entite.Enfant;

public interface IntAtelierDAO {

	public void ajoutAtelier(Atelier a) throws DAOException;
	public List<Atelier> listeAtelier() throws DAOException;
	public void ajouterEnfantDansAtelier(Atelier atelier, Enfant e) throws DAOException;
	
}
