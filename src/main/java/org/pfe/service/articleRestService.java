package org.pfe.service;

import org.pfe.entities.article;
import org.pfe.metier.articleMetier;

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
public class articleRestService {
	
	@Autowired
	private articleMetier articleMetier;
	
	
    @RequestMapping(value="/article", method=RequestMethod.POST)
	public article ajoutarticle(@RequestBody article a) {
		return articleMetier.ajoutarticle(a);
	}
    
    
    @RequestMapping(value="/article", method=RequestMethod.GET)
	public List<article> listarticle() {
		return articleMetier.listarticle();
	}
	
	@RequestMapping(value="/article" , method=RequestMethod.PUT)
	public boolean ChangerArticle(@RequestParam long code, 
			                      @RequestParam double tva,
			                      @RequestParam String dis,
			                      @RequestParam String nom,
			                      @RequestParam double prix,
			                      @RequestParam double quantite,
			                      @RequestParam String unite
			                      ) {
		return articleMetier.changerArticle(code, tva, dis, nom, prix, quantite, unite);
	}
			

	
}
