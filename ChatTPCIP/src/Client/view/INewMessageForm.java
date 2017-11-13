package Client.view;

import java.awt.event.ActionListener;

public interface INewMessageForm {
	public void closeForm();
	public void setActionListenerForOKButtonInNewMassageForm(ActionListener listener);
	public String getTextUserName();
}
