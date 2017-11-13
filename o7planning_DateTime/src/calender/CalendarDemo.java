/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calender;

/**
 *
 * @author AnhTu
 */
import java.util.Calendar;
 
public class CalendarDemo {
 
  public static void showCalendar(Calendar c) {
      int year = c.get(Calendar.YEAR);
 
      // Trả về giá trị từ 0 - 11
      int month = c.get(Calendar.MONTH);
      int day = c.get(Calendar.DAY_OF_MONTH);
      int hour = c.get(Calendar.HOUR_OF_DAY);
      int minute = c.get(Calendar.MINUTE);
      int second = c.get(Calendar.SECOND);
      int millis = c.get(Calendar.MILLISECOND);
 
      System.out.println(year + "-" + (month + 1) + "-" + day + " "
              + hour + ":" + minute + ":" + second + "." + millis);
  }
 
  public static void main(String[] args) {
      // Tạo đối tượng Calendar, thời điểm hiện tại
      Calendar c = Calendar.getInstance();
 
      System.out.println("First calendar info");
      showCalendar(c);
 
      // roll(..) không làm thay đổi các trường khác.
      // Tăng thêm một giờ (boolean up = true)
      c.roll(Calendar.HOUR_OF_DAY, true);
 
      System.out.println("After roll 1 hour");
      showCalendar(c);
 
      // roll(..) không làm thay đổi các trường khác.
      // Giảm một giờ (boolean up = false)
      c.roll(Calendar.HOUR_OF_DAY, false);
 
      System.out.println("After roll -1 hour");
      showCalendar(c);
 
      // add(..) có thể làm thay đổi các trường khác.
      // Tăng thêm một giờ (boolean up = true)
      c.add(Calendar.HOUR_OF_DAY, 1);
 
      System.out.println("After add 1 hour");
      showCalendar(c);
 
      // roll(..) không làm thay đổi các trường khác.
      // Giảm 30 ngày        
      c.roll(Calendar.DAY_OF_MONTH, -30);
 
      System.out.println("After roll -30 day");
      showCalendar(c);
      
      // add(..) có thể làm thay đổi các trường khác.
      // Thêm 30 ngày.
      c.add(Calendar.DAY_OF_MONTH,  30);
      System.out.println("After add 30 day");
      showCalendar(c);
 
  }
 
}