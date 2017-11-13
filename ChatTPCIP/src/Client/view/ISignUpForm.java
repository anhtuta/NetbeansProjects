package Client.view;

import java.awt.event.ActionListener;

public interface ISignUpForm {
	public void closeForm();
	public void setActionListenerForSignUpButtonInSignUpForm(ActionListener listener);
	public String getTextUserName();
	public String getTextPassword();
	public String getTextReEnterPassword();

}
