package org.pfe.service;


import org.pfe.entities.prix_coton;
import org.pfe.metier.prix_cotonMetier;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Controller
@RestController
public class prix_cotonRestService {
	
	@Autowired
	private prix_cotonMetier prix_cotonMetier;
	
	
	 @RequestMapping(value="/prix_coton", method=RequestMethod.GET)
		public List<prix_coton> listarticle() {
			return prix_cotonMetier.getPrix_coton();
		}
    
    
    @RequestMapping(value="/prix_coton" , method=RequestMethod.PUT)
	public boolean changerPrix(@RequestParam double choix1, 
			                      @RequestParam double choix2,
			                      @RequestParam double choix3,
			                      @RequestParam long code) {
		return prix_cotonMetier.changerPrix(choix1, choix2, choix3, code);
	}
	
	
			

	
}
