package org.pfe.metier;

import java.util.Date;
import java.util.List;

import org.pfe.dao.prix_cotonRepository;
import org.pfe.entities.prix_coton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public  class prix_cotonMetierImplementation implements  prix_cotonMetier {
	
	@Autowired
    private prix_cotonRepository prix_cotonRepository;

	

	@Override
	public List<prix_coton> getPrix_coton() {
	
		return prix_cotonRepository.findAll();
	}



	@Override
	@Transactional
	public boolean changerPrix(double choix1, double choix2, double choix3, long code) {
		prix_coton p = prix_cotonRepository.findOne(code);
		p.setChoix1(choix1);
		p.setChoix2(choix2);
		p.setChoix3(choix3);
		p.setDate(new Date());
		return true;
	}



	
	
	
	
	
}
