package org.pfe.metier;

import java.util.Collection;
import java.util.List;

import org.pfe.entities.canton;
import org.pfe.entities.sous_prefecture;



public interface sous_prefectureMetier {
	
	public sous_prefecture ajoutsous_prefecture(sous_prefecture spf);
	public List<sous_prefecture> listsous_prefecture();
	public sous_prefecture chargerSous_prefecture(long code);
	public boolean changerLibelle(long code, String libelle, String nom, long codePrefecture);
	public boolean changerPrefecture(long codeSp, long codeP);
	public Collection<canton> Listcanton(long code);

}
