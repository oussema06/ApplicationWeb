package org.pfe.metier;

import java.util.List;

import org.pfe.dao.bordereau_de_livraisonRepository;
import org.pfe.dao.clientRepository;
import org.pfe.dao.ticket_de_pesageRepository;
import org.pfe.dao.usineRepository;
import org.pfe.entities.CGI;
import org.pfe.entities.bordereau_de_livraison;
import org.pfe.entities.client;
import org.pfe.entities.ticket_de_pesage;
import org.pfe.entities.usine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public  class usineMetierImplementation implements  usineMetier {
	
	@Autowired
    private usineRepository usineRepository;
	
	@Autowired
    private clientRepository clientRepository;
	
	@Autowired
    private ticket_de_pesageRepository ticket_de_pesageRepository;
	
	@Autowired
    private bordereau_de_livraisonRepository bordereau_de_livraisonRepository;
    
	@Override
	public usine ajoutusine(usine u) {
		// TODO Auto-generated method stub
		return usineRepository.save(u);
	}

	@Override
	public List<usine> listusine() {
		// TODO Auto-generated method stub
		return usineRepository.findAll();
	}
	
	@Override
	public usine chargerUsine(long code) {
		return usineRepository.findOne(code);
	}

	@Override
	@Transactional
	public List<client> listClient(long code) {
		
		usine u = usineRepository.findOne(code);
		List<CGI> l = u.getCGI();
		List<client> c = clientRepository.findAll();
		c.clear();
		
		for (int i=0; i<l.size(); i++){
			List<client> list = l.get(i).getClient();
			for ( int j=0; j<list.size(); j++){
				c.add(list.get(j));
			}
			
		}

		return c;
	}

	@Override
	@Transactional
	public List<ticket_de_pesage> listTicket(long code) {
		usine u = usineRepository.findOne(code);
		List<CGI> l = u.getCGI();
		List<client> c = clientRepository.findAll();
		c.clear();
		
		for (int i=0; i<l.size(); i++){
			List<client> list = l.get(i).getClient();
			for ( int j=0; j<list.size(); j++){
				c.add(list.get(j));
			}
			
		}
		List<ticket_de_pesage> liste = ticket_de_pesageRepository.findAll();
		liste.clear();
		
		for (int k = 0; k<c.size(); k++){
			List<ticket_de_pesage> aa = c.get(k).getTicket_de_pesage();
			for (int y=0; y<aa.size(); y++){
				liste.add(aa.get(y));
			}
		}
	
		return liste;
	}

	@Override
	@Transactional
	public List<bordereau_de_livraison> listBordereau(long code) {
		usine u = usineRepository.findOne(code);
		List<CGI> l = u.getCGI();
		List<client> c = clientRepository.findAll();
		c.clear();
		
		for (int i=0; i<l.size(); i++){
			List<client> list = l.get(i).getClient();
			for ( int j=0; j<list.size(); j++){
				c.add(list.get(j));
			}
			
		}
		List<bordereau_de_livraison> liste = bordereau_de_livraisonRepository.findAll();
		liste.clear();
		
		for (int k = 0; k<c.size(); k++){
			List<bordereau_de_livraison> aa = c.get(k).getBordereau_de_livraison();
			for (int y=0; y<aa.size(); y++){
				liste.add(aa.get(y));
			}
		}
	
		return liste;
	}

}
