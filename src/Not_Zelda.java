package src;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Not_Zelda {
	
	
	GamePanel game;
	GamePanel game2;
	Controller Control;
	Controller Control2;
	String map ;
	String map2 ;
	Labyrinthe labyrinthe;
	Labyrinthe labyrinthe2;	
	Hero player1;
	Hero player2;
	Monstre monstre1;
	Monstre monstre2;
	int pixelSize;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	public void setUp() throws Exception {
		pixelSize = 48; //changed to 48
		game=new GamePanel();
		game2=new GamePanel();
		Control= new Controller(game);
		Control2= new Controller(game2);
		map = "/src/res/maptest.txt";
		map2 = "/src/res/maptest2.txt";
		labyrinthe=new Labyrinthe(game,map);
		labyrinthe2=new Labyrinthe(game2,map2);
		player1 = new Hero(game,Control,1000,1*pixelSize,1*pixelSize);
		player2 = new Hero(game2,Control2,1000,1*pixelSize,1*pixelSize);
		monstre1= new Monstre(game,1000,3*pixelSize,3*pixelSize);
		monstre2= new Monstre(game2,20,2*pixelSize,1*pixelSize);
	}

	@Test
	public void test_mvt_bH() {
		
		for (int i=0 ; i<40; i++)
			player1.deplacerHaut();
		assertEquals(player1.positionX,1*pixelSize);
		assertEquals(player1.positionY,0);
	}
	@Test
public void test_mvt_bD() {
		
		for (int i=0 ; i<40; i++)
			player1.deplacerDroite();
		assertEquals(player1.positionX,15*pixelSize);
		assertEquals(player1.positionY,1*pixelSize);
	}
	@Test
public void test_mvt_bG() {
	
	for (int i=0 ; i<40; i++)
		player1.deplacerGauche();
	assertEquals(player1.positionX,0);
	assertEquals(player1.positionY,1*pixelSize);
}
	@Test
	public void test_mvt_bB() {
		
		for (int i=0 ; i<40; i++)
			player1.deplacerBas();
		assertEquals(player1.positionX,1*pixelSize);
		assertEquals(player1.positionY,11*pixelSize);
	}
	
	@Test
	public void test_mvt_collisionH() {
		
		for (int i=0 ; i<40; i++)
		{	Control2.Up=true;
			player2.Mouvement();
		}
		assertEquals(player2.positionX,1*pixelSize);
		assertEquals(player2.positionY,1*pixelSize);
	}
	
	@Test
public void test_mvt_collisionD() {
		
		for (int i=0 ; i<1000; i++)
		{	Control2.Right=true;
			player2.Mouvement();
		}
		//System.out.print(player2.positionX);
		assertEquals(player2.positionX,10*pixelSize);
		assertEquals(player2.positionY,1*pixelSize);
	}
	
	@Test
public void test_mvt_collisionG() {
	
	for (int i=0 ; i<40; i++)
	{	Control2.Left=true;
	player2.Mouvement();
}
	assertEquals(player2.positionX,1*pixelSize);
	assertEquals(player2.positionY,1*pixelSize);
}
	
	@Test
	public void test_mvt_collisionB() {
		
		for (int i=0 ; i<40; i++)
		{	Control2.Down=true;
		player2.Mouvement();
	}
		assertEquals(player2.positionX,1*pixelSize);
		assertEquals(player2.positionY,10*pixelSize);
	}
	
	@Test
	public void test_mvt_aleatoire() {
		
		for (int i=0 ; i<1000; i++)
			monstre1.deplacerAleatoire();
		assertFalse(monstre1.perdreVie());
	}

	

}
