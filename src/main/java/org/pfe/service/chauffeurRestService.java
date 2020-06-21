package org.pfe.service;

import org.pfe.entities.chauffeur;
import org.pfe.metier.chauffeurMetier;

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
public class chauffeurRestService {
	
	@Autowired
	private chauffeurMetier chauffeurMetier;
	
	
    @RequestMapping(value="/chauffeur", method=RequestMethod.POST)
	public chauffeur ajoutchauffeur(@RequestBody chauffeur chauf) {
		return chauffeurMetier.ajoutchauffeur(chauf);
	}
    
    
    @RequestMapping(value="/chauffeur", method=RequestMethod.GET)
	public List<chauffeur> listchauffeur() {
		return chauffeurMetier.listchauffeur();
	}
	
	
	@RequestMapping(value="/chauffeur/{code}" , method=RequestMethod.GET)
	public chauffeur chargerChauffeur(@PathVariable long code) {
		return chauffeurMetier.chargerChauffeur(code);
	}
			

	
}
