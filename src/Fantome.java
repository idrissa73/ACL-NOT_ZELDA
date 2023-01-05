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
			if ( (this.positionX < (GamePanel.horizontalPixels-1)*GamePanel.pixelSize) & (this.positionY > 0) & (this.positionY < (GamePanel.verticalPixals-1)*GamePanel.pixelSize) & (this.positionX > 0)){

					if ((s==1)&((Labyrinthe.mapTileNum[(this.positionX/48)][this.positionY/48 -1 ]==0)|(Labyrinthe.mapTileNum[(this.positionX/48)][this.positionY/48 -1 ]==1)))
						super.deplacerHaut();
					else if ((s==2) & ((Labyrinthe.mapTileNum[(this.positionX/48 )][this.positionY/48 +1]==0)|(Labyrinthe.mapTileNum[(this.positionX/48 )][this.positionY/48 +1]==1)))
						super.deplacerBas();
					else if ((s==3) &((Labyrinthe.mapTileNum[(this.positionX/48 -1)][this.positionY/48]==0)|(Labyrinthe.mapTileNum[(this.positionX/48 -1)][this.positionY/48]==1)))
						super.deplacerGauche();
					else if ((s==4) &((Labyrinthe.mapTileNum[(this.positionX/48 +1)][this.positionY/48]==0)|(Labyrinthe.mapTileNum[(this.positionX/48 +1)][this.positionY/48]==1)))
						super.deplacerDroite();
			}
			else if (this.positionX == (GamePanel.horizontalPixels-1)*GamePanel.pixelSize) {
				int h=(int)(Math.random()* 50 )+1;
				if (h==3)
				super.deplacerGauche();
				else if (h==2)
					super.deplacerBas();
				else if (h==1)
					super.deplacerHaut();
			}
			else if (this.positionY == 0) {
				int h=(int)(Math.random()* 50 )+1;
				if (h==3)
				super.deplacerGauche();
				else if (h==2)
					super.deplacerBas();
				else if (h==1)
					super.deplacerDroite();
			}
			else if (this.positionY == (GamePanel.verticalPixals-1)*GamePanel.pixelSize) {
				int h=(int)(Math.random()* 50 )+1;
				if (h==3)
				super.deplacerGauche();
				else if (h==2)
					super.deplacerDroite();
				else if (h==1)
					super.deplacerHaut();
			}
			else if (this.positionX ==0 ) {
				int h=(int)(Math.random()* 50 )+1;
				if (h==3)
				super.deplacerDroite();
				else if (h==2)
					super.deplacerBas();
				else if (h==1)
					super.deplacerHaut();
			}
				
			
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

