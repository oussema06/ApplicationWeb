package org.pfe.metier;

import java.util.Collection;
import java.util.List;


import org.pfe.entities.pays;
import org.pfe.entities.prefecture;



public interface paysMetier {
	
	public pays ajoutpays(pays p);
	public List<pays> listpays();
	public pays chargerPays(long code);
	public Collection<prefecture> Listprefecture(long code);

}
