import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JPanel;

// Écran qui fait la transition entre les tours des joueurs

public class TransitionTour extends JPanel{
	
	private JButton nextBtn;
	private Dimension dimension;
	private Fenetre fenetre;
	
	
	
	public TransitionTour(Player player, Fenetre fenetre) {
		
		String txtBtn = player.getName() + ", à toi de jouer !";
		
		this.fenetre = fenetre;
		nextBtn = new JButton(txtBtn);
		dimension = new Dimension(fenetre.getDimension());
		
		
		setLayout(null);
		
		nextBtn.setBounds(dimension.width/3, dimension.height/3, dimension.width/3, 60);
		add(nextBtn);
	}
	
	
	// PAINT COMPONENT

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
				
		g.setColor(Color.white);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());		
	}


	public JButton getNextBtn() {
		return nextBtn;
	}


	public void setNextBtn(JButton nextBtn) {
		this.nextBtn = nextBtn;
	}
	
	
}
