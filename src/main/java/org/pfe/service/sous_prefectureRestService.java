package org.pfe.service;

import org.pfe.entities.canton;
import org.pfe.entities.sous_prefecture;
import org.pfe.metier.sous_prefectureMetier;

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
public class sous_prefectureRestService {
	
	@Autowired
	private sous_prefectureMetier sous_prefectureMetier;
	
	
    @RequestMapping(value="/sous_prefecture", method=RequestMethod.POST)
	public sous_prefecture ajoutprefecture(@RequestBody sous_prefecture spf) {
		return sous_prefectureMetier.ajoutsous_prefecture(spf);
    }
    
    
    @RequestMapping(value="/sous_prefecture", method=RequestMethod.GET)
	public List<sous_prefecture> listsous_prefecture() {
		return sous_prefectureMetier.listsous_prefecture();
	}
	
	@RequestMapping(value="/sous_prefecture/{code}" , method=RequestMethod.GET)
	public sous_prefecture chargerSous_prefecture(@PathVariable long code) {
		return sous_prefectureMetier.chargerSous_prefecture(code);
	}
	
	@RequestMapping(value="/sous_prefecture/libelle" , method=RequestMethod.PUT)
	public boolean ChangerLibelle(@RequestParam long code, 
			                      @RequestParam String libelle,
			                      @RequestParam String nom,
			                      @RequestParam long codePrefecture) {
		return sous_prefectureMetier.changerLibelle(code, libelle, nom, codePrefecture);
	}
	
	@RequestMapping(value="/sous_prefecture/prefecture" , method=RequestMethod.PUT)
	public boolean ChangerPrefecture(@RequestParam long codeC, 
			                         @RequestParam long codeSP) {
		return sous_prefectureMetier.changerPrefecture(codeC, codeSP);
	}
	
	@RequestMapping(value="/sous_prefecturre/canton" , method=RequestMethod.PUT)
	public Collection<canton> Listcanton(@RequestParam long code) {
		return sous_prefectureMetier.Listcanton(code);
	}
	
}

	

