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
public class article implements Serializable {
	
	
    @Id
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    
	private long code_article;
    
	private String nom;
	private String discription_technique;
	private double prix_unitaire;
	
	
	private double TVA;
	private double quantite_disponible;
	
	private String unite_de_vente;
	


	@OneToMany(mappedBy="article",fetch=FetchType.LAZY)
	private Collection<liqne_bordereau> liqne_bordereau;
	
	public article() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	


	public article(long code_article, String nom, String discription_technique, double prix_unitaire, double tVA,
			double quantite_disponible, String unite_de_vente) {
		super();
		this.code_article = code_article;
		this.nom = nom;
		this.discription_technique = discription_technique;
		this.prix_unitaire = prix_unitaire;
		TVA = tVA;
		this.quantite_disponible = quantite_disponible;
		this.unite_de_vente = unite_de_vente;
	}





	public long getCode_article() {
		return code_article;
	}

	public void setCode_article(long code_article) {
		this.code_article = code_article;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDiscription_technique() {
		return discription_technique;
	}

	public void setDiscription_technique(String discription_technique) {
		this.discription_technique = discription_technique;
	}

	public double getPrix_unitaire() {
		return prix_unitaire;
	}

	public void setPrix_unitaire(double prix_unitaire) {
		this.prix_unitaire = prix_unitaire;
	}

	

	public double getTVA() {
		return TVA;
	}

	public void setTVA(double tVA) {
		TVA = tVA;
	}

	public String getUnite_de_vente() {
		return unite_de_vente;
	}

	public void setUnite_de_vente(String unite_de_vente) {
		this.unite_de_vente = unite_de_vente;
	}


	/**
	 * @return the quantité_disponible
	 */
	public double getQuantite_disponible() {
		return quantite_disponible;
	}


	/**
	 * @param quantité_disponible the quantité_disponible to set
	 */
	public void setQuantite_disponible(double quantité_disponible) {
		this.quantite_disponible = quantité_disponible;
	}


	/**
	 * @return the liqne_bordereau
	 */
	@JsonIgnore
	public Collection<liqne_bordereau> getLiqne_bordereau() {
		return liqne_bordereau;
	}


	/**
	 * @param liqne_bordereau the liqne_bordereau to set
	 */
	public void setLiqne_bordereau(Collection<liqne_bordereau> liqne_bordereau) {
		this.liqne_bordereau = liqne_bordereau;
	}


	
	
	
	
	
	

}
