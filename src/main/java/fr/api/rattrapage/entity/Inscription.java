package fr.api.rattrapage.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Inscription implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	InscriptionKey id;
	
	@ManyToOne
    @MapsId("idSession")
    @JoinColumn(name = "idsession")
	@JsonIgnoreProperties({"intervenant","surveillant","inscriptions"})
	private Session session;

    @ManyToOne
    @MapsId("idApprenant")
    @JoinColumn(name = "idapprenant")
    @JsonIgnoreProperties({"inscriptions"})
    private Apprenant apprenant;
	
	@Column(name = "datefin")
	private long dateFin;

	@Column(name = "emmargement")
	private boolean emmargement;
	
	@Column(name = "note")
	private int note;

	public Inscription(InscriptionKey id, Session session, Apprenant apprenant, long dateFin, boolean emmargement,
			int note) {
		super();
		this.id = id;
		this.session = session;
		this.apprenant = apprenant;
		this.dateFin = dateFin;
		this.emmargement = emmargement;
		this.note = note;
	}

	public Inscription () {}
	
	public InscriptionKey getId() {
		return id;
	}

	public void setId(InscriptionKey id) {
		this.id = id;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public Apprenant getApprenant() {
		return apprenant;
	}

	public void setApprenant(Apprenant apprenant) {
		this.apprenant = apprenant;
	}

	public long getDateFin() {
		return dateFin;
	}

	public void setDateFin(long dateFin) {
		this.dateFin = dateFin;
	}

	public boolean isEmmargement() {
		return emmargement;
	}

	public void setEmmargement(boolean emmargement) {
		this.emmargement = emmargement;
	}

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
