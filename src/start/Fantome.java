package start;

import java.awt.Color;
import java.awt.Graphics2D;

import engine.Controller;
import engine.GamePanel;

public class Fantome extends Monstre {
	// change of case position parameter to two parameter positionx and positiony

	public Fantome (GamePanel gp, Controller control,int pointsVie, int positionX,int positionY) {
	super(gp,pointsVie,positionX,positionY);
			
	}

	public void traverserMur() {
		//*******
	} 
	
	public void testCase() {
		//*******
	}
	
	public void draw(Graphics2D g2) {
		g2.setColor(Color.red);
		g2.fillRect(positionX, positionY, GamePanel.pixelSize, GamePanel.pixelSize);
	
		}
}

