package Client.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;

import javax.swing.event.ListSelectionListener;

import Client.model.Conversation;

public interface IMainForm {

	public void addActionListenerForSignOutInMainForm(ActionListener listener);
	public void addActionListenerForTemp(ActionListener listener);
	public void addActionListenerForNewMessageInMainForm(ActionListener listener);
	public void addActionListenerForAttachFileInMainForm(ActionListener listener);
	public void addActionListenerForSendButtonInMainForm(ActionListener listener);
	public void closeForm();
	public void inSert(Component pathFile);
	public void insertStringInPane(int size, String text, Color cl);
	public String getTextToSend();
	public void handleString(String string);
	public void handleReceiver(String string);
	void resetList(Conversation[] conv);
	public String getSelectJList() throws Exception;
	public void addActionListenerForJListInMainForm(ListSelectionListener listener);
	public void clearJTextPane();
	public String getJButtonTemp();
	void addActionListenerForChangeAvatarInMainForm(ActionListener listener);
	public void setScrollBottom();
}
