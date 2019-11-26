package beans;

public class Entreprise {
	private int id;
	private String nom;
	private String description;
	
	public Entreprise(int id, String nom, String description) {
		this.id = id;
		this.nom = nom;
		this.description = description;
	}

	public Entreprise(String nom, String description) {
		this.nom = nom;
		this.description = description;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Entreprise [id=" + id + ", nom=" + nom + ", description=" + description + "]";
	}

	
	
}
