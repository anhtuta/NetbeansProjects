package Client.view;

import java.awt.event.ActionListener;

public interface ISignInForm {
	public void closeForm();
	public void closeWhenSignInToMainView();
	public void setActionListenerForSignInButtonInSignInForm(ActionListener listener);
	public void setActionListenerForRegisterButtonInSignInForm(ActionListener listener);
	public String getTextUserName();
	public String getTextPassword();
}
