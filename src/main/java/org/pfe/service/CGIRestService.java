package org.pfe.service;

import org.pfe.entities.CGI;
import org.pfe.entities.bordereau_de_livraison;
import org.pfe.entities.client;
import org.pfe.metier.CGIMetier;

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
public class CGIRestService {
	
	@Autowired
	private CGIMetier CGIMetier;
	
	
    @RequestMapping(value="/CGI", method=RequestMethod.POST)
	public CGI ajoutCGI(@RequestBody CGI C) {
		return CGIMetier.ajoutCGI(C);
	}
    
    
    @RequestMapping(value="/CGI", method=RequestMethod.GET)
	public List<CGI> listCGI() {
		return CGIMetier.listCGI();
	}
    
    
    @RequestMapping(value="/CGI/{code}" , method=RequestMethod.GET)
	public CGI chargerCGI(@PathVariable long code) {
		return CGIMetier.chargerCGI(code);
	}
    
    @RequestMapping(value="/CGI/client/{codeCGI}" , method=RequestMethod.GET)
   	public List<client> chargerClient(@PathVariable long codeCGI) {
   		return CGIMetier.listClient(codeCGI);
   	}
   	
   	@RequestMapping(value="/CGI/bordereau/{code}" , method=RequestMethod.GET)
	public List<bordereau_de_livraison> chargerUsineBord(@PathVariable long code) {
		return CGIMetier.listBordereau(code);
	}	
    
	
}
