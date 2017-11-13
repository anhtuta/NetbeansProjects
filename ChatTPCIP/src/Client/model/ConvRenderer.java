package Client.model;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.io.File;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

public class ConvRenderer extends JPanel implements ListCellRenderer<Conversation> {
	private JLabel lbIcon = new JLabel();
    private JLabel lbName = new JLabel();
    private JLabel lbMess = new JLabel();
    private JLabel lbTime = new JLabel();
    
    public ConvRenderer(){
    	setLayout(new BorderLayout(5, 5));
    	
    	JPanel panelText = new JPanel(new GridLayout(0, 1));
        panelText.add(lbName);
        panelText.add(lbMess);
        panelText.add(lbTime);
        add(lbIcon, BorderLayout.WEST);
        add(panelText, BorderLayout.CENTER);
    }
	@Override
	public Component getListCellRendererComponent(JList<? extends Conversation> list, Conversation convers, int index, 
			boolean isSelected, boolean cellHasFocus) {
		// TODO Auto-generated method stub
		File file = new File("D:\\icon");
		if (!file.exists()){
			file.mkdirs();
		}
		File fileAva = new File("D:\\icon\\"+convers.getDisplayName());
		if (fileAva.exists())
			lbIcon.setIcon(new ImageIcon(new ImageIcon("D:\\icon\\"+convers.getDisplayName()).getImage().getScaledInstance(40, 40,  java.awt.Image.SCALE_SMOOTH)));
		else
			lbIcon.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/avatar/default.jpg")).getImage().getScaledInstance(40, 40,  java.awt.Image.SCALE_SMOOTH)));
		lbName.setText(convers.getDisplayName());
		lbMess.setText(convers.getMess());
		long min = convers.getMinAgo();
		if (min < 60)
			lbTime.setText(Long.toString(min)+ ((min <= 1)?" minute ago":" minutes ago"));
		else{
			long hour = min/60;
			long min1 = min%60;
			if (hour < 24){
				lbTime.setText(Long.toString(hour)+ ((hour == 1)?" hour ":" hours ")
						+ ((min1 == 0)?"":(Long.toString(min1)+((min1 <= 1)?" minute":" minutes")))+" ago");
			}
			else{
				lbTime.setText(convers.getDate());
			}
		}
		lbName.setForeground(Color.red);
		lbTime.setForeground(Color.blue);
		
		
		// set Opaque to change background color of JLabel
	    lbName.setOpaque(true);
	    lbMess.setOpaque(true);
	    lbTime.setOpaque(true);
	    lbIcon.setOpaque(true);
	 
	    // when select item
	    if (isSelected) {
	        lbName.setBackground(list.getSelectionBackground());
	        lbMess.setBackground(list.getSelectionBackground());
	        lbTime.setBackground(list.getSelectionBackground());
	        lbIcon.setBackground(list.getSelectionBackground());
	        setBackground(list.getSelectionBackground());
	    } else { // when don't select
	        lbName.setBackground(list.getBackground());
	        lbMess.setBackground(list.getBackground());
	        lbTime.setBackground(list.getBackground());
	        lbIcon.setBackground(list.getBackground());
	        setBackground(list.getBackground());
	    }
		return this;
	}

}
