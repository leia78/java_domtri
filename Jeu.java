import java.util.ArrayList;
import java.util.List;

public class Jeu {
	
	Joueur ListeJ[];
	ArrayList<Pion> pionsPoses = new ArrayList<Pion>();
	int nbJ;
	
	public Jeu() {}
	
	//On envoie le nombre de joueurs pour initialiser la partie.
	
	public Jeu (int nbJ) {
		this.nbJ = nbJ;
		this.ListeJ = new Joueur[nbJ];
	}
	
	
	
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
	
	
	public Pion CoupIA(int numJ) {
		
		Pion p1 = new Pion();
		Pion p2 = new Pion();
		Pion retour = new Pion();
		
		for(int i = 0; i < pionsPoses.size();i++)
		{
			p1 = pionsPoses.get(i);
			for(int j = 0; j < ListeJ[numJ].m_lpion.size();j++)
			{
				p2 = ListeJ[numJ].m_lpion.get(j);
				
				if (dispoArete(p1,p2))
					retour = p2;
				else
					retour = p1;
			}
		}
		
		
		//dans la fonction affichage il faudra faire attention que retour ne soit pas vide,
		//ce qui signifierait qu'aucun pion sur le plateau n'est compatible avec le jeu de l'IA.
		
		return retour;
	}
}
