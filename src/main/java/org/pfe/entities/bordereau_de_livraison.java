package org.pfe.entities;

import java.io.Serializable;
import java.util.Date;
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
public class bordereau_de_livraison implements Serializable {
	
	@Id
		
    @GeneratedValue(strategy=GenerationType.IDENTITY) 
	private long num ;
	private Date date;
	private int etat;
	
	@ManyToOne
	@JoinColumn(name="code_client")
	private client client;
	
	@ManyToOne
	@JoinColumn(name="num_facture")
	private facture facture;
	
	@OneToMany(mappedBy="bordereau_de_livraison",fetch=FetchType.LAZY)
	private List<liqne_bordereau> liqne_bordereau;

	public bordereau_de_livraison() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public bordereau_de_livraison(long num, Date date, int etat) {
		super();
		this.num = num;
		this.date = date;
		this.etat = etat;
	}



	/**
	 * @return the num
	 */
	public long getNum() {
		return num;
	}

	/**
	 * @param num the num to set
	 */
	public void setNum(long num) {
		this.num = num;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
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
	 * @return the liqne_bordereau
	 */
	@JsonIgnore
	public List<liqne_bordereau> getLiqne_bordereau() {
		return liqne_bordereau;
	}

	/**
	 * @param liqne_bordereau the liqne_bordereau to set
	 */
	public void setLiqne_bordereau(List<liqne_bordereau> liqne_bordereau) {
		this.liqne_bordereau = liqne_bordereau;
	}

	/**
	 * @return the facture
	 */
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