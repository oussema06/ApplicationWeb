package org.pfe.service;

import java.util.List;

import org.pfe.entities.ticket_de_pesage;
import org.pfe.metier.ticket_de_pesageMetier;


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
public class ticket_de_pesageRestService {
	
	@Autowired
	private ticket_de_pesageMetier ticket_de_pesageMetier;
	
	
    @RequestMapping(value="/ticket_de_pesage", method=RequestMethod.POST)
	public ticket_de_pesage ajoutticket_de_pesage(@RequestBody ticket_de_pesage t) {
		return ticket_de_pesageMetier.ajoutticket_de_pesage(t);
	}
    
    @RequestMapping(value="/ticket_de_pesage/{codeclt}", method=RequestMethod.GET)
   	public List<ticket_de_pesage> listticket_de_pesage(@PathVariable long codeclt) {
   		return ticket_de_pesageMetier.listticket_de_pesage(codeclt);
   	}
   	
    @RequestMapping(value="/ticket_de_pesage", method=RequestMethod.GET)
   	public List<ticket_de_pesage> listticket_de_pesageUsine() {
   		return ticket_de_pesageMetier.listticket_de_pesage();
   	}
   	
   	
   	@RequestMapping(value="/ticket_de_pesage" , method=RequestMethod.PUT)
	public ticket_de_pesage changerTicket(@RequestParam long codeT,
			                      @RequestParam int choix,
	                              @RequestParam double distance, 
			                      @RequestParam String libelle,
	                              @RequestParam double poids,
			                      @RequestParam long codeC,
	                              @RequestParam long codeClt,
	                              @RequestParam long matricule){
		return ticket_de_pesageMetier.changerTicket(codeT, choix, distance, libelle, poids, codeC, codeClt, matricule);
	}
    
    
}
