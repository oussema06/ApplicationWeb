package org.pfe.metier;

import java.util.List;

import org.pfe.entities.type_vehicule;



public interface type_vehiculeMetier {
	
	public type_vehicule ajouttype_vehicule(type_vehicule tv);
	public List<type_vehicule> listtype_vehicule();
	public type_vehicule chargerType_vehicule(long code);
}
