package org.pfe.metier;

import java.util.List;

import org.pfe.entities.CGI;
import org.pfe.entities.bordereau_de_livraison;
import org.pfe.entities.client;




public interface CGIMetier {
	
	public CGI ajoutCGI(CGI C);
	public List<CGI> listCGI();
	public CGI chargerCGI(long code);
	public List<client> listClient(long codeCGI);
	public List<bordereau_de_livraison> listBordereau(long code);

}
