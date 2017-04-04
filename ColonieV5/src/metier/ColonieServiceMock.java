package metier;

import java.util.List;

import entite.Atelier;
import entite.Enfant;

public class ColonieServiceMock implements IntColonieService{
	
	@Override
	public Integer moyenneAge(List<Enfant> e) {
		return 8;
	}

	@Override
	public boolean contrainteAgeMin(Atelier a, Integer age) {
		return true;
	}

	@Override
	public boolean nbMax(Atelier a) {
		return true;
	}

	@Override
	public void affichageAtelier() {
		System.out.println("voici la liste de tous nos atliers!");
		
	}

	@Override
	public void affichageEnfant() {
		System.out.println("voici la liste de tous nos enfants!");
		
	}

	@Override
	public boolean testAtelier(Atelier a, Enfant e) {
		return true;
	}

	@Override
	public void infoAtelier(Atelier a) {
		System.out.println("Voici le nom atelier");
	}

	@Override
	public void affecterEnfantAuHasardDansAtelier(Enfant e, List<Atelier> li) {
		System.out.println("lalalala");	
	}

	@Override
	public void affichageEnfantAtelier(Atelier a) {
		// TODO Auto-generated method stub
		
	}
	
	

}
