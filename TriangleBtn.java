import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

// Bouton qui contient un triangle orientié selon une certaine direction

public class TriangleBtn extends JButton implements ActionListener {
	
	private Orientation orientation = Orientation.HAUT;
	private Point pos; // position de la flèche dans la fenêtre
	private Domino domino;
	

	public TriangleBtn(Orientation orientation, Domino domino) {
		
		// INSTANCIATIONS
		
		this.orientation = orientation;
		pos = new Point(0,0);
		this.domino = domino;
		
        setBorderPainted(false);// true : affiche les bords du bouton
        setContentAreaFilled(false); // si true : affiche le ptit dégradé bleu des JButton et l'animation quand on clique
        setOpaque(false); // pas difficile à comprendre
        
        // ÉCOUTEURS
        
        addActionListener(this);

		setSize(Domino.taille, Domino.taille);
		setLocation(pos);
	}
	
	public TriangleBtn(Orientation orientation, Domino domino, Point pos) {
		this(orientation, domino);
		
		this.pos = pos;
		setLocation(this.pos);
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.green);
		
		// Dessin du triangle
		// Le premier point est la pointe du triangle
		
		int[] xPts = new int[3];
		int[] yPts = new int[3];
		
		if(orientation == Orientation.HAUT) {
			xPts[0] = Domino.taille/2;
			xPts[1] = Domino.taille/4;
			xPts[2] = 3*Domino.taille/4;
			yPts[0] = Domino.taille/3;
			yPts[1] = 2*Domino.taille/3;
			yPts[2] = yPts[1];
			
		}
		else if(orientation == Orientation.BAS) {
			xPts[0] = Domino.taille/2;
			xPts[1] = Domino.taille/4;
			xPts[2] = 3*Domino.taille/4;
			yPts[0] = 2*Domino.taille/3;
			yPts[1] = Domino.taille/3;
			yPts[2] = yPts[1];
		}
		else if(orientation == Orientation.DROITE) {
			yPts[0] = Domino.taille/2;
			yPts[1] = Domino.taille/4;
			yPts[2] = 3*Domino.taille/4;
			xPts[0] = 2*Domino.taille/3;
			xPts[1] = Domino.taille/3;
			xPts[2] = xPts[1];
		}
		else { // GAUCHE
			yPts[0] = Domino.taille/2;
			yPts[1] = Domino.taille/4;
			yPts[2] = 3*Domino.taille/4;
			xPts[0] = Domino.taille/3;
			xPts[1] = 2*Domino.taille/3;
			xPts[2] = xPts[1];
		}
		
		g.fillPolygon(xPts, yPts, 3);

	}
	
	
	// CLIC SUR BOUTON
	
	public void actionPerformed(ActionEvent arg0) {
		
		Point pos = new Point(this.pos);
		Domino selectedDom = domino.getPlateauDom().getSelectedDomino();
		System.out.println("Clic sur triangle !");
		
		if(selectedDom != null)
		{
			// Translation vers la position où sera posé le domino (si besoin)
			
			if(orientation == Orientation.GAUCHE)
			{
				pos.setLocation(pos.x - Domino.taille, pos.y);
			}
			else if(orientation == Orientation.HAUT)
			{
				pos.setLocation(pos.x, pos.y - Domino.taille);
			}
			
			// Positionnement du domino
			
			selectedDom.poserDomino(pos, orientation);
			
			// Échange des valeurs si besoin
			
//			if()
			
			System.out.println(selectedDom.getVal1()+ "," +selectedDom.getVal2()+ " : " +selectedDom.isJouableVal1()+ "," +selectedDom.isJouableVal2());
			
			// Le domino précédent n'est plus jouable d'un côté
			
			if(domino.isDomDouble())
			{
				if(domino.getOrientation() == orientation)
				{
					domino.setJouableVal2(false);
				}
				else
				{
					domino.setJouableVal1(false);
				}
			}
			else
			{
				domino.setJouableVal2(false);
			}
			System.out.println(domino.getVal1()+ "," +domino.getVal2()+ " : " +domino.isJouableVal1()+ "," +domino.isJouableVal2());

			
			// Effacement de toutes les flèches
			
			PlateauDom plateauDom = domino.getPlateauDom();
			
			for(TriangleBtn fleche : plateauDom.getListeFleches())
			{
				plateauDom.remove(fleche);
			}
			
			System.out.println("Effacement des éléments");
			plateauDom.getListeFleches().clear();
			plateauDom.revalidate();
			plateauDom.repaint();

		}
		else
		{
			System.out.println("Pas de domino sélectionné !");
		}
		
	}


}
