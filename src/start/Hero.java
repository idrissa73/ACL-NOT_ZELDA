package start;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import engine.Controller;
import engine.GamePanel;

public class Hero extends Personnage {

	
	Controller control;

	public Hero(GamePanel gp, Controller control,int pointsVie, int positionX,int positionY) {
		super(gp,pointsVie,positionX,positionY);
		this.control=control;
	
	getPlayerImage();
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
	
	public void Mouvement()
	{
	if(control.Up==true || control.Down==true || control.Left==true || control.Right==true  ) {
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


	//IF COLLISION IS FALSE,PLAYER CAN MOVE






	spriteCounter++;
	if (spriteCounter>10)
	{

	if (spriteNum ==1)
	{
	spriteNum=2;
	}
	else if (spriteNum==2)
	{
	spriteNum=1;
	}
	spriteCounter=0;
	}
	}
	}


	public void getPlayerImage()
	{
	try
	{
	up1=ImageIO.read(getClass().getResourceAsStream("/grilles/tile_character.png"));
	up2=ImageIO.read(getClass().getResourceAsStream("/grilles/tile_character.png"));
	down1=ImageIO.read(getClass().getResourceAsStream("/grilles/tile_character.png"));
	down2=ImageIO.read(getClass().getResourceAsStream("/grilles/tile_character.png"));
	right1=ImageIO.read(getClass().getResourceAsStream("/grilles/tile_character.png"));
	right2=ImageIO.read(getClass().getResourceAsStream("/grilles/tile_character.png"));
	left1=ImageIO.read(getClass().getResourceAsStream("/grilles/tile_character.png"));
	left2=ImageIO.read(getClass().getResourceAsStream("/grilles/tile_character.png"));
	}

	catch(IOException e)
	{e.printStackTrace();}
	}
	/*
	public void update() {
	if (control.Up==true) {
	direction="up";
	}
	if (control.Down==true) {
	direction="down";
	}
	if (control.Left==true) {
	direction="left";
	}
	if (control.Right==true) {
	direction="right";
	}
	}
	*/
	public void draw(Graphics2D g2)
	{
	BufferedImage image=null;
	switch(direction)
	{
	case "up":
	if(spriteNum==1)
	{
	image=up1;
	}
	if(spriteNum==2)
	{
	image=up2;
	}
	break;
	case "down":
	if(spriteNum==1)
	{
	image=down1;
	}
	if(spriteNum==2)
	{
	image=down2;
	}
	break;
	case "left":
	if(spriteNum==1)
	{
	image=left1;
	}
	if(spriteNum==2)
	{
	image=left2;
	}
	break;
	case "right":
	if(spriteNum==1)
	{
	image=right1;
	}
	if(spriteNum==2)
	{
	image=right2;
	}
	break;
	}
	g2.drawImage(image,positionX,positionY, gp.pixelSize,gp.pixelSize,null);
	}

	}