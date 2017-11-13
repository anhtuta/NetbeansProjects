/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_datagram_socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 *
 * @author AnhTu
 */
//chú ý: giao thức UDP thì server ko quan tâm client có nhận đc tin hay ko, nó cứ gửi thôi, gửi xong nó kết thúc luôn
//do đó phải chạy client trước, vì nếu server chạy trước thì nó gửi xong rồi kết thúc, khi đó client chưa chạy nên sẽ mất gói tin
public class UDPServer {
    //server đẩy gói tin đến đích ở địa chỉ là localhost, cổng là 3000. gói tin là str ở dưới, giao thức là UDP:
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        DatagramSocket dataGrSoc =new DatagramSocket();
        InetAddress ip=InetAddress.getByName("localhost");
        String str="xin chao att95";
        DatagramPacket dataGrPac=new DatagramPacket(str.getBytes(), str.length(), ip, 3000); ///nếu client ở cổng 3000 localhost thì sẽ nhận đc gói tin này
        
        dataGrSoc.send(dataGrPac);
        dataGrSoc.close();
    }
}
