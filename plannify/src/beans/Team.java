package beans;

public class Team {
	private int id;
	private String nom;
	Entreprise entreprise;
	
	public Team(int id, String nom, Entreprise entreprise) {
		this.id = id;
		this.nom = nom;
		this.entreprise = entreprise;
	}
	
	public Team(String nom, Entreprise entreprise) {
		this.nom = nom;
		this.entreprise = entreprise;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Entreprise getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Team [id=" + id + ", nom=" + nom + "]";
	}
	
	

	
	
}
