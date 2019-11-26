package beans;

public class User {
	private int id;
	private String email;
	private String password;
	private String nom;
	private String prenom;
	private Role role;
	private Entreprise entreprise;
	
	public User(int id, String email, String password, String nom, String prenom, Role role, Entreprise entreprise) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.role = role;
		this.entreprise = entreprise;
	}

	public User(String email, String password, String nom, String prenom, Role role, Entreprise entreprise) {
		this.email = email;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.role = role;
		this.entreprise = entreprise;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
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
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", nom=" + nom + ", prenom=" + prenom
				+ ", role=" + role + ", entreprise=" + entreprise + "]";
	}
	
	
	
	
}
