package org.pfe.metier;

import java.util.List;

import org.pfe.dao.CGIRepository;
import org.pfe.dao.bordereau_de_livraisonRepository;
import org.pfe.dao.clientRepository;
import org.pfe.entities.CGI;
import org.pfe.entities.bordereau_de_livraison;
import org.pfe.entities.client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public  class CGIMetierImplementation implements  CGIMetier {
	
	@Autowired
    private CGIRepository CGIRepository;
	
	@Autowired
    private clientRepository clientRepository;
	
	@Autowired
    private bordereau_de_livraisonRepository bordereau_de_livraisonRepository;
    
	@Override
	public CGI ajoutCGI(CGI C) {
		// TODO Auto-generated method stub
		return CGIRepository.save(C);
	}

	@Override
	public List<CGI> listCGI() {
		// TODO Auto-generated method stub
		return CGIRepository.findAll();
	}
	
	@Override
	public CGI chargerCGI(long code) {
		return CGIRepository.findOne(code);
	}

	@Override
	public List<client> listClient(long codeCGI) {
		CGI c = CGIRepository.findOne(codeCGI);
		List<client> l = c.getClient();
		return l;
	}
	
	@Override
	@Transactional
	public List<bordereau_de_livraison> listBordereau(long code) {
		CGI u = CGIRepository.findOne(code);
	
		List<client> c = clientRepository.findAll();
		c.clear();
		
	
			List<client> list = u.getClient();
			for ( int j=0; j<list.size(); j++){
				c.add(list.get(j));
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
