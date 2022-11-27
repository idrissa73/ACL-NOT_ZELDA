package start;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;

import engine.GamePanel;

public class Monstre extends Personnage {
	GamePanel gp;

	// change of case position parameter to two parameter positionx and positiony
	
	public Monstre(GamePanel gp,int pointsVie, int positionX,int positionY) {
			super(gp,pointsVie,positionX,positionY);
			this.gp = gp;
			
			
	}	
	public void attaquer(Monstre monstre1) {
		
		
	}

public void deplacerAleatoire() {
	int s=(int)(Math.random()* 100 )+1;
			if ((s==1) & (Labyrinthe.mapTileNum[(this.positionX/48)][this.positionY/48 -1 ]==0))
				super.deplacerHaut();
			else if ((s==2) & (Labyrinthe.mapTileNum[(this.positionX/48 )][this.positionY/48 +1]==0))
				super.deplacerBas();
			else if ((s==3) & (Labyrinthe.mapTileNum[(this.positionX/48 -1)][this.positionY/48]==0))
				super.deplacerGauche();
			else if ((s==4) & (Labyrinthe.mapTileNum[(this.positionX/48 +1)][this.positionY/48]==0))
				super.deplacerDroite();
		

	
}

public void deplacerIntelligent() {
	//*******
}

public void draw(Graphics2D g2) {
try
{
mons=ImageIO.read(getClass().getResourceAsStream("/grilles/greenslime_down_2.png"));
}
catch (IOException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
g2.drawImage(mons,positionX,positionY, gp.pixelSize,gp.pixelSize,null);
// g2.setColor(Color.black);
// g2.fillRect(positionX, positionY, GamePanel.pixelSize, GamePanel.pixelSize);
}

}