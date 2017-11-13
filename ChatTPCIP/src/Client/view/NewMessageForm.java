package Client.view;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NewMessageForm extends JFrame implements INewMessageForm{
	public static JTextField tfUserName;
	
	public static JButton btnOK;
	public static JButton btnCancel;
	
	public NewMessageForm(){
		tfUserName = new JTextField(50);
		
		btnOK = new JButton("OK");
		btnCancel = new JButton("Cancel");
		
		btnCancel.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				closeForm();
			}
			
		});
		
		JLabel lbUserName = new JLabel("To: ");
		
		Container cp = this.getContentPane();
		JPanel panel1 = new JPanel();
		panel1.add(lbUserName);
		panel1.add(tfUserName);
		JPanel panel2 = new JPanel();
		panel2.add(btnOK);
		panel2.add(btnCancel);
		cp.setLayout(new GridLayout(2,1));
		cp.add(panel1);
		cp.add(panel2);
		
        setTitle("New Conversation");
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
	public void setActionListenerForOKButtonInNewMassageForm(ActionListener listener) {
		// TODO Auto-generated method stub
		btnOK.addActionListener(listener);
	}

	@Override
	public String getTextUserName() {
		// TODO Auto-generated method stub
		return tfUserName.getText().trim();
	}
}
