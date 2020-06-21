package org.pfe.service;

import org.pfe.entities.liqne_bordereau;
import org.pfe.metier.ligne_bordereauMetier;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Controller
@RestController
public class ligne_bordereauRestService {
	
	@Autowired
	private ligne_bordereauMetier liqne_bordereauMetier;
	
	
    @RequestMapping(value="/ligne_bordereau", method=RequestMethod.POST)
	public liqne_bordereau ajoutliqne_bordereau(@RequestBody liqne_bordereau a) {
		return liqne_bordereauMetier.ajoutliqne_bordereau(a);
	}
    
    
    @RequestMapping(value="/ligne_bordereau", method=RequestMethod.GET)
	public List<liqne_bordereau> listliqne_bordereau() {
		return liqne_bordereauMetier.listliqne_bordereau();
	}
	
	@RequestMapping(value="/ligne_bordereau" , method=RequestMethod.PUT)
	public liqne_bordereau changerLigne(@RequestParam long codeLigne, 
			                      @RequestParam int quantite) {
		return liqne_bordereauMetier.changerLigne(codeLigne, quantite);
	}
			

	
}
