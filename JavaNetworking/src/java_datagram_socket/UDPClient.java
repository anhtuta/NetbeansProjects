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
//chạy client trước rồi tới server
public class UDPClient {
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        InetAddress inetAddr=InetAddress.getByName("localhost"); //địa chỉ server là localhost
        DatagramSocket dgrSoc=new DatagramSocket(3000, inetAddr); //client sẽ nghe các thông tin từ địa chỉ localhost, cổng 3000
        
        byte[] buf=new byte[1024];
        DatagramPacket dgrPac=new DatagramPacket(buf, buf.length);
        
        dgrSoc.receive(dgrPac); //nhận gói tin từ server trả về, lưu bộ nhớ là byte, mảng có 1024 ký tự
        String str=new String(dgrPac.getData(), 0, buf.length); //đọc dl từ client: lấy dl từ server, từ vị trí 0 đến vị trí buf.length
        System.out.println(str);
        dgrSoc.close();
        
        
        
    }
}
