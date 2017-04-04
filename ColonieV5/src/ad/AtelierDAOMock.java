package ad;

import java.util.ArrayList;
import java.util.List;

import entite.Atelier;
import entite.Enfant;

public class AtelierDAOMock implements IntAtelierDAO{
	public List<Atelier> listeAtelier= new ArrayList<Atelier>();

	public void ajoutAtelier(Atelier a) {
		listeAtelier.add(a);
	}

	public List<Atelier> listeAtelier() {
		return listeAtelier;
	}

	@Override
	public void ajouterEnfantDansAtelier(Atelier atelier, Enfant e) throws DAOException {
		
	}

}
