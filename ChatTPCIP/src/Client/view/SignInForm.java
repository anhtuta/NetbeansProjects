package Client.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SignInForm extends JFrame implements ISignInForm{
	public static JTextField tfUserName;
	public static JPasswordField tfPassword;
	
	public static JButton btnSignIn;
	public static JButton btnRegister;
	public static JButton btnExit;
	
	public SignInForm(){
		tfUserName = new JTextField(20);
		tfPassword = new JPasswordField(20);

		
		btnSignIn = new JButton("Sign In");
		btnRegister = new JButton("Register");
		btnExit = new JButton("Exit");
		
		btnExit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				closeForm();
			}
			
		});
		
		JLabel lbUserName = new JLabel("User Name: ");
		JLabel lbPassword = new JLabel("Password: ");
		
		JPanel tf = new JPanel(new GridLayout(2,2));
		tf.add(lbUserName);
		tf.add(tfUserName);
		tf.add(lbPassword);
		tf.add(tfPassword);
		
		JPanel btn = new JPanel(new GridLayout(1,3));
		btn.add(btnSignIn);
		btn.add(btnRegister);
		btn.add(btnExit);
		
		Container cp = this.getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(tf, BorderLayout.CENTER);
		cp.add(btn, BorderLayout.SOUTH);
		
        setTitle("Sign In");
        pack();
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
	}

	@Override
	public void closeForm() {
		// TODO Auto-generated method stub
		System.exit(0);
	}
	
	public void closeWhenSignInToMainView(){
		this.dispose();
	}

	@Override
	public void setActionListenerForSignInButtonInSignInForm(ActionListener listener) {
		// TODO Auto-generated method stub
		btnSignIn.addActionListener(listener);
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
	public void setActionListenerForRegisterButtonInSignInForm(ActionListener listener) {
		// TODO Auto-generated method stub
		btnRegister.addActionListener(listener);
	}
}
