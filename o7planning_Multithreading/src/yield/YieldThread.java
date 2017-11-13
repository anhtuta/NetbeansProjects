/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yield;

/**
 *
 * @author AnhTu
 */
/*
Về mặt lý thuyết, "yield" có nghĩa là để cho đi, từ bỏ, đầu hàng.
Một luồng yield nói với máy ảo là nó sẵn sàng để cho các thread khác được sắp xếp ở vị trí của nó.
Điều này cho thấy rằng nó không phải làm một cái gì đó quá quan trọng.
Lưu ý rằng nó chỉ là một gợi ý, mặc dù, và không đảm bảo có hiệu lực ở tất cả.

yield() được định nghĩa như sau trong Thread.java:
public static native void yield();

To yield = to give up
To join = to come together.

What does that mean with yield() and join()? It's exactly that the words mean. Also:

yield( ): The thread that issued the yield() signals the JVM that it's willing to be interrupted. If the JVM follows the signal and interrupts it, it's another history. In plain English: JVM can ignore the yield(). This method is rarely used, except for debugging purposes.

join(): The thread that signaled "join()" tells other threads that it's willing to wait for their "ending". In plain English: It's the way to synchronize several running threads so that none of the threads ends and quits too early.

Example:
    // start 2 FULLY-independent tasks: 
    BrowserWeb bw = new BrowserWeb();
    WebBrowser wb = new WebBrowser();
    // start 2 threads
    bw.start();
    wb.start();
    // they should wait for each other's termination
    bw.join();
    wb.join();
*/

/*
2 questions:
1 - Why is yield() used rarely ?
2 - Suppose that, I have 2 thread: threadA and threadB. ThreadA uses yield(). So if I let threadA not use yield()
and use method join() for threadB, will the program return same result ? why?

answer:
1. Rarely used because it does not make sense to ask the JVM to interrupt the thread when its turn is still in 
the scheduling queue (hence: JVM ignores the yield), or when it completed and JVM sees no need to interrupt a terminated thread. 
When you have several threads: t1, t2,t3,..,tn and normally the running sequence of threads is unpredictable. 
BUT if you want to see the sequence t1, t2, t3, t4, t5,...,tn then each thread must be "yielded" by yield() before
the next thread starts. And that makes only sense when you are in DEBUG mode. Otherwise it makes less sense to do that.

2. NO. yield() and join() work differently. yield() works with the JVM, join() work with other thread(s).
To synchronize 2 (or more) threads so that they should wait for each other each thread must be joined by join().
The BrowserProxy example shows you that one of the threads BrowserWeb and WebBrowser shouldn't terminate and closes
the connection before one of them is still running. This way is used to keep the result reliable.
*/
public class YieldThread {
    
}
