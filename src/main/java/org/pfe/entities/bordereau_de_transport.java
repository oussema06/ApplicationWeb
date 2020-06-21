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
import javax.persistence.OneToOne;

@Entity
public class bordereau_de_transport implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long num;
	private Date date;
	private String devise;
	
	@OneToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name = "code_ticket_de_pesage")
	private ticket_de_pesage ticket_de_pesage;

	public bordereau_de_transport() {
		super();
		// TODO Auto-generated constructor stub
	}

	public bordereau_de_transport(long num, Date date, String devise) {
		super();
		this.num = num;
		this.date = date;
		this.devise = devise;
	}

	public long getNum() {
		return num;
	}

	public void setNum(long num) {
		this.num = num;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDevise() {
		return devise;
	}

	public void setDevise(String devise) {
		this.devise = devise;
	}

	public ticket_de_pesage getTicket_de_pesage() {
		return ticket_de_pesage;
	}

	public void setTicket_de_pesage(ticket_de_pesage ticket_de_pesage) {
		this.ticket_de_pesage = ticket_de_pesage;
	} 
	
	

}
