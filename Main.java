import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
 
class MaFenetre extends JFrame
{
	public MaFenetre(ArrayList<Pion> listPion)
	{
		setTitle("titre");
		setBounds(0,0,1100,900);
		
		JPanel pan = new JPanel();
		Container page = getContentPane();

		page.setLayout(new BorderLayout());
		pan.setLayout(new FlowLayout());

		BoutonTrio[] trio = new BoutonTrio[7];
		BoutonPioche pioche = new BoutonPioche();
		/*Joueur j1 = new Joueur("helo");
		ArrayList<Pion> listPion = j1.getM_lpion();*/
		
		for(int i=0; i<7; i++)
		{
			int un = listPion.get(i).m_lnum.get(0);
			int deux = listPion.get(i).m_lnum.get(1);
			int trois = listPion.get(i).m_lnum.get(2);
			trio[i] = new BoutonTrio(""+i,"00_helo/"+un+"_"+deux+"_"+trois+".png");
			pan.add(trio[i]);
			
		}
		page.add(pioche);
		page.add(pan,BorderLayout.SOUTH);	
	}
}

public class Main
{
	public static void main(String args[])
	{
		Joueur j1 = new Joueur("Helo");
		Pioche p = new Pioche(2);
		p.initlistetrio();
		j1.m_lpion=p.distrib();
		//System.out.println(j1.m_lpion.get(0).m_lnum.get(1));//
		
		MaFenetre fen = new MaFenetre(j1.m_lpion);
		fen.setVisible(true);
	}
}