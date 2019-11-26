package beans;

public class Role {
	private int id;
	private String nom;
	
	public Role(int id, String nom) {
		this.id = id;
		this.nom = nom;
	}

	public Role(String nom) {
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
		return "Role [id=" + id + ", nom=" + nom + "]";
	}
	
	
	
}
