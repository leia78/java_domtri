import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
 
class MaFenetre extends JFrame
{
	public MaFenetre()
	{
		setTitle("titre");
		setBounds(0,0,1100,900);
		
		JPanel pan = new JPanel();
		Container page = getContentPane();

		page.setLayout(new BorderLayout());
		pan.setLayout(new FlowLayout());

		Joueur j1 = new Joueur("Helo");
		Pion pion = new Pion();
		BoutonTrio[] bouton = new BoutonTrio[9];
		for(int i=0; i<9; i++)
		{
			pion = j1.m_lpion.get(i);
			int un = pion.m_lnum.get(0);
			int deux = pion.m_lnum.get(1);
			int trois = pion.m_lnum.get(3);
			bouton[i] = new BoutonTrio(""+i,"00_helo/"+un+"_"+deux+"_"+trois+".png");
			bouton[i].setPreferredSize(new Dimension(75, 75));
			bouton[i].setBorderPainted(false);
			pan.add(bouton[i]);
			
		}
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
		System.out.println(j1.m_lpion.get(0).m_lnum.get(0));
		
		MaFenetre fen = new MaFenetre();
		fen.setVisible(true);
	}
}