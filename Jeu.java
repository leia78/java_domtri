import java.util.ArrayList;
import java.util.List;

public class Jeu {
	
	Joueur ListeJ[];
	int nbJ;
	
	public Jeu() {}
	
	
	//On envoie le nombre de joueurs pour initialiser la partie.
	
	public Jeu (int nbJ) {
		this.nbJ = nbJ;
		this.ListeJ = new Joueur[nbJ];
	}
	
	
	//POUR HELO
	//cette méthode vérifie si le coup est possible grâce aux deux pions cliqués
	//voir pdf AreteTriomino
	
	public boolean dispoArete(Pion p1, Pion p2) {
    	if((p2.libre[0] == true) && (p1.m_lnum.get(0)==p2.m_lnum.get(0)) && (p1.m_lnum.get(1)==p2.m_lnum.get(1)))
    	{
    		p2.libre[0] = false;
    		return true;
    	}
    	else if((p2.libre[1] == true) && (p1.m_lnum.get(1)==p2.m_lnum.get(1)) && (p1.m_lnum.get(2)==p2.m_lnum.get(2)))
    	{
    		p2.libre[0] = false;
    		return true;
    	}
    	else if((p2.libre[2] == true) && (p1.m_lnum.get(2)==p2.m_lnum.get(2)) && (p1.m_lnum.get(0)==p2.m_lnum.get(0)))
    	{
    		p2.libre[0] = false;
    		return true;
    	}
    	else
    		return false;	
    }
	
	
	//pas fini
	
	public void CalculCoupIA() {
		
		for(int i = 0; i < nbJ; i++)
		{
			for(int j = 0; j < ListeJ[i].m_lpion.size();j++)
			{
				
			}
	
		}
	}
	
	
	//pas fini
	
	public void AutoriseCoupIA() {

	}
	
	
}
