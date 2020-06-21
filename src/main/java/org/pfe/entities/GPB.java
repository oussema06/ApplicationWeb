package org.pfe.entities;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@DiscriminatorValue("GPB")
public class GPB extends utilisateur {

	

		private String mdp;
		
		@ManyToOne
		@JoinColumn(name="code_usine")
		private usine usine;
	
		
	
	public GPB() {
			super();
			// TODO Auto-generated constructor stub
		}
	

	public GPB(String nom, String prenom, String role, String email, Integer tel, String login, String mdp) {
		super(nom, prenom, email, tel);

		this.mdp = mdp;
	}


	


	public String getMdp() {
		return mdp;
	}


	public void setMdp(String mdp) {
		this.mdp = mdp;
	}


	public usine getUsine() {
		return usine;
	}


	public void setUsine(usine usine) {
		this.usine = usine;
	}
	
	


}