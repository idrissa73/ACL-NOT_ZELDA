package main;
import javax.swing.JFrame; // a voir javafx

import engine.GamePanel;

public class Main 

{
	public static void main(String[] args) 
	{
		JFrame jeu= new JFrame();
		jeu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jeu.setResizable(false);
		jeu.setTitle("NOT_ZELDA");
		
		GamePanel game=new GamePanel();
		jeu.add(game);
		jeu.pack();
		
		jeu.setLocationRelativeTo(null);
		jeu.setVisible(true);
		game.startThread();
		System.out.print("hello game");
		
	}
}
