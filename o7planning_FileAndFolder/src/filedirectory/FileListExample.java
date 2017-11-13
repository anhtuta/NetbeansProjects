/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filedirectory;

import java.io.File;

/**
 *
 * @author AnhTu
 */
/*
Lớp java.io.File cung cấp một vài phương thức để lấy ra danh sách các tập tin con và thư mục con trong một thư mục. Và sử dụng FileFilter để lọc các tập tin đó.
Phương thức                             Mô tả
static File[] listRoots()               Trả về một mảng các đối tượng File là đại diện cho các thư mục gốc. Trong Windows nó sẽ là các ổ đĩa (C:, D:,..), trong Unix nó là /
File[] listFiles()                      (?)Trả về một mảng các đối tượng File, là các tập tin và các thư mục con của thư mục hiện tại.
File[] listFiles(FilenameFilter filter)	Trả về một mảng các đối tượng File, là các tập tin và các thư mục con của thư mục hiện tại, và phù hợp với bộ lọc FilenameFilter trên tham số.
File[] listFiles(FileFilter filter)	Trả về một mảng các đối tượng File, là các tập tin và các thư mục con của thư mục hiện tại, và phù hợp với bộ lọc FileFilter trên tham số.
 	 
String[] list()                         (?)Trả về một mảng các đường dẫn, là đường dẫn của các tập tin và đường dẫn của các thư mục con của thư mục hiện tại.
String[] list(FilenameFilter filter)	Trả về một mảng các đường dẫn, là đường dẫn của các tập tin và đường dẫn của các thư mục con của thư mục hiện tại, và phù hợp với bộ lọc FiltenameFilter trên tham số.
*/
public class FileListExample {
    public static void main(String[] args) {
        //Ví dụ liệt kê tất cả các thư mục gốc:
        File[] roots = File.listRoots();
         
        for(File root: roots)  {
            System.out.println(root.getAbsolutePath());
        }
 
        
        //Ví dụ sau liệt kê ra tất cả các tập tin và thư mục con trực tiếp của một thư mục:
        System.out.println("File[] listFiles():\n");
 
        File dir = new File(System.getProperty("user.dir"));
 
        File[] children = dir.listFiles();
 
        for (File file : children) {
            System.out.println(file.getAbsolutePath());
        }
 
        System.out.println("\n-----------------------");
        
        System.out.println("String[] list():\n");
 
        String[] paths = dir.list();
 
        for (String path : paths) {
            System.out.println(path);
        }
    }
}
