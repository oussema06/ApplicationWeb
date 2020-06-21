package org.pfe.service;

import org.pfe.entities.bordereau_de_livraison;
import org.pfe.entities.client;
import org.pfe.entities.ticket_de_pesage;
import org.pfe.metier.clientMetier;

import java.util.Collection;
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
public class clientRestService {
	
	@Autowired
	private clientMetier clientMetier;
	
    @RequestMapping(value="/client", method=RequestMethod.POST)
	public client ajoutClient(@RequestBody client c) {
		return clientMetier.ajoutClient(c);
	}
	
	@RequestMapping(value="/client/{code}" , method=RequestMethod.GET)
	public client chargerClient(@PathVariable long code) {
		return clientMetier.chargerClient(code);
	}

	@RequestMapping(value="/client" , method=RequestMethod.GET)
	public List<client> ListClient() {
		return clientMetier.ListClient();
	}
	
	@RequestMapping(value="/client/ticket_de_pesage/{codeclt}" , method=RequestMethod.GET)
	public List<ticket_de_pesage> ListTicket_de_pesage(@PathVariable long codeclt) {
		return clientMetier.ListTicket_de_pesage(codeclt);
	}
	
	
	
	@RequestMapping(value="/client/bordereau_de_livraison/{codeclt}" , method=RequestMethod.GET)
	public List<bordereau_de_livraison> ListBordereau_de_livraison(@PathVariable long codeclt) {
		return clientMetier.ListBordereau_de_livraison(codeclt);
	}
	
	@RequestMapping(value="/client" , method=RequestMethod.PUT)
	public boolean ChangerClient(@RequestParam long code, 
			                     @RequestParam String adrFac,
			                     @RequestParam String adrLiv,
			                     @RequestParam int fax,
			                     @RequestParam String libelle,
			                     @RequestParam String mail,
			                     @RequestParam String nom,
			                     @RequestParam int tel,
			                     @RequestParam long codeCGI,
			                     @RequestParam long codeCanton
			                     ) {
		return clientMetier.changerClient(code, adrFac, adrLiv, fax, libelle, mail, nom, tel, codeCGI, codeCanton);
	}
	
	/*@RequestMapping(value="/client/CGI/{codeCGI}" , method=RequestMethod.GET)
	public List<client> chargerClientCGI(@PathVariable long codeCGI) {
		return clientMetier.ListClientCGI(codeCGI);
	}*/
	
	
}
