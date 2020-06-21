package org.pfe.metier;

import java.util.List;

import org.pfe.entities.article;




public interface articleMetier {
	
	public article ajoutarticle(article a);
	public List<article> listarticle();
	public boolean changerArticle(long code, double tva, String dis, String nom, double prix, double quantite, String unite);

}
