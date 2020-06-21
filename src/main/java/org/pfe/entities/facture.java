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
public class facture implements Serializable {
	
	
    @Id
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    
	private long num_facture;
    
	private Date date;
	
	private int etat;
	
	private double net;
	
	private double total;
	
	private double totalBord;
	
	private double totalTicket;
	
	private double totalFac;
	
	@ManyToOne
	@JoinColumn(name="code_client")
	private client client;


	@OneToMany(mappedBy="facture",fetch=FetchType.LAZY)
	private List<bordereau_de_livraison> bordereau_de_livraison;
	
	
	@OneToMany(mappedBy="facture",fetch=FetchType.LAZY)
	private List<ticket_de_pesage> ticket_de_pesage;
	
	
	
	
	public facture() {
		super();
		// TODO Auto-generated constructor stub
	}
	


	public facture(long num_facture, Date date, int etat, double net, double total, double totalBord,
			double totalTicket, double totalFac) {
		super();
		this.num_facture = num_facture;
		this.date = date;
		this.etat = etat;
		this.net = net;
		this.total = total;
		this.totalBord = totalBord;
		this.totalTicket = totalTicket;
		this.totalFac = totalFac;
	}



	/**
	 * @return the num
	 */
	public long getNum() {
		return num_facture;
	}




	/**
	 * @param num the num to set
	 */
	public void setNum(long num_facture) {
		this.num_facture = num_facture;
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
	 * @return the bordereau_de_livraison
	 */
	@JsonIgnore
	public List<bordereau_de_livraison> getBordereau_de_livraison() {
		return bordereau_de_livraison;
	}




	/**
	 * @param bordereau_de_livraison the bordereau_de_livraison to set
	 */
	public void setBordereau_de_livraison(List<bordereau_de_livraison> bordereau_de_livraison) {
		this.bordereau_de_livraison = bordereau_de_livraison;
	}




	/**
	 * @return the ticket_de_pesage
	 */
	@JsonIgnore
	public List<ticket_de_pesage> getTicket_de_pesage() {
		return ticket_de_pesage;
	}




	/**
	 * @param ticket_de_pesage the ticket_de_pesage to set
	 */
	public void setTicket_de_pesage(List<ticket_de_pesage> ticket_de_pesage) {
		this.ticket_de_pesage = ticket_de_pesage;
	}



	/**
	 * @return the num_facture
	 */
	public long getNum_facture() {
		return num_facture;
	}



	/**
	 * @param num_facture the num_facture to set
	 */
	public void setNum_facture(long num_facture) {
		this.num_facture = num_facture;
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



	/**
	 * @return the net
	 */
	public double getNet() {
		return net;
	}



	/**
	 * @param net the net to set
	 */
	public void setNet(double net) {
		this.net = net;
	}




	/**
	 * @return the total
	 */
	public double getTotal() {
		return total;
	}




	/**
	 * @param total the total to set
	 */
	public void setTotal(double total) {
		this.total = total;
	}



	/**
	 * @return the totalBord
	 */
	public double getTotalBord() {
		return totalBord;
	}



	/**
	 * @param totalBord the totalBord to set
	 */
	public void setTotalBord(double totalBord) {
		this.totalBord = totalBord;
	}



	/**
	 * @return the totalTicket
	 */
	public double getTotalTicket() {
		return totalTicket;
	}



	/**
	 * @param totalTicket the totalTicket to set
	 */
	public void setTotalTicket(double totalTicket) {
		this.totalTicket = totalTicket;
	}



	/**
	 * @return the totalFac
	 */
	public double getTotalFac() {
		return totalFac;
	}



	/**
	 * @param totalFac the totalFac to set
	 */
	public void setTotalFac(double totalFac) {
		this.totalFac = totalFac;
	}
	
	
	
	
	
	
	
	
	
	
	

	
	

	
	
	
	
	
	

}
