package org.pfe.service;

import org.pfe.entities.prefecture;
import org.pfe.entities.sous_prefecture;
import org.pfe.metier.prefectureMetier;

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
public class prefectureRestService {
	
	@Autowired
	private prefectureMetier prefectureMetier;
    @RequestMapping(value="/prefecture", method=RequestMethod.POST)
	public prefecture ajoutprefecture(@RequestBody prefecture pf) {
		return prefectureMetier.ajoutprefecture(pf);
    }
    
    @RequestMapping(value="/prefecture", method=RequestMethod.GET)
	public List<prefecture> listprefecture() {
		return prefectureMetier.listprefecture();
	}
	
	@RequestMapping(value="/prefecture/{code}" , method=RequestMethod.GET)
	public prefecture chargerPrefecture(@PathVariable long code) {
		return prefectureMetier.chargerPrefecture(code);
	}
	
	@RequestMapping(value="/prefecture/libelle" , method=RequestMethod.PUT)
	public boolean ChangerLibelle(@RequestParam long code,
			                      @RequestParam String nom,
			                      @RequestParam String libelle,
			                      @RequestParam long codePays) {
		return prefectureMetier.changerLibelle(code, libelle, nom, codePays);
	}
	
	@RequestMapping(value="/prefecture/sous_prefecture/{code}" , method=RequestMethod.PUT)
	public Collection<sous_prefecture> Listsous_prefecture(@RequestParam long code) {
		return prefectureMetier.Listsous_prefecture(code);
	}
		
}



	

