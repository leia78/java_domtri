import javax.swing.JFrame;


public class main {

	
	
	public static void main(String[] args) {
		JFrame fenetre = new JFrame();
        
	    fenetre.setTitle("Ma première fenêtre Java");
	    fenetre.setSize(1000, 800);
	    fenetre.setLocationRelativeTo(null);
	    fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    fenetre.setContentPane(new Trio());
	    fenetre.setVisible(true);
	}

}
