/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daemon;

/**
 *
 * @author AnhTu
 */
/*
Java chia thread làm 2 loại một loại thông thường và Deamon Thread. Chúng chỉ khác nhau ở cách thức ngừng hoạt động.
Trong một chương trình các luồng thông thường và luồng Deamon chạy song song với nhau,
khi TẤT CẢ các luồng thông thường kết thúc, mọi luồng Deamon cũng sẽ bị kết thúc theo bất kể nó đang làm việc gì.

Chú ý: 
Sử dụng setDeamon(boolean) để sét đặt một luồng là Deamon hoặc không.
Chú ý, bạn chỉ có thể gọi hàm setDeamon(boolean) khi thread chưa được chạy.
Điều đó có nghĩa là khi thread đã chạy bạn không thể chuyển luồng từ non-deamon sang deamon và ngược lại. 

Khi một luồng mới được tạo ra, nó được thừa hưởng đặc tính deamon từ luồng cha.
Như vậy khi bạn tạo một luồng trong hàm main của 1 class nó vốn là luồng non-deamon,
vì vậy thread tạo ra mặc định cũng là none-deamon. Như vậy nếu bạn tạo một luồng mới trong một luồng Deamon,
mặc định nó cũng sẽ là Deamon.

VD:
Thread thread = new MyThread();

// sét luồng này là deamon.
// Chỉ gọi được method này khi thread chưa start.
// Trong trường hợp start rồi sẽ bị một ngoại lệ.
thread.setDeamon(true);

// Sét luồng này là non-deamon.
// Chỉ gọi được method này khi thread chưa start.
// Trong trường hợp start rồi sẽ bị một ngoại lệ.
thread.setDeamon(false);
*/
public class DaemonTest {

    public static void main(String[] args) {
        System.out.println("==> Main Thread running..\n");
        // Tạo một Thread
        Thread deamonThread = new DeamonThread();
        // Sét nó là Deamon Thread.
        deamonThread.setDaemon(true);
        deamonThread.start();

        // Tạo một Thread khác
        new NoneDeamonThread().start();

        try {
            // Ngủ 5 giây.
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }

        // Ghi ra thông báo luồng main này kết thúc.
        System.out.println("\n==> Main Thread ending\n");
    }

}
/*
Kết quả chạy:
==> Main Thread running..

  - Hello from None Deamon Thread 0
+ Hello from Deamon Thread 0
  - Hello from None Deamon Thread 1
  - Hello from None Deamon Thread 2
+ Hello from Deamon Thread 1
  - Hello from None Deamon Thread 3
  - Hello from None Deamon Thread 4
+ Hello from Deamon Thread 2

==> Main Thread ending

  - Hello from None Deamon Thread 5
  - Hello from None Deamon Thread 6
+ Hello from Deamon Thread 3
  - Hello from None Deamon Thread 7
  - Hello from None Deamon Thread 8
+ Hello from Deamon Thread 4
  - Hello from None Deamon Thread 9

==> None Deamon Thread ending


CHÚ Ý RẰNG Deamon Thread SẼ KẾT THÚC NGAY KHI CHƯƠNG TRÌNH KẾT THÚC, DO ĐÓ KO THÔNG BÁO THREAD NÀY KẾT THÚC LÚC NÀO ĐC
luồng Deamon đã bị dừng lại khi tất cả các luồng thông thường đã dừng. Mặc dù code của nó là chạy vô tận.
*/