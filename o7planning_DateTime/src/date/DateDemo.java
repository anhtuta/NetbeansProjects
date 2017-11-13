/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package date;

/**
 *
 * @author AnhTu
 */
import java.util.Date;
import java.util.concurrent.TimeUnit;

/*
Java cung cấp một số class liên quan tới thời gian và lịch (Calendar), dưới đây là danh sách các class này:

Class                               Mô tả

java.util.Date                      Một class mô tả cho ngày tháng năm và thời gian. Tiếc là hầu hết các method của nó đã bị lỗi thời, khuyến cáo là không nên sử dụng các method đó, tuy nhiên class Date vẫn được sử dụng rỗng rãi.
java.util.concurrent.TimeUnit	    TimeUnit là một Enum mô tả các đơn vị ngày tháng năm và thời gian.
java.sql.Date                       Một class mô tả ngày tháng năm. Thông tin về thời gian bị cắt bỏ. Class này thường sử dụng trong JDBC.
java.sql.Time                       Một class mô tả thời gian (Giờ phút giây, milli giây), và không chứa thông tin ngày tháng năm.Class này thường sử dụng trong JDBC.
java.sql.Timestamp                  Một class mô tả ngày tháng năm và thời gian. Class này thường sử dụng trong JDBC.
java.util.Calendar                  Class mô tả bộ Lịch. Nó có các method toán học về thời gian, chẳng hạn thêm ngày, bớt ngày,...
java.util.GregorianCalendar         Là một class con trực tiếp của java.util.Calendar, mô tả ngày Dương Lịch, bộ lịch được sử dụng rộng rãi trên thế giới ngày nay. Nó có tất cả các method từ java.util.Calendar để thao tác toán học trên ngày tháng năm và thời gian.
java.util.TimeZone                  Class TimeZone là class mô tả múi giờ, nó có ích khi bạn làm việc với Lịch trên múi giờ.
java.text.SimpleDateFormat          Class giúp bạn chuyển một String có định dạng ngày tháng sang kiểu Date và ngược lại
*/
public class DateDemo {

    public static void main(String[] args) throws InterruptedException {

        // Tạo một đối tượng Date mô tả thời gian hiện tại.
        Date date1 = new Date();

        // Ngừng 1 khoảng thời gian 3 giây.
        Thread.sleep(TimeUnit.SECONDS.toMillis(3));

        // Số milli giây từ 01-01-1970 tới hiện tại.
        long millis = System.currentTimeMillis();
        Date date2 = new Date(millis);

        // So sánh 2 đối tượng date1 và date2.
        // i < 0 nghĩa là date1 < date2
        // i = 0 nghĩa là date1 = date2
        // i > 0 nghĩa là date1 > date2
        int i = date1.compareTo(date2);

        System.out.println("Date1 = "+date1);
        System.out.println("Date2 = "+date2);
        
        System.out.println("date1 compareTo date2 = " + i);

        // Kiểm tra xem date1 có đứng trước date2 không.
        boolean before = date1.before(date2);

        System.out.println("date1 before date2 ? " + before);

        // Kiểm tra xem date1 có đứng sau date2 không.
        boolean after = date1.after(date2);

        System.out.println("date1 after date2 ? " + after);
    }
}
