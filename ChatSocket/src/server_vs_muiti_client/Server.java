/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server_vs_muiti_client;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author AnhTu
 */
public class Server extends JFrame {    //nếu ko cần giao diện thì ko cần extends jframe, nghĩa là ko cần class này làm j, chỉ cần ServerThread là đủ
    
    public static void main(String[] args) {
        
        try {
            
            ServerSocket serverSocket = new ServerSocket(9999); //chỉ có 1 đối tượng serverSocket duy nhất, đối tượng này sẽ tạo từng socket để giao tiếp với socket của client
            System.out.println("Server is running and ready to server any client...");
            System.out.println("Now there's no one is connecting to server\n");
            
            while(true) {
                Socket socketOfServer = serverSocket.accept();      //cứ có 1 client kết nối thì lệnh này mới đc thực hiện, sau đó 1 thread mới đc tạo ra để xử lý client đó, nghĩa là có 1 socket mới bên server để nối với socket của client
                ServerThread serverThread = new ServerThread(socketOfServer);
                serverThread.start();
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Lỗi xảy ra, có thể là: Cổng này đang có server chiếm dụng!");
        }
    }
}


/*
client kết nối với server và server luôn chấp nhận, và class này chỉ làm nhiệm vụ chấp nhận thằng 
socketOfClient đó và tạo 1 thằng serverThread để quản lý riêng thằng socketOfClient đó
chú ý rằng: socketOfClient tới server và server tạo 1 socketOfServer nối với socketOfClient, 
và thằng serverThread chứa thằng socketOfServer đó

nó tạo 1 socket để nối tới socket tương ứng của client đó
sau đó: dùng 2 vòng while ở hàm run bên class ServerThread:
1. dùng để kiểm tra xem tên của client có hợp lệ ko
   nếu ko thì yêu cầu nhập lại tên khác
2. nếu có thì thoát vòng while trên và dùng vòng while thứ 2 và chat như thường

*/