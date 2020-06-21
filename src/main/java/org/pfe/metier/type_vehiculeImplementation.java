package org.pfe.metier;

import java.util.List;

import org.pfe.dao.type_vehiculeRepository;
import org.pfe.entities.type_vehicule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public  class type_vehiculeImplementation implements  type_vehiculeMetier {
	
	@Autowired
    private type_vehiculeRepository type_vehiculeRepository;
    
	@Override
	public type_vehicule ajouttype_vehicule(type_vehicule tv) {
		// TODO Auto-generated method stub
		return type_vehiculeRepository.save(tv);
	}

	@Override
	public List<type_vehicule> listtype_vehicule() {
		// TODO Auto-generated method stub
		return type_vehiculeRepository.findAll();
	}

	@Override
	public type_vehicule chargerType_vehicule(long code) {
		return type_vehiculeRepository.findOne(code);
	}

}
