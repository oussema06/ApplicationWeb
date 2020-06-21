package org.pfe.metier;

import java.util.List;

import org.pfe.entities.bordereau_de_livraison;
import org.pfe.entities.client;
import org.pfe.entities.ticket_de_pesage;



public interface clientMetier {
	
	public client ajoutClient(client c);
	public client chargerClient(long code);
	public List<client> ListClient();
	public boolean changerClient(long code, String adrFac, String adrLiv, int fax, String libelle, String mail, String nom, int tel, long codeCGI, long codeCanton);
	public List<ticket_de_pesage> ListTicket_de_pesage(long codeclt);
	public List<bordereau_de_livraison> ListBordereau_de_livraison(long codeclt);
	//public List<client> ListClientCGI(long codeCGI);

}
