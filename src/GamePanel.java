package src;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
//added
import java.util.ArrayList;

//added
import javax.swing.JPanel;


public class GamePanel extends JPanel implements Runnable{
	boolean pause=true;
	boolean pause2=true;

	public final static int pixelSize = 48; //changed to 48
	public static int horizontalPixels =16; //changed to 16 + added visibility public+ remove of final
	public static int verticalPixals =12; //changed to 12 + added visibility public + remove of final
	final int screenWidth = pixelSize*horizontalPixels;
	final int screenHeight = pixelSize*verticalPixals;
	//added
		Labyrinthe labyrinthe=new Labyrinthe(this);
	//added
	
		
	Thread thread;
	Controller Control= new Controller();
	Hero player1 = new Hero(this,Control,1000,1*pixelSize,1*pixelSize);
	Monstre monstre1= new Monstre(this,1000,3*pixelSize,3*pixelSize);
	Monstre monstre2= new Monstre(this,1000,6*pixelSize,6*pixelSize);
	Fantome fantome1= new Fantome(this,100,5*pixelSize,5*pixelSize);	
	Fantome fantome2= new Fantome(this,100,5*pixelSize,5*pixelSize);
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth,screenHeight));
		this.setBackground(Color.green);
		//this.add(paintingChild, "hello");

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
			System.out.println(Control.pause);
			if (Control.pause==false){
					
				update();
				repaint();
				oldTime = System.currentTimeMillis();
			}
		}
	}
}
	public void update() {
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
			//monstre2.deplacerIntelligent(player1); 
			
			monstre2.attaquer(player1);
			player1.attaquer(monstre2);
			
			}
		fantome1.deplacementFantome();
		fantome2.deplacementFantome();
		
		fantome2.attaquer(player1);
		player1.attaquer(fantome2);
		
		
		
		
		//System.out.println(player1.positionX);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		//added
		labyrinthe.draw(g2);
		//added
		if (player1.perdreVie()==false)
		{
			 g.setColor(Color.BLACK);
	            g.fillRect(10,10,201,20); 
	            g.setColor(Color.RED);
	            g.fillRect(10,10,player1.getPointsVie()/5,20);
			player1.draw(g2);		}
		else {
			thread=null;
		}
		
		
		
		if ((monstre1.perdreVie()==true) & pause == true )
		{
		player1.score++; 
		pause=false;
		}
		if ((monstre2.perdreVie()==true)& pause2 ==true)
		{
		player1.score++;
		pause2=false;
		}
	
		System.out.println(player1.score);
		if (monstre1.perdreVie()==false)
		{
		monstre1.draw(g2);
		}
		if (monstre2.perdreVie()==false)
		{
		monstre2.draw(g2);
		}
		fantome1.draw(g2);
		fantome2.draw(g2);	
		
		g2.dispose();
		
	}
void sauvegardescores(int score){
		ArrayList<Integer> listedesscores = new ArrayList<Integer>();
		listedesscores.add(score);
	}
}