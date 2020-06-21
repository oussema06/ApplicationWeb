package org.pfe.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class expression_de_besoin implements Serializable {
	
    @Id
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private long code;
    private String besoins;
    
    @ManyToOne
	@JoinColumn(name="code_client")
	private client client;

	public expression_de_besoin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public expression_de_besoin(long code, String besoins) {
		super();
		this.code = code;
		this.besoins = besoins;
	}

	/**
	 * @return the code
	 */
	public long getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(long code) {
		this.code = code;
	}

	/**
	 * @return the besoins
	 */
	public String getBesoins() {
		return besoins;
	}

	/**
	 * @param besoins the besoins to set
	 */
	public void setBesoins(String besoins) {
		this.besoins = besoins;
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
    
    
    
    

}
