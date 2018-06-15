import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;


// Chaque domino est un bouton dans lequel, selon les valeurs, on dessine les points noirs et la barre 
public class Domino extends JButton implements ActionListener {
	
    private int val1;
    private int val2;
    private boolean jouableVal1;
    private boolean jouableVal2;
    private boolean domDouble;
    private Orientation orientation; // orientation par défaut du domino
    public static final int taille = 60; // taille du petit côté d'un domino
    public static final int diametrePt = taille/5; // diamètre d'un point noir sur le domino
    public static final int decalagePts = diametrePt + 5; // décalage entre les points
    Point reperePts; // repère en px où on commence à positionner les points d'un dominos
    private Point[][] posPtsDomino; // positions des 9 points qui peuvent se trouver sur un domino
    private Point pos; // Position du domino sur le plateau
    private PlateauDom plateauDom;
    private ArrayList<TriangleBtn> fleches;

    
    public Domino(int startVal1, int startVal2, PlateauDom plateauDom)
    {
    	this(startVal1, startVal2, Orientation.BAS, plateauDom);
    }
    
    public Domino(int startVal1, int startVal2, Orientation orientation, PlateauDom plateauDom)
    {
    	// INSTANCIATIONS

        val1 = startVal1;
        val2 = startVal2;
        jouableVal1 = true;
        jouableVal2 = true;
        if(val1 == val2)
        	domDouble=true;
        else
        	domDouble=false;
        posPtsDomino = new Point[3][3];
        pos = new Point(0,0);
        fleches = new ArrayList<TriangleBtn>();
        this.plateauDom = plateauDom;
        
        // ECOUTEURS
        this.addActionListener(this);
        
        
        // Initialisation du tableau de tous les points d'un domino
        
        initialiserPoints();
        
        // Paramétrage du bouton
        
        setBorderPainted(true);// true : affiche les bords du bouton
        setContentAreaFilled(false); // si true : affiche le ptit dégradé bleu des JButton et l'animation quand on clique
        setOpaque(false); // pas difficile à comprendre
        
        
        // Définition orientation et taille du domino
        
        setOrientation(orientation);
        
        
    }

    
    public void setOrientation(Orientation orientation)
    {
    	
    	this.orientation = orientation;
    	
    	switch(orientation)
    	{
    	case HAUT:
    		setSize(taille, taille*2);
//    		echangerValeurs();
    		break;
    	case BAS:
    		setSize(taille, taille*2);
    		break;
    	case GAUCHE:
    		setSize(taille*2, taille);
//    		echangerValeurs();
    		break;
    	case DROITE:
    		setSize(taille*2, taille);
    		break;
    	default:
    			System.out.println("Problème de paramétrage de l'orientation du domino");
    	}
    }
    
    
    
    
	// PAINT COMPONENT
    // Méthode qui s'exécute à chaque événement : passage de souris sur un composant, clic, redimensionnement...

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.black);
		
		
		// TEST AFFICHAGE DES POINTS
//        for(int i=0; i<3; i++)
//        {
//        	for(int j=0; j<3; j++)
//        	{
//        		g.fillOval(posPtsDomino[i][j].x, posPtsDomino[i][j].y, diametrePt, diametrePt);
//        	}
//        }
		
		
		// Dessinage des 2 côtés du domino et de la barre entre les 2 côtés
		
		paintDomino(g);
	}

	
	public void paintDomino(Graphics g)
	{
		// Dessinage des 2 côtés du domino et de la barre entre les 2 côtés :
		// à partir d'un repère, dessine le motif correspondant à la valeur.
		// Pour le 2eme côté, attention à incrémenter le repère selon l'orientation du domino
		
		int[] valeurs = {val1, val2};
		Point decalage = new Point(0,0);
		
		if(orientation == Orientation.HAUT || orientation == Orientation.GAUCHE)
		{
			int temp = valeurs[0];
			valeurs[0] = valeurs[1];
			valeurs[1] = temp;
//			System.out.println("Orientation " +orientation+ " : " +valeurs[0]+ "," + valeurs[1]);

		}
		
		for(int val : valeurs)
		{
//			System.out.println("val = " +val);
			switch(val)
			{
			case 1:
				g.fillOval(posPtsDomino[1][1].x + decalage.x, posPtsDomino[1][1].y + decalage.y, diametrePt, diametrePt);
				break;
			case 2:
				if(orientation == Orientation.BAS || orientation == Orientation.HAUT)
				{
					g.fillOval(posPtsDomino[2][0].x + decalage.x, posPtsDomino[2][0].y + decalage.y, diametrePt, diametrePt);
					g.fillOval(posPtsDomino[0][2].x + decalage.x, posPtsDomino[0][2].y + decalage.y, diametrePt, diametrePt);
				}
				else
				{
					g.fillOval(posPtsDomino[0][0].x + decalage.x, posPtsDomino[0][0].y + decalage.y, diametrePt, diametrePt);
					g.fillOval(posPtsDomino[2][2].x + decalage.x, posPtsDomino[2][2].y + decalage.y, diametrePt, diametrePt);
				}
				break;
			case 3:
				g.fillOval(posPtsDomino[1][1].x + decalage.x, posPtsDomino[1][1].y + decalage.y, diametrePt, diametrePt);

				if(orientation == Orientation.BAS || orientation == Orientation.HAUT)
				{
					g.fillOval(posPtsDomino[2][0].x + decalage.x, posPtsDomino[2][0].y + decalage.y, diametrePt, diametrePt);
					g.fillOval(posPtsDomino[0][2].x + decalage.x, posPtsDomino[0][2].y + decalage.y, diametrePt, diametrePt);
				}
				else
				{
					g.fillOval(posPtsDomino[0][0].x + decalage.x, posPtsDomino[0][0].y + decalage.y, diametrePt, diametrePt);
					g.fillOval(posPtsDomino[2][2].x + decalage.x, posPtsDomino[2][2].y + decalage.y, diametrePt, diametrePt);
				}

				break;
			case 4:
				g.fillOval(posPtsDomino[2][0].x + decalage.x, posPtsDomino[2][0].y + decalage.y, diametrePt, diametrePt);
				g.fillOval(posPtsDomino[0][2].x + decalage.x, posPtsDomino[0][2].y + decalage.y, diametrePt, diametrePt);
				g.fillOval(posPtsDomino[0][0].x + decalage.x, posPtsDomino[0][0].y + decalage.y, diametrePt, diametrePt);
				g.fillOval(posPtsDomino[2][2].x + decalage.x, posPtsDomino[2][2].y + decalage.y, diametrePt, diametrePt);
				break;
			case 5:
				g.fillOval(posPtsDomino[2][0].x + decalage.x, posPtsDomino[2][0].y + decalage.y, diametrePt, diametrePt);
				g.fillOval(posPtsDomino[0][2].x + decalage.x, posPtsDomino[0][2].y + decalage.y, diametrePt, diametrePt);
				g.fillOval(posPtsDomino[0][0].x + decalage.x, posPtsDomino[0][0].y + decalage.y, diametrePt, diametrePt);
				g.fillOval(posPtsDomino[2][2].x + decalage.x, posPtsDomino[2][2].y + decalage.y, diametrePt, diametrePt);
				g.fillOval(posPtsDomino[1][1].x + decalage.x, posPtsDomino[1][1].y + decalage.y, diametrePt, diametrePt);
				break;
			case 6:
				if(orientation == Orientation.BAS || orientation == Orientation.HAUT)
				{
					g.fillOval(posPtsDomino[0][0].x + decalage.x, posPtsDomino[0][0].y + decalage.y, diametrePt, diametrePt);
					g.fillOval(posPtsDomino[1][0].x + decalage.x, posPtsDomino[1][0].y + decalage.y, diametrePt, diametrePt);
					g.fillOval(posPtsDomino[2][0].x + decalage.x, posPtsDomino[2][0].y + decalage.y, diametrePt, diametrePt);
					g.fillOval(posPtsDomino[0][2].x + decalage.x, posPtsDomino[0][2].y + decalage.y, diametrePt, diametrePt);
					g.fillOval(posPtsDomino[1][2].x + decalage.x, posPtsDomino[1][2].y + decalage.y, diametrePt, diametrePt);
					g.fillOval(posPtsDomino[2][2].x + decalage.x, posPtsDomino[2][2].y + decalage.y, diametrePt, diametrePt);
				}
				else
				{
					g.fillOval(posPtsDomino[0][0].x + decalage.x, posPtsDomino[0][0].y + decalage.y, diametrePt, diametrePt);
					g.fillOval(posPtsDomino[0][1].x + decalage.x, posPtsDomino[0][1].y + decalage.y, diametrePt, diametrePt);
					g.fillOval(posPtsDomino[0][2].x + decalage.x, posPtsDomino[0][2].y + decalage.y, diametrePt, diametrePt);
					g.fillOval(posPtsDomino[2][0].x + decalage.x, posPtsDomino[2][0].y + decalage.y, diametrePt, diametrePt);
					g.fillOval(posPtsDomino[2][1].x + decalage.x, posPtsDomino[2][1].y + decalage.y, diametrePt, diametrePt);
					g.fillOval(posPtsDomino[2][2].x + decalage.x, posPtsDomino[2][2].y + decalage.y, diametrePt, diametrePt);					
				}
				break;
			}
			
			// Passage au 2eme côté du domino
			if(val == valeurs[0])
			{
				// Dessin de la barre et décalage vers le 2eme côté
				
				if(orientation == Orientation.HAUT || orientation == Orientation.BAS)
				{
					decalage.setLocation(0, taille);
					g.drawLine(reperePts.x, taille, taille-reperePts.x, taille);
				}
				else
				{
					decalage.setLocation(taille, 0);
					g.drawLine(taille, reperePts.y, taille, taille-reperePts.y);
				}
			}
		}

	}
	
	
	public void initialiserPoints()
	{
        reperePts = new Point(7, 7); // repère en px où on commence à positionner les points d'un domino
        
        for(int i=0; i<3; i++)
        {
        	for(int j=0; j<3; j++)
        	{
        		posPtsDomino[i][j] = new Point(reperePts.x + j*decalagePts, reperePts.x + i*decalagePts);
//        		System.out.println("[" +i+ "," +j+ "] vaut (" +posPtsDomino[i][j].x+ "," +posPtsDomino[i][j].y+ ")");
        	}
        }
	}
	
	
	public void echangerValeurs() {
		int temp;
		temp = val1;
		val1 = val2;
		val2 = temp;
	}
	
	public void echangerOrientation() {
		if(orientation == Orientation.BAS)
		{
			orientation = Orientation.HAUT;
		}
		else if(orientation == Orientation.HAUT)
		{
			orientation = Orientation.BAS;
		}
		else if(orientation == Orientation.GAUCHE)
		{
			orientation = Orientation.DROITE;
		}

		else if(orientation == Orientation.DROITE)
		{
			orientation = Orientation.GAUCHE;
		}
	}
	
	// ajoute les flèches au domino et les affiche autour du domino
	// /!\ ajoute également ces flèches à la lste des flèches dans le plateau (pour qu'elles soient regroupées)
	public void addFleches(Orientation orientation)
	{
		Point pos = new Point(0,0);
		
//		if(!isDomDouble())
//		{
			// Détermination du repère dans lequel on part pour placer nos flèches
			
			if(orientation == Orientation.DROITE) {
				pos.setLocation(this.pos.x + Domino.taille, this.pos.y);
			}
			else if(orientation == Orientation.BAS)
			{
				pos.setLocation(this.pos.x, this.pos.y + Domino.taille);
			}
			else
			{
				pos.setLocation(this.pos.x, this.pos.y);
			}
			
			System.out.println("Repère flèches : " +pos.x+ "," +pos.y);
				
			// Création des flèches
			
			if(orientation != Orientation.HAUT) { // ajout flèche bas
				fleches.add(new TriangleBtn(Orientation.BAS, this, new Point(pos.x, pos.y + Domino.taille))); // ajoute une fl1eche dans
				plateauDom.getListeFleches().add(fleches.get(fleches.size()-1)); // ajoute cette même flèche dans la liste des flèches du plateau
				plateauDom.add(fleches.get(fleches.size()-1)); // ajoute cette flèche aux composants du plateau
			}
			if(orientation != Orientation.BAS) { // ajout flèche haut
				fleches.add(new TriangleBtn(Orientation.HAUT, this, new Point(pos.x, pos.y - Domino.taille)));
				plateauDom.getListeFleches().add(fleches.get(fleches.size()-1)); // ajoute cette même flèche dans la liste des flèches du plateau
				plateauDom.add(fleches.get(fleches.size()-1));
			}
			if(orientation != Orientation.GAUCHE) { // ajout flèche droite
				fleches.add(new TriangleBtn(Orientation.DROITE, this, new Point(pos.x + Domino.taille, pos.y)));
				plateauDom.getListeFleches().add(fleches.get(fleches.size()-1)); // ajoute cette même flèche dans la liste des flèches du plateau
				plateauDom.add(fleches.get(fleches.size()-1));
			}
			if(orientation != Orientation.DROITE) { // ajout flèche gauche
				fleches.add(new TriangleBtn(Orientation.GAUCHE, this, new Point(pos.x - Domino.taille, pos.y)));
				plateauDom.getListeFleches().add(fleches.get(fleches.size()-1)); // ajoute cette même flèche dans la liste des flèches du plateau
				plateauDom.add(fleches.get(fleches.size()-1));
			}
//		}
//		else // si c'est un double
//		{
//			pos.setLocation(this.pos);
//			
//			if(orientation == Orientation.GAUCHE)
//			{
//				if(jouableVal2)
//				{
//					fleches.add(new TriangleBtn(Orientation.GAUCHE, this, new Point(pos.x - Domino.taille, pos.y)));
//					plateauDom.getListeFleches().add(fleches.get(fleches.size()-1)); // ajoute cette même flèche dans la liste des flèches du plateau
//					plateauDom.add(fleches.get(fleches.size()-1));
//				}
//				
//				if(jouableVal1)
//				{
//					fleches.add(new TriangleBtn(Orientation.DROITE, this, new Point(pos.x + 2*Domino.taille, pos.y)));
//					plateauDom.getListeFleches().add(fleches.get(fleches.size()-1)); // ajoute cette même flèche dans la liste des flèches du plateau
//					plateauDom.add(fleches.get(fleches.size()-1));
//				}
//			}
//			else if(orientation == Orientation.DROITE)
//			{
//				if(jouableVal2)
//				{
//					fleches.add(new TriangleBtn(Orientation.DROITE, this, new Point(pos.x + 2*Domino.taille, pos.y)));
//					plateauDom.getListeFleches().add(fleches.get(fleches.size()-1)); // ajoute cette même flèche dans la liste des flèches du plateau
//					plateauDom.add(fleches.get(fleches.size()-1));
//				}
//				
//				if(jouableVal1)
//				{
//					fleches.add(new TriangleBtn(Orientation.GAUCHE, this, new Point(pos.x - Domino.taille, pos.y)));
//					plateauDom.getListeFleches().add(fleches.get(fleches.size()-1)); // ajoute cette même flèche dans la liste des flèches du plateau
//					plateauDom.add(fleches.get(fleches.size()-1));
//				}
//			}
//			else if(orientation == Orientation.HAUT)
//			{
//				if(jouableVal2)
//				{
//					fleches.add(new TriangleBtn(Orientation.HAUT, this, new Point(pos.x, pos.y - Domino.taille)));
//					plateauDom.getListeFleches().add(fleches.get(fleches.size()-1)); // ajoute cette même flèche dans la liste des flèches du plateau
//					plateauDom.add(fleches.get(fleches.size()-1));
//				}
//				
//				if(jouableVal1)
//				{
//					fleches.add(new TriangleBtn(Orientation.BAS, this, new Point(pos.x, pos.y + 2*Domino.taille)));
//					plateauDom.getListeFleches().add(fleches.get(fleches.size()-1)); // ajoute cette même flèche dans la liste des flèches du plateau
//					plateauDom.add(fleches.get(fleches.size()-1));
//				}
//			}
//			else // Orientation == BAS
//			{
//				if(jouableVal2)
//				{
//					fleches.add(new TriangleBtn(Orientation.BAS, this, new Point(pos.x, pos.y + 2*Domino.taille)));
//					plateauDom.getListeFleches().add(fleches.get(fleches.size()-1)); // ajoute cette même flèche dans la liste des flèches du plateau
//					plateauDom.add(fleches.get(fleches.size()-1));
//				}
//				
//				if(jouableVal1)
//				{
//					fleches.add(new TriangleBtn(Orientation.HAUT, this, new Point(pos.x, pos.y - Domino.taille)));
//					plateauDom.getListeFleches().add(fleches.get(fleches.size()-1)); // ajoute cette même flèche dans la liste des flèches du plateau
//					plateauDom.add(fleches.get(fleches.size()-1));
//				}
//			}
//		}
	}
	
	// poser le domino à une certaine position sur le plateau
	
	void poserDomino(Point pos, Orientation orientation)
	{
		setPos(pos);
		setLocation(pos);
		setOrientation(orientation);
		jouableVal1 = false;
		jouableVal2 = true;
		setEnabled(false); // désactive le bouton
		
		plateauDom.add(this);
		plateauDom.revalidate();
		plateauDom.repaint();

	}

	
	// Recherche des dominos jouables sur le plateau et ajout des flèches
	
    public void dom_click(Domino dom)
    {
    	for(Domino domPlateau : plateauDom.getDominoPlateau())
    	{    		
    		domPlateau.afficherDomino();
    		
    		if( domPlateau.isJouableVal1() && 
    				(domPlateau.getVal1() == dom.getVal1() || domPlateau.getVal1() == dom.getVal2()) )
    		{
    			domPlateau.addFleches(orientationInverse(domPlateau.getOrientation()));
    		}
    		
    		if( domPlateau.isJouableVal2() && 
    				(domPlateau.getVal2() == dom.getVal1() || domPlateau.getVal2() == dom.getVal2()) )
    		{
    			domPlateau.addFleches(domPlateau.getOrientation());
    		}
    	}
    	
    	
    	
//    	int[] valTab = {dom.getVal1(), dom.getVal2()};
//
//        for (Domino domi : plateauDom.getDominoPlateau())
//        {
//        	for(int val : valTab)
//        	{
//                if (domi.isJouableVal1() && domi.getVal1() == val)
//        		{
//                	domi.addFleches();
//        		}
//                	
//                if(domi.isJouableVal2() && domi.getVal2() == val)
//                {
//                    domi.addFleches();
//                }
//        	}
//        }
    }
    
    
    public Orientation orientationInverse(Orientation orientation)
    {
    	Orientation ok = Orientation.BAS;
    	
    	if(orientation == Orientation.BAS)
    		ok = Orientation.HAUT;
    	else if(orientation == Orientation.HAUT)
    		ok = Orientation.BAS;
    	else if(orientation == Orientation.GAUCHE)
    		ok = Orientation.DROITE;
    	else if(orientation == Orientation.DROITE)
    		ok = Orientation.GAUCHE;
    	
    	return ok;
    }
    
    
    public void afficherDomino()
    {
    	String orientStr = "PAS D'ORIENTATION";
    	if(orientation == Orientation.BAS)
    		orientStr = "BAS";
    	else if(orientation == Orientation.HAUT)
    		orientStr = "HAUT";
    	else if(orientation == Orientation.GAUCHE)
    		orientStr = "GAUCHE";
    	else if(orientation == Orientation.DROITE)
    		orientStr = "DROITE";
    	
    	System.out.println(orientStr+ " : " +val1+ "," +val2);
    }
    

	
	// ACTION DU CLIC
	
	public void actionPerformed(ActionEvent arg0) {
		
//		System.out.println("Clic sur domino !");
		
		plateauDom.setSelectedDomino(this);
		System.out.println("Domino sélectionné : " +plateauDom.getSelectedDomino().getVal1()+ "," +plateauDom.getSelectedDomino().getVal2());
		
		// Ajout des flèches
		
		dom_click(this);
//		plateauDom.getDomi().addFleches();
		plateauDom.repaint();
		plateauDom.invalidate();		
	}
	
	
    public boolean isDouble()
    {
        if (val1 == val2)
            return true;
        else
            return false;
    }
    

    public int getVal1()
    {
        return val1;
    }

    public int getVal2()
    {
        return val2;
    }
    
	public void setVal1(int val1) {
		this.val1 = val1;
	}

	public void setVal2(int val2) {
		this.val2 = val2;
	}


	public PlateauDom getPlateauDom() {
		return plateauDom;
	}

	public void setPlateauDom(PlateauDom plateauDom) {
		this.plateauDom = plateauDom;
	}

	public Point getPos() {
		return pos;
	}

	public void setPos(Point pos) {
		this.pos = pos;
	}
	
	public void setPos(int x, int y) {
		this.pos.x = x;
		this.pos.y = y;
	}


	public Orientation getOrientation() {
		return orientation;
	}

	public boolean isJouableVal1() {
		return jouableVal1;
	}

	public void setJouableVal1(boolean jouableVal1) {
		this.jouableVal1 = jouableVal1;
	}

	public boolean isJouableVal2() {
		return jouableVal2;
	}

	public void setJouableVal2(boolean jouableVal2) {
		this.jouableVal2 = jouableVal2;
	}

	public boolean isDomDouble() {
		return domDouble;
	}

	public void setDomDouble(boolean domDouble) {
		this.domDouble = domDouble;
	}
	
	

} 