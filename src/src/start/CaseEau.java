package start;

import java.io.IOException;

import javax.imageio.ImageIO;

public class CaseEau extends Cases {
	public CaseEau() {
		try {
			this.image = ImageIO.read(getClass().getResourceAsStream("/src/res/water.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}