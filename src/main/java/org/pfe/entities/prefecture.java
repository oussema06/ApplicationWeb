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
public class prefecture implements Serializable {
	
	
	@Id
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	
	private long code_pefecture;
	private String nom_prefecture;
	private String libelle;
	
	@ManyToOne
	@JoinColumn(name="code_pays")
	private pays pays;
	
	@OneToMany(mappedBy="prefecture",fetch=FetchType.LAZY)
	private Collection<sous_prefecture> sous_prefecture;
	
	
	
	public prefecture() {
		super();
		// TODO Auto-generated constructor stub
	}



	public prefecture(long code_pefecture, String nom_prefecture) {
		super();
		this.code_pefecture = code_pefecture;
		this.nom_prefecture = nom_prefecture;
	}



	public long getCode_pefecture() {
		return code_pefecture;
	}



	public void setCode_pefecture(long code_pefecture) {
		this.code_pefecture = code_pefecture;
	}


	
	

	public String getNom_prefecture() {
		return nom_prefecture;
	}



	public void setNom_prefecture(String nom_prefecture) {
		this.nom_prefecture = nom_prefecture;
	}



	public String getLibelle() {
		return libelle;
	}



	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	public pays getPays() {
		return pays;
	}



	public void setPays(pays pays) {
		this.pays = pays;
	}
	
	
	@JsonIgnore
	public Collection<sous_prefecture> getsous_Prefecture() {
		return sous_prefecture;
	}


	public void setPrefecture(Collection<sous_prefecture> sous_prefecture) {
		this.sous_prefecture = sous_prefecture;
	}
	

}
