package org.pfe.metier;


import java.util.List;

import org.pfe.dao.CGIRepository;
import org.pfe.dao.cantonRepository;
import org.pfe.dao.clientRepository;
import org.pfe.dao.utilisateurRepository;
import org.pfe.entities.bordereau_de_livraison;
import org.pfe.entities.canton;
import org.pfe.entities.client;
import org.pfe.entities.CGI;
import org.pfe.entities.GPB;
import org.pfe.entities.ticket_de_pesage;
import org.pfe.entities.utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public  class clientMetierImplementation implements  clientMetier {
	
	@Autowired
    private clientRepository clientRepository;
	
	@Autowired
    private utilisateurRepository utilisateurRepository;
	
	@Autowired
    private CGIRepository CGIRepository;
	
	@Autowired
    private cantonRepository cantonRepository;
	
	
    
	@Override
	public client ajoutClient(client c) {
		// TODO Auto-generated method stub
		return clientRepository.save(c);
	}

	@Override
	public client chargerClient(long code) {
		return clientRepository.findOne(code);
	}

	@Override
	public List<client> ListClient() {
		// TODO Auto-generated method stub
		return clientRepository.findAll();
	}

	@Override
	@Transactional
	public List<ticket_de_pesage> ListTicket_de_pesage(long codeclt) {
		
		client C = clientRepository.findOne(codeclt);
		 List<ticket_de_pesage> p = C.getTicket_de_pesage();
		 int k = p.size();
		 for(int e = 0; e<k ;e++){
			if (p.get(e).getEtat() != 0) {
				p.remove(e);
				k = k-1;
				e=e-1;
			}
		 }
		return p;
	}
	
	
	@Override
	@Transactional
	public List<bordereau_de_livraison> ListBordereau_de_livraison(long codeclt) {
		//long num = Long.parseLong(codeclt);
		
		client C = clientRepository.findOne(codeclt);
		List<bordereau_de_livraison> l = C.getBordereau_de_livraison();
		int j = l.size();
		for(int i = 0; i<j ;i++){
			if (l.get(i).getEtat()!= 0){
				l.remove(i);
				j = j-1;
				i=i-1;
				
			}
		}
		return l;
	}

	@Override
	@Transactional
	public boolean changerClient(long code, String adrFac, String adrLiv, int fax, String libelle, String mail,
			String nom, int tel, long codeCGI, long codeCanton) {

		CGI cgi = CGIRepository.findOne(codeCGI);
		canton canton = cantonRepository.findOne(codeCanton);
		client c = clientRepository.findOne(code);

		
		
		c.setAdresse_de_facturation(adrFac);
		c.setAdresse_de_livraison(adrLiv);
		c.setFax(fax);
		c.setLibelle(libelle);
		c.setMail(mail);
		c.setNom_client(nom);
		c.setTel(tel);
		c.setCGI(cgi);
		c.setCanton(canton);
		
		
		
		return true;
	}

	/*@Override
	@Transactional
	public List<client> ListClientCGI(long codeCGI) {
		
		
		 List<client> c1 = clientRepository.findAll();
		 List<client> c = clientRepository.findAll();
		 c.clear();
		 int j=c1.size();
		 for (int i=0; i<j;i++){
			 if(c1.get(i).getCGI().getCode_CGI() != codeCGI ){
				// c.add(c1.get(i));
				 c1.remove(i);
				 i = i-1;
				 j=j-1;
			 }
		 }
		return c1;
	}*/

	
	
	

	

}
