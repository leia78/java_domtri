import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
 
class MaFenetre extends JFrame implements MouseListener
{
	String nomPionClic;
	int taille=10;
	BoutonTrio[] trio = new BoutonTrio[taille];
	BoutonPioche Bpioche = new BoutonPioche();
	
	public MaFenetre(ArrayList<Pion> listPion, ArrayList<Pion> pioche)
	{
		this.taille = listPion.size();
		setTitle("titre");
		setBounds(0,0,1100,900);
		
		JPanel pan = new JPanel();
		Container page = getContentPane();

		page.setLayout(new BorderLayout());
		pan.setLayout(new FlowLayout());

		
		for(int i=0; i<taille; i++)
		{
			//AFFICHAGE PIONS TRIO
			int un = listPion.get(i).m_lnum.get(0);
			int deux = listPion.get(i).m_lnum.get(1);
			int trois = listPion.get(i).m_lnum.get(2);
			trio[i] = new BoutonTrio(""+i,"00_helo/"+un+"_"+deux+"_"+trois);
			
			//CLIC SOURIS
			trio[i].addMouseListener(this);
			
			pan.add(trio[i]);
		}
		
		//AFFICHAGE PIOCHE
		if(!pioche.isEmpty())
			page.add(Bpioche);
		
		page.add(pan,BorderLayout.SOUTH);	
	}
	
	
	public void mousePressed(MouseEvent evt) { // clic droit souris
		
		BoutonTrio b = (BoutonTrio)evt.getSource(); // on recupère le bouton cliqué
		nomPionClic = b.nomPion ;
		
		//new BoutonRotation(nomPionClic);

		System.out.println("Cliqué par bouton "+nomPionClic);
	}
	public void mouseReleased(MouseEvent arg0) {}
	public void mouseClicked(MouseEvent arg0) {}
	public void mouseEntered(MouseEvent arg0) {}
	public void mouseExited(MouseEvent arg0) {}
	/*
	public void rotation(String nom){
		System.out.println("rotation : "+nom);

	}*/
	
}

public class Main
{
	public static void main(String args[])
	{
		Joueur j1 = new Joueur("Helo");
		Pioche p = new Pioche(3);
		p.initlistetrio();
		j1.m_lpion=p.distrib();
		
		MaFenetre fen = new MaFenetre(j1.m_lpion, p.m_lpioche);
		fen.setVisible(true);
	}
}