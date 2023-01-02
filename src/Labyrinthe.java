package src;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Labyrinthe {
	
	// change the two attributes TailleX and TailleY to one attribute GamePanel
		GamePanel gp;
		Cases[] grille; 
		static int mapTileNum[][];
		int nbTypeCases = 10; 
		//String map = "/src/res/map01.txt";
		
		
		public Labyrinthe(GamePanel gp, String map)
		{
			this.gp=gp;
			grille=new Cases[nbTypeCases];
			mapTileNum= new int[GamePanel.horizontalPixels][GamePanel.verticalPixals];
			getTileImage();
			loadMap(map);
			
		}
		
	
	
	public int getTailleX()
	{// Retourne la longueur du labyrinthe en nombre de cases.
		return GamePanel.horizontalPixels;
	}
	
	public int getTailleY()
	{// Retourne la largeur du labyrinthe en nombre de cases.
		return gp.verticalPixals;	
	}
	public void setTailleX(int x)
	{// Modifie la longueur du labyrinthe en nombre de cases.
		this.gp.horizontalPixels=x;
	}
	
	public void setTailleY(int y)
	{// Modifie la largeur du labyrinthe en nombre de cases.
		this.gp.verticalPixals=y;	
	}
	
	//To see later
	public boolean	existe_t_il (int coordonnex,int coordonney)
	{
	//Indique si la case passee en parametre est libre ou pas
		return true;
	}
	
	public float getDepatureX()
	{
    // Retourne l'abscisse de la case de sortie dans le labyrinthe
		return 0;
	}
	
	public float getDepatureY()
	{
    // Retourne l'ordonnee de la case de sortie dans le labyrinthe
		return 0;
	}
	
	
	
	//Construction du labyrinthe
	public void getTileImage()
	{
		/*
		 0 --> sol   2--->eau            4----->BonusBanane     6---->Piege
		 1 --> mur   3---> BonusPomme    5----->Obstacle        7---->Tresor
		 			
		 */
		try {
			grille[0]=new Cases();
			grille[0].image=ImageIO.read(getClass().getResourceAsStream("/src/res/tile_grass.png"));
			grille[1]=new CaseMur();
			grille[2]=new CaseEau();
			grille[3] = new CaseBonus(1);
			grille[4] = new CaseBonus(2);
			grille[5] = new CaseObstacle();
			grille[6] = new CasePiege();
			grille[7] = new CaseTresor();
		
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadMap(String filePath) {
		
		try {
			InputStream is=getClass().getResourceAsStream(filePath);
			BufferedReader br=new BufferedReader(new InputStreamReader(is));
			
			int col=0;
			int row=0;
			
			while(col<gp.horizontalPixels && row <gp.verticalPixals)
			{
				String line=br.readLine();
				
				while(col<gp.horizontalPixels) {
					String numbers[]=line.split(" ");
					
					int num=Integer.parseInt(numbers[col]);
					
					mapTileNum[col][row]=num;
					col++;
				}
				
				if (col ==gp.horizontalPixels) {
					col=0;
					row++;
				}
				
				
			}
			br.close();
	}catch(Exception e) {
		}
	}
	
	public void draw(Graphics2D g2)
	{
		
		int col=0;
		int row=0;
		int x=0;
		int y=0;
		
		while (col<gp.horizontalPixels && row< gp.verticalPixals) {
			int tileNum=mapTileNum[col][row];
			g2.drawImage(grille[tileNum].image,x,y,gp.pixelSize,gp.pixelSize,null);
			col++;
			x+=gp.pixelSize;
			if (col == gp.horizontalPixels) {
				col=0;
				x=0;
				row++;
				y+=gp.pixelSize;
			}

		}
		
	
}
}