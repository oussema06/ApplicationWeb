package org.pfe.metier;

import java.util.List;

import org.pfe.dao.chauffeurRepository;
import org.pfe.entities.chauffeur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public  class chauffeurMetierImplementation implements  chauffeurMetier {
	
	@Autowired
    private chauffeurRepository chauffeurRepository;
    
	@Override
	public chauffeur ajoutchauffeur(chauffeur chauf) {
		// TODO Auto-generated method stub
		return chauffeurRepository.save(chauf);
	}

	@Override
	public List<chauffeur> listchauffeur() {
		// TODO Auto-generated method stub
		return chauffeurRepository.findAll();
	}

	@Override
	public chauffeur chargerChauffeur(long code) {
		return chauffeurRepository.findOne(code);
	}
}
