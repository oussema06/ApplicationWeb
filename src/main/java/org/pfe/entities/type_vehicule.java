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
public class type_vehicule implements Serializable {
	
	
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long code_type_vehicule;
	private String nom_type_vehicule;
	private String libelle;
	
	@OneToMany(mappedBy="type_vehicule",fetch=FetchType.LAZY)
	private Collection<vehicule> vehicule;

	public type_vehicule() {
		super();
		// TODO Auto-generated constructor stub
	}

	public type_vehicule(long code_type_vehicule, String nom_type_vehicule, String libelle) {
		super();
		this.code_type_vehicule = code_type_vehicule;
		this.nom_type_vehicule = nom_type_vehicule;
		this.libelle = libelle;
	}

	public long getCode_type_vehicule() {
		return code_type_vehicule;
	}

	public void setCode_type_vehicule(long code_type_vehicule) {
		this.code_type_vehicule = code_type_vehicule;
	}

	public String getNom_type_vehicule() {
		return nom_type_vehicule;
	}

	public void setNom_type_vehicule(String nom_type_vehicule) {
		this.nom_type_vehicule = nom_type_vehicule;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@JsonIgnore
	public Collection<vehicule> getVehicule() {
		return vehicule;
	}

	public void setVehicule(Collection<vehicule> vehicule) {
		this.vehicule = vehicule;
	}
	
	
	

}
