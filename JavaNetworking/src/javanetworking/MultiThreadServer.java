/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javanetworking;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author AnhTu
 */
public class MultiThreadServer extends Thread {

    Socket csocket;

    MultiThreadServer(Socket csocket) {
        this.csocket = csocket;
    }

    public static void main(String args[])
            throws Exception {
        ServerSocket ssock = new ServerSocket(1234);
        System.out.println("Listening");
        while (true) {
            Socket sock = ssock.accept();
            System.out.println("Connected");
            new Thread(new MultiThreadServer(sock)).start();
        }
    }

    @Override
    public void run() {
        try {
            PrintStream pstream = new PrintStream(csocket.getOutputStream());
            for (int i = 100; i >= 0; i--) {
                pstream.println(i + " bottles of beer on the wall");
            }
            pstream.close();
            csocket.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
