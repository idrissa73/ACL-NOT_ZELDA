package src;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
//added

import javax.swing.JLabel;
//added
import javax.swing.JPanel;


public class GamePanel extends JPanel implements Runnable{
	boolean test=true,test1=true,test2=true,test3=true;
	public final static int pixelSize = 48; //changed to 48
	public static int horizontalPixels =16; //changed to 16 + added visibility public+ remove of final
	public static int verticalPixals =12; //changed to 12 + added visibility public + remove of final
	final int screenWidth = pixelSize*horizontalPixels;
	final int screenHeight = pixelSize*verticalPixals+50;
	public String map = "/src/res/map00.txt";
	
	//added
		
		
	//added
		static int gameStatus=0; //etat du jeu 1 pour playstate et 2 pour le gain,3 pour la pause et 4 pour le game over 
		
	
		
	Thread thread;
	Controller Control= new Controller(this);
	
	
	Labyrinthe labyrinthe=new Labyrinthe(this,map);	
	Labyrinthe labyrinthe2=new Labyrinthe(this,map);
	
	Hero player1 = new Hero(this,Control,1000,1*pixelSize,1*pixelSize);
	Monstre monstre1= new Monstre(this,1000,3*pixelSize,3*pixelSize);
	Monstre monstre2= new Monstre(this,1000,6*pixelSize,6*pixelSize);
	Fantome fantome1= new Fantome(this,100,5*pixelSize,5*pixelSize);	
	Fantome fantome2= new Fantome(this,100,5*pixelSize,5*pixelSize);
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth,screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true); // draw in the background / better performance / not necessary
		this.addKeyListener(Control);
		this.setFocusable(true);// wait for key 
	}
	
	public void startThread()  {      // Create a thread that would be executed in every 1/60s
		thread = new Thread(this);   // should be added to class variables ? 
		thread.start();
	}
	
	public void run() {
		long interval=1000/60; // FPS
		long passTime =0;
		long oldTime = System.currentTimeMillis();
		long currentTime;
		
		while (thread != null){	
			currentTime = System.currentTimeMillis();
			passTime = currentTime - oldTime;
			if (passTime > interval ) {  //><
			update();
			
			repaint();
			oldTime = System.currentTimeMillis();
			}
		}
	}
	public void update() {
		if (gameStatus ==0) {
			Labyrinthe labyrinthe2=new Labyrinthe(this,map);
		}
		
		if (gameStatus==1){
			if (Control.Map1) {
				Labyrinthe labyrinthe2=new Labyrinthe(this,map);
				Control.Map1 = false;
			}
			if (Control.Map2) {
				Labyrinthe labyrinthe2=new Labyrinthe(this,map);
				Control.Map2 = false;
			}
			if (Control.Map3) {
				Labyrinthe labyrinthe2=new Labyrinthe(this,map);
				Control.Map3 = false;
			}
		player1.Mouvement();
		
		if (monstre1.perdreVie()==false) {
			
		if (Math.abs(player1.positionY-monstre1.positionY)<pixelSize) {
			//monstre1.deplacerIntelligent(player1);
		}else {
			monstre1.deplacerAleatoire(); 
		}
		//monstre1.deplacerAleatoire(); 
		monstre1.attaquer(player1);
		player1.attaquer(monstre1);
		
		}
		if (monstre2.perdreVie()==false) {
			monstre2.deplacerAleatoire(); 
			
			monstre2.attaquer(player1);
			player1.attaquer(monstre2);
			
			}
		if (fantome1.perdreVie()==false) {
		fantome1.deplacementFantome();
		fantome1.attaquer(player1);
		player1.attaquer2(fantome1);}
		if (fantome2.perdreVie()==false) {
		fantome2.deplacementFantome();
		fantome2.attaquer(player1);
		player1.attaquer2(fantome2);
		}
		
		}
		
		if ((gameStatus==2)||(gameStatus==3)||(gameStatus==4)){
			
			
		}
		
		
		
		//System.out.println(player1.positionX);
	}
	
	public void paintComponent(Graphics g) {
	
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		if(gameStatus==0) {
			
			labyrinthe2.draw(g2);
			
			g.setColor(Color.WHITE);
	         
	         g.setFont(new Font("Serif", Font.ITALIC, 46));
	         g.drawString("WELCOME TO THE GAME", 120, 80);
	         
			
			g.setColor(Color.WHITE);
	         
	         g.setFont(new Font("Serif", Font.ITALIC, 36));
	         g.drawString("press 1 to choose the map 1", 200, 200);
	         
	         g.setColor(Color.WHITE);
	         
	         g.setFont(new Font("Serif", Font.ITALIC, 36));
	         g.drawString("press 2 to choose the map 2", 200,250 );
	         
	         g.setColor(Color.WHITE);
	         
	         g.setFont(new Font("Serif", Font.ITALIC, 36));
	         g.drawString("press 3 to choose the map 3", 200,300);
		}
		if (gameStatus==1){
		//added
		labyrinthe2.draw(g2);
		//added
		if (player1.perdreVie()==false)
		{
			 g.setColor(Color.BLUE);
	            g.fillRect(540,590,201,20); 
	            g.setColor(Color.RED);
	            g.fillRect(540,590,player1.getPointsVie()/5,20);
			player1.draw(g2);		}
	
	
		if (monstre1.perdreVie()==false)
		{
		monstre1.draw(g2);
		}
		if ((monstre1.perdreVie()==true) && test)
		{
		player1.score++; 
		
		test=false;
		}
		if ((monstre2.perdreVie()==true)&& test1)
		{
		player1.score++;
		test1=false;
		}
		if ((fantome1.perdreVie()==true) && test2)
		{
		player1.score++; 
		
		test2=false;
		}
		if ((fantome2.perdreVie()==true)&& test3)
		{
		player1.score++;
		test3=false;
		}
	
		if (monstre2.perdreVie()==false)
		{
		monstre2.draw(g2);
		}
		if (fantome1.perdreVie()==false)
		{
			fantome1.draw(g2);
		}
		if (fantome2.perdreVie()==false)
		{
			fantome2.draw(g2);
		}
		g.setColor(Color.WHITE);
        
        g.setFont(new Font("Serif", Font.ITALIC, 36));
        g.drawString("score : "+player1.score, 5, 560+50);
		}
		
		if (gameStatus==2){
			 g.setColor(Color.WHITE);
	         
	         g.setFont(new Font("Serif", Font.ITALIC, 36));
	         g.drawString("YOU  WOoNNN", 5*48, 6*48);
			
			
		}
		if (player1.perdreVie()==true) {
			labyrinthe.draw(g2);
			monstre1.draw(g2);
			monstre2.draw(g2);
			fantome1.draw(g2);
			fantome2.draw(g2);
			gameStatus=4;
			g.setColor(Color.WHITE);
	         g.setFont(new Font("Serif", Font.BOLD, 72));
	         g.drawString("GAME OVER", 3*48, 6*48);
	         
		}
		if (gameStatus==3) {
			labyrinthe.draw(g2);
			player1.draw(g2);
			if (monstre1.perdreVie()==false)
			monstre1.draw(g2);
			if (monstre2.perdreVie()==false)
			monstre2.draw(g2);
			fantome1.draw(g2);
			fantome2.draw(g2);
			g.setColor(Color.WHITE);
	         
	         g.setFont(new Font("Serif", Font.BOLD, 72));
	         g.drawString("PAUSE", 6*48, 6*48);
		}
		g2.dispose();
		
	}
	
	
	
}