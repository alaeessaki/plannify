package beans;

import java.util.Date;

public class Project {
	private int id;
	private String nom;
	private String description;
	private Date created_at;
	private Team team;
	private Categorie categorie;
	
	public Project(int id, String nom, String description, Date created_at, Team team, Categorie categorie) {
		this.id = id;
		this.nom = nom;
		this.description = description;
		this.created_at = created_at;
		this.team = team;
		this.categorie = categorie;
	}

	public Project(String nom, String description, Date created_at, Team team, Categorie categorie) {
		this.nom = nom;
		this.description = description;
		this.created_at = created_at;
		this.team = team;
		this.categorie = categorie;
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

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public int getId() {
		return id;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public Team getTeam() {
		return team;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", nom=" + nom + ", description=" + description + ", created_at=" + created_at
				+ ", team=" + team + ", categorie=" + categorie + "]";
	}
	
	
	
	
}
