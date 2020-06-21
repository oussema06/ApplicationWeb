package org.pfe.metier;

import java.util.Collection;
import java.util.List;

import org.pfe.entities.prefecture;
import org.pfe.entities.sous_prefecture;



public interface prefectureMetier {
	
	public prefecture ajoutprefecture(prefecture pf);
	public List<prefecture> listprefecture();
	public prefecture chargerPrefecture(long code);
	public boolean changerLibelle(long code, String libelle, String nom, long codePays);
	public Collection<sous_prefecture> Listsous_prefecture(long code);

}
