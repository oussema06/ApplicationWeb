package org.pfe.service;

import org.pfe.entities.bordereau_de_livraison;
import org.pfe.entities.client;
import org.pfe.entities.facture;
import org.pfe.entities.ticket_de_pesage;
import org.pfe.metier.factureMetier;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Controller
@RestController
public class factureRestService {
	
	@Autowired
	private factureMetier factureMetier;
	
	
    @RequestMapping(value="/facture", method=RequestMethod.POST)
	public facture ajoutfacture(@RequestBody facture f) {
		return factureMetier.ajoutfacture(f);
	}
    
    
    @RequestMapping(value="/facture", method=RequestMethod.GET)
	public List<facture> listfacture() {
		return factureMetier.listfacture();
	}
	
	@RequestMapping(value="/facture" , method=RequestMethod.PUT)
	public facture changerFacture(@RequestParam long code) {
		return factureMetier.changerFacture(code);
	}
	
	@RequestMapping(value="/facture/net" , method=RequestMethod.PUT)
	public boolean ChangerNet(@RequestParam int net,
			                  @RequestParam long num) {
		return factureMetier.changerNet(net, num);
	}
	
	@RequestMapping(value="/factureP", method=RequestMethod.GET)
	public List<facture> listfactureP() {
		return factureMetier.listfactureP();
	}
	
	@RequestMapping(value="/factureN", method=RequestMethod.GET)
	public List<facture> listfactureN() {
		return factureMetier.listfactureN();
	}
	
	@RequestMapping(value="/facture/bordereau_de_livraison/{code}" , method=RequestMethod.GET)
	public List<bordereau_de_livraison> chargerBord(@PathVariable long code) {
		return factureMetier.listBrdereau(code);
	}
	
	@RequestMapping(value="/facture/ticket_de_pesage/{code}" , method=RequestMethod.GET)
	public List<ticket_de_pesage> chargerTicket(@PathVariable long code) {
		return factureMetier.listTicket(code);
	}
	
			

	
}
