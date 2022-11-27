package engine;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
//added
import start.Labyrinthe;
import start.Monstre;

//added
import javax.swing.JPanel;

import start.Hero;
import start.Labyrinthe;

public class GamePanel extends JPanel implements Runnable{
	
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
	Hero player1 = new Hero(this,Control,10,1*pixelSize,1*pixelSize);
	Monstre monstre1= new Monstre(this,100,3*pixelSize,3*pixelSize);
		
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth,screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true); // draw in the background / better performance / not necessary
		this.addKeyListener(Control);
		this.setFocusable(true);// wait for key 
	}
	
	public void startThread() {      // Create a thread that would be executed in every 1/60s
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
		
		player1.Mouvement();
		
		if (monstre1.perdreVie()==false) {
		monstre1.deplacerAleatoire(); 
		player1.attaquer(monstre1);
		
		}
		
		
		
		//System.out.println(player1.positionX);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		//added
		labyrinthe.draw(g2);
		//added
		player1.draw(g2);
		
		if (monstre1.perdreVie()==false)
		{
		monstre1.draw(g2);
		}
		g2.dispose();
		
	}
	
	
	
}