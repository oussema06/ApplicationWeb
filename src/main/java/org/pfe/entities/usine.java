package org.pfe.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class usine implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long code_usine;
	private String nom_usine;
	private String libelle;
	
	@OneToMany(mappedBy="usine",fetch=FetchType.LAZY)
	private List<CGI> CGI;
	
	@OneToMany(mappedBy="usine",fetch=FetchType.LAZY)
	private List<GPB> GPB;
	
	@OneToMany(mappedBy="usine",fetch=FetchType.LAZY)
	private List<superviseur_financier> superviseur_financier;
	
	

	public usine() {
		super();
		// TODO Auto-generated constructor stub
	}

	public usine(long code_usine, String nom_usine, String libelle) {
		super();
		this.code_usine = code_usine;
		this.nom_usine = nom_usine;
		this.libelle = libelle;
	}

	public long getCode_usine() {
		return code_usine;
	}

	public void setCode_usine(long code_usine) {
		this.code_usine = code_usine;
	}

	public String getNom_usine() {
		return nom_usine;
	}

	public void setNom_usine(String nom_usine) {
		this.nom_usine = nom_usine;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * @return the cGI
	 */
	@JsonIgnore
	public List<CGI> getCGI() {
		return CGI;
	}

	/**
	 * @param cGI the cGI to set
	 */
	public void setCGI(List<CGI> cGI) {
		CGI = cGI;
	}

	/**
	 * @return the gPB
	 */
	@JsonIgnore
	public List<GPB> getGPB() {
		return GPB;
	}

	/**
	 * @param gPB the gPB to set
	 */
	public void setGPB(List<GPB> gPB) {
		GPB = gPB;
	}

	/**
	 * @return the superviseur_financier
	 */
	@JsonIgnore
	public List<superviseur_financier> getSuperviseur_financier() {
		return superviseur_financier;
	}

	/**
	 * @param superviseur_financier the superviseur_financier to set
	 */
	public void setSuperviseur_financier(List<superviseur_financier> superviseur_financier) {
		this.superviseur_financier = superviseur_financier;
	}

	
	
	
	

}
