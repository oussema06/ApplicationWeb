package org.pfe.entities;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;




@Entity
@DiscriminatorValue("admin")
public class admin extends utilisateur {

	

		private String mdp;
	
		
	
	public admin() {
			super();
			// TODO Auto-generated constructor stub
		}
	

	public admin(String nom, String prenom, String role, String email, Integer tel, String login, String mdp) {
		super(nom, prenom, email, tel);

		this.mdp = mdp;
	}




	public String getMdp() {
		return mdp;
	}


	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	
	
	

}