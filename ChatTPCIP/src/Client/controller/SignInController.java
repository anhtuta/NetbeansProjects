package Client.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JOptionPane;

//import Client.model.DataSend;
import Client.view.ISignInForm;
import Client.view.SignInForm;
import Server.DataSend;

public class SignInController {
	ISignInForm signInForm;
	public static final String HOSTNAME = "ketromdeptrai.ddns.net";

	public SignInController() {
		signInForm = new SignInForm();
		signInForm.setActionListenerForSignInButtonInSignInForm(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				boolean checkUserName = false;
				
				if (checkUserName == false && signInForm.getTextUserName().length() == 0) {
					checkUserName = true;
					JOptionPane.showMessageDialog(null, "User Name Is Not Null!", "Error", 0);

				}
				if (checkUserName == false && signInForm.getTextPassword().length() == 0) {
					checkUserName = true;
					JOptionPane.showMessageDialog(null, "Password Is Not Null!", "Error", 0);	
				}
				
				if (!checkUserName){ //send data to server
					String userName = signInForm.getTextUserName();
					String password = signInForm.getTextPassword();
					DataSend dataSend = new DataSend("signIn", userName, password, " ", " ", " ", new byte[2]);
					try{
						Socket clientSocket = new Socket(HOSTNAME, 5000);
						ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
						ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
						out.writeObject(dataSend);
						out.flush();
						DataSend dataReceive = (DataSend) in.readObject();
			            System.out.println("DataSend: "+dataSend.getInfo());
						if (dataReceive.getInfo().split("\\|")[0].equals("SignInOK")){
							//JOptionPane.showMessageDialog(null, "Sign In Successful");
							MainFormController mainFormController = new MainFormController(signInForm.getTextUserName());
							signInForm.closeWhenSignInToMainView();
						}
						else JOptionPane.showMessageDialog(null, "Username or Password is incorrect", "Error", 0);
						clientSocket.close();	
					}
					catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		});
		signInForm.setActionListenerForRegisterButtonInSignInForm(new ActionListener (){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				SignUpController signUp = new SignUpController();
			}
			
			
		});
	}
}
