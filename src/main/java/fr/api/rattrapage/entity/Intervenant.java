package fr.api.rattrapage.entity;

import java.io.Serializable;
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
public class Intervenant implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idintervenant")
	private int idIntervenant;

	@Column(name = "prenom")
	private String prenom;

	@Column(name = "nom")
	private String nom;

	@Column(name = "rueadresse")
	private String rueAdresse;

	@Column(name = "cpadresse")
	private String cpAdresse;

	@Column(name = "villeadresse")
	private String villeAdresse;

	@Column(name = "telportable")
	private String telPortable;

	@Column(name = "courriel")
	private String courriel;

	@Column(name = "photoID")
	private String photoID;

	@Column(name = "echelon")
	private int echelon;

	@OneToMany(mappedBy = "intervenant", cascade = CascadeType.MERGE)
	@JsonIgnore
	private List<Session> session;
	
	public Intervenant(int idIntervenant, String prenom, String nom, String rueAdresse, String cpAdresse,
			String villeAdresse, String telPortable, String courriel, String photoID, int echelon,
			List<Session> session) {
		super();
		this.idIntervenant = idIntervenant;
		this.prenom = prenom;
		this.nom = nom;
		this.rueAdresse = rueAdresse;
		this.cpAdresse = cpAdresse;
		this.villeAdresse = villeAdresse;
		this.telPortable = telPortable;
		this.courriel = courriel;
		this.photoID = photoID;
		this.echelon = echelon;
		this.session = session;
	}
	
	public Intervenant() {}

	public int getIdIntervenant() {
		return idIntervenant;
	}

	public void setIdIntervenant(int idIntervenant) {
		this.idIntervenant = idIntervenant;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getRueAdresse() {
		return rueAdresse;
	}

	public void setRueAdresse(String rueAdresse) {
		this.rueAdresse = rueAdresse;
	}

	public String getCpAdresse() {
		return cpAdresse;
	}

	public void setCpAdresse(String cpAdresse) {
		this.cpAdresse = cpAdresse;
	}

	public String getVilleAdresse() {
		return villeAdresse;
	}

	public void setVilleAdresse(String villeAdresse) {
		this.villeAdresse = villeAdresse;
	}

	public String getTelPortable() {
		return telPortable;
	}

	public void setTelPortable(String telPortable) {
		this.telPortable = telPortable;
	}

	public String getCourriel() {
		return courriel;
	}

	public void setCourriel(String courriel) {
		this.courriel = courriel;
	}

	public String getPhotoID() {
		return photoID;
	}

	public void setPhotoID(String photoID) {
		this.photoID = photoID;
	}

	public int getEchelon() {
		return echelon;
	}

	public void setEchelon(int echelon) {
		this.echelon = echelon;
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
