import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
	
public class Rotation extends JButton implements MouseListener{
	
	private BufferedImage rot;

	Rotation(){
		try {
			rot = ImageIO.read(new File("00_helo/rot.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//pan.add(this);
		this.addMouseListener(this);
	}
	
	public void paintComponent(Graphics g){
		g.drawImage(rot, 0, 0, null);
		this.setBounds(100,100,75,75);
		this.setBorderPainted(false);
		
	}

	public void mouseClicked(MouseEvent e) 
	{
		System.out.printf("Rot");
		
		//new PiontChoisi(x,y);
		
	}

	public void mouseEntered(MouseEvent arg0) {}
	public void mouseExited(MouseEvent arg0) {}
	public void mousePressed(MouseEvent arg0) {}
	public void mouseReleased(MouseEvent arg0) {}

}



