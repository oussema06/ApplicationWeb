package org.pfe.service;

import org.pfe.entities.bordereau_de_livraison;
import org.pfe.entities.liqne_bordereau;
import org.pfe.metier.bordereau_de_livraisonMetier;

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
public class bordereau_de_livraisonRestService {
	
	@Autowired
	private bordereau_de_livraisonMetier bordereau_de_livraisonMetier;
	
	
    @RequestMapping(value="/bordereau_de_livraison", method=RequestMethod.POST)
	public bordereau_de_livraison ajoutbordereau_de_livraison(@RequestBody bordereau_de_livraison b) {
		return bordereau_de_livraisonMetier.ajoutbordereau_de_livraison(b);
	}
    
    
    @RequestMapping(value="/bordereau_de_livraison", method=RequestMethod.GET)
	public List<bordereau_de_livraison> listbordereau_de_livraison() {
		return bordereau_de_livraisonMetier.listbordereau_de_livraison();
	}
	
	
	@RequestMapping(value="/bordereau_de_livraison/ligne_bordereau/{codeB}" , method=RequestMethod.GET)
	public List<liqne_bordereau> Listligne_bordereau(@PathVariable long codeB) {
		return bordereau_de_livraisonMetier.listLigne_bordereau(codeB);
	}		

	
}
