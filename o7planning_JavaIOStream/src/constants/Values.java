/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constants;

/**
 *
 * @author AnhTu
 */
public class Values {
    public static final String WORKING_DIR = System.getProperty("user.dir"); //D:\Documents\NetBeansProjects\JavaIOStream_o7planning
    public static final String TEST_FOLDER = System.getProperty("user.dir") + "\\Test_folder";
    
    public static void main(String[] args) {
        System.out.println(TEST_FOLDER);
    }
}
