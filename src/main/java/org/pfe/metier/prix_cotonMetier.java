package org.pfe.metier;



import java.util.List;

import org.pfe.entities.prix_coton;




public interface prix_cotonMetier {
	
	public boolean changerPrix(double choix1, double choix2, double choix3, long code);
	public List<prix_coton> getPrix_coton();

}
