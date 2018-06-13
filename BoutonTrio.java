import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;


public class BoutonTrio extends JButton implements MouseListener{

	String nomPion;
	String nomPionClic=null;
	String chemin;
	BufferedImage image;
	MaFenetre fen;
	public BoutonTrio(){}
	
	public BoutonTrio(String nom, String chemin){
		this.nomPion = nom;
		this.chemin = chemin;

		try {
			image = ImageIO.read(new File(chemin+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setPreferredSize(new Dimension(75, 75));
		this.setBorderPainted(false);
		this.addMouseListener(this);
	}
		
	public void paintComponent(Graphics g){
		g.drawImage(image, 0, 0, null);
	}

	public void mouseClicked(MouseEvent arg0) {}
	public void mouseEntered(MouseEvent arg0) {}
	public void mouseExited(MouseEvent arg0) {}
	public void mousePressed(MouseEvent evt) { // clic droit
		try {
			image = ImageIO.read(new File(chemin+"g"+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void mouseReleased(MouseEvent arg0) {}
}
