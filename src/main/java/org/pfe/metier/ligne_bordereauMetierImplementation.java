package org.pfe.metier;

import java.util.List;

import org.pfe.dao.articleRepository;
import org.pfe.dao.ligne_bordereauRepository;
import org.pfe.entities.article;
import org.pfe.entities.liqne_bordereau;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public  class ligne_bordereauMetierImplementation implements  ligne_bordereauMetier {
	
	@Autowired
    private ligne_bordereauRepository ligne_bordereauRepository;
	
	@Autowired
    private articleRepository articleRepository;
	
	
	@Override
	@Transactional
	public liqne_bordereau ajoutliqne_bordereau(liqne_bordereau l) {
		// TODO Auto-generated method stub
		article A = articleRepository.findOne(l.getArticle().getCode_article());
	    double Q = A.getQuantite_disponible();
	    Q = Q - l.getQauntite();
	    A.setQuantite_disponible(Q);
		return ligne_bordereauRepository.save(l);
	}

	@Override
	public List<liqne_bordereau> listliqne_bordereau() {
		// TODO Auto-generated method stub
		return ligne_bordereauRepository.findAll();
	}

	@Override
	@Transactional
	public liqne_bordereau changerLigne(long codeLigne, int quantite) {
		liqne_bordereau L = ligne_bordereauRepository.findOne(codeLigne);
		L.setQauntite(quantite);
		return L;
	}
	
}
