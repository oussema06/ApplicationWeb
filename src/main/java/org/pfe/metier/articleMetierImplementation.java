package org.pfe.metier;

import java.util.List;

import org.pfe.dao.articleRepository;
import org.pfe.entities.article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public  class articleMetierImplementation implements  articleMetier {
	
	@Autowired
    private articleRepository articleRepository;
	
	
	@Override
	public article ajoutarticle(article a) {
		// TODO Auto-generated method stub
		return articleRepository.save(a);
	}

	@Override
	public List<article> listarticle() {
		// TODO Auto-generated method stub
		return articleRepository.findAll();
	}

	@Override
	@Transactional
	public boolean changerArticle(long code, double tva, String dis, String nom, double prix, double quantite, String unite) {
		article a = articleRepository.findOne(code);
		
		a.setDiscription_technique(dis);
		a.setTVA(tva);
		a.setNom(nom);
		a.setPrix_unitaire(prix);
		a.setQuantite_disponible(quantite);
		a.setUnite_de_vente(unite);
		
		return true;
	}
	
}
