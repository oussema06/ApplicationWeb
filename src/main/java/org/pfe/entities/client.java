package org.pfe.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;



@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_CLT" , discriminatorType=DiscriminatorType.STRING)

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME,include=JsonTypeInfo.As.PROPERTY,property="type")
@JsonSubTypes ({
	
	@Type(name="AV", value=AV.class),
	@Type(name="client", value=autre_client.class),
	
		
})

public abstract class client implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long code_client;
	
	private String nom_client;
	private String libelle;
	private int tel;
	private int fax;
	private String mail;
	private String adresse_de_facturation;
	private String adresse_de_livraison;
	
	@ManyToOne
	@JoinColumn(name="code_canton")
	private canton canton;
	
	

	@ManyToOne
	@JoinColumn(name="code_CGI")
	private CGI CGI;
	
	@OneToMany(mappedBy="client",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<ticket_de_pesage> ticket_de_pesage;
	
	@OneToMany(mappedBy="client",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private Collection<expression_de_besoin> expression_de_besoin;
	
	@OneToMany(mappedBy="client",fetch=FetchType.LAZY)
	private List<bordereau_de_livraison> bordereau_de_livraison;
	
	@OneToMany(mappedBy="client",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<facture> facture;
	
	public client() {
		super();
		// TODO Auto-generated constructor stub
	}



	public client(String nom_client, int tel, int fax, String mail, String adresse_de_facturation,
			String adresse_de_livraison) {
		super();
		this.nom_client = nom_client;
		this.tel = tel;
		this.fax = fax;
		this.mail = mail;
		this.adresse_de_facturation = adresse_de_facturation;
		this.adresse_de_livraison = adresse_de_livraison;
	}



	public long getCode_client() {
		return code_client;
	}

	public void setCode_client(long code_client) {
		this.code_client = code_client;
	}


	public canton getCanton() {
		return canton;
	}

	public void setCanton(canton canton) {
		this.canton = canton;
	}



	public String getNom_client() {
		return nom_client;
	}



	public void setNom_client(String nom_client) {
		this.nom_client = nom_client;
	}



	



	
	public CGI getCGI() {
		return CGI;
	}



	public void setCGI(CGI cGI) {
		CGI = cGI;
	}



	public String getLibelle() {
		return libelle;
	}



	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}



	/**
	 * @return the tel
	 */
	public int getTel() {
		return tel;
	}



	/**
	 * @param tel the tel to set
	 */
	public void setTel(int tel) {
		this.tel = tel;
	}



	/**
	 * @return the fax
	 */
	public int getFax() {
		return fax;
	}



	/**
	 * @param fax the fax to set
	 */
	public void setFax(int fax) {
		this.fax = fax;
	}



	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}



	/**
	 * @param mail the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}



	/**
	 * @return the adresse_de_facturation
	 */
	public String getAdresse_de_facturation() {
		return adresse_de_facturation;
	}



	/**
	 * @param adresse_de_facturation the adresse_de_facturation to set
	 */
	public void setAdresse_de_facturation(String adresse_de_facturation) {
		this.adresse_de_facturation = adresse_de_facturation;
	}



	/**
	 * @return the adresse_de_livraison
	 */
	public String getAdresse_de_livraison() {
		return adresse_de_livraison;
	}



	/**
	 * @param adresse_de_livraison the adresse_de_livraison to set
	 */
	public void setAdresse_de_livraison(String adresse_de_livraison) {
		this.adresse_de_livraison = adresse_de_livraison;
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
	 * @return the expression_de_besoin
	 */
	@JsonIgnore
	public Collection<expression_de_besoin> getExpression_de_besoin() {
		return expression_de_besoin;
	}



	/**
	 * @param expression_de_besoin the expression_de_besoin to set
	 */
	public void setExpression_de_besoin(Collection<expression_de_besoin> expression_de_besoin) {
		this.expression_de_besoin = expression_de_besoin;
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
	 * @return the facture
	 */
	@JsonIgnore
	public List<facture> getFacture() {
		return facture;
	}



	/**
	 * @param facture the facture to set
	 */
	public void setFacture(List<facture> facture) {
		this.facture = facture;
	}



	


	

		

	
}
