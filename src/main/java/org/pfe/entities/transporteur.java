package org.pfe.entities;

import java.util.Collection;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@DiscriminatorValue("transporteur")
public class transporteur extends client {

	
	
	@OneToMany(mappedBy="transporteur",fetch=FetchType.LAZY)
	private Collection<chauffeur> chauffeur;
	
	
	public transporteur() {
		super();
		// TODO Auto-generated constructor stub
	}



	public transporteur(String nom_client, int tel, int fax, String mail, String adresse_de_facturation,
			String adresse_de_livraison, long code_transporteur, Collection<org.pfe.entities.chauffeur> chauffeur) {
		super(nom_client, tel, fax, mail, adresse_de_facturation, adresse_de_livraison);
		
		this.chauffeur = chauffeur;
	}






	@JsonIgnore
	public Collection<chauffeur> getChauffeur() {
		return chauffeur;
	}


	public void setChauffeur(Collection<chauffeur> chauffeur) {
		this.chauffeur = chauffeur;
	}
	  
	
	
}
