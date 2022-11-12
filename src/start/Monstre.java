package start;

import java.awt.Color;
import java.awt.Graphics2D;

import engine.GamePanel;

public class Monstre extends Personnage {
	GamePanel gp;

	// change of case position parameter to two parameter positionx and positiony
	
	public Monstre(GamePanel gp,int pointsVie, int positionX,int positionY) {
			super(gp,pointsVie,positionX,positionY);
			this.gp = gp;
			
			
	}	

public void deplacerAleatoire() {
	
	
}; 


public void deplacerIntelligent() {
	//*******
} ;

public void draw(Graphics2D g2) {
	g2.setColor(Color.black);
	g2.fillRect(positionX, positionY, GamePanel.pixelSize, GamePanel.pixelSize);

	}

}
