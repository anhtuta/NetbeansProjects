package webcam;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamStreamer;


public class MjpegStreamingExample {

	public void runMe() {
		Webcam w = Webcam.getDefault();
		new WebcamStreamer(8088, w, 0.1, true);
                
		do {
                    try
                    {
			Thread.sleep(500);
                    } catch (Exception ex){}

		} while (true);
	}

}
