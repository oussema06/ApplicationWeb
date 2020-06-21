package org.pfe.metier;

import java.util.List;

import org.pfe.entities.liqne_bordereau;



public interface ligne_bordereauMetier {
	
	public liqne_bordereau ajoutliqne_bordereau(liqne_bordereau l);
	public List<liqne_bordereau> listliqne_bordereau();
	public liqne_bordereau changerLigne(long codeLigne, int quantite);
	

}
