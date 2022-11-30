package src;

import java.io.IOException;

import javax.imageio.ImageIO;

public class CaseCle extends Cases {
	public CaseCle() {
		try {
			this.image = ImageIO.read(getClass().getResourceAsStream("/src/res/Cle.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
