package start;

import java.io.IOException;

import javax.imageio.ImageIO;

public class CasePiege extends Cases {
	private int diminuerVie = 0;
	
	
	public CasePiege() {
		try {
			this.image = ImageIO.read(getClass().getResourceAsStream("/grilles/Piege.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public CasePiege(int diminuerVie) {
		this.diminuerVie = diminuerVie;
		try {
			this.image = ImageIO.read(getClass().getResourceAsStream("/grilles/Piege.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int getDiminuerVie() {
		return diminuerVie;
	}
}
