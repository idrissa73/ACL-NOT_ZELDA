package src;

import java.io.IOException;

import javax.imageio.ImageIO;

public class CaseMur extends Cases {
	public CaseMur() {
		try {
			this.image = ImageIO.read(getClass().getResourceAsStream("/src/res/tile_crate.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}