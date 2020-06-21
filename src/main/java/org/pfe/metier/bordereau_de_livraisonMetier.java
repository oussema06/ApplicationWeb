package org.pfe.metier;

import java.util.List;

import org.pfe.entities.bordereau_de_livraison;
import org.pfe.entities.liqne_bordereau;





public interface bordereau_de_livraisonMetier {
	
	public bordereau_de_livraison ajoutbordereau_de_livraison(bordereau_de_livraison b);
	public List<bordereau_de_livraison> listbordereau_de_livraison();
	public List<liqne_bordereau> listLigne_bordereau(long codeB);

}
