package org.pfe.metier;


import java.util.List;

import org.pfe.entities.ticket_de_pesage;




public interface ticket_de_pesageMetier {
	
	public ticket_de_pesage ajoutticket_de_pesage(ticket_de_pesage t);
	public List<ticket_de_pesage> listticket_de_pesage(long codeclt);
	public List<ticket_de_pesage> listticket_de_pesage();
	public ticket_de_pesage changerTicket(long codeT, int choix, double distance, String libelle, double poids, long codeC, long codeClt, long matricule);

}
