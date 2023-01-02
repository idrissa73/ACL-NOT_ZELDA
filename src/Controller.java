package src;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller implements KeyListener {
	GamePanel gp ; 
	public boolean Up,Left,Down,Right,Attaque;
	public boolean Map1,Map2,Map3;
	public Controller(GamePanel gp) {
		this.gp=gp;
	}
	public void keyTyped(KeyEvent e) {			
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int input = e.getKeyCode();
		
		if (input == KeyEvent.VK_UP) {
			Up=true;
		}
		if (input == KeyEvent.VK_DOWN) {
			Down=true;
		}
		if (input == KeyEvent.VK_LEFT) {
			Left=true;
		}
		if (input == KeyEvent.VK_RIGHT) {
			Right=true;
		}
		if (input == KeyEvent.VK_SPACE) {
			Attaque=true;
		}
		if (input == KeyEvent.VK_P) {
		   if (GamePanel.gameStatus==1) {
			   GamePanel.gameStatus=3; 
		   }
		   else if (GamePanel.gameStatus==3) {
			   GamePanel.gameStatus=1;
		   }
		}
		if (input == KeyEvent.VK_1) {
			Map1=true;
			gp.map = "/src/res/map01.txt";
			GamePanel.gameStatus=1; 
		}
		if (input == KeyEvent.VK_2) {
			Map2=true;
			gp.map = "/src/res/map02.txt";
			GamePanel.gameStatus=1;  
		}
		if (input == KeyEvent.VK_3) {
			Map3=true;
			gp.map = "/src/res/map03.txt";
			GamePanel.gameStatus=1; 
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
int input = e.getKeyCode();
		
		if (input == KeyEvent.VK_UP) {
			Up=false;
		}
		if (input == KeyEvent.VK_DOWN) {
			Down=false;
		}
		if (input == KeyEvent.VK_LEFT) {
			Left=false;
		}
		if (input == KeyEvent.VK_RIGHT) {
			Right=false;
		}
		if (input == KeyEvent.VK_SPACE) {
			Attaque=false;
		}
	}
		
	

}
