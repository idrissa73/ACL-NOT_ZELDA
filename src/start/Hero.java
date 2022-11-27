package start;

import java.awt.Color;
import java.awt.Graphics2D;

import engine.Controller;
import engine.GamePanel;

public class Hero extends Personnage {

	
	Controller control;

	public Hero(GamePanel gp, Controller control,int pointsVie, int positionX,int positionY) {
		super(gp,pointsVie,positionX,positionY);
		this.control=control;
	}

	//	public Hero(int pointsVie, int positionX,int positionY) {
	//		super(pointsVie,0,0);
	//	}
	
	public void attaquer(Monstre monstre1) {
		if (control.Attaque == true ) {
	           if (((this.positionX + GamePanel.pixelSize==monstre1.positionX) && (this.positionY ==monstre1.positionY))||
	        		((this.positionY + GamePanel.pixelSize ==monstre1.positionY) &&(this.positionX==monstre1.positionX))||
	        		((this.positionX - GamePanel.pixelSize==monstre1.positionX) &&(this.positionY ==monstre1.positionY))||
	        		((this.positionY - GamePanel.pixelSize ==monstre1.positionY) &&(this.positionX==monstre1.positionX))||
	        		((this.positionX == monstre1.positionX)&&(this.positionY ==monstre1.positionY)))
				{   System.out.println(monstre1.getPointsVie());
		            monstre1.subirDegat(10);
		            System.out.println("attaque");
		           
		        }
	}}
	

	public void Mouvement() {

		if (control.Up == true) {
			if((Labyrinthe.mapTileNum[(this.positionX/48)][this.positionY/48 -1 ])==0) {
			super.deplacerHaut();
			control.Up=false;}
			
			//control.Up = false;
		}
		if (control.Down == true) {
			if((Labyrinthe.mapTileNum[(this.positionX/48 )][this.positionY/48 +1])==0) {
			super.deplacerBas();
			control.Down=false;}

			//control.Down = false;
		}
		if (control.Left == true) {
			
			if((Labyrinthe.mapTileNum[(this.positionX/48 -1)][this.positionY/48])==0)
			{super.deplacerGauche();
			control.Left=false;}

			//control.Left = false;
		}
		if (control.Right == true) {
			if((Labyrinthe.mapTileNum[(this.positionX/48 +1)][this.positionY/48])==0){
			super.deplacerDroite();
			control.Right=false;}
			//control.Right = false;
			
	}
	}
	public void draw(Graphics2D g2) {     //affichage
	g2.setColor(Color.white);
	g2.fillOval(positionX, positionY, GamePanel.pixelSize, GamePanel.pixelSize);
	}
}