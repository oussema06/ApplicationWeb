package org.pfe.metier;

import java.util.Collection;
import java.util.List;

import org.pfe.dao.paysRepository;
import org.pfe.entities.pays;
import org.pfe.entities.prefecture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public  class paysMetierImplementation implements  paysMetier {
	
	@Autowired
    private paysRepository paysRepository;
    
	@Override
	public pays ajoutpays(pays p) {
		// TODO Auto-generated method stub
		return paysRepository.save(p);
	}

	@Override
	public List<pays> listpays() {
		// TODO Auto-generated method stub
		return paysRepository.findAll();
	}
	
	@Override
	public pays chargerPays(long code) {
		return paysRepository.findOne(code);
	}

	@Override
	@Transactional
	public Collection<prefecture> Listprefecture(long code) {
		pays P = paysRepository.findOne(code);
		return P.getPrefecture();
	}

}
