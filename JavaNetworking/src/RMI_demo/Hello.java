/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI_demo;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author AnhTu
 */
public interface Hello extends Remote {
    public String hello(String name) throws RemoteException;
    
}
