import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;


public class BoutonTrio extends JButton{

	String nomBouton;
	String chemin;
	BufferedImage image;

	public BoutonTrio(String nom, String chemin){
		this.nomBouton = nom;
		this.chemin = chemin;
		System.out.println(this.chemin);

		try {
			image = ImageIO.read(new File(chemin));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
    
	public void paintComponent(Graphics g){
		//System.out.println("image");
		g.drawImage(image, 0, 0, null);
	}

}
