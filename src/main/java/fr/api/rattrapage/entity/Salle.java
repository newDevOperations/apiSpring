package fr.api.rattrapage.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Salle implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idsalle")
	private int idSalle;

	@Column(name = "nomsalle")
	private String nomSalle;

	@Column(name = "capacite")
	private int capacite;

	@OneToMany(mappedBy = "salle", cascade = CascadeType.MERGE)
	@JsonIgnore
	private List<Session> session = new ArrayList<>();

	public Salle(int idSalle, String nomSalle, int capacite, List<Session> session) {
		super();
		this.idSalle = idSalle;
		this.nomSalle = nomSalle;
		this.capacite = capacite;
		this.session = session;
	}

	public Salle() {
	}

	public int getIdSalle() {
		return idSalle;
	}

	public void setIdSalle(int idSalle) {
		this.idSalle = idSalle;
	}

	public String getNomSalle() {
		return nomSalle;
	}

	public void setNomSalle(String nomSalle) {
		this.nomSalle = nomSalle;
	}

	public int getCapacite() {
		return capacite;
	}

	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}

	public List<Session> getSession() {
		return session;
	}

	public void setSession(List<Session> session) {
		this.session = session;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
