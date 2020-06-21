package org.pfe.metier;

import java.util.List;

import org.pfe.entities.chauffeur;




public interface chauffeurMetier {
	
	public chauffeur ajoutchauffeur(chauffeur chauf);
	public List<chauffeur> listchauffeur();
	public chauffeur chargerChauffeur(long code);

}
