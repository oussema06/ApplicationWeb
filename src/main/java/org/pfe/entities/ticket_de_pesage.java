package org.pfe.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ticket_de_pesage implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long code_tichet;
	
	@ManyToOne
	@JoinColumn(name="matricule")
	private vehicule vehicule;
	
	@ManyToOne
	@JoinColumn(name="code_chauffeur")
	private chauffeur chauffeur;
	
	@ManyToOne
	@JoinColumn(name="code_client")
	private client client;
	
	@OneToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY , mappedBy="ticket_de_pesage")
    private bordereau_de_transport bordereau_de_transport;
	

	
	@ManyToOne
	@JoinColumn(name="num_facture")
	private facture facture;
	
	
	private int choix_coton;
	private double poids;
	private Date date;
	private String libelle;
	private double distance_parcourue;
	private int etat;
	
	public ticket_de_pesage() {
		super();
		// TODO Auto-generated constructor stub
	}



	





	public ticket_de_pesage(long code_tichet, int choix_coton, double poids, Date date, String libelle,
			double distance_parcourue, int etat) {
		super();
		this.code_tichet = code_tichet;
		this.choix_coton = choix_coton;
		this.poids = poids;
		this.date = date;
		this.libelle = libelle;
		this.distance_parcourue = distance_parcourue;
		this.etat = etat;
	}









	public long getCode_tichet() {
		return code_tichet;
	}



	public void setCode_tichet(long code_tichet) {
		this.code_tichet = code_tichet;
	}



	public vehicule getVehicule() {
		return vehicule;
	}



	public void setVehicule(vehicule vehicule) {
		this.vehicule = vehicule;
	}



	public chauffeur getChauffeur() {
		return chauffeur;
	}



	public void setChauffeur(chauffeur chauffeur) {
		this.chauffeur = chauffeur;
	}



	public int getChoix_coton() {
		return choix_coton;
	}



	public void setChoix_coton(int choix_coton) {
		this.choix_coton = choix_coton;
	}




	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public String getLibelle() {
		return libelle;
	}



	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}



	public bordereau_de_transport getBordereau_de_transport() {
		return bordereau_de_transport;
	}



	public void setBordereau_de_transport(bordereau_de_transport bordereau_de_transport ) {
		this.bordereau_de_transport = bordereau_de_transport;
	}




	/**
	 * @return the poids
	 */
	public double getPoids() {
		return poids;
	}



	/**
	 * @param poids the poids to set
	 */
	public void setPoids(double poids) {
		this.poids = poids;
	}



	/**
	 * @return the distance_parcourue
	 */
	public double getDistance_parcourue() {
		return distance_parcourue;
	}



	/**
	 * @param distance_parcourue the distance_parcourue to set
	 */
	public void setDistance_parcourue(double distance_parcourue) {
		this.distance_parcourue = distance_parcourue;
	}



	/**
	 * @return the client
	 */
	public client getClient() {
		return client;
	}



	/**
	 * @param client the client to set
	 */
	public void setClient(client client) {
		this.client = client;
	}



	/**
	 * @return the facture
	 */
	@JsonIgnore
	public facture getFacture() {
		return facture;
	}



	/**
	 * @param facture the facture to set
	 */
	public void setFacture(facture facture) {
		this.facture = facture;
	}



	/**
	 * @return the etat
	 */
	public int getEtat() {
		return etat;
	}



	/**
	 * @param etat the etat to set
	 */
	public void setEtat(int etat) {
		this.etat = etat;
	}
	
	
	
	
	
	



	
	
	
	
	

}
