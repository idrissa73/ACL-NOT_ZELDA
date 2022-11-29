package engine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller implements KeyListener {
	
	public boolean Up,Left,Down,Right,Attaque;

	
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
