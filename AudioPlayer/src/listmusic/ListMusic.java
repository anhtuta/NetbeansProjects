package listmusic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JTextArea;
import javax.swing.JTextPane;

import main.AudioPlayer;

public class ListMusic {

	private ArrayList<MusicFile> listMusicFile;
	private String urlListURL;
	private String urlListName;
	private String currentListURL;
	private String currentListName;
	private JTextPane textPane;
	private JTextArea textArea;
	public ListMusic() {
		listMusicFile = new ArrayList<>();
		urlListURL = AudioPlayer.getCurrentDirectory() + "//audioplayer.listmusic.txt";
		urlListName = AudioPlayer.getCurrentDirectory() + "//audioplayer.listname.txt";
		getCurrentListName();
		getCurrentListURL();
		setListMusicFile();
		
		
		
	}

	public void setListMusicFile() {
		BufferedReader brURL;
		BufferedReader brName;

		try {
			brURL = new BufferedReader(new FileReader(urlListURL));
			brName = new BufferedReader(new FileReader(urlListName));
			String lineURL = brURL.readLine();
			String lineName = brName.readLine();
			if (lineURL != null) {
				listMusicFile.add(new MusicFile(lineURL, lineName));
				lineURL = brURL.readLine();
				lineName = brName.readLine();
			}
			while (lineURL != null) {
				listMusicFile.add(new MusicFile(lineURL, lineName));
				lineURL = brURL.readLine();
				lineName = brName.readLine();
			}
			brURL.close();
			brName.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String getCurrentListURL() {
		if (currentListURL == null) {
			BufferedReader br;
			try {
				br = new BufferedReader(new FileReader(urlListURL));
				String line = br.readLine();
				if (line != null) {
					currentListURL = line;
					line = br.readLine();
				}
				while (line != null) {
					currentListURL = currentListURL + "\n" + line;
					line = br.readLine();
				}
				br.close();
			} catch (FileNotFoundException e) {

				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return currentListURL;
	}

	public void addToCurrentListURL(String audioURL) {
		if (this.currentListURL == null) {
			this.currentListURL = audioURL;
		} else {
			this.currentListURL = this.currentListURL + "\n" + audioURL;
			System.out.println(currentListURL);
		}
		BufferedWriter bw;
		try {
			
			bw = new BufferedWriter(new FileWriter(urlListURL));
			
			bw.write(this.currentListURL);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getCurrentListName() {
		if (currentListName == null) {
			BufferedReader br;
			try {
				br = new BufferedReader(new FileReader(urlListName));
				String line = br.readLine();
				if (line != null) {
					currentListName = line;
					line = br.readLine();
				}
				while (line != null) {
					currentListName = currentListName + "\n" + line;
					line = br.readLine();
				}
				br.close();
			} catch (FileNotFoundException e) {

				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return currentListName;
	}

	public void addToCurrentListName(String audioName) {
		if (this.currentListName == null) {
			this.currentListName = audioName;
		} else {
			this.currentListName = this.currentListName + "\n" + audioName;
		}
		BufferedWriter bw;
		try {
			bw = new BufferedWriter(new FileWriter(urlListName));
			bw.write(this.currentListName);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getUrlListURL() {
		return urlListURL;
	}

	public String getUrlListName() {
		return urlListName;
	}

	public void addToListMusicFile(String audioURL, String audioName) {
		listMusicFile.add(new MusicFile(audioURL, audioName));
	}

	public ArrayList<MusicFile> getListMusicFile() {
		return listMusicFile;
	}
}
