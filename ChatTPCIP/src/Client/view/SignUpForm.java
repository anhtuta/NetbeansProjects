package Client.view;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class SignUpForm  extends JFrame implements ISignUpForm{
	public static JTextField tfUserName;
	public static JPasswordField tfPassword;
	public static JPasswordField tfReEnterPassword;
	
	public static JButton btnSignUp;
	public static JButton btnCancel;
	
	public SignUpForm(){
		tfUserName = new JTextField(20);
		tfPassword = new JPasswordField(20);
		tfReEnterPassword = new JPasswordField(20);
		
		btnSignUp = new JButton("Sign Up");
		btnCancel = new JButton("Cancel");
		
		btnCancel.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				closeForm();
			}
			
		});
		
		JLabel lbUserName = new JLabel("User Name: ");
		JLabel lbPassword = new JLabel("Password: ");
		JLabel lbReEnterPassword = new JLabel("Re-Enter Password: ");
		
		Container cp = this.getContentPane();
		cp.setLayout(new GridLayout(4,2));
		cp.add(lbUserName);
		cp.add(tfUserName);
		cp.add(lbPassword);
		cp.add(tfPassword);
		cp.add(lbReEnterPassword);
		cp.add(tfReEnterPassword);
		cp.add(btnSignUp);
		cp.add(btnCancel);
		
        setTitle("Sign Up");
        pack();
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
	}
	@Override
	public void closeForm() {
		// TODO Auto-generated method stub
		this.dispose();
	}
	@Override
	public void setActionListenerForSignUpButtonInSignUpForm(ActionListener listener) {
		// TODO Auto-generated method stub
		btnSignUp.addActionListener(listener);
	}
	@Override
	public String getTextUserName() {
		// TODO Auto-generated method stub
		return tfUserName.getText().trim();
	}
	@Override
	public String getTextPassword() {
		// TODO Auto-generated method stub
		return tfPassword.getText();
	}
	@Override
	public String getTextReEnterPassword() {
		// TODO Auto-generated method stub
		return tfReEnterPassword.getText();
	}
	
	
}
