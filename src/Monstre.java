package src;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;



public class Monstre extends Personnage {
	GamePanel gp;
	Controller control;

	// change of case position parameter to two parameter positionx and positiony
	
	public Monstre(GamePanel gp,int pointsVie, int positionX,int positionY) {
			super(gp,pointsVie,positionX,positionY);
			this.gp = gp;
			
			
	}	
	public void attaquer(Hero hero) {

		if (((this.positionX + GamePanel.pixelSize==hero.positionX) && (this.positionY ==hero.positionY))||
        		((this.positionY + GamePanel.pixelSize ==hero.positionY) &&(this.positionX==hero.positionX))||
        		((this.positionX - GamePanel.pixelSize==hero.positionX) &&(this.positionY ==hero.positionY))||
        		((this.positionY - GamePanel.pixelSize ==hero.positionY) &&(this.positionX==hero.positionX))||
        		((this.positionX ==hero.positionX)&&(this.positionY ==hero.positionY)))
			{   System.out.println(hero.getPointsVie());
	            hero.subirDegat(10);
	            System.out.println("attaque du monstre");
	           
	        }
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

public void deplacerIntelligent(Hero hero) {
	if ((this.positionY>hero.positionY) & (Labyrinthe.mapTileNum[(this.positionX/48)][this.positionY/48 -1 ]==0))
			{
			deplacerHaut(10);
			
			}
		else if (((this.positionY<hero.positionY)) & (Labyrinthe.mapTileNum[(this.positionX/48 )][this.positionY/48 +1]==0))
		{
			deplacerBas(10);
			}
		else if (((this.positionX>hero.positionX)) & (Labyrinthe.mapTileNum[(this.positionX/48 -1)][this.positionY/48]==0))
			{deplacerGauche(10);
			
			}
		else if (((this.positionX<hero.positionX)) & (Labyrinthe.mapTileNum[(this.positionX/48 +1)][this.positionY/48]==0))
			{deplacerDroite(10);
			
			}
}
public void deplacerHaut(int v)
{
if (this.positionY > 0)
this.positionY -= v;  //speedtest
}

public void deplacerBas(int v)
{
if (this.positionY < (GamePanel.verticalPixals-1)*GamePanel.pixelSize)
this.positionY += v;
}

public void deplacerGauche(int v)
{
if (this.positionX > 0)
this.positionX -= v;
}

public void deplacerDroite(int v)
{
if (this.positionX < (GamePanel.horizontalPixels-1)*GamePanel.pixelSize)
this.positionX += v;
}

public void draw(Graphics2D g2) {
try
{
mons=ImageIO.read(getClass().getResourceAsStream("/src/res/greenslime_down_2.png"));
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