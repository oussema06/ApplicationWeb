package org.pfe.entities;

import java.io.Serializable;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class pays implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long code_pays;
	private String nom_pays;
	private String type_pays;
	private String libelle;
	
	@OneToMany(mappedBy="pays",fetch=FetchType.LAZY)
	private Collection<prefecture> prefecture;
	
	
	public pays() {
		super();
	}


	public pays(long code_pays, String nom_pays, String type_pays) {
	
		this.code_pays = code_pays;
		this.nom_pays = nom_pays;
		this.type_pays = type_pays;

	}


	public long getCode_pays() {
		return code_pays;
	}


	public void setCode_pays(long code_pays) {
		this.code_pays = code_pays;
	}


	public String getNom_pays() {
		return nom_pays;
	}


	public void setNom_pays(String nom_pays) {
		this.nom_pays = nom_pays;
	}


	public String getType_pays() {
		return type_pays;
	}


	public void setType_pays(String type_pays) {
		this.type_pays = type_pays;
	}


	public String getLibelle() {
		return libelle;
	}


	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	
	@JsonIgnore
	public Collection<prefecture> getPrefecture() {
		return prefecture;
	}


	public void setPrefecture(Collection<prefecture> prefecture) {
		this.prefecture = prefecture;
	}
	

}
