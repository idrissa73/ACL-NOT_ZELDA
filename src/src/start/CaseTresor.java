package start;

import java.io.IOException;

import javax.imageio.ImageIO;

public class CaseTresor extends Cases {
	
	public CaseTresor() {
		try {
			this.image = ImageIO.read(getClass().getResourceAsStream("/src/res/Tresor2.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
