package metier;

import java.util.List;

import ad.AtelierDAOImpl;
import ad.DAOException;
import ad.EnfantDAOImpl;
import entite.Atelier;
import entite.Enfant;

public class ColonieServiceImp implements IntColonieService {

	// Partie Singleton

	private static IntColonieService instance;

	private ColonieServiceImp() {
	}

	public static IntColonieService getInstance() {
		if (instance == null) {
			instance = new ColonieServiceImp();
		}
		return instance;
	}
	///////////////////

	@Override
	public Integer moyenneAge(List<Enfant> e) {
		Integer resultat = 0;
		for (Enfant enfant : e) {
			resultat = resultat + enfant.getAgeEnfant();
		}
		return resultat / e.size();
	}

	@Override
	// renvoie vrai si l'enfant l'âge minimum pour faire l'atelier
	public boolean contrainteAgeMin(Atelier a, Integer age) {
		if (age >= a.getAgeMin()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	// renvoie vrai si il reste de la place dans l'atelier et faux s'il est
	// plein
	public boolean nbMax(Atelier a) {
		if (a.getEnfantsParticipant().size() >= a.getNbMax()) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void affichageAtelier() throws DAOException {
		System.out.println("Voici la liste des ateliers proposés par la colonie: ");
		List<Atelier> listeAtelier = AtelierDAOImpl.getInstance().listeAtelier();
		for (Atelier atelier : listeAtelier) {
			System.out.println(atelier.getNomAtelier());
		}
	}

	@Override
	public void affichageEnfant() throws DAOException {
		System.out.println("Voici la liste des enfants: ");
		List<Enfant> listeEnfant = EnfantDAOImpl.getInstance().listeEnfant();
		for (Enfant enfant : listeEnfant) {
			System.out.println(enfant.getNomEnfant() + " " + enfant.getPrenomEnfant());
		}
	}

	@Override
	// affiche les nom-prenoms des enfants dans un atelier
	public void affichageEnfantAtelier(Atelier a) {
		for (Enfant enfant : a.getEnfantsParticipant()) {
			System.out.println(enfant.getNomEnfant() + " " + enfant.getPrenomEnfant());
		}

	}

	@Override
	// renvoie vrai si l'enfant est dans l'atelier et faux sinon
	public boolean testAtelier(Atelier a, Enfant e) {
		boolean resultat = false;
		for (Enfant enfant : a.getEnfantsParticipant()) {
			if (enfant.getNumeroEnfant() == e.getNumeroEnfant()) {
				return resultat = true;
			}
		}
		return resultat;
	}

	// procédure qui renvoie toutes les informations d'un atelier avec toutes
	// les infos des enfants
	@Override
	public void infoAtelier(Atelier a) {
		System.out.println("Nom atelier: " + a.getNomAtelier());
		System.out.println("Nombre de places: " + a.getNbMax());
		System.out.println("Age minimum: " + a.getAgeMin());
		ColonieServiceImp.getInstance().affichageEnfantAtelier(a);
	}

	// affecter un enfant au hasard dans une activité:
	@Override
	public void affecterEnfantAuHasardDansAtelier(Enfant e, List<Atelier> listeAtelier) throws DAOException {
		boolean affecte = false;
		boolean ilAUnePlace = false;

		for (Atelier atelier : listeAtelier) {
			if (contrainteAgeMin(atelier, e.getAgeEnfant()) && nbMax(atelier)) {
				ilAUnePlace = true;
			}
		}

		if (ilAUnePlace) {
			while (!affecte) {
				// nombre aléatoire pour désigner un atelier
				int nombreAleatoire = (int) (Math.random() * listeAtelier.size());
				if (contrainteAgeMin(listeAtelier.get(nombreAleatoire), e.getAgeEnfant())
						&& nbMax(listeAtelier.get(nombreAleatoire))) {
					AtelierDAOImpl.getInstance().ajouterEnfantDansAtelier(listeAtelier.get(nombreAleatoire), e);
					affecte = true;
				}
			}
		} else {
			System.out.println("Aucune activité ne peut être proposée à l'enfant");
		}
	}

}
