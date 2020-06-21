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
public class vehicule implements Serializable {
	
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    
	private long matricule;
    
	private long identite_interne;
	private Double poids;
	private String libelle;
	
	
	@ManyToOne
	@JoinColumn(name="code_type_vehicule")
	private type_vehicule type_vehicule;
	
	@OneToMany(mappedBy="vehicule",fetch=FetchType.LAZY)
	private Collection<ticket_de_pesage> ticket_de_pesage;


	public vehicule() {
		super();
		// TODO Auto-generated constructor stub
	}


	public vehicule(long matricule, long identite_interne, Double poids, String libelle) {
		super();
		this.matricule = matricule;
		this.identite_interne = identite_interne;
		this.poids = poids;
		this.libelle = libelle;
	}


	public long getMatricule() {
		return matricule;
	}


	public void setMatricule(long matricule) {
		this.matricule = matricule;
	}


	public long getIdentite_interne() {
		return identite_interne;
	}


	public void setIdentite_interne(long identite_interne) {
		this.identite_interne = identite_interne;
	}


	public Double getPoids() {
		return poids;
	}


	public void setPoids(Double poids) {
		this.poids = poids;
	}


	public String getLibelle() {
		return libelle;
	}


	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}




	public type_vehicule getType_vehicule() {
		return type_vehicule;
	}


	public void setType_vehicule(type_vehicule type_vehicule) {
		this.type_vehicule = type_vehicule;
	}


	@JsonIgnore
	public Collection<ticket_de_pesage> getTicket_de_pesage() {
		return ticket_de_pesage;
	}


	public void setTicket_de_pesage(Collection<ticket_de_pesage> ticket_de_pesage) {
		this.ticket_de_pesage = ticket_de_pesage;
	}

	
	
	
}
