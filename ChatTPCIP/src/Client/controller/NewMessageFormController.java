package Client.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JOptionPane;
import Client.view.*;
import Server.DataSend;

public class NewMessageFormController {
	public INewMessageForm newMessageForm;
	public static final String HOSTNAME = "ketromdeptrai.ddns.net";
	public NewMessageFormController() {
		newMessageForm = new NewMessageForm();
		newMessageForm.setActionListenerForOKButtonInNewMassageForm(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				boolean checkUserName = false;
				if (checkUserName == false && newMessageForm.getTextUserName().length() == 0) {
					checkUserName = true;
					JOptionPane.showMessageDialog(null, "User Name Is Not Null!", "Error", 0);
				}
				
				if (!checkUserName){
					//
					String userName = MainFormController.userName;
					String friendUserName = "| "+userName+" "+newMessageForm.getTextUserName()+" |";
					
					DataSend dataSend = new DataSend("addConversation", userName, " ", friendUserName, " ", " ", new byte[2]);
					try{
						Socket clientSocket = new Socket(HOSTNAME, 5000);
						ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
						ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
						out.writeObject(dataSend);
						out.flush();
						DataSend dataReceive = (DataSend) in.readObject();
			            System.out.println("DataSend: "+dataSend.getInfo());
						if (dataReceive.getInfo().split("\\|")[0].equals("AddConversationOK")){
							newMessageForm.closeForm();
							MainFormController.friendUserName = friendUserName.replaceAll("\\|", "");
						}
						else JOptionPane.showMessageDialog(null, "One or some user are not available", "Error", 0);
						clientSocket.close();	
					}
					catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
			
		});
	}
}
