package fr.api.rattrapage.entity;

import java.io.Serializable;
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
public class Session implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idsession")
	private int idSession;

	@Column(name = "sujet")
	private String sujet;

	@Column(name = "datedebut")
	private long dateDebut;

	@Column(name = "duree")
	private int duree;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "idintervenant")
	private Intervenant intervenant;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "idsurveillant")
	private Surveillant surveillant;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "idmodule")
	private Module module;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "idsalle")
	private Salle salle;
	
	@OneToMany(mappedBy = "session", cascade = CascadeType.MERGE)
	@JsonIgnore
	private List<Inscription> inscriptions;

	public Session(int idSession, String sujet, long dateDebut, int duree, Intervenant intervenant,
			Surveillant surveillant, Module module, Salle salle, List<Inscription> inscriptions) {
		super();
		this.idSession = idSession;
		this.sujet = sujet;
		this.dateDebut = dateDebut;
		this.duree = duree;
		this.intervenant = intervenant;
		this.surveillant = surveillant;
		this.module = module;
		this.salle = salle;
		this.inscriptions = inscriptions;
	}
	
	public Session() {}

	public int getIdSession() {
		return idSession;
	}

	public void setIdSession(int idSession) {
		this.idSession = idSession;
	}

	public String getSujet() {
		return sujet;
	}

	public void setSujet(String sujet) {
		this.sujet = sujet;
	}

	public long getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(long dateDebut) {
		this.dateDebut = dateDebut;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public Intervenant getIntervenant() {
		return intervenant;
	}

	public void setIntervenant(Intervenant intervenant) {
		this.intervenant = intervenant;
	}

	public Surveillant getSurveillant() {
		return surveillant;
	}

	public void setSurveillant(Surveillant surveillant) {
		this.surveillant = surveillant;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	public List<Inscription> getInscriptions() {
		return inscriptions;
	}

	public void setInscriptions(List<Inscription> inscriptions) {
		this.inscriptions = inscriptions;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
