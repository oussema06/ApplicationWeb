package org.pfe.metier;

import java.util.List;

import org.pfe.entities.bordereau_de_livraison;
import org.pfe.entities.client;
import org.pfe.entities.ticket_de_pesage;
import org.pfe.entities.usine;



public interface usineMetier {
	
	public usine ajoutusine(usine u);
	public List<usine> listusine();
	public usine chargerUsine(long code);
	public List<client> listClient(long code);
	public List<ticket_de_pesage> listTicket(long code);
	public List<bordereau_de_livraison> listBordereau(long code);

}
