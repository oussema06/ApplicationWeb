package org.pfe.entities;

import java.io.Serializable;
import java.util.Collection;

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
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_UTLI" , discriminatorType=DiscriminatorType.STRING)

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME,include=JsonTypeInfo.As.PROPERTY,property="type")
@JsonSubTypes ({
	
	@Type(name="admin", value=admin.class),
	@Type(name="agent_CGI", value=agent_CGI.class),

	@Type(name="GPB", value=GPB.class),
	@Type(name="superviseur_financier", value=superviseur_financier.class),
		
})
public abstract class utilisateur implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Long code_utilisateur;
	
	private String nom;
	private String prenom;

	private String email;
	private Integer tel;
	
	
	public utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}


	public utilisateur(String nom, String prenom, String email, Integer tel) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		
		this.email = email;
		this.tel = tel;
	}


	public Long getCode_utilisateur() {
		return code_utilisateur;
	}


	public void setCode_utilisateur(Long code_utilisateur) {
		this.code_utilisateur = code_utilisateur;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Integer getTel() {
		return tel;
	}


	public void setTel(Integer tel) {
		this.tel = tel;
	}


	
	
	
	
	

	
	
	
}
