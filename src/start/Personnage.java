package start;

import engine.Controller;
import engine.GamePanel;
import java.awt.Rectangle;

public class Personnage {

	private int pointsVie;
	public int positionX;
	public int positionY;
    GamePanel gp;
    public Rectangle solidArea=new Rectangle(0,0,48,48); 
    public int solidAreaDefaultX,solidAreaDefaultY;
    
	
	public Personnage(GamePanel gp ,int pointsVie, int positionX,int positionY) {
		this.gp=gp;
		this.pointsVie = pointsVie;
		this.positionX = positionX;
		this.positionY = positionX;
	}

	public int getPointsVie() {
		return pointsVie;
	}

	public void setPointsVie(int pointsVie) {
		this.pointsVie = pointsVie;
	}

	/*
	 * public Case getPosition() { return position; }
	 */

//	public void setPosition(Case position) {
//		this.position = position;
//	}
	
	//setPosition peut nous aider a la fonction de teleport
	//qlq setters et getters doivent etre reajoutés au diagram
	
	//added *0.05 to reduce speed

	public void deplacerHaut(){
		this.positionY -= GamePanel.pixelSize*0.05;
	}
	public void deplacerBas(){
		this.positionY += GamePanel.pixelSize*0.05;
	}
	public void deplacerGauche(){
		this.positionX -= GamePanel.pixelSize*0.05;
	}
	public void deplacerDroite(){
		this.positionX += GamePanel.pixelSize*0.05;
	}
	//setter a ajouter dans la classe case

	public void attaquer() {
		//*******
	}
	//nom à changer
	
	public boolean perdreVie() {
		if (pointsVie == 0)
			return true;
		return false;
	}
	//nom a changer
	
	public void gagner() {
		//*********
	}
	
	public void subirDegat(int degat) {
		pointsVie-=degat;
	}
	//nom à changer
	
//	public void testCase() {
//		if (position instanceof(/*****/));
//		//*****
//	}
	
	
}
