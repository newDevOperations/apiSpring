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
public class Module {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idmodule")
	private int idModule;

	@Column(name = "nommodule")
	private String nomModule;

	@Column(name = "descmodule")
	private String descModule;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "idmatiere")
	private Matiere matiere;
	
	@OneToMany(mappedBy = "module", cascade = CascadeType.MERGE)
	@JsonIgnore
	private List<Session> session = new ArrayList<>();

	public Module(int idModule, String nomModule, String descModule, Matiere matiere, List<Session> session) {
		super();
		this.idModule = idModule;
		this.nomModule = nomModule;
		this.descModule = descModule;
		this.matiere = matiere;
		this.session = session;
	}
	
	public Module() {}

	public int getIdModule() {
		return idModule;
	}

	public void setIdModule(int idModule) {
		this.idModule = idModule;
	}

	public String getNomModule() {
		return nomModule;
	}

	public void setNomModule(String nomModule) {
		this.nomModule = nomModule;
	}

	public String getDescModule() {
		return descModule;
	}

	public void setDescModule(String descModule) {
		this.descModule = descModule;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	public List<Session> getSession() {
		return session;
	}

	public void setSession(List<Session> session) {
		this.session = session;
	}

	
	
}
