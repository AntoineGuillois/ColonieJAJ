package metier;

import java.util.List;

import ad.DAOException;
import entite.Atelier;
import entite.Enfant;

public interface IntColonieService {
	public Integer moyenneAge(List<Enfant> e);
	public boolean contrainteAgeMin(Atelier a, Integer age);
	public boolean nbMax(Atelier a);
	public void affichageAtelier() throws DAOException;
	public void affichageEnfant() throws DAOException;
	public void affichageEnfantAtelier(Atelier a); //affiche les enfants d'un atelier
	public boolean testAtelier(Atelier a, Enfant e);
	public void infoAtelier(Atelier a);
	public void affecterEnfantAuHasardDansAtelier(Enfant e, List<Atelier> l) throws DAOException;
}
