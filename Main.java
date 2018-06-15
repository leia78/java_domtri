import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
 
//from cyrine
/*public class Main {
	public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				Menu frame = new Menu();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
				}
			}
		});
	}
}*/

//from helo

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

		Jeu plateau = new Jeu();
		BoutonTrio[] trio = new BoutonTrio[7];
		BoutonPioche pioche = new BoutonPioche();
		
		for(int i=0; i<7; i++)
		{
			//listPion.get(i) c'est le pion qui apparait
			int un = listPion.get(i).m_lnum.get(0);
			int deux = listPion.get(i).m_lnum.get(1);
			int trois = listPion.get(i).m_lnum.get(2);
			//trio[i] = new BoutonTrio(listPion.get(i),""+i,"00_helo/"+un+"_"+deux+"_"+trois+".png");
			trio[i] = new BoutonTrio(listPion.get(i),""+i,"00_helo/"+un+"_"+deux+"_"+trois+".png");
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
		PiocheT p = new PiocheT(2);
		int stop=0;
		p.initlistetrio();
		j1.m_lpion=p.distrib();
		//System.out.println(j1.m_lpion.get(0).m_lnum.get(1));//
		
		
		MaFenetre fen = new MaFenetre(j1.m_lpion);
		fen.setVisible(true);
		
	}
}
