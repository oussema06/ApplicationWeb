package org.pfe.metier;

import java.util.List;

import org.pfe.entities.vehicule;



public interface vehiculeMetier {
	
	public vehicule ajoutvehicule(vehicule v);
	public List<vehicule> listvehicule();
	public vehicule chargerVehicule(long matricule);

}
