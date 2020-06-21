package org.pfe.service;

import org.pfe.entities.utilisateur;
import org.pfe.metier.utilisateurMetier;

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
public class utilisateurRestService {
	
	@Autowired
	private utilisateurMetier utilisateurMetier;
	
	
    @RequestMapping(value="/utilisateur", method=RequestMethod.POST)
	public utilisateur ajoutUtilisateur(@RequestBody utilisateur U) {
		return utilisateurMetier.ajoutUtilisateur(U);
	}
    
    
@   RequestMapping(value="/utilisateur", method=RequestMethod.GET)
	public List<utilisateur> listUtilisateur() {
		return utilisateurMetier.listUtilisateur();
	}
	
	
	@RequestMapping(value="/utilisateur/{code}" , method=RequestMethod.GET)
	public utilisateur chargerUtilisateur(@PathVariable long code) {
		return utilisateurMetier.chargerUtilisateur(code);
	}
	
	@RequestMapping(value="/utilisateur" , method=RequestMethod.PUT)
	public boolean ChangerUtilisateur(@RequestParam long code, 
			@RequestParam String type,
			@RequestParam String mail,
			@RequestParam String nom,
			@RequestParam String prenom,
			@RequestParam int tel,
			@RequestParam String mdp,
			@RequestParam long codeCgi,
			@RequestParam long codeUsine) {
		return utilisateurMetier.chnagerUtilisateur(code, type, mail, nom, prenom, tel, mdp, codeCgi, codeUsine);
	}
			

	
}
