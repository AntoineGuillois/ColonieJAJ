package presentatio;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
 
public class Panneau extends JPanel {
	
  public void paintComponent(Graphics g){
    try {
      BufferedImage img = ImageIO.read(new File("C:/Users/Antoine Guillois/workspace/ColonieV5/src/presentatio/colo.jpg"));
      //Pour une image de fond
      g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
    } catch (IOException e) {
      e.printStackTrace();
    }    
  } 
  
}