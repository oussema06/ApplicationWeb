package org.pfe.metier;

import java.util.Date;
import java.util.List;

import org.pfe.dao.bordereau_de_livraisonRepository;
import org.pfe.dao.prix_cotonRepository;
import org.pfe.dao.factureRepository;
import org.pfe.dao.ticket_de_pesageRepository;
import org.pfe.entities.bordereau_de_livraison;
import org.pfe.entities.facture;
import org.pfe.entities.liqne_bordereau;
import org.pfe.entities.prix_coton;
import org.pfe.entities.ticket_de_pesage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public  class factureMetierImplementation implements  factureMetier {
	
	@Autowired
    private factureRepository factureRepository;
	
	@Autowired
    private ticket_de_pesageRepository ticket_de_pesageRepository;
	
	@Autowired
    private bordereau_de_livraisonRepository bordereau_de_livraisonRepository;
	
	@Autowired
    private prix_cotonRepository prix_cotonRepository;

	

	
	
	
	@Override
	public facture ajoutfacture(facture f) {
		
		//ajout de la date du systeme
		f.setDate(new Date());
		
		return factureRepository.save(f);
	}

	@Override
	public List<facture> listfacture() {
		// TODO Auto-generated method stub
		return factureRepository.findAll();
	}

	@Override
	@Transactional
	public facture changerFacture(long code) {
		
		facture f = factureRepository.findOne(code);
		ticket_de_pesage ticket;
		bordereau_de_livraison bordereau;
		double t =0;
		double b =0;
		double n =0;
		long u = 1;
		prix_coton prix = prix_cotonRepository.findOne(u);
		
		//ajout des tickets de pesage non facturé
		List<ticket_de_pesage> T = f.getClient().getTicket_de_pesage();
		for(int i=0 ; i<T.size(); i++){
			if(T.get(i).getEtat()== 0){
				
				ticket = ticket_de_pesageRepository.findOne(T.get(i).getCode_tichet());
				ticket.setEtat(1);
				ticket.setFacture(f);
				 if(ticket.getChoix_coton()==1) {
				    	t = t+ticket.getPoids()*prix.getChoix1();
				    }
				    else if(ticket.getChoix_coton()==2){
				    	t = t+ticket.getPoids()*prix.getChoix2();
				    }
				    else if(ticket.getChoix_coton()==3){
				    	t = t+ticket.getPoids()*prix.getChoix3();
				    }
			}
		}
		
		
		//ajout des bordereau de livraison non facturé
		List<liqne_bordereau> ligne = null;
		List<bordereau_de_livraison> B = f.getClient().getBordereau_de_livraison();
		for(int i = 0; i<B.size(); i++){
			if(B.get(i).getEtat() == 0){
				bordereau = bordereau_de_livraisonRepository.findOne(B.get(i).getNum());
				bordereau.setEtat(1);
				bordereau.setFacture(f);
				
				ligne = bordereau.getLiqne_bordereau();
				for(int j=0; j<ligne.size(); j++){
					b = b+(ligne.get(j).getArticle().getPrix_unitaire()+ligne.get(j).getArticle().getPrix_unitaire()*ligne.get(j).getArticle().getTVA())*ligne.get(j).getQauntite();
				}
				}
		}
		
		List<facture> list = factureRepository.findAll();
		
		double fac = 0;
		for(int i=0; i<list.size(); i++){
			if(list.get(i).getClient().getCode_client() == f.getClient().getCode_client()){
			   double net = list.get(i).getNet();
			   if(net<0){
				   fac = fac + list.get(i).getNet();
				   facture facture = factureRepository.findOne(list.get(i).getNum());
				   facture.setNet(0);
				   net = 0;
			   }
			 	
			}	
		}
		
		
		
		n =t-b+fac;
		
		f.setTotalFac(fac);
		f.setTotalTicket(t);
		f.setTotalBord(b);
		f.setNet(n);
		f.setTotal(n);
		return f;
	}

	@Override
	public List<facture> listfactureP() {
		
		List<facture> f = factureRepository.findAll();
		List<facture> res = factureRepository.findAll();
		res.clear();
		for(int k=0; k<f.size(); k++){
			if(f.get(k).getNet()==0){
				res.add(f.get(k));
			}
		}
		return res;
	}
	
	
	@Override
	public List<facture> listfactureN() {
		
		List<facture> f = factureRepository.findAll();
		List<facture> res = factureRepository.findAll();
		res.clear();
		for(int k=0; k<f.size(); k++){
			if(f.get(k).getNet()!=0){
				res.add(f.get(k));
			}
		}
		return res;
	}

	@Override
	@Transactional
	public boolean changerNet(int net, long num) {
		facture f = factureRepository.findOne(num);
		double a = f.getNet();
		f.setNet(a-net);
		return true;
	}

	@Override
	@Transactional
	public List<bordereau_de_livraison> listBrdereau(long numFacture) {
		facture f = factureRepository.findOne(numFacture);
		List<bordereau_de_livraison> b = f.getBordereau_de_livraison();
		return b;
	}

	@Override
	public List<ticket_de_pesage> listTicket(long numFacture) {
		facture f = factureRepository.findOne(numFacture);
		List<ticket_de_pesage> t = f.getTicket_de_pesage();
		return t;
	}

	
	
}
