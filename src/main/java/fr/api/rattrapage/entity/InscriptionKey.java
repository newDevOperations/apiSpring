package fr.api.rattrapage.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class InscriptionKey implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Column(name = "idsession")
    int idSession;

    @Column(name = "idapprenant")
    int idApprenant;

    
    public InscriptionKey(int idSession, int idApprenant) {
		super();
		this.idSession = idSession;
		this.idApprenant = idApprenant;
	}
    
    public InscriptionKey() {}

	public int getIdSession() {
		return idSession;
	}

	public void setIdSession(int idSession) {
		this.idSession = idSession;
	}

	public int getIdApprenant() {
		return idApprenant;
	}

	public void setIdApprenant(int idApprenant) {
		this.idApprenant = idApprenant;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
