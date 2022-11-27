package start;

import java.io.IOException;

import javax.imageio.ImageIO;

public class CaseObstacle extends Cases{
	public CaseObstacle() {
		try {
			this.image =ImageIO.read(getClass().getResourceAsStream("/grilles/Obstacle2.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}