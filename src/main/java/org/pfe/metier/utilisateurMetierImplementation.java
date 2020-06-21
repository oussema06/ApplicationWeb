package org.pfe.metier;

import java.util.List;

import org.pfe.dao.CGIRepository;
import org.pfe.dao.usineRepository;
import org.pfe.dao.utilisateurRepository;
import org.pfe.entities.CGI;
import org.pfe.entities.GPB;
import org.pfe.entities.admin;
import org.pfe.entities.agent_CGI;
import org.pfe.entities.superviseur_financier;
import org.pfe.entities.usine;
import org.pfe.entities.utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public  class utilisateurMetierImplementation implements  utilisateurMetier {
	
	@Autowired
    private utilisateurRepository utilisateurRepository;
	
	@Autowired
    private usineRepository usineRepository;
	
	@Autowired
    private CGIRepository CGIRepository;
    
	@Override
	public utilisateur ajoutUtilisateur(utilisateur U) {
		// TODO Auto-generated method stub
		return utilisateurRepository.save(U);
	}

	@Override
	public List<utilisateur> listUtilisateur() {
		// TODO Auto-generated method stub
		return utilisateurRepository.findAll();
	}
	
	@Override
	public utilisateur chargerUtilisateur(long code) {
		return utilisateurRepository.findOne(code);
	}

	@Override
	@Transactional
	public boolean chnagerUtilisateur(long code, String type, String mail, String nom, String prenom, int tel,
			String mdp, long codeCgi, long codeUsine) {
		utilisateur u1 = utilisateurRepository.findOne(code);
		
	
		u1.setEmail(mail);
		u1.setNom(nom);
		u1.setPrenom(prenom);
		u1.setTel(tel);
		
		
		if (type == "admin"){
			admin a = new admin();
			a.setEmail(mail);
			a.setNom(nom);
			a.setPrenom(prenom);
			a.setTel(tel);
			a.setMdp(mdp);
			
			utilisateur u = utilisateurRepository.findOne(code);
			
			u = a;
			u.setNom(nom);
			
			
		}
		else if (type == "GPB"){
			GPB g = new GPB();
			g.setEmail(mail);
			g.setNom(nom);
			g.setPrenom(prenom);
			g.setTel(tel);
			g.setMdp(mdp);
			
			usine us = usineRepository.findOne(codeUsine);
			g.setUsine(us);
			
			utilisateur u = utilisateurRepository.findOne(code);
			
			u = g;
		}else if (type == "agent_CGI"){ 
			agent_CGI ag = new agent_CGI();
			ag.setEmail(mail);
			ag.setNom(nom);
			ag.setPrenom(prenom);
			ag.setTel(tel);
			ag.setMdp(mdp);
			
			CGI cgi = CGIRepository.findOne(codeCgi);
			ag.setCGI(cgi);
			
			utilisateur u = utilisateurRepository.findOne(code);
			
			u = ag;
		}else if ( type == "superviseur_financier"){
			superviseur_financier s = new superviseur_financier();
			s.setEmail(mail);
			s.setNom(nom);
			s.setPrenom(prenom);
			s.setTel(tel);
			s.setMdp(mdp);
			
			usine us = usineRepository.findOne(codeUsine);
			s.setUsine(us);
			
			utilisateur u = utilisateurRepository.findOne(code);
			
			u = s;

		}
		
		return true;
	}

}
