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
			if((Labyrinthe.mapTileNum[(this.positionX/48)][this.positionY/48 -1 ])==0) {
			super.deplacerHaut();
<<<<<<< HEAD
			control.Up=false;
=======
			control.Up=false;}
			
>>>>>>> ba1bdfd30fe101d32edad914882b9f16c3d286e5
			//control.Up = false;
		}
		if (control.Down == true) {
			if((Labyrinthe.mapTileNum[(this.positionX/48 )][this.positionY/48 +1])==0) {
			super.deplacerBas();
<<<<<<< HEAD
			control.Down=false;
=======
			control.Down=false;}
>>>>>>> ba1bdfd30fe101d32edad914882b9f16c3d286e5

			//control.Down = false;
		}
		if (control.Left == true) {
<<<<<<< HEAD
			System.out.print(Labyrinthe.mapTileNum[this.positionX/48][this.positionY/48]);
			if((Labyrinthe.mapTileNum[((this.positionY/48))][this.positionX/48])==0)
=======
			
			if((Labyrinthe.mapTileNum[(this.positionX/48 -1)][this.positionY/48])==0)
>>>>>>> ba1bdfd30fe101d32edad914882b9f16c3d286e5
			{super.deplacerGauche();
			control.Left=false;}

			//control.Left = false;
		}
		if (control.Right == true) {
			if((Labyrinthe.mapTileNum[(this.positionX/48 +1)][this.positionY/48])==0){
			super.deplacerDroite();
<<<<<<< HEAD
			control.Right=false;
=======
			control.Right=false;}
>>>>>>> ba1bdfd30fe101d32edad914882b9f16c3d286e5
			//control.Right = false;
			
	}
<<<<<<< HEAD
	
=======
	}
>>>>>>> ba1bdfd30fe101d32edad914882b9f16c3d286e5
	public void draw(Graphics2D g2) {     //affichage
	g2.setColor(Color.white);
	g2.fillOval(positionX, positionY, GamePanel.pixelSize, GamePanel.pixelSize);
	}
}

