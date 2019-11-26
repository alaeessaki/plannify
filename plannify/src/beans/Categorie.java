package beans;

public class Categorie {
	private int id;
	private String nom;
	
	public Categorie(int id, String nom) {
		this.id = id;
		this.nom = nom;
	}

	public Categorie(String nom) {
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Categorie [id=" + id + ", nom=" + nom + "]";
	}
	
}
