package org.pfe.service;

import org.pfe.entities.pays;
import org.pfe.entities.prefecture;
import org.pfe.metier.paysMetier;

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
public class paysRestService {
	
	@Autowired
	private paysMetier paysMetier;
	
	
    @RequestMapping(value="/pays", method=RequestMethod.POST)
	public pays ajoutClient(@RequestBody pays pf) {
		return paysMetier.ajoutpays(pf);
	}
    
    
    @RequestMapping(value="/pays", method=RequestMethod.GET)
	public List<pays> listpays() {
		return paysMetier.listpays();
	}
	
	
	
	@RequestMapping(value="/pays/{code}" , method=RequestMethod.GET)
	public pays chargerPays(@PathVariable long code) {
		return paysMetier.chargerPays(code);
	}
	
	@RequestMapping(value="/pays/prefecture" , method=RequestMethod.PUT)
	public Collection<prefecture> Listprefecture(@RequestParam long code) {
		return paysMetier.Listprefecture(code);
	}

	
}
