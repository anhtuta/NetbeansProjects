/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filedirectory;

import java.io.File;
import java.io.FileFilter;


/**
 *
 * @author AnhTu
 */
public class TxtFileFilter implements FileFilter {

    @Override
    //// Chỉ chấp nhận 'pathname' là file và có mở rộng là txt:
    public boolean accept(File file) {
        if(!file.isFile()) return false;
        return file.getAbsolutePath().endsWith(".txt");
    }
    
    public static void main(String[] args) {
 
        File dir = new File("C:/test");
 
        File[] txtFiles = dir.listFiles(new TxtFileFilter());
 
        for (File txtFile : txtFiles) {
            System.out.println(txtFile.getAbsolutePath());
        }
    }
 
}
