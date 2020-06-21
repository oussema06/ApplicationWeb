package org.pfe.metier;

import java.util.List;

import org.pfe.entities.bordereau_de_livraison;
import org.pfe.entities.facture;
import org.pfe.entities.ticket_de_pesage;




public interface factureMetier {
	
	public facture ajoutfacture(facture f);
	public List<facture> listfacture();
	public facture changerFacture(long code);
	public List<facture> listfactureP();
	public List<facture> listfactureN();
	public boolean changerNet(int net, long num);
	public List<bordereau_de_livraison> listBrdereau(long numFacture);
	public List<ticket_de_pesage> listTicket(long numFacture);


}
