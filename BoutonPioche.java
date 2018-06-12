import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;


public class BoutonPioche extends JButton{;
	BufferedImage image;

	public BoutonPioche(){
		try {
			image = ImageIO.read(new File("00_helo/vide.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setPreferredSize(new Dimension(75, 75));
		this.setBorderPainted(false);
	}
		
    
	public void paintComponent(Graphics g){
		//System.out.println("image");
		g.drawImage(image, 0, 0, null);
	}

}
