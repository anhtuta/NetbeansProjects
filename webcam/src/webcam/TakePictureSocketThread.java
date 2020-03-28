package webcam;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamResolution;

import javax.swing.*;
import java.net.*;
import java.io.*;
import javax.imageio.ImageIO;

/**
 * Example of how to take single picture.
 * 
 * @author Bartosz Firyn (SarXos)
 */


public class TakePictureSocketThread extends Thread{

        public Socket s;
        public boolean isRunning;
        public ServerSocket ss;
        public JPanel p;
	public void run(){

		// get default webcam and open it
		Webcam webcam = Webcam.getDefault();
                webcam.setViewSize(new Dimension(176,144));
		//webcam.setViewSize(WebcamResolution.VGA.getSize());
                webcam.open();
                isRunning=true;
                try
                {
                    ss=new ServerSocket(1088);
                    s=ss.accept();
                    OutputStream os=s.getOutputStream();
                    System.out.println("Client connected!");
                    while(isRunning)
                    {
                        BufferedImage image = webcam.getImage();
                        //java.io.BufferedOutputStream bo=new BufferedOutputStream(s.getOutputStream());
                        //ObjectOutputStream oo=new ObjectOutputStream(s.getOutputStream());
                        //oo.writeObject(image);
                        //oo.flush();
                        //System.out.println("An image was sent!");
                        
                        ImageIO.write(image, "PNG", os);
                        os.flush();
                        p.getGraphics().drawImage(image, 0, 0,null);
                        Thread.sleep(100);
                    }
                    
                } catch (Exception ex){}
	}
}
