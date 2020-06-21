package org.pfe.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class prix_coton implements Serializable {
	
    @Id
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private long prix;

	private double choix1;
	private double choix2;
	private double choix3;
	private Date date;
	
	
	public prix_coton() {
		super();
		// TODO Auto-generated constructor stub
	}




	public prix_coton(long prix, double choix1, double choix2, double choix3, Date date) {
		super();
		this.prix = prix;
		this.choix1 = choix1;
		this.choix2 = choix2;
		this.choix3 = choix3;
		this.date = date;
	}




	/**
	 * @return the choix1
	 */
	public double getChoix1() {
		return choix1;
	}


	/**
	 * @param choix1 the choix1 to set
	 */
	public void setChoix1(double choix1) {
		this.choix1 = choix1;
	}


	/**
	 * @return the choix2
	 */
	public double getChoix2() {
		return choix2;
	}


	/**
	 * @param choix2 the choix2 to set
	 */
	public void setChoix2(double choix2) {
		this.choix2 = choix2;
	}


	/**
	 * @return the choix3
	 */
	public double getChoix3() {
		return choix3;
	}


	/**
	 * @param choix3 the choix3 to set
	 */
	public void setChoix3(double choix3) {
		this.choix3 = choix3;
	}




	/**
	 * @return the prix
	 */
	public long getPrix() {
		return prix;
	}




	/**
	 * @param prix the prix to set
	 */
	public void setPrix(long prix) {
		this.prix = prix;
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
	
	
	

}
