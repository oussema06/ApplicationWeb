package org.pfe.service;

import org.pfe.entities.type_vehicule;
import org.pfe.metier.type_vehiculeMetier;

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
public class type_vehiculeRestService {
	
	@Autowired
	private type_vehiculeMetier type_vehiculeMetier;
	
	
    @RequestMapping(value="/type_vehicule", method=RequestMethod.POST)
	public type_vehicule ajouttype_vehicule(@RequestBody type_vehicule adr) {
		return type_vehiculeMetier.ajouttype_vehicule(adr);
	}
    
    
    @RequestMapping(value="/type_vehicule", method=RequestMethod.GET)
	public List<type_vehicule> listtype_vehicule() {
		return type_vehiculeMetier.listtype_vehicule();
	}
	
	
	@RequestMapping(value="/type_vehicule/{code}" , method=RequestMethod.GET)
	public type_vehicule chargerType_vehicule(@PathVariable long code) {
		return type_vehiculeMetier.chargerType_vehicule(code);
	}
			

	
}
