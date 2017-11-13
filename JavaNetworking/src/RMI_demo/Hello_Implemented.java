/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI_demo;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AnhTu
 */
//RMI server:
public class Hello_Implemented extends UnicastRemoteObject implements Hello {

    private static final long serialVersionUID=1L;
    
    protected Hello_Implemented() throws RemoteException {
        
    }
    
    @Override
    public String hello(String name) throws RemoteException {
        System.out.println("name is: "+name);
        return "Hello "+name;
    }
    
    public static void main(String[] args) {
        try {
            Naming.rebind("rmi://localhost:5000/hello", new Hello_Implemented());
            System.out.println("server is ready!");
        } catch (RemoteException ex) {
            Logger.getLogger(Hello_Implemented.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Hello_Implemented.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
