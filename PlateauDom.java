import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlateauDom extends JPanel {
	
	
	private Fenetre fenetre;
	private Dimension dimension; // dimension de la fenêtre
	private Domino selectedDomino;
	private ArrayList<TriangleBtn> listeFleches;
	private PiocheD pioche;
	private ArrayList<Player> listePlayer;
	private Player playerCourant; // joueur à qui c'est le tour 
	private int indicePlayer; // indice du joueur courant dans la liste de joueurs
	public static final Point repereCentre = new Point(Fenetre.dimension.width/2 - Domino.taille, Fenetre.dimension.height/2 - 2*Domino.taille);
	private ArrayList<Domino> dominoPlateau;
	private JButton piocheBtn;
	private JButton finTourBtn;




	public PlateauDom(Fenetre fenetre) {
		
		// INSTANCIATIONS
		
		this.fenetre = fenetre;
		dimension = new Dimension(Fenetre.dimension);
		listeFleches = new ArrayList<TriangleBtn>();
		pioche = new PiocheD(this);
		listePlayer = new ArrayList<Player>();
		dominoPlateau = new ArrayList<Domino>();
		piocheBtn = new JButton("Piocher");
		finTourBtn = new JButton("Fin du tour");
		
		// Paramétrage du plateau
		
		setSize(dimension);
		setLayout(null);
		
		piocheBtn.setBounds(11*dimension.width/15, 12*dimension.height/15, 100, 40);
		add(piocheBtn);
		
		finTourBtn.setBounds(10*dimension.width/15 +70, 13*dimension.height/15, 150, 40);
		add(finTourBtn);

		
		// TESTS
		
		
		listePlayer.add(new Player(pioche, "Zak", this));
		listePlayer.add(new Player(pioche, "Jalul", this));
		
		playerCourant = listePlayer.get(0);
		
		printList(playerCourant.getHand_list());
		
		dominoPlateau.add(new Domino(3, 5, Orientation.GAUCHE, this));
		dominoPlateau.add(new Domino(0, 6, Orientation.DROITE, this));
		dominoPlateau.add(new Domino(1, 4, Orientation.HAUT, this));
		dominoPlateau.add(new Domino(2, 2, Orientation.BAS, this));


		
		Point pos = new Point(200, 300);
		for(Domino dom : dominoPlateau)
		{
			dom.setPos(pos.x, pos.y);
			dom.poserDomino(dom.getPos(), dom.getOrientation());
			pos.setLocation(pos.x + 300, pos.y);
		}
		
//		dominoPlateau.get(0).afficherDomino();
//		dominoPlateau.get(0).addFleches(Orientation.DROITE);

		
		
		
		// Calcul du joueur qui commence
		
//		indicePlayer = find_first(listePlayer);
//		playerCourant = listePlayer.get(indicePlayer);
		
		
		// Pose du plus grand double sur le terrain
		
//		selectedDomino = returnBestDouble(playerCourant);
//		dominoPlateau.add(selectedDomino); // ajout dans les dominos du plateau
//		selectedDomino.poserDomino(repereCentre, Orientation.DROITE);
//		selectedDomino.setJouableVal1(true);
//		selectedDomino.setJouableVal2(true);
////		System.out.println("Pose du domino à " +repereCentre.x+ "," +repereCentre.y);
//		playerCourant.getHand_list().remove(selectedDomino); // suppression dans les dominos du joueur
		
		
		// BOUCLE DE JEU
		
		// Changement de main
		
//		indicePlayer = (indicePlayer+1)%listePlayer.size();
//		playerCourant = listePlayer.get(indicePlayer);
//		printList(playerCourant.getHand_list());

		
		
		
		
				
						

		
	}
	
	
	// Affiche la liste de dominos d'un joueur sur la fenêtre en partant d'une position de départ
	public void printList(ArrayList<Domino> list) {
		Point repere = new Point(dimension.width/10, 4*dimension.height/5);
		int decalage = Domino.taille + 40;
		
		for(Domino dom : list) {
			dom.setPos(new Point(repere.x, repere.y));
			dom.setLocation(dom.getPos());
			add(dom);
			repere.setLocation(repere.getX() + decalage, repere.getY());
		}
		
	}
	
	
	
	
	
	// renvoie l'indice dans listeJoueurs du joueur qui possède le + grand double
	
    private int find_first(ArrayList<Player> player_list)
    {
        for (int i = 6; i >= 0; i--)
        {
            int nb = 0;
            for (Player player : player_list)
            {
                for (Domino dom : player.getHand_list())
                {
                    if (dom.getVal1() == i && dom.getVal2() == i)
                    {
                        return nb;
                    }
                }
                ++nb;
            }
        }
        return (-1);
    }
    
    
    // retourne le meilleur double de la liste d'un joueur
    
    private Domino returnBestDouble(Player player)
    {
        int max_double = 0;
        Domino max_dom = new Domino(0, 0, this);
        for(Domino dom : player.getHand_list())
        {
            if (dom.isDouble())
            {
                if (max_double <= dom.getVal1())
                {
                    max_double = dom.getVal1();
                    max_dom = dom;
                }
            }
        }
        System.out.println(max_dom.getVal1() + " : " + max_dom.getVal2());
        //player.play_domino(max_dom);
        return max_dom;
    }	
	
	
	
	// PAINT COMPONENT


	public void paintComponent(Graphics g) {
		super.paintComponent(g);
				
		g.setColor(Color.white);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
//		g.setColor(Color.BLACK);
//		g.fillOval(120, 120, 50, 50);
	}
	


	public Dimension getDimension() {
		return dimension;
	}

	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}
	
	public Domino getSelectedDomino() {
		return selectedDomino;
	}

	public void setSelectedDomino(Domino selectedDomino) {
		this.selectedDomino = selectedDomino;
	}

	public ArrayList<TriangleBtn> getListeFleches() {
		return listeFleches;
	}

	public void setListeFleches(ArrayList<TriangleBtn> listeFleches) {
		this.listeFleches = listeFleches;
	}


	public Player getPlayerCourant() {
		return playerCourant;
	}


	public void setPlayerCourant(Player playerCourant) {
		this.playerCourant = playerCourant;
	}


	public ArrayList<Domino> getDominoPlateau() {
		return dominoPlateau;
	}


	public void setDominoPlateau(ArrayList<Domino> dominoPlateau) {
		this.dominoPlateau = dominoPlateau;
	}


}
