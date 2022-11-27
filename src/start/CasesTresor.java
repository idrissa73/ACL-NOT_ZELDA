package start;

import java.io.IOException;

import javax.imageio.ImageIO;

public class CasesTresor extends Cases {
	
	public CasesTresor() {
		try {
			this.image = ImageIO.read(getClass().getResourceAsStream("/grilles/Tresor2.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
