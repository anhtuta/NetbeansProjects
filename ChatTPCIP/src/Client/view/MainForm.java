package Client.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.text.Utilities;

import Client.controller.MainFormController;
import Client.model.ConvRenderer;
import Client.model.Conversation;

public class MainForm extends JFrame implements IMainForm {
	
	//emoticon
	ImageIcon angry = new ImageIcon(getClass().getResource("/icon/angry.png"));
	final String strAngry = ">:O";
	ImageIcon big_smile = new ImageIcon(getClass().getResource("/icon/big_smile.png"));
	final String strBigSmile = ":D";
	ImageIcon cry = new ImageIcon(getClass().getResource("/icon/cry.png"));
	final String strCry = ":'(";
	ImageIcon curly_lips = new ImageIcon(getClass().getResource("/icon/curly_lips.png"));
	final String strCurlyLips = ":3";
	ImageIcon glasses = new ImageIcon(getClass().getResource("/icon/glasses.png"));
	final String strGlasses = "8-)";
	ImageIcon heart = new ImageIcon(getClass().getResource("/icon/heart.png"));
	final String strHeart = "<3";
	ImageIcon kiki = new ImageIcon(getClass().getResource("/icon/kiki.png"));
	final String strKiki = "^_^";
	ImageIcon kiss = new ImageIcon(getClass().getResource("/icon/kiss.png"));
	final String strKiss = ":*";
	ImageIcon like = new ImageIcon(getClass().getResource("/icon/like.png"));
	final String strLike = "(y)";
	ImageIcon pacman = new ImageIcon(getClass().getResource("/icon/pacman.png"));
	final String strPacman = ":v";
	ImageIcon sad = new ImageIcon(getClass().getResource("/icon/sad.png"));
	final String strSad = ":(";
	ImageIcon squinting = new ImageIcon(getClass().getResource("/icon/squinting.png"));
	final String strsquinting = "-_-";
	ImageIcon tongue_out = new ImageIcon(getClass().getResource("/icon/tongue_out.png"));
	final String strTongueOut = ":P";
	ImageIcon unsure = new ImageIcon(getClass().getResource("/icon/unsure.png"));
	final String strUnsure = ":/";
	ImageIcon wink = new ImageIcon(getClass().getResource("/icon/wink.png"));
	final String strWink = ";)";
	ImageIcon wtf = new ImageIcon(getClass().getResource("/icon/wtf.png"));
	final String strWtf = "o.O";
	
	String[] emoticons = {strAngry, strBigSmile, strCry, strCurlyLips, strGlasses,
			strHeart, strKiki, strKiss, strLike, strPacman, strSad, strsquinting,
			strTongueOut, strUnsure, strWink, strWtf};
	
	public JList myList;
	private JMenuItem btnAdd = new JMenuItem("New",KeyEvent.VK_N);
	private JMenuItem btnOut = new JMenuItem("Sign out",KeyEvent.VK_G);
	private JMenuItem btnChangeAvatar = new JMenuItem ("Change Avatar", KeyEvent.VK_C);
	private JButton btnSend = new JButton("Send");
	private JButton btnAtt = new JButton("Attach File");
	private JTextField tfMess = new JTextField(20);
	private JTextPane taShow = new JTextPane();
	private JButton btnTemp = new JButton(" ");
	private JScrollPane scrollShow;
	
	private JList<Conversation> createList() {
		// create defaultListModel
		DefaultListModel<Conversation> model = new DefaultListModel<>();
		// add element to model
		
		// set model to JList
		JList<Conversation> list = new JList<Conversation>(model);
		list.setCellRenderer(new ConvRenderer());
		return list;
	}
	
	
	
	public MainForm(String userName){
		
		//display Menu bar
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Option");
		menu.setMnemonic(KeyEvent.VK_O);
		menuBar.add(menu);
		menu.add(btnAdd);
		menu.add(btnChangeAvatar);
		menu.add(btnOut);
		setJMenuBar(menuBar);
		
		//display list
		myList = createList();  //create list
		JScrollPane scrollList = new JScrollPane(myList);
		scrollList.setBorder(BorderFactory.createEmptyBorder(
				5, //top
				5, //left
				5, //bottom
				0) //right
				);
		
		taShow.setEditable(false);
		
		
		//panel send message (right)
		JPanel pnRight = new JPanel(new BorderLayout());
		
		//panel includes text field, 2 buttons are send and attach 
		JPanel pnUnder = new JPanel(new BorderLayout());
		
		//panel Send: 2 buttons are send and attach
		JPanel pnSend = new JPanel(new GridLayout(0,1,5,5));
		pnSend.add(btnSend);
		pnSend.add(btnAtt);
		pnUnder.add(pnSend,BorderLayout.EAST);
		btnSend.requestFocus();
		pnUnder.add(tfMess,BorderLayout.CENTER);
		// enter for tfMess
		tfMess.addKeyListener(new KeyListener(){


			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER)
					btnSend.doClick();
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		//Text Panes
		scrollShow = new JScrollPane(taShow);
		taShow.setVisible(true);
		
		//Show
		pnRight.add(scrollShow,BorderLayout.CENTER);
		pnRight.add(pnUnder,BorderLayout.SOUTH);
		pnRight.setBorder(BorderFactory.createEmptyBorder(
				5, //top
				5, //left
				5, //bottom
				5) //right
				);
		
		// add panel to container
		setLayout(new BorderLayout());
		add(scrollList,BorderLayout.WEST);
		add(pnRight,BorderLayout.CENTER);
		
		setTitle(userName + " - Best Java chat software in the world");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,500);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	public void addActionListenerForTemp(ActionListener listener){
		this.btnTemp.addActionListener(listener);
	}
	@Override
	public void addActionListenerForChangeAvatarInMainForm(ActionListener listener){
		this.btnChangeAvatar.addActionListener(listener);
	}
	
	public void addActionListenerForSignOutInMainForm(ActionListener listener) {
		// TODO Auto-generated method stub
		this.btnOut.addActionListener(listener);
	}
	@Override
	public void addActionListenerForNewMessageInMainForm(ActionListener listener) {
		// TODO Auto-generated method stub
		this.btnAdd.addActionListener(listener);
	}
	@Override
	public void addActionListenerForAttachFileInMainForm(ActionListener listener) {
		// TODO Auto-generated method stub
		this.btnAtt.addActionListener(listener);
	}
	@Override
	public void addActionListenerForSendButtonInMainForm(ActionListener listener) {
		// TODO Auto-generated method stub
		this.btnSend.addActionListener(listener);
	}
	@Override
	public void closeForm() {
		// TODO Auto-generated method stub
		this.dispose();
	}
	
	@Override
	public void inSert(Component component) {
		// TODO Auto-generated method stub
		taShow.insertComponent(component);
	}


	@Override
	public void insertStringInPane(int size, String text, Color cl) {
		// TODO Auto-generated method stub
		StyledDocument doc = (StyledDocument) taShow.getDocument();

	    // Create a style object and then set the style attributes
	    Style style = doc.addStyle("Sty", null);
	    StyleConstants.setFontSize(style, size);
	    StyleConstants.setForeground(style,cl);

	    try {
			doc.insertString(doc.getLength(), text, style);
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	    
	}

	@Override
	public String getTextToSend(){
		String text = this.tfMess.getText() + '\n';
		this.tfMess.setText("");
		return text;
	}


	@Override
	public void handleString(String string) {
	    
	
		StyledDocument doc = (StyledDocument) taShow.getDocument();
		Style style = doc.addStyle("Sty", null);
		int start = doc.getLength(); 
		try {
			doc.insertString(doc.getLength(), string, style);
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		for (String emoticon : emoticons) {//for each emoticon

            int i = string.indexOf(emoticon);
            while (i >= 0) {
                final SimpleAttributeSet attrs = new SimpleAttributeSet(doc.getCharacterElement(start + i).getAttributes());
                if (StyleConstants.getIcon(attrs) == null) {

                    switch (emoticon) {//check which emtoticon picture to apply
                        case strAngry:
                            StyleConstants.setIcon(attrs, angry);
                            break;
                        case strBigSmile:
                            StyleConstants.setIcon(attrs, big_smile);
                            break;
                        case strCry:
                            StyleConstants.setIcon(attrs, cry);
                            break;
                        case strCurlyLips:
                            StyleConstants.setIcon(attrs, curly_lips);
                            break;
                        case strGlasses:
                            StyleConstants.setIcon(attrs, glasses);
                            break;
                        case strHeart:
                            StyleConstants.setIcon(attrs, heart);
                            break;
                        case strKiki:
                            StyleConstants.setIcon(attrs, kiki);
                            break;
                        case strKiss:
                            StyleConstants.setIcon(attrs, kiss);
                            break;
                        case strLike:
                            StyleConstants.setIcon(attrs, like);
                            break;
                        case strPacman:
                            StyleConstants.setIcon(attrs, pacman);
                            break;
                        case strSad:
                            StyleConstants.setIcon(attrs, sad);
                            break;
                        case strsquinting:
                            StyleConstants.setIcon(attrs, squinting);
                            break;
                        case strTongueOut:
                            StyleConstants.setIcon(attrs, tongue_out);
                            break;
                        case strUnsure:
                            StyleConstants.setIcon(attrs, unsure);
                            break;
                        case strWink:
                            StyleConstants.setIcon(attrs, wink);
                            break;
                        case strWtf:
                            StyleConstants.setIcon(attrs, wtf);
                            break;
                    }
                    
                    try {
						doc.remove( start + i, emoticon.length());
						doc.insertString( start + i, emoticon, attrs);
					} catch (BadLocationException e) {
						// TODO Auto-generated catch block
						System.out.println(e);
					}
                }
                i = string.indexOf(emoticon, i + emoticon.length());
            }
        }
    }


	@Override
	public void handleReceiver(String string) {
		// TODO Auto-generated method stub
		if (string.startsWith("<file>")){
			String [] split = string.split(">");
			JButton btn = new JButton(split[1]);
			btn.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					MainFormController.receiveFile(btn.getText());
				}
				
			});
			this.taShow.setCaretPosition(taShow.getDocument().getLength());
			this.taShow.insertComponent(btn);
		}
		else
			handleString(string);
	}
	
	public void resetList(Conversation[] conv) {
		// TODO Auto-generated method stub
		DefaultListModel model = (DefaultListModel) myList.getModel();
		model.clear();
		for (int i = 0; i < conv.length; i++){
			if (conv[i] == null)
				break;
			model.addElement(conv[i]);
		}
		myList.setModel(model);
		myList.ensureIndexIsVisible(23);
		myList.setCellRenderer(new ConvRenderer());
	}
	
	public void addActionListenerForJListInMainForm(ListSelectionListener listener) {
		// TODO Auto-generated method stub
		myList.addListSelectionListener(listener);
	}


	@Override
	public String getSelectJList() throws Exception {
		// TODO Auto-generated method stub
		Conversation obj = (Conversation)myList.getSelectedValue();
		return obj.getName();
	}
	
	public void clearJTextPane(){
		this.taShow.setText("");
	}
	
	public String getJButtonTemp(){
		return this.btnTemp.getText();
	}
	
	public void setScrollBottom(){
		scrollShow.getViewport().setViewPosition(new Point(0, taShow.getDocument().getLength()));
	}
}
