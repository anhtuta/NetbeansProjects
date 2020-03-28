package webcam;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamResolution;

/**
 * Example of how to take single picture.
 * 
 * @author Bartosz Firyn (SarXos)
 */
public class TakePictureExample {

	public void RunMe(){

		// get default webcam and open it
		Webcam webcam = Webcam.getDefault();
		webcam.setViewSize(WebcamResolution.VGA.getSize());
                webcam.open();

		// get image
                
		BufferedImage image = webcam.getImage();

                try
                {
		// save image to PNG file
		ImageIO.write(image, "JPG", new File("testMyWebcam.JPG"));
            } catch (IOException ex){}
	}
}
