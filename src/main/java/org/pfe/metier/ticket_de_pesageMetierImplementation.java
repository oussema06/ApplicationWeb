package org.pfe.metier;


import java.util.Date;
import java.util.List;

import org.pfe.dao.chauffeurRepository;
import org.pfe.dao.clientRepository;
import org.pfe.dao.ticket_de_pesageRepository;
import org.pfe.dao.vehiculeRepository;
import org.pfe.entities.chauffeur;
import org.pfe.entities.client;
import org.pfe.entities.ticket_de_pesage;
import org.pfe.entities.vehicule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public  class ticket_de_pesageMetierImplementation implements  ticket_de_pesageMetier {
	
	@Autowired
    private ticket_de_pesageRepository ticket_de_pesageRepository;
	
	@Autowired
    private chauffeurRepository chauffeurRepository;
	
	@Autowired
    private clientRepository clientRepository;
	
	@Autowired
    private vehiculeRepository vehiculeRepository;
	
	
    
	@Override
	public ticket_de_pesage ajoutticket_de_pesage(ticket_de_pesage t) {
		// TODO Auto-generated method stub
		t.setDate(new Date());
		return ticket_de_pesageRepository.save(t);
	}


	@Override
	@Transactional
	public List<ticket_de_pesage> listticket_de_pesage(long codeclt) {
		// TODO Auto-generated method stub
		
	  List<ticket_de_pesage> L = ticket_de_pesageRepository.findAll();
	  List<ticket_de_pesage> res = null;
	  
	  
	  for(int i = 0; i < L.size(); i++){
		  if(L.get(i).getClient().getCode_client() == codeclt){
			  res.add(L.get(i));
			  
		  }
		  
		  
	  }
	  return res;
	}


	@Override
	public List<ticket_de_pesage> listticket_de_pesage() {
		return ticket_de_pesageRepository.findAll();
	}


	@Override
	@Transactional
	public ticket_de_pesage changerTicket(long codeT, int choix, double distance, String libelle, double poids,
			long codeC, long codeClt, long matricule) {
		
		ticket_de_pesage T = ticket_de_pesageRepository.findOne(codeT);
		
		T.setChoix_coton(choix);
		T.setDistance_parcourue(distance);
		T.setLibelle(libelle);
		T.setPoids(poids);
		
		client C = clientRepository.findOne(codeClt);
		T.setClient(C);
		
		chauffeur Ch = chauffeurRepository.findOne(codeC);
		T.setChauffeur(Ch);
		
		vehicule V = vehiculeRepository.findOne(matricule);
		T.setVehicule(V);
		
		
		return T;
	}
	
	

}
