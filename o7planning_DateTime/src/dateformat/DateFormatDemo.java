/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dateformat;

/**
 *
 * @author AnhTu
 */
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
 
public class DateFormatDemo {
 
    public static void main(String[] args) throws ParseException {

        final DateFormat df1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        String dateStr = "02/05/2017 10:29:32";
        System.out.println(df1.parse(dateStr));
        System.out.println(df1.format(df1.parse(dateStr)));
        
        Date d1 = new Date();
        System.out.println(d1);
        System.out.println(df1.format(d1));
        
        long timemili = System.currentTimeMillis() + 1000*1000;
        Date d2 = new Date(timemili);
        System.out.println(d2);
        
        Calendar c = Calendar.getInstance();
        System.out.println(c);
        
        
    }
}