/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yield;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author AnhTu
 */
public class BrowserProxy {   
    public static void main(String args[]) throws Exception {
        (new BrowserProxy((args.length > 0)? Integer.parseInt(args[0]):8888)).serve();
    }
    public BrowserProxy(int port) {
        this.port = port;
    }
    private int port;
    private void serve() throws Exception {
            ServerSocket serverSock = new ServerSocket(port);
            System.out.println("Proxy@Port:"+port+" is running.\n"+
                               "CRTL-C to cancel the running Proxy");
            while(true) (new Service(serverSock.accept())).start();
     } 

    private class Service extends Thread{
        private Socket webSoc, soc;
        private InputStream ins, webIns;
        private OutputStream out, webOut;
       
        public Service(Socket soc) {
            this.soc = soc;
        }
        //
        @Override
        public void run() {
            try {
                ins = soc.getInputStream();
                out = soc.getOutputStream();
                byte[] buf = new byte[2048]; // 2KB
                ins.read(buf); // read the header
                String header = new String(buf);
                int p = header.indexOf("Host: ");
                // Ignore the header starting with "HEAD..."
                if (header.indexOf("HEAD") == 0 || p < 0) {
                    closeAll();
                    return;
                }
                p += 6; //+6: point after "Host: "
                int e = header.indexOf("\r\n", p);
                if (e > 0) { // retrieve the hostname
                    String host = header.substring(p, e);
                    header = header.replace("http://"+host, "");
                    p = host.indexOf(":");
                    if (p > 0) { // other port than 80 or 443?
                        int x = p;
                        p = Integer.parseInt(host.substring(x+1));
                        host = host.substring(0, x);
                    } else p = buf[0] == 'C'? 443:80;
                    // prepare the connection between Browser and the Web
                    webSoc = new Socket(host, p);
                    webIns = webSoc.getInputStream();
                    webOut = webSoc.getOutputStream();
                    if (buf[0] == 'C') { // CONNECT --> Tunneling
                        out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                        out.flush();
                    } else { // It's GET, PUT or POST
                        // tidy the Header for the web-site
                        webOut.write(header.replace("Proxy-", "").
                                            replace("keep-alive","close").
                                            getBytes());
                        webOut.flush();
                    }
                    // start 2 FULLY-independent tasks: 
                    BrowserWeb bw = new BrowserWeb();
                    WebBrowser wb = new WebBrowser();
                    // start 2 threads
                    bw.start();
                    wb.start();
                    // they should wait for each other's termination
                    bw.join();
                    wb.join();
                }
            } catch (Exception e) {}
            closeAll();
        }
        
        private void closeAll() {
            try {
                ins.close();
                out.close();
                soc.close();
                if (webSoc != null){
                    webIns.close();
                    webOut.close();
                    webSoc.close();
                }
            } catch (Exception ex) { }
        }
        // Browser to web
        private class BrowserWeb extends Thread {
            public BrowserWeb() { } // empty for better performance
            public void run() {
                try {
                    int n;
                    byte[] rec = new byte[1028];
                    while ((n = ins.read(rec)) > 0) webOut.write(rec,0,n);
                    webOut.flush();
                } catch (Exception e) { }
            }
        }
        // web to browser
        private class WebBrowser extends Thread {
            public WebBrowser() { } // empty for better performance
            public void run() {
                try {
                    int n;
                    byte[] rec = new byte[65536];
                    while ((n = webIns.read(rec)) > 0) out.write(rec,0,n);
                    out.flush();
                } catch (Exception e) { }
            }
        }
    }
}