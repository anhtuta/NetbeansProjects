/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file_in_java;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AnhTu
 */
public class FileAndDirectory {
    public static void main(String[] args) {
        File directory = new File("thu muc moi");
        directory.mkdir();
        
        try {
            File file = new File("test2.txt");
            file.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(FileAndDirectory.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
