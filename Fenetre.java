import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Fenetre extends JFrame {
	
	private PlateauDom plateauDom;
	private TransitionTour transitionTour;
	public static final Dimension dimension = new Dimension(1400,1000);

	public Fenetre()
	{		
		// INSTANCIATIONS
		
		plateauDom = new PlateauDom(this);
		transitionTour = new TransitionTour(plateauDom.getPlayerCourant(), this);
		
		
		// ECOUTEURS

		transitionTour.getNextBtn().addActionListener(new TransitionBtn());
		// bouton de fin de tour
		

		// INITIALISATION DE LA FENETRE
		
		this.setTitle("Domino Day"); // titre de la fenêtre
		this.setSize(dimension); // largeur & hauteur
		this.setLocationRelativeTo(null); // centrer la fenêtre
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // dire que la croix ferme le processus
		
		
		this.afficherEcran(plateauDom); // définir container en tant que contenu "principal"
		setBackground(Color.PINK);
	}
	
	
	public void afficherEcran(JPanel ecran) {
		setContentPane(ecran);
		repaint();
		invalidate();
		setVisible(true); // TRES IMPORTANT
	}
	
	
	// BOUTONS
	
	public class TransitionBtn implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			afficherEcran(plateauDom);
		}
	}

	
	// GETTERS ET SETTERS

	public Dimension getDimension() {
		return dimension;
	}


	
	

}
