package Client.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JOptionPane;

import Client.view.ISignUpForm;
import Client.view.SignUpForm;
import Server.DataSend;
//import Client.model.DataSend;

public class SignUpController {
	ISignUpForm signUpForm;
//	String UserName = "Hello";
	public static final String HOSTNAME = "ketromdeptrai.ddns.net";
	public SignUpController() {
		signUpForm = new SignUpForm();
		signUpForm.setActionListenerForSignUpButtonInSignUpForm(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				boolean checkUserName = false;
				for (int i = 0; i<signUpForm.getTextUserName().length(); i++)
					if (signUpForm.getTextUserName().charAt(i) == ' ')
						checkUserName = true;
				if (checkUserName)
					JOptionPane.showMessageDialog(null, "User Name can't contain space character!", "Error", 0);
				
				if (checkUserName == false && signUpForm.getTextUserName().length() == 0) {
					checkUserName = true;
					JOptionPane.showMessageDialog(null, "User Name Is Not Null!", "Error", 0);
				}
				
				if (checkUserName == false && signUpForm.getTextUserName().length() == 0) {
					checkUserName = true;
					JOptionPane.showMessageDialog(null, "User Name Is Not Null!", "Error", 0);
				}
				
				if (checkUserName == false && signUpForm.getTextPassword().length() == 0) {
					checkUserName = true;
					JOptionPane.showMessageDialog(null, "Password Is Not Null!", "Error", 0);	
				}
				
				if(checkUserName == false && signUpForm.getTextPassword().compareTo(signUpForm.getTextReEnterPassword()) != 0){
					checkUserName = true;
					JOptionPane.showMessageDialog(null, "Re-enter Password don't match Password !", "Error", 0);				
				}
				
				//
				if (!checkUserName){ // send data to server
					String userName = signUpForm.getTextUserName();
					String password = signUpForm.getTextPassword();
					DataSend dataSend = new DataSend("signUp", userName, password, null, null, null, null);
					try{
						Socket clientSocket = new Socket(HOSTNAME, 5000);
						ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
						ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
						out.writeObject(dataSend);
						out.flush();
						DataSend dataReceive = (DataSend) in.readObject();
						if (dataReceive.getInfo().split("\\|")[0].equals("SignUpOK")){
							JOptionPane.showMessageDialog(null, "Sign Up Successful");
							signUpForm.closeForm();
						}
						else JOptionPane.showMessageDialog(null, "Username has already existed", "Error", 0);
						clientSocket.close();	
					}
					catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}
				
				
			}
		});
		
		
	}
}


