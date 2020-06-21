package org.pfe.metier;

import java.util.List;

import org.pfe.entities.utilisateur;



public interface utilisateurMetier {
	
	public utilisateur ajoutUtilisateur(utilisateur U);
	public List<utilisateur> listUtilisateur();
	public utilisateur chargerUtilisateur(long code);
	public boolean chnagerUtilisateur(long code, String type, String mail, String nom, String prenom, int tel, String mdp, long codeCgi, long codeUsine);

}
