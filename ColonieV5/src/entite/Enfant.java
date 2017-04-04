package entite;

public class Enfant {

	protected String numeroEnfant;
	protected String nomEnfant;
	protected String prenomEnfant;
	protected Integer ageEnfant;
	protected Atelier atelier;
	
	public Enfant() {
	}


	public Enfant(String numeroEnfant, String nomEnfant, String prenomEnfant, Integer ageEnfant) {
		super();
		this.numeroEnfant = numeroEnfant;
		this.nomEnfant = nomEnfant;
		this.prenomEnfant = prenomEnfant;
		this.ageEnfant = ageEnfant;
	}


	public String getNumeroEnfant() {
		return numeroEnfant;
	}


	public void setNumeroEnfant(String numeroEnfant) {
		this.numeroEnfant = numeroEnfant;
	}


	public String getNomEnfant() {
		return nomEnfant;
	}


	public void setNomEnfant(String nomEnfant) {
		this.nomEnfant = nomEnfant;
	}


	public String getPrenomEnfant() {
		return prenomEnfant;
	}


	public void setPrenomEnfant(String prenomEnfant) {
		this.prenomEnfant = prenomEnfant;
	}


	public Integer getAgeEnfant() {
		return ageEnfant;
	}


	public void setAgeEnfant(Integer ageEnfant) {
		this.ageEnfant = ageEnfant;
	}


	@Override
	public String toString() {
		return "Enfant [numeroEnfant=" + numeroEnfant + ", nomEnfant=" + nomEnfant + ", prenomEnfant=" + prenomEnfant
				+ ", ageEnfant=" + ageEnfant + "]";
	}

	
}
