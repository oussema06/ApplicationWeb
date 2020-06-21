package org.pfe.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CGI implements Serializable {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long code_CGI;
	
	private String nom_CGI;
	private String libelle;
	
	@ManyToOne
	@JoinColumn(name="code_usine")
	private usine usine;
	
	@OneToMany(mappedBy="CGI",fetch=FetchType.LAZY)
	private List<client> client;
	
	@OneToMany(mappedBy="CGI",fetch=FetchType.LAZY)
	private Collection<agent_CGI> agent_CGI;

	public CGI() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CGI(long code_CGI, String nom_CGI, String libelle) {
		super();
		this.code_CGI = code_CGI;
		this.nom_CGI = nom_CGI;
		this.libelle = libelle;
	}

	public long getCode_CGI() {
		return code_CGI;
	}

	public void setCode_CGI(long code_CGI) {
		this.code_CGI = code_CGI;
	}

	public String getNom_CGI() {
		return nom_CGI;
	}

	public void setNom_CGI(String nom_CGI) {
		this.nom_CGI = nom_CGI;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public usine getUsine() {
		return usine;
	}

	public void setUsine(usine usine) {
		this.usine = usine;
	}

	

	/**
	 * @return the client
	 */
	@JsonIgnore
	public List<client> getClient() {
		return client;
	}

	/**
	 * @param client the client to set
	 */
	public void setClient(List<client> client) {
		this.client = client;
	}

	@JsonIgnore
	public Collection<agent_CGI> getAgent_CGI() {
		return agent_CGI;
	}

	public void setAgent_CGI(Collection<agent_CGI> agent_CGI) {
		this.agent_CGI = agent_CGI;
	}
	
	
	
	

}
