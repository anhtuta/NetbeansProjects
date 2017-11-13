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
/*
Sơ lược về các bộ lịch:
Gregorian Calendar: Đây chính là Dương Lịch, còn gọi lịch Thiên chúa giáo, là lịch quốc tế. Nó được sử dụng rộng rãi nhất được đặt tên theo Đức Giáo Hoàng Gregory XIII, người đã giới thiệu nó vào năm 1582.
http://en.wikipedia.org/wiki/Gregorian_calendar
Buddhist Calendar: Đây là một bộ lịch phật giáo, thường được sử dụng tại một số nước Đông Nam Á trước kia như Thái Lan, Lào, Campuchia, cũng như Sri Lanka. Hiện nay lịch này được sử dụng trong các lễ hội phật giáo. Và không còn quốc gia nào sử dụng lịch này một cách chính thức, các quốc gia này đã đổi sang sử dụng Gregorian Calendar. Bạn có thể tham khảo thêm thông tin về lịch này tại:
http://en.wikipedia.org/wiki/Buddhist_calendar
Japanese Imperial Calendar: Đây là bộ lịch truyền thống của Nhật bản, hiện nay Nhật bản đã chuyển sang sử dụng dương lịch ( Gregorian Calendar), tuy nhiên bộ lịch truyền thống vẫn được sử dụng một cách không chính thức.
Calendar là class mô phỏng một hệ thống Lịch.

Calendar có một vài class con:
GregorianCalendar
JapaneseImperialCalendar
BuddhistCalendar
Calendar là một class trừu tượng. Nghĩa là bạn không thể khởi tạo nó từ cấu tử (Constructor). Tuy nhiên có 4 method tĩnh để tạo ra đối tượng Calendar.
public static Calendar getInstance();
public static Calendar getInstance(TimeZone zone);
public static Calendar getInstance(Locale aLocale);
public static Calendar getInstance(TimeZone zone,Locale aLocale);

Khi bạn sử dụng Calendar.getInstance(TimeZone,Locale) sẽ nhận được trả về là một trong các class con nói trên. Mà hầu hết là trả về GregorianCalendar. 

Gọi Calendar.getInstance() trả về đối tượng Calendar với tham số TimeZone theo máy tính của bạn và Locale mặc định.

Một số method quan trọng:
Phương thức get(int)            Giá trị trả về

get(Calendar.DAY_OF_WEEK)	1 (Calendar.SUNDAY) tới 7 (Calendar.SATURDAY).
get(Calendar.YEAR)              Năm (year)
get(Calendar.MONTH)             0 (Calendar.JANUARY) tới 11 (Calendar.DECEMBER).
get(Calendar.DAY_OF_MONTH)	1 tới 31
get(Calendar.DATE)              1 tới 31
get(Calendar.HOUR_OF_DAY)	0 tới 23
get(Calendar.MINUTE)            0 tới 59
get(Calendar.SECOND)            0 tới 59
get(Calendar.MILLISECOND)	0 tới 999
get(Calendar.HOUR)              0 tới 11, được sử dụng cùng với Calendar.AM_PM.
get(Calendar.AM_PM)             0 (Calendar.AM) hoặc 1 (Calendar.PM).
get(Calendar.DAY_OF_WEEK_IN_MONTH)	DAY_OF_MONTH 1 tới 7 luôn luôn tương ứng với DAY_OF_WEEK_IN_MONTH 1; 8 tới 14 tương ứng với DAY_OF_WEEK_IN_MONTH 2, ...
get(Calendar.DAY_OF_YEAR)	1 tới 366
get(Calendar.ZONE_OFFSET)	Giá trị GMT của múi giờ.
get(Calendar.ERA)               Biểu thị AD (GregorianCalendar.AD), BC (GregorianCalendar.BC).
*/

/*
Một số method khác của Calendar:
void set(int calendarField, int value)
void set(int year, int month, int date)
void set(int year, int month, int date, int hour, int minute, int second)
 
// Thêm hoặc trừ một khoảng thời gian chỉ định (amount) theo trường (field)
// dựa trên quy tắc của bộ lịch.
void add(int field, int amount)
 
// Cộng hoặc trừ (lên/xuống) duy nhất một đơn vị thời gian cho bởi trường (field)
// và không làm ảnh hưởng tới các trường khác.
void roll(int calendarField, boolean up)
 
// Thêm một lượng thời gian trên trường chỉ định (calendarField)
// và không làm ảnh hưởng tới các trường khác
void roll(int calendarField, int amount):
 
 
// Trả về đối tượng Date dựa trên giá trị của Calendar.
Date getTime()
 
void setTime(Date date)
 
// Trả về số mili giây của đối tượng Calendar này.
long getTimeInMills():
 
void setTimeInMillis(long millis)
 
void setTimeZone(TimeZone value)
*/
import java.util.Calendar;
 
public class CalendarFieldsDemo {
 
  public static void main(String[] args) {
      // Tạo một đối tượng Lịch mặc định.
      Calendar c = Calendar.getInstance();
      int year = c.get(Calendar.YEAR);
 
      // Trả về giá trị từ 0 - 11
      int month = c.get(Calendar.MONTH);
      int day = c.get(Calendar.DAY_OF_MONTH);
      int hour = c.get(Calendar.HOUR_OF_DAY);
      int minute = c.get(Calendar.MINUTE);
      int second = c.get(Calendar.SECOND);
      int millis = c.get(Calendar.MILLISECOND);
 
      System.out.println("Year: " + year);
      System.out.println("Month: " + (month+1));
      System.out.println("Day: " + day);
      System.out.println("Hour: " + hour);
      System.out.println("Minute: " + minute);
      System.out.println("Second: " + second);
      System.out.println("Minute: " + minute);
      System.out.println("Milli Second: " + millis);
 
  }
 
}