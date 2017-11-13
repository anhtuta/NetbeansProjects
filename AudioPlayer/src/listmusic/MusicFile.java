package listmusic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class MusicFile {
	private String url;
	private String name;
	private File file;
	private String title;
	private String artist;
	private String album;
	private String year;
	private String comment;
	private int size;
	private int numberFrames;
	private double timeEnd;
	private int bitrate;
	private int frameLength;
	private int sizeOfTag;
	private int currentFrame;
	private byte[] byteInsert;

	public MusicFile() {
	}

	public MusicFile(File file) {
		this.file = file;
		this.url = file.getPath();
		this.name = file.getName();
		this.currentFrame = 0;
		setInformation();
		byteInsert = new byte[frameLength];
	}

	public MusicFile(String url, String name) {
		this.file = new File(url);
		this.url = url;
		this.name = name;
		setInformation();
		byteInsert = new byte[frameLength];
	}

	private void setSizeOfTag() {
		this.sizeOfTag = 0;
		FileInputStream fileInput;
		try {
			fileInput = new FileInputStream(file);
			fileInput.skip(6);
			byte[] byteFrame = new byte[4];
			fileInput.read(byteFrame);
			String s1 = String.format("%8s", Integer.toBinaryString(byteFrame[0] & 0xFF)).replace(' ', '0').substring(1,
					8);
			String s2 = String.format("%8s", Integer.toBinaryString(byteFrame[1] & 0xFF)).replace(' ', '0').substring(1,
					8);
			String s3 = String.format("%8s", Integer.toBinaryString(byteFrame[2] & 0xFF)).replace(' ', '0').substring(1,
					8);
			String s4 = String.format("%8s", Integer.toBinaryString(byteFrame[3] & 0xFF)).replace(' ', '0').substring(1,
					8);

			String size = s1 + s2 + s3 + s4;
			this.sizeOfTag = Integer.parseInt(size, 2);
			fileInput.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void setNumberFrames() {
		setSizeOfTag();
		FileInputStream fileInput;
		try {
			fileInput = new FileInputStream(file);
			fileInput.skip(getSizeOfTag() + 10);
			byte[] byteFrame = new byte[4];
			fileInput.read(byteFrame);
			String f1 = String.format("%8s", Integer.toBinaryString(byteFrame[0] & 0xFF)).replace(' ', '0');
			String f2 = String.format("%8s", Integer.toBinaryString(byteFrame[1] & 0xFF)).replace(' ', '0');
			String f3 = String.format("%8s", Integer.toBinaryString(byteFrame[2] & 0xFF)).replace(' ', '0');
			String f4 = String.format("%8s", Integer.toBinaryString(byteFrame[3] & 0xFF)).replace(' ', '0');
			String frames = f1 + f2 + f3 + f4;
			setBitrate(frames.substring(16, 20));
			getBitrate();
			int sampRate = 0;
			switch (Integer.valueOf(frames.substring(20, 22))) {
			case 0:
				sampRate = 44100;
				break;
			case 1:
				sampRate = 48000;
				break;
			case 10:
				sampRate = 32000;
				break;
			}
			int padd = Integer.valueOf(frames.substring(22, 23));
			frameLength = (int) ((144 * bitrate * 1000) / sampRate + padd);
			this.numberFrames = (int) (file.length() - getSizeOfTag() - 128) / frameLength;
			fileInput.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void setInformation() {
		try {
			setNumberFrames();
			timeEnd = numberFrames * 0.026;
			FileInputStream fileInput = new FileInputStream(file);
			size = (int) file.length();
			fileInput.skip(size - 128);
			byte[] byteInformation = new byte[128];
			fileInput.read(byteInformation);
			String information = new String(byteInformation);
			title = information.substring(3, 33);
			artist = information.substring(33, 63);
			album = information.substring(63, 93);
			year = information.substring(93, 97);
			comment = information.substring(97, 128);
			fileInput.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void getInformation() {
		System.out.println("frames = " + numberFrames + "\n" + "time end = " + timeEnd + "\n" + "title = " + title
				+ "\n" + "artist " + artist + "\n" + "year" + year + album);
	}

	public void changeInformation(File newFile, String newTitle, String newArtist, String newAlbum, String newYear,
			String newComment) {

		String nameFile = newFile.getName();
		if (nameFile.length() > 4) {
			String mp3 = nameFile.substring(nameFile.length() - 4);
			if (mp3.equals(".mp3")) {

			} else {
				newFile = new File(newFile.toString() + ".mp3");
				newFile = new File(newFile.getParentFile(), nameFile + ".mp3");
			}
		} else {
			newFile = new File(newFile.toString() + ".mp3");
			newFile = new File(newFile.getParentFile(), nameFile + ".mp3");
		}

		try {
			FileInputStream fileInput = new FileInputStream(file);
			OutputStream fileOutput = new FileOutputStream(newFile);
			size = (int) file.length();
			for (int i = 1; i <= size - 128; i++) {
				byte[] byteRead = new byte[1];
				fileInput.read(byteRead);
				fileOutput.write(byteRead);
			}

			byte[] byteTAG = "TAG".getBytes();
			for (int i = 0; i < 3; i++) {
				fileOutput.write(byteTAG[i]);
			}
			String o = " ";
			byte[] byteNewTitle = newTitle.getBytes();
			for (int i = 0; i < 30; i++) {
				if (i < byteNewTitle.length) {
					fileOutput.write(byteNewTitle[i]);
				} else {
					fileOutput.write(o.getBytes());
				}
			}
			byte[] byteNewArtist = newArtist.getBytes();
			for (int i = 0; i < 30; i++) {
				if (i < byteNewArtist.length) {
					fileOutput.write(byteNewArtist[i]);
				} else {
					fileOutput.write(o.getBytes());
				}
			}
			byte[] byteNewAlbum = newAlbum.getBytes();
			for (int i = 0; i < 30; i++) {
				if (i < byteNewAlbum.length) {
					fileOutput.write(byteNewAlbum[i]);
				} else {
					fileOutput.write(o.getBytes());
				}
			}
			byte[] byteNewYear = newYear.getBytes();
			for (int i = 0; i < 4; i++) {
				if (i < byteNewYear.length) {
					fileOutput.write(byteNewYear[i]);
				} else {
					fileOutput.write(o.getBytes());
				}
			}
			byte[] byteNewComment = newComment.getBytes();
			for (int i = 0; i < 31; i++) {
				if (i < byteNewComment.length) {
					fileOutput.write(byteNewComment[i]);
				} else {
					fileOutput.write(o.getBytes());
				}
			}
			fileInput.close();
			fileOutput.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

	public void cutFile(File newFile, int timeStartCut, int timeEndCut) {
		int frameStart = (int) (timeStartCut * numberFrames / timeEnd);
		int frameEnd = (int) (timeEndCut * numberFrames / timeEnd);
		int byteStart = getSizeOfTag() + frameStart * frameLength;
		int byteEnd = getSizeOfTag() + frameEnd * frameLength;
		String nameFile = newFile.getName();
		if (nameFile.length() > 4) {
			String mp3 = nameFile.substring(nameFile.length() - 4);
			if (mp3.equals(".mp3")) {

			} else {
				newFile = new File(newFile.toString() + ".mp3");
				newFile = new File(newFile.getParentFile(), nameFile + ".mp3");
			}
		} else {
			newFile = new File(newFile.toString() + ".mp3");
			newFile = new File(newFile.getParentFile(), nameFile + ".mp3");
		}

		try {
			FileInputStream fileInput = new FileInputStream(file);
			OutputStream fileOutput = new FileOutputStream(newFile);
			size = (int) file.length();
			for (int i = 1; i <= getSizeOfTag(); i++) {
				byte[] byteRead = new byte[1];
				fileInput.read(byteRead);
				fileOutput.write(byteRead);
			}
			fileInput.skip(byteStart - getSizeOfTag());
			for (int i = byteStart; i < byteEnd; i++) {
				byte[] byteRead = new byte[1];
				fileInput.read(byteRead);
				fileOutput.write(byteRead);
			}
			fileInput.close();
			FileInputStream fileInputInformation = new FileInputStream(file);
			fileInputInformation.skip(size - 128);
			byte[] byteInformation = new byte[128];
			fileInputInformation.read(byteInformation);
			fileOutput.write(byteInformation);
			fileInputInformation.close();
			fileOutput.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

	public void insertFile(File newFile) {
		int frameStart = 0;
		int frameEnd = numberFrames;
		int byteStart = getSizeOfTag() + frameStart * frameLength;
		int byteEnd = getSizeOfTag() + frameEnd * frameLength;
		int timeStartread = 0;
		int timeEndread = 0;
		String nameFile = newFile.getName();
		if (nameFile.length() > 4) {
			String mp3 = nameFile.substring(nameFile.length() - 4);
			if (mp3.equals(".mp3")) {

			} else {
				newFile = new File(newFile.toString() + ".mp3");
				newFile = new File(newFile.getParentFile(), nameFile + ".mp3");
			}
		} else {
			newFile = new File(newFile.toString() + ".mp3");
			newFile = new File(newFile.getParentFile(), nameFile + ".mp3");
		}

		try {
			FileInputStream fileInput = new FileInputStream(file);
			OutputStream fileOutput = new FileOutputStream(newFile);
			size = (int) file.length();
			for (int i = 1; i <= getSizeOfTag(); i++) {
				byte[] byteRead = new byte[1];
				fileInput.read(byteRead);

				fileOutput.write(byteRead);
			}

//			for (int i = byteStart; i < byteEnd;) {
//
//				byteStart++;
//				timeEndread = (int) ((byteStart - sizeOfTag) * timeEnd / (byteEnd - sizeOfTag));
//				// System.out.println(byteStart);
//				// System.out.println(timeEndread);
//				if (timeEndread - timeStartread <= 1) {
//					fileInput.read(byteInsert);
//					i++;
//				}
//				if (timeEndread - timeStartread >= 3) {
//					timeStartread = timeEndread;
//				}
//				fileOutput.write(byteInsert);
//			}
			for (int i = frameStart; i < 300;) {

				frameStart++;
				timeEndread = (int) (frameStart * timeEnd / frameEnd);
				// System.out.println(byteStart);
				System.out.println("frameStart" + frameStart + "\n");
				 System.out.println("timeEndread" + timeEndread+ "\n");
				 System.out.println(" hieu "+(timeEndread - timeStartread)+ "\n");
				if (timeEndread - timeStartread < 1) {
					fileInput.read(byteInsert);
					i++;
				} else {
					System.out.println(byteInsert.length - frameLength +"ok");
				}
				if (timeEndread - timeStartread >=2) {
					timeStartread = timeEndread;
					
				}
				fileOutput.write(byteInsert);
			}
			fileInput.close();
			FileInputStream fileInputInformation = new FileInputStream(file);
			fileInputInformation.skip(size - 128);
			byte[] byteInformation = new byte[128];
			fileInputInformation.read(byteInformation);
			fileOutput.write(byteInformation);
			fileInputInformation.close();
			fileOutput.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public int getCurrentFrame() {
		return currentFrame;
	}

	public void setCurrentFrame(int currentTime) {
		this.currentFrame = (int) (currentTime * numberFrames / timeEnd);
	}

	public void increaseCurrentFrame() {
		this.currentFrame = this.currentFrame + (int) (numberFrames / (20 * timeEnd));

	}

	public int getCurrentTimeSecond() {
		int currentTime = (int) (this.currentFrame * timeEnd / numberFrames);
		return currentTime;
	}

	public String getCurrentTime() {
		int currentTime = (int) (this.currentFrame * timeEnd / numberFrames);
		String hour = String.valueOf((int) currentTime / 3600);
		String minute = String.valueOf((int) (currentTime / 60) - Integer.valueOf(hour) * 60);
		String second = String.valueOf(currentTime - Integer.valueOf(minute) * 60);
		String time = hour + ":" + minute + ":" + second;
		return time;
	}

	public String getTotalTime() {

		String hour = String.valueOf((int) (timeEnd / 3600));
		String minute = String.valueOf((int) (timeEnd / 60) - Integer.valueOf(hour) * 60);
		String second = String.valueOf((int) timeEnd - Integer.valueOf(minute) * 60);
		String time = hour + ":" + minute + ":" + second;
		return time;
	}

	public void setBitrate(String bitrate) {
		switch (Integer.valueOf(bitrate)) {
		case 0:
			this.bitrate = 128;
			break;
		case 1:
			this.bitrate = 32;
			break;
		case 10:
			this.bitrate = 40;
			break;
		case 11:
			this.bitrate = 48;
			break;
		case 100:
			this.bitrate = 56;
			break;
		case 101:
			this.bitrate = 64;
			break;
		case 110:
			this.bitrate = 80;
			break;
		case 111:
			this.bitrate = 96;
			break;
		case 1000:
			this.bitrate = 112;
			break;
		case 1001:
			this.bitrate = 128;
			break;
		case 1010:
			this.bitrate = 160;
			break;
		case 1011:
			this.bitrate = 192;
			break;
		case 1100:
			this.bitrate = 224;
			break;
		case 1101:
			this.bitrate = 256;
			break;
		case 1110:
			this.bitrate = 320;
			break;
		case 1111:
			this.bitrate = 320;
			break;
		}
	}

	public File getFile() {
		return file;
	}

	public int getSize() {
		return size;
	}

	public double getTimeEnd() {
		return timeEnd;
	}

	public int getSizeOfTag() {
		return sizeOfTag;
	}

	public String getUrl() {
		return url;
	}

	public String getName() {
		return name;
	}

	public int getNumberFrames() {
		return numberFrames;
	}

	public int getFrameLength() {
		return frameLength;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getTitle() {
		return title;
	}

	public String getArtist() {
		return artist;
	}

	public String getAlbum() {
		return album;
	}

	public String getYear() {
		return year;
	}

	public int getBitrate() {
		return bitrate;
	}

}
