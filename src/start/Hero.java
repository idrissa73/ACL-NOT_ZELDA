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
			//control.Up = false;
		}
		if (control.Down == true) {
			super.deplacerBas();
			//control.Down = false;
		}
		if (control.Left == true) {
			super.deplacerGauche();
			//control.Left = false;
		}
		if (control.Right == true) {
			super.deplacerDroite();
			//control.Right = false;
		}		
	}
	
	public void draw(Graphics2D g2) {
	g2.setColor(Color.white);
	g2.fillOval(positionX, positionY, GamePanel.pixelSize, GamePanel.pixelSize);

	}
}
