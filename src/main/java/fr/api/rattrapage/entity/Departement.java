package fr.api.rattrapage.entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Departement implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "iddepartement")
	private int idDepartement;

	@Column(name = "nomdepartement")
	private String nomDepartement;

	@Column(name = "descdepartement")
	private String descDepartement;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "idresponsable")
	private Responsable responsable;

	public Departement(int idDepartement, String nomDepartement, String descDepartement, Responsable responsable) {
		super();
		this.idDepartement = idDepartement;
		this.nomDepartement = nomDepartement;
		this.descDepartement = descDepartement;
		this.responsable = responsable;
	}

	public Departement() {}

	public int getIdDepartement() {
		return idDepartement;
	}

	public void setIdDepartement(int idDepartement) {
		this.idDepartement = idDepartement;
	}

	public String getNomDepartement() {
		return nomDepartement;
	}

	public void setNomDepartement(String nomDepartement) {
		this.nomDepartement = nomDepartement;
	}

	public String getDescDepartement() {
		return descDepartement;
	}

	public void setDescDepartement(String descDepartement) {
		this.descDepartement = descDepartement;
	}

	public Responsable getResponsable() {
		return responsable;
	}

	public void setResponsable(Responsable responsable) {
		this.responsable = responsable;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
