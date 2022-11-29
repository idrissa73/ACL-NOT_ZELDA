package src;

import java.io.IOException;

import javax.imageio.ImageIO;

public class CaseBonus extends Cases {
	private int bonusAttaque = 0;
	private int bonusVie = 0;
	
	public CaseBonus(int bonusAttaque, int bonusVie) {
		this.bonusAttaque = bonusAttaque;
		this.bonusVie = bonusVie;
		// Chargement de l'image
		try {
			this.image = ImageIO.read(getClass().getResourceAsStream("/src/res/apple2s.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public CaseBonus(int typeBonus) {
		// Chargement de l'image
		try {
			if (typeBonus == 1) {
				this.image = ImageIO.read(getClass().getResourceAsStream("/src/res/apple2.png"));
			}else if (typeBonus==2) {
				this.image = ImageIO.read(getClass().getResourceAsStream("/src/res/banana.png"));
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int getBonusAttaque() {
		return bonusAttaque;
	}
	public int getBonusVie() {
		return bonusVie;
	}
}