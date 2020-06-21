package org.pfe.metier;

import java.util.Collection;
import java.util.List;

import org.pfe.entities.canton;
import org.pfe.entities.client;




public interface cantonMetier {
	
	public canton ajoutcanton(canton ct);
	public List<canton> listcanton();
	public canton chargerCanton(long code);
	public boolean changerLibelle(long code, String libelle, String nom, long codeSous_prefecture);
	public boolean changerSous_prefecture(long codeC, long codeSP);
	public Collection<client> Listclient(long code);

}
