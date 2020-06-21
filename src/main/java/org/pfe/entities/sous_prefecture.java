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

public class sous_prefecture implements Serializable { 
	
	@Id
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	
	
	private long code_sous_prefecture;
	private String nom_sous_prefecture;
	private String libelle;
	
	@ManyToOne
	@JoinColumn(name="code_pefecture")
	private prefecture prefecture;
	
	@OneToMany(mappedBy="sous_prefecture",fetch=FetchType.LAZY)
	private Collection<canton> canton;
	
	
	
	public sous_prefecture() {
		super();
	}



	public sous_prefecture(long code_sous_prefecture, String nom_sous_prefecture) {
		super();
		this.code_sous_prefecture = code_sous_prefecture;
		this.nom_sous_prefecture = nom_sous_prefecture;
	}



	public long getCode_sous_prefecture() {
		return code_sous_prefecture;
	}



	public void setCode_sous_prefecture(long code_sous_prefecture) {
		this.code_sous_prefecture = code_sous_prefecture;
	}
	
	
	



	public String getNom_sous_prefecture() {
		return nom_sous_prefecture;
	}



	public void setNom_sous_prefecture(String nom_sous_prefecture) {
		this.nom_sous_prefecture = nom_sous_prefecture;
	}



	public String getLibelle() {
		return libelle;
	}



	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}



	public prefecture getPrefecture() {
		return prefecture;
	}



	public void setPrefecture(prefecture prefecture) {
		this.prefecture = prefecture;
	}
	
	
	@JsonIgnore
	public Collection<canton> getcanton() {
		return canton;
	}


	public void setcanton(Collection<canton> canton) {
		this.canton = canton;
	}
	
	

}
