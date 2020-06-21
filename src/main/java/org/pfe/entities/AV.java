package org.pfe.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("AV")
public class AV extends client {
	
	private String representant;
	private String activité;
	
	
	public AV() {
		super();
	}


	public AV(String nom_client, int tel, int fax, String mail, String adresse_de_facturation,
			String adresse_de_livraison, String representant, String activité) {
		super(nom_client, tel, fax, mail, adresse_de_facturation, adresse_de_livraison);
		this.representant = representant;
		this.activité = activité;
	}






	public String getRepresentant() {
		return representant;
	}



	public void setRepresentant(String representant) {
		this.representant = representant;
	}



	public String getActivité() {
		return activité;
	}



	public void setActivité(String activité) {
		this.activité = activité;
	}
	
	
	
	
	
	
	
	
	
	

}
