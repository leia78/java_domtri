import java.util.ArrayList;
import java.util.List;

public class Jeu {
	
	Clic clicJoue = new Clic();
	Clic clicJeu = new Clic();
	
	List<Joueur> ListeJ = new ArrayList<Joueur>();
	
	
	public Jeu () {}
	
	public boolean AutoriseCoupJ() {
		Pion pionJoue = clicJoue.getPion();
		Pion pionJeu = clicJeu.getPion();
		
		
		
		
		/*if ((pionJoue.m_lnum.get(0) == pionJeu.m_lnum.get(0)) && (pionJoue.m_lnum.get(1) == pionJeu.m_lnum.get(1)))
			return true;
		else if ((pionJoue.m_lnum.get(0) == pionJeu.m_lnum.get(0)) && (pionJoue.m_lnum.get(2) == pionJeu.m_lnum.get(2)))
			return true;
		else if ((pionJoue.m_lnum.get(1) == pionJeu.m_lnum.get(1)) && (pionJoue.m_lnum.get(2) == pionJeu.m_lnum.get(2)))
			return true;*/
	}
	
	public void CalculCoupIA() {
		
		for(int i = 0; i < ListeJ.size(); i++)
		{
			for(int j = 0; j < ListeJ.get(i).m_lpion.size();j++)
			{
				
			}
	
		}
	}
	
	public void AutoriseCoupIA() {
		clicJoue.getPiece();
		clicJeu.getPiece();
	}
	
	
	public void coteDispo(Pion pionJoue, Pion pionJeu)
	{
		
	}
	
}
