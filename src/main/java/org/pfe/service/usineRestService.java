package org.pfe.service;

import org.pfe.entities.bordereau_de_livraison;
import org.pfe.entities.client;
import org.pfe.entities.ticket_de_pesage;
import org.pfe.entities.usine;
import org.pfe.metier.usineMetier;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@Controller
@RestController
public class usineRestService {
	
	@Autowired
	private usineMetier usineMetier;
	
	
    @RequestMapping(value="/usine", method=RequestMethod.POST)
	public usine ajoutusine(@RequestBody usine u) {
		return usineMetier.ajoutusine(u);
	}
    
    
    @RequestMapping(value="/usine", method=RequestMethod.GET)
	public List<usine> listusine() {
		return usineMetier.listusine();
	}
	
	
	
	@RequestMapping(value="/usine/{code}" , method=RequestMethod.GET)
	public usine chargerUsine(@PathVariable long code) {
		return usineMetier.chargerUsine(code);
	}	
	
	@RequestMapping(value="/usine/client/{code}" , method=RequestMethod.GET)
	public List<client> chargerUsineClient(@PathVariable long code) {
		return usineMetier.listClient(code);
	}	
	
	@RequestMapping(value="/usine/ticket/{code}" , method=RequestMethod.GET)
	public List<ticket_de_pesage> chargerUsineTicket(@PathVariable long code) {
		return usineMetier.listTicket(code);
	}	
	
	@RequestMapping(value="/usine/bordereau/{code}" , method=RequestMethod.GET)
	public List<bordereau_de_livraison> chargerUsineBord(@PathVariable long code) {
		return usineMetier.listBordereau(code);
	}	

	
}
