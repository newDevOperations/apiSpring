package fr.api.rattrapage.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Matiere {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idmatiere")
	private int idMatiere;

	@Column(name = "nommatiere")
	private String nomMatiere;

	@Column(name = "descmatiere")
	private String descMatiere;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "iddepartement")
	private Departement departement;
	
	@OneToMany(mappedBy = "matiere", cascade = CascadeType.MERGE)
	@JsonIgnore
	private List<Module> module = new ArrayList<>();

	public Matiere(int idMatiere, String nomMatiere, String descMatiere, Departement departement, List<Module> module) {
		super();
		this.idMatiere = idMatiere;
		this.nomMatiere = nomMatiere;
		this.descMatiere = descMatiere;
		this.departement = departement;
		this.module = module;
	}

	public Matiere() {}

	public int getIdMatiere() {
		return idMatiere;
	}

	public void setIdMatiere(int idMatiere) {
		this.idMatiere = idMatiere;
	}

	public String getNomMatiere() {
		return nomMatiere;
	}

	public void setNomMatiere(String nomMatiere) {
		this.nomMatiere = nomMatiere;
	}

	public String getDescMatiere() {
		return descMatiere;
	}

	public void setDescMatiere(String descMatiere) {
		this.descMatiere = descMatiere;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	public List<Module> getModule() {
		return module;
	}

	public void setModule(List<Module> module) {
		this.module = module;
	}
	
}
