package src;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Fantome extends Monstre {
	// change of case position parameter to two parameter positionx and positiony

	public Fantome (GamePanel gp,int pointsVie, int positionX,int positionY) {
	super(gp,pointsVie,positionX,positionY);
			
	}

	public void deplacementFantome() {
			int s=(int)(Math.random()* 100 )+1;
					if ((s==1) & (Labyrinthe.mapTileNum[(this.positionX/48)][this.positionY/48 -1 ]!=0))
						super.deplacerHaut();
					else if ((s==2) & (Labyrinthe.mapTileNum[(this.positionX/48 )][this.positionY/48 +1]!=0))
						super.deplacerBas();
					else if ((s==3) & (Labyrinthe.mapTileNum[(this.positionX/48 -1)][this.positionY/48]!=0))
						super.deplacerGauche();
					else if ((s==4) & (Labyrinthe.mapTileNum[(this.positionX/48 +1)][this.positionY/48]!=0))
						super.deplacerDroite();
		
	} 
	
	public void testCase() {
		//*******
	}
	
	public void draw(Graphics2D g2) {
		try
		{
		mons=ImageIO.read(getClass().getResourceAsStream("/src/res/Fantome.png"));
		}
		catch (IOException e) {
		e.printStackTrace();
		}
		g2.drawImage(mons,positionX,positionY, gp.pixelSize,gp.pixelSize,null);
		// g2.setColor(Color.black);
		// g2.fillRect(positionX, positionY, GamePanel.pixelSize, GamePanel.pixelSize);
		}

		}

