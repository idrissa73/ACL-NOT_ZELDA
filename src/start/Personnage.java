package start;

import engine.Controller;
import engine.GamePanel;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Personnage
{
private int pointsVie;
public int positionX;
public int positionY;
    GamePanel gp;
    public Rectangle solidArea=new Rectangle(0,0,48,48);
    public int solidAreaDefaultX,solidAreaDefaultY;
    public BufferedImage up1,up2,down1,down2,left1,left2,right1,right2,mons;
    public String direction="down";
    public int spriteCounter =0;
    public int spriteNum=1;
    public boolean collisionOn=false;


public Personnage(GamePanel gp ,int pointsVie, int positionX,int positionY)
{
this.gp=gp;
this.pointsVie = pointsVie;
this.positionX = positionX;
this.positionY = positionX;
}



public int getPointsVie()
{
return pointsVie;
}

public void setPointsVie(int pointsVie)
{
this.pointsVie = pointsVie;
}

/*
* public Case getPosition() { return position; }
*/

// public void setPosition(Case position) {
// this.position = position;
// }

//setPosition peut nous aider a la fonction de teleport
//qlq setters et getters doivent etre reajout�s au diagram

//added *0.05 to reduce speed
//><
public void deplacerHaut()
{
if (this.positionY > 0)
this.positionY -= GamePanel.pixelSize;  //speedtest
}

public void deplacerBas()
{
if (this.positionY < (GamePanel.verticalPixals-1)*GamePanel.pixelSize)
this.positionY += GamePanel.pixelSize;
}

public void deplacerGauche()
{
if (this.positionX > 0)
this.positionX -= GamePanel.pixelSize;
}

public void deplacerDroite()
{
if (this.positionX < (GamePanel.horizontalPixels-1)*GamePanel.pixelSize)
this.positionX += GamePanel.pixelSize;
}
//setter a ajouter dans la classe case

public void attaquer()
{
//*******
}
//nom � changer

public boolean perdreVie()
{
if (pointsVie == 0)
return true;
return false;
}
//nom a changer

public void gagner()
{
//*********
}

public void subirDegat(int degat)
{
pointsVie-=degat;
}
//nom � changer

// public void testCase() {
// if (position instanceof(/*****/));
// //*****
// }


}