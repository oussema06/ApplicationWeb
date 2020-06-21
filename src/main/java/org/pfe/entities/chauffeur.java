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
public class chauffeur implements Serializable {
	
	
    @Id
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    
	private long code_chauffeur;
	private String nom_chauffeur;
	private String prenom_chauffeur;
	private int tel;
	private String libelle;
	
	
	@ManyToOne
	@JoinColumn(name="code_transporteur")
	private transporteur transporteur;
	
	@OneToMany(mappedBy="vehicule",fetch=FetchType.LAZY)
	private Collection<ticket_de_pesage> ticket_de_pesage;


	public chauffeur() {
		super();
		// TODO Auto-generated constructor stub
	}


	public chauffeur(long code_chauffeur, String nom_chauffeur, String prenom_chauffeur, int tel) {
		super();
		this.code_chauffeur = code_chauffeur;
		this.nom_chauffeur = nom_chauffeur;
		this.prenom_chauffeur = prenom_chauffeur;
		this.tel = tel;
	}


	public long getCode_chauffeur() {
		return code_chauffeur;
	}


	public void setCode_chauffeur(long code_chauffeur) {
		this.code_chauffeur = code_chauffeur;
	}


	public String getNom_chauffeur() {
		return nom_chauffeur;
	}


	public void setNom_chauffeur(String nom_chauffeur) {
		this.nom_chauffeur = nom_chauffeur;
	}


	public String getPrenom_chauffeur() {
		return prenom_chauffeur;
	}


	public void setPrenom_chauffeur(String prenom_chauffeur) {
		this.prenom_chauffeur = prenom_chauffeur;
	}


	public int getTel() {
		return tel;
	}


	public void setTel(int tel) {
		this.tel = tel;
	}


	public String getLibelle() {
		return libelle;
	}


	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	public transporteur getTransporteur() {
		return transporteur;
	}


	public void setTransporteur(transporteur transporteur) {
		this.transporteur = transporteur;
	}


	@JsonIgnore
	public Collection<ticket_de_pesage> getTicket_de_pesage() {
		return ticket_de_pesage;
	}


	public void setTicket_de_pesage(Collection<ticket_de_pesage> ticket_de_pesage) {
		this.ticket_de_pesage = ticket_de_pesage;
	}


	

	
	
}
