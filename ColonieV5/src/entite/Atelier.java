package entite;

import java.util.ArrayList;
import java.util.List;

import entite.Enfant;

public class Atelier {

	protected String identifiantAtelier;
	protected String identifiantEnfant;
	protected String nomAtelier;
	protected Integer ageMin;
	protected Integer nbMax;
	protected List<Enfant> enfantsParticipant = new ArrayList<Enfant>();

	public Atelier() {
	}

	public String getIdentifiantEnfant() {
		return identifiantEnfant;
	}

	public void setIdentifiantEnfant(String identifiantEnfant) {
		this.identifiantEnfant = identifiantEnfant;
	}

	public Atelier(String identifiantAtelier, String nomAtelier, Integer ageMin, Integer nbMax) {
		super();
		this.identifiantAtelier = identifiantAtelier;
		this.nomAtelier = nomAtelier;
		this.ageMin = ageMin;
		this.nbMax = nbMax;
	}

	public String getIdentifiantAtelier() {
		return identifiantAtelier;
	}

	public void setIdentifiantAtelier(String identifiantAtelier) {
		this.identifiantAtelier = identifiantAtelier;
	}

	public String getNomAtelier() {
		return nomAtelier;
	}

	public void setNomAtelier(String nomAtelier) {
		this.nomAtelier = nomAtelier;
	}

	public Integer getAgeMin() {
		return ageMin;
	}

	public void setAgeMin(Integer ageMin) {
		this.ageMin = ageMin;
	}

	public Integer getNbMax() {
		return nbMax;
	}

	public void setNbMax(Integer nbMax) {
		this.nbMax = nbMax;
	}

	public List<Enfant> getEnfantsParticipant() {
		return enfantsParticipant;
	}

	public void setEnfantsParticipant(List<Enfant> enfantsParticipant) {
		this.enfantsParticipant = enfantsParticipant;
	}

}
