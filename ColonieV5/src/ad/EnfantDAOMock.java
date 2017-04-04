package ad;

import java.util.ArrayList;
import java.util.List;

import entite.Enfant;

public class EnfantDAOMock implements IntEnfantDAO{
	public List<Enfant> listeEnfant= new ArrayList<Enfant>();

	public void ajoutEnfant(Enfant e) {
		// TODO Auto-generated method stub
		listeEnfant.add(e);
	}

	public List<Enfant> ListeEnfant() {
		// TODO Auto-generated method stub
		return listeEnfant;
	}

	@Override
	public List<Enfant> listeEnfant() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

}
