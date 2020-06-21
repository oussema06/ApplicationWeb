package org.pfe.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class liqne_bordereau implements Serializable {
	
	
	@Id
	
    @GeneratedValue(strategy=GenerationType.IDENTITY) 
	private long num ;
	private int qauntite;
	
	@ManyToOne
	@JoinColumn(name="num_bordereau")
	private bordereau_de_livraison bordereau_de_livraison;
	
	@ManyToOne
	@JoinColumn(name="code_article")
	private article article;

	public liqne_bordereau() {
		super();
		// TODO Auto-generated constructor stub
	}

	public liqne_bordereau(long num, int qauntite) {
		super();
		this.num = num;
		this.qauntite = qauntite;
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
	 * @return the qauntite
	 */
	public int getQauntite() {
		return qauntite;
	}

	/**
	 * @param qauntite the qauntite to set
	 */
	public void setQauntite(int qauntite) {
		this.qauntite = qauntite;
	}

	/**
	 * @return the bordereau_de_livraison
	 */
	public bordereau_de_livraison getBordereau_de_livraison() {
		return bordereau_de_livraison;
	}

	/**
	 * @param bordereau_de_livraison the bordereau_de_livraison to set
	 */
	public void setBordereau_de_livraison(bordereau_de_livraison bordereau_de_livraison) {
		this.bordereau_de_livraison = bordereau_de_livraison;
	}

	/**
	 * @return the article
	 */
	public article getArticle() {
		return article;
	}

	/**
	 * @param article the article to set
	 */
	public void setArticle(article article) {
		this.article = article;
	}
	
	

}
