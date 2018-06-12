import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;


public class BoutonTrio extends JButton implements ActionListener{

	String nomPion;
	String chemin;
	BufferedImage image;

	public BoutonTrio(String nom, String chemin){
		this.nomPion = nom;
		this.chemin = chemin;
		//System.out.println(this.chemin);

		try {
			image = ImageIO.read(new File(chemin));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setPreferredSize(new Dimension(75, 75));
		this.setBorderPainted(false);
		this.addActionListener(this);
	}
		
    
	public void paintComponent(Graphics g){
		//System.out.println("image");
		g.drawImage(image, 0, 0, null);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		//System.out.println("Cliqué par bouton "+nomPion);
		BoutonTrio b = (BoutonTrio)e.getSource();
		System.out.println("Cliqué par bouton "+b.nomPion);
	}

	public String getPionCliquer(){
		return nomPion;
	}
}
