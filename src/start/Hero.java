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

	public void Mouvement() {

		if (control.Up == true) {
			super.deplacerHaut();
			control.Up=false;
			//control.Up = false;
		}
		if (control.Down == true) {
			super.deplacerBas();
			control.Down=false;

			//control.Down = false;
		}
		if (control.Left == true) {
			System.out.print(Labyrinthe.mapTileNum[this.positionX/48][this.positionY/48]);
			if((Labyrinthe.mapTileNum[((this.positionY/48))][this.positionX/48])==0)
			{super.deplacerGauche();
			control.Left=false;}

			//control.Left = false;
		}
		if (control.Right == true) {
			super.deplacerDroite();
			control.Right=false;
			//control.Right = false;
		}		
	}
	
	public void draw(Graphics2D g2) {     //affichage
	g2.setColor(Color.white);
	g2.fillOval(positionX, positionY, GamePanel.pixelSize, GamePanel.pixelSize);
	}
}

