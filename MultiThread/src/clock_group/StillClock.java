/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clock_group;

import java.awt.*;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.text.DateFormat;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author AnhTu
 */
public class StillClock extends JPanel {
    TimeZone timeZ;
    int xC, yC, clockR;  //Đường tròn tâm (xC, yC), bán kính = clockR
    DateFormat form;
    
    public StillClock(Locale l, TimeZone t) {
        setLocale(l);
        this.timeZ = t;
    }
    public StillClock() {  //CHÚ Ý HÀM NÀY CẦN CÓ HÀM TRÊN MỚI KO BỊ LỖI
        this(Locale.getDefault(), TimeZone.getDefault());
    }
    
    public void setTimeZoneID(String newT) {
        timeZ = TimeZone.getTimeZone(newT);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        clockR = (int) (Math.min(getSize().width, getSize().height)*0.7*0.5);
        xC = (getSize().width)/2;
        yC = (getSize().height)/2;
        
        //draw cicle:
        g.setColor(Color.black);
        g.drawOval(xC-clockR, yC-clockR, 2*clockR, 2*clockR);
        g.drawString("12", xC-5, yC-clockR);
        g.drawString("9", xC-clockR - 10, yC+3);
        g.drawString("3", xC+clockR, yC+3);
        g.drawString("6", xC+3, yC+clockR+10);
        
        //đọc thời gian từ máy tính:
        GregorianCalendar cal = new GregorianCalendar(timeZ);
        
        //vẽ kim giây:
        int sec = cal.get(GregorianCalendar.SECOND);
        int sLen = (int) (clockR*0.9);
        int xS = (int) (xC+sLen*Math.sin(sec*(2*Math.PI/60)));
        int yS = (int) (yC-sLen*Math.cos(sec*(2*Math.PI/60)));
        g.setColor(Color.red);
        g.drawLine(xC, yC, xS, yS);
        
        //vẽ kim phút:
        int min = cal.get(GregorianCalendar.MINUTE);
        int mLen = (int) (clockR*0.75);
        int xM = (int) (xC+mLen*Math.sin(min*(2*Math.PI/60)));
        int yM = (int) (yC-mLen*Math.cos(min*(2*Math.PI/60)));
        g.setColor(Color.blue);
        g.drawLine(xC, yC, xM, yM);
        
        //vẽ kim giờ:
        int hour = cal.get(GregorianCalendar.HOUR_OF_DAY);
        int hLen = (int) (clockR*0.6);
        int xH = (int) (xC+hLen*Math.sin(hour*(2*Math.PI/60)));
        int yH = (int) (yC-hLen*Math.cos(hour*(2*Math.PI/60)));
        g.setColor(Color.GREEN);
        g.drawLine(xC, yC, xH, yH);
        
        //đặt chế độ hiển thị theo múi giờ địa phương và kiểu hiển thị:
        form = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.LONG, getLocale());
        form.setTimeZone(timeZ);
        
        //hiển thị ngày giờ:
        String today = form.format(cal.getTime());
        FontMetrics fm = g.getFontMetrics();
        g.drawString(today, (getSize().width - fm.stringWidth(today))/2, yC+clockR+30);
        
        
    }
    
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.add(new StillClock());
        f.setDefaultCloseOperation(3);
        f.setSize(300, 300);
        f.setVisible(true);
    }
    
    
    
}
