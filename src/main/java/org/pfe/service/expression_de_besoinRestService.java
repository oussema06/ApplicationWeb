package org.pfe.service;

import org.pfe.entities.expression_de_besoin;
import org.pfe.metier.expression_de_besoinMetier;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@Controller
@RestController
public class expression_de_besoinRestService {
	
	@Autowired
	private expression_de_besoinMetier expression_de_besoinMetier;
	
	
    @RequestMapping(value="/expression_de_besoin", method=RequestMethod.POST)
	public expression_de_besoin ajoutexpression_de_besoin(@RequestBody expression_de_besoin ex) {
		return expression_de_besoinMetier.ajoutexpression_de_besoin(ex);
	}
    
    
    @RequestMapping(value="/expression_de_besoin", method=RequestMethod.GET)
	public List<expression_de_besoin> listexpression_de_besoin() {
		return expression_de_besoinMetier.listexpression_de_besoin();
	}
	

	
}
