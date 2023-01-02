package src;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame; // a voir javafx



public class Main

{
	//static JButton jouer = new JButton("démarrer la partie");
	static GamePanel game=new GamePanel();
	public static void main(String[] args) 
	{
		JFrame jeu= new JFrame();
		jeu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jeu.setResizable(false);
		jeu.setTitle("NOT_ZELDA");
		
		jeu.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		//jeu.add(jouer,c);
		
		
		jeu.add(game);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		jeu.add(game,c);
		jeu.pack();
		jeu.setLocationRelativeTo(null);
		jeu.setVisible(true);
		game.startThread();
		System.out.print("hello game");
		
	}
	
}
