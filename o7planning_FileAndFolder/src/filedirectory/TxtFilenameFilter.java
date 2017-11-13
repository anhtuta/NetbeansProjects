/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filedirectory;

/**
 *
 * @author AnhTu
 */
import java.io.File;
import java.io.FilenameFilter;
 
public class TxtFilenameFilter implements FilenameFilter {
  
    // Chấp nhận các đường dẫn có đuôi '.txt'
    @Override
    public boolean accept(File dir, String name) {
        return name.endsWith(".txt");
    }
 
    public static void main(String[] args) {
 
        File dir = new File("C:/test");
 
        File[] txtFiles = dir.listFiles(new TxtFilenameFilter());
 
        for (File txtFile : txtFiles) {
            System.out.println(txtFile.getAbsolutePath());
        }
    }
}