package org.pfe.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;




@Entity
@DiscriminatorValue("superviseur_financier")
public class superviseur_financier extends utilisateur {


		private String mdp;
		
		@ManyToOne
		@JoinColumn(name="code_usine")
		private usine usine;
	
		
	
	public superviseur_financier() {
			super();
			// TODO Auto-generated constructor stub
		}
	

	public superviseur_financier(String nom, String prenom, String role, String email, Integer tel, String login,
			String mdp) {
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
