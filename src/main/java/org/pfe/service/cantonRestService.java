package org.pfe.service;

import org.pfe.entities.canton;
import org.pfe.entities.client;
import org.pfe.metier.cantonMetier;

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
public class cantonRestService {
	
	@Autowired
	private cantonMetier cantonMetier;
	
	
    @RequestMapping(value="/canton", method=RequestMethod.POST)
	public canton ajoutcanton(@RequestBody canton ct) {
		return cantonMetier.ajoutcanton(ct);
	}
    
    
    @RequestMapping(value="/canton", method=RequestMethod.GET)
	public List<canton> listcanton() {
		return cantonMetier.listcanton();
	}
	
	
	@RequestMapping(value="/canton/{code}" , method=RequestMethod.GET)
	public canton chargerCanton(@PathVariable long code) {
		return cantonMetier.chargerCanton(code);
	}
	

	@RequestMapping(value="/canton/libelle" , method=RequestMethod.PUT)
	public boolean ChangerLibelle(@RequestParam long code, 
			                      @RequestParam String libelle,
			                      @RequestParam String nom,
			                      @RequestParam long codeSous_prefecture) {
		return cantonMetier.changerLibelle(code, libelle, nom, codeSous_prefecture);
	}
	
	@RequestMapping(value="/canton/prefecture" , method=RequestMethod.PUT)
	public boolean ChangerSous_prefecture(@RequestParam long codeC, 
			                              @RequestParam long codeSP) {
		return cantonMetier.changerSous_prefecture(codeC, codeSP);
	}
	
	@RequestMapping(value="/canton/client" , method=RequestMethod.PUT)
	public Collection<client> Listclient(@RequestParam long code) {
		return cantonMetier.Listclient(code);
	}
			

	
}
