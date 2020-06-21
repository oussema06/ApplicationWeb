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
@DiscriminatorValue("agent_CGI")
public class agent_CGI extends utilisateur {

	

		private String mdp;
	
		@ManyToOne
		@JoinColumn(name="code_CGI")
		private CGI CGI;
	
	public agent_CGI() {
			super();
			// TODO Auto-generated constructor stub
		}
	

	public agent_CGI(String nom, String prenom, String role, String email, Integer tel, String login, String mdp) {
		super(nom, prenom, email, tel);

		this.mdp = mdp;
	}


	

	public String getMdp() {
		return mdp;
	}


	public void setMdp(String mdp) {
		this.mdp = mdp;
	}


	/**
	 * @return the cGI
	 */
	public CGI getCGI() {
		return CGI;
	}


	/**
	 * @param cGI the cGI to set
	 */
	public void setCGI(CGI cGI) {
		CGI = cGI;
	}


	
	
	


}