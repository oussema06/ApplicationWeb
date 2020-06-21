package org.pfe.entities;

import java.io.Serializable;
import java.util.Collection;

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

public class canton implements Serializable {
	
	@Id
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	
	
	
	private long code_canton;
	private String nom_canton;
	private String libelle;
	
	@ManyToOne
	@JoinColumn(name="code_sous_prefecture")
	private sous_prefecture sous_prefecture;
	
	@OneToMany(mappedBy="canton",fetch=FetchType.LAZY)
	private Collection<client> client;
	
	
	public canton() {
		super();
	}


	public canton(long code_canton, String nom_canton, String libelle) {
		super();
		this.code_canton = code_canton;
		this.libelle = libelle;
		this.nom_canton = nom_canton;
	}


	public long getCode_canton() {
		return code_canton;
	}


	public void setCode_canton(long code_canton) {
		this.code_canton = code_canton;
	}


	public String getLibelle() {
		return libelle;
	}


	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}




	public sous_prefecture getSous_prefecture() {
		return sous_prefecture;
	}


	public void setSous_prefecture(sous_prefecture sous_prefecture) {
		this.sous_prefecture = sous_prefecture;
	}
	
	
	
	@JsonIgnore
	public Collection<client> getclient() {
		return client;
	}


	public void setclient(Collection<client> client) {
		this.client = client;
	}


	/**
	 * @return the nom_canton
	 */
	public String getNom_canton() {
		return nom_canton;
	}


	/**
	 * @param nom_canton the nom_canton to set
	 */
	public void setNom_canton(String nom_canton) {
		this.nom_canton = nom_canton;
	}
	
	
	
	

	
}
