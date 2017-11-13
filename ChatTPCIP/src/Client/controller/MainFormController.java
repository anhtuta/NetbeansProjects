package Client.controller;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.StyledDocument;
import javax.swing.text.Utilities;

import Client.view.IMainForm;
import Client.view.MainForm;
import Server.DataSend;
import Client.model.*;

public class MainFormController {
	public IMainForm mainForm;
	public static String userName;
	public static String friendUserName;
	private Conversation [] conv = new Conversation[100];
	private boolean stopThread = false;
	public static final String HOSTNAME = "ketromdeptrai.ddns.net";
	private String dataTemp, dataTemp2;
	public MainFormController(String userName) throws InterruptedException{

		mainForm = new MainForm(userName);
		this.userName = userName;
		friendUserName = " "+userName+" ";
		mainForm.addActionListenerForNewMessageInMainForm(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new NewMessageFormController();
			}
		});
		
		mainForm.addActionListenerForChangeAvatarInMainForm(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JFileChooser obj = new JFileChooser();
				int returnVal = obj.showOpenDialog((Component) mainForm);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = obj.getSelectedFile();
					if (!(file.getName().contains(".jpg") || file.getName().contains(".png") || file.getName().contains(".gif")))
						JOptionPane.showMessageDialog(null, "Invalid image format!", "Error", 0);
					else{
						Path path = Paths.get(file.getPath());
						try {
							byte [] data = Files.readAllBytes(path);
							DataSend dataSend = new DataSend("changeAvatar", userName, null, "|"+friendUserName+"|", null, userName, data);
							Socket clientSocket = new Socket(HOSTNAME, 5000);
							ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
							out.writeObject(dataSend);
							out.flush();
							if (clientSocket.isInputShutdown() || clientSocket.isOutputShutdown())
								clientSocket.close();
						}
						catch (IOException e) {
							// TODO Auto-generated catch block
							System.out.println("IOE");
						}
					}
				}		
			}
	
		});
		
		mainForm.addActionListenerForJListInMainForm(new ListSelectionListener(){

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					if (mainForm.getSelectJList()!= null){
						try {
							friendUserName = " "+mainForm.getSelectJList()+" ";
						} catch (Exception e) {
							// TODO Auto-generated catch block
							System.out.println(e.getMessage());
						}
						System.out.println(friendUserName);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
			}
			
		}); 
		
		mainForm.addActionListenerForSignOutInMainForm(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//close 2 thread
				mainForm.closeForm();
				stopThread = true;
				SignInController signIn = new SignInController();
				
			}
		});

		mainForm.addActionListenerForSendButtonInMainForm(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String message = mainForm.getTextToSend().replaceAll("\n", "");
			//	mainForm.handleReceiver(text);//, Color.red);
				DataSend dataSend = new DataSend("sendMsg", userName, " ", "|"+friendUserName+"|", message.replaceAll("_", ""), " ", new byte[2]);
				try{
					Socket clientSocket = new Socket(HOSTNAME, 5000);
					ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
					out.writeObject(dataSend);
					System.out.println("DataSend: "+dataSend.getInfo());
					if (clientSocket.isInputShutdown() || clientSocket.isOutputShutdown())
						clientSocket.close();
				}
				catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());				}			
			}
		});

		mainForm.addActionListenerForAttachFileInMainForm(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JFileChooser obj = new JFileChooser();
				int returnVal = obj.showOpenDialog((Component) mainForm);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = obj.getSelectedFile();
					Path path = Paths.get(file.getPath());
					try {
						byte [] data = Files.readAllBytes(path);
						DataSend dataSend = new DataSend("sendFile", userName, null, "|"+friendUserName+"|", null, file.getName().replaceAll("_", ""), data);
						Socket clientSocket = new Socket(HOSTNAME, 5000);
						ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
						out.writeObject(dataSend);
						out.flush();
						if (clientSocket.isInputShutdown() || clientSocket.isOutputShutdown())
							clientSocket.close();
					}
					catch (IOException e) {
						System.out.println("IOE");
					}
				}		
			}
		});
		/////////////
		Thread updateListChatThread = new Thread(){
			public void run(){
				while (!stopThread){
					updateListChat();
					try {
						sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
				}
			}
		};
		updateListChatThread.start();
		/////////////
		Thread updateChatWindowThread = new Thread(){
			public void run(){
				while (!stopThread){
					updateChatWindow();
					try {
						sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
				}
			}
		};
		updateChatWindowThread.start();
		/////////////

	}
	
	private void updateListChat(){
		DataSend dataSend = new DataSend("updateListChat", userName, " ", " ", " ", " ", new byte[2]);
		try{
			Socket clientSocket = new Socket(HOSTNAME, 5000);
			ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
			ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
			out.writeObject(dataSend);
			System.out.println("DataSend: "+dataSend.getInfo());
			DataSend dataReceive = (DataSend) in.readObject();
			System.out.println("DataReceive: "+dataReceive.getInfo());
			clientSocket.close();
			if (!(dataReceive.getInfo().equals(dataTemp2))){
				String [] yourFriendUserList = dataReceive.getYourFriendUserName().split("_");
				String [] messageList = dataReceive.getMessage().split("_");
				String [] timeList = dataReceive.getTimelist().split("_");
				String [] displayUserList = new String [100];
				for (int i = 0; i<yourFriendUserList.length; i++){
					displayUserList[i] = (" "+yourFriendUserList[i]+" ").replaceAll(" "+userName+" ", " ").trim();
					File fileAvatar = new File("D:\\icon\\"+displayUserList[i]);
					Path path = Paths.get("D:\\icon\\"+displayUserList[i]);
					if (fileAvatar.exists()){
						Files.delete(path);
					}
					Socket clientSocket1 = new Socket(HOSTNAME, 5000);
					ObjectOutputStream out1 = new ObjectOutputStream(clientSocket1.getOutputStream());
					ObjectInputStream in1 = new ObjectInputStream(clientSocket1.getInputStream());
					DataSend dataSend1 = new DataSend("updateAvatar", displayUserList[i], " ", " ", " ", " ", new byte[2]);
					out1.writeObject(dataSend1);
					System.out.println("DataSend: "+dataSend1.getInfo());
					DataSend dataReceive1 = (DataSend) in1.readObject();
					System.out.println("DataReceive: "+dataReceive1.getInfo());
					clientSocket1.close();
					if (dataReceive1.getCommand().equals("updateAvatarOK")){
						FileOutputStream fos = new FileOutputStream("D:\\icon\\"+displayUserList[i]);
						fos.write(dataReceive1.getData());
						fos.close();
					}
				}

				//Cap nhat avatar tai day
				for (int i = 0; i< yourFriendUserList.length; i++){
					conv[i] = new Conversation (yourFriendUserList[i], (" "+yourFriendUserList[i]+" ").replaceAll(" "+userName+" ", " ").trim(),  messageList[i].replaceAll("\\|", " "), Long.parseLong(timeList[i]));

				}
				dataTemp2 = dataReceive.getInfo();
				mainForm.resetList(conv);
			}
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	private void updateChatWindow(){
		DataSend dataSend;
		dataSend = new DataSend("updateChatWindow", userName, " ", "|"+friendUserName+"|", " ", " ", new byte[2]);
		try{
			Socket clientSocket = new Socket(HOSTNAME, 5000);
			ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
			ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
			out.writeObject(dataSend);
			System.out.println("DataSend: "+dataSend.getInfo());
			DataSend dataReceive = (DataSend) in.readObject();
			System.out.println("DataReceive: "+dataReceive.getInfo());
			clientSocket.close();
			if (!(dataReceive.getInfo().equals(dataTemp))){
				String [] userSendList = dataReceive.getTimelist().split("_");
				String [] messageList = dataReceive.getMessage().split("_");
				mainForm.clearJTextPane();
				for (int i = 1; i < userSendList.length; i++){
					if (userSendList[i].equals(userName))
						mainForm.insertStringInPane(12, userSendList[i]+": ", Color.red);
					else mainForm.insertStringInPane(12, userSendList[i]+": ", Color.blue);
					mainForm.handleReceiver(messageList[i]);
					mainForm.handleString("\n");				
				}
				dataTemp = dataReceive.getInfo();
			}
			
 		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	public static void receiveFile (String fileName){
		DataSend dataSend = new DataSend("receiveFile", userName, " ", " ", " ", fileName, new byte[2]);
		try{
			Socket clientSocket = new Socket(HOSTNAME, 5000);
			ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
			ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
			out.writeObject(dataSend);
			System.out.println("DataSend: "+dataSend.getInfo());
			DataSend dataReceive = (DataSend) in.readObject();
			System.out.println("DataReceive: "+dataReceive.getInfo());
			clientSocket.close();
			FileOutputStream fos = new FileOutputStream("D:\\"+fileName);
			fos.write(dataReceive.getData());
			fos.close();
			JOptionPane.showMessageDialog(null, "File saved to D:\\"+fileName);
		}
		catch (IOException | NullPointerException e1) {
			// TODO Auto-generated catch block
			System.out.print(e1);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			System.out.print(e1);
		}			
	}
}
