package org.pfe.metier;

import java.util.Date;
import java.util.List;

import org.pfe.dao.bordereau_de_livraisonRepository;
import org.pfe.entities.bordereau_de_livraison;
import org.pfe.entities.liqne_bordereau;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public  class bordereau_de_livraisonMetierImplementation implements  bordereau_de_livraisonMetier {
	
	@Autowired
    private bordereau_de_livraisonRepository bordereau_de_livraisonRepository;
	
	
	@Override
	public bordereau_de_livraison ajoutbordereau_de_livraison(bordereau_de_livraison a) {
		a.setDate(new Date());
		return bordereau_de_livraisonRepository.save(a);
	}

	@Override
	@Transactional
	public List<bordereau_de_livraison> listbordereau_de_livraison() {
		List<bordereau_de_livraison> B1 = bordereau_de_livraisonRepository.findAll();
		List<bordereau_de_livraison> B = bordereau_de_livraisonRepository.findAll();
		B.clear();
		for(int i = 0; i<B1.size(); i++){
			if(B1.get(i).getEtat() == 0){
				B.add(B1.get(i));
				}
		}
		
		return B;
	}

	@Override
	public List<liqne_bordereau> listLigne_bordereau(long codeB) {
		
		bordereau_de_livraison B = bordereau_de_livraisonRepository.findOne(codeB);
		return B.getLiqne_bordereau();
	}
	
}
