package webcam;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamResolution;
import java.awt.Dimension;

import javax.swing.*;
/**
 * Example of how to take single picture.
 * 
 * @author Bartosz Firyn (SarXos)
 */


public class TakePictureThread extends Thread{

        public JPanel p;
        public boolean isRunning;
	public void run(){

		// get default webcam and open it
		Webcam webcam = Webcam.getDefault();
		//webcam.setViewSize(WebcamResolution.VGA.getSize());
                webcam.setViewSize(new Dimension(640,480));
                webcam.open();

		// get image
                isRunning=true;
                while(isRunning)
                {
                    BufferedImage image = webcam.getImage();
                    p.getGraphics().drawImage(image, 0, 0, null);
                }

	}
}
