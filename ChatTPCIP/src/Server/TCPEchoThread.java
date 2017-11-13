package Server;

import java.io.*;
import java.net.*;
import java.sql.SQLException;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

public class TCPEchoThread implements Runnable {
	private Socket socket;
	public TCPEchoThread(Socket s){
		socket = s;
	}


	public void run() {
		try(ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream())
				){
			DataSend dataReceive = (DataSend) in.readObject();
			DataSend dataSend = new DataSend();
            System.out.println("DataReceive: "+dataReceive.getInfo());
			QuerryData querryData = new QuerryData();
			String command = dataReceive.getInfo().split("\\|")[0];
			System.out .println("Command: "+command);
			//command = "signIn";
			int commandID = 0;
			//do something here
			if (command.equals("signIn"))
				commandID = 1;
			else if(command.equals("signUp"))
				commandID = 2;
			else if(command.equals("sendMsg"))
				commandID = 3;
			else if(command.equals("updateListChat"))
				commandID = 4;
			else if(command.equals("updateChatWindow"))
				commandID = 5;
			else if(command.equals("sendFile"))
				commandID = 6;
			else if(command.equals("receiveFile"))
				commandID = 7;
			else if(command.equals("addConversation"))
				commandID = 8;
			else if(command.equals("changeAvatar"))
				commandID = 9;
			else if(command.equals("updateAvatar"))
				commandID = 10;
			switch (commandID){
			case 1:
				querryData.QuerrySignIn(dataReceive);
				dataSend = querryData.data;
				System.out.println("DataSend: "+dataSend.getInfo());
				out.writeObject(dataSend);		
				out.flush();
				break;
			////////////////////////////////
			case 2:
				querryData.QuerrySignUp(dataReceive);
				dataSend = querryData.data;
				if (querryData.data.getInfo().split("\\|")[0].equals("SignUpOK"))
					querryData.AddUser(dataReceive);
				out.writeObject(dataSend);
				System.out.println("DataSend: "+dataSend.getInfo());
				out.flush();
				break;
			////////////////////////////////
			case 3:
				querryData.AddMessage(dataReceive);
				break;
			///////////////////////////////
			case 4:
				querryData.QuerryListChat(dataReceive);
				dataSend = querryData.data;
				System.out.println("DataSend: "+dataSend.getInfo());
				out.writeObject(dataSend);
				out.flush();
				break;
			//////////////////////////////
			case 5:
				querryData.QuerryChatWindow(dataReceive);
				dataSend = querryData.data;
				//querryData.SetSeen(dataReceive);
				out.writeObject(dataSend);
				out.flush();
				break;
			//////////////////////////////
			case 6:
				querryData.SendFile(dataReceive);
				writeFileToDisk(dataReceive);
				break;
			/////////////////////////////
			case 7:
				dataSend = new DataSend ("receiveFile", null, null,null,null, dataReceive.getFileName(), readFileFromDisk(dataReceive));
				out.writeObject(dataSend);
				out.flush();
				break;
			////////////////////////////
			case 8 :
				querryData.QuerryUser(dataReceive);
				if(querryData.data.getInfo().split("\\|")[0].equals("AddConversationOK"))
					querryData.AddConversation(dataReceive);
				dataSend = querryData.data;
				System.out.println(dataSend.getInfo());
				out.writeObject(dataSend);
				out.flush();
				break;
			///////////////////////////
			case 9:
				writeAvatarToDisk(dataReceive);
				break;
			//////////////////////////
			case 10: 
				File fileAva = new File("D:\\Samsung\\Chat\\Server\\Avatar\\"+dataReceive.getYourUserName());
				if(fileAva.exists()){
					dataSend = new DataSend ("updateAvatarOK", null, null, null, null, null, readAvatarFromDisk(dataReceive));
				}
				else{
					dataSend = new DataSend ("updateAvatarNotOK", null, null, null, null, null,null);
				}
				out.writeObject(dataSend);
				out.flush();
				break;
			//////////////////////////
			default:
				break;
			}
			in.close();
			out.close();
			socket.close();
		}catch (IOException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}
	
	private void writeFileToDisk (DataSend dataReceive){
		String fileName = dataReceive.getFileName();
		try{
			FileOutputStream fos = new FileOutputStream("D:\\Samsung\\Chat\\Server\\File\\"+fileName);
			fos.write(dataReceive.getData());
			fos.close();
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}
	
	private byte[] readFileFromDisk (DataSend dataReceive){
		byte [] data = null;
		try{
			String fileName = dataReceive.getFileName();
			Path path = Paths.get("D:\\Samsung\\Chat\\Server\\File\\"+fileName);
			data = Files.readAllBytes(path);
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		return data;
	}
	
	private void writeAvatarToDisk(DataSend dataReceive){
		String fileName = dataReceive.getFileName();
		try{
			Path path = Paths.get("D:\\Samsung\\Chat\\Server\\Avatar\\"+fileName);
			if(new File("D:\\Samsung\\Chat\\Server\\Avatar\\"+fileName).exists())
				Files.delete(path);
			FileOutputStream fos = new FileOutputStream("D:\\Samsung\\Chat\\Server\\Avatar\\"+fileName);
			fos.write(dataReceive.getData());
			fos.close();
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}
	
	private byte[] readAvatarFromDisk(DataSend dataReceive){
		byte [] data = null;
		try{
			String fileName = dataReceive.getYourUserName();
			Path path = Paths.get("D:\\Samsung\\Chat\\Server\\Avatar\\"+fileName);
			data = Files.readAllBytes(path);
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		return data;
	}
	

}
