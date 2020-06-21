package org.pfe.metier;

import java.util.List;

import org.pfe.dao.vehiculeRepository;
import org.pfe.entities.vehicule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public  class vehiculeMetierImplementation implements  vehiculeMetier {
	
	@Autowired
    private vehiculeRepository vehiculeRepository;
    
	@Override
	public vehicule ajoutvehicule(vehicule v) {
		// TODO Auto-generated method stub
		return vehiculeRepository.save(v);
	}

	@Override
	public List<vehicule> listvehicule() {
		// TODO Auto-generated method stub
		return vehiculeRepository.findAll();
	}
	
	@Override
	public vehicule chargerVehicule(long code) {
		return vehiculeRepository.findOne(code);
	}

}
