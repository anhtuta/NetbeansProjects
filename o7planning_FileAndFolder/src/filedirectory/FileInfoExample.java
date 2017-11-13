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
/*
Lớp java.io.File đại diện cho một tập tin hoặc một thư mục trong hệ thống, nó đại diện cho một đường dẫn (pathname).

java.io.File có thể đại diện cho một đường dẫn (pathname) mà đường dẫn đó có thể không thực sự tồn tại trên hệ thống. Nếu tồn tại nó có thể là một thư mục (directory) hoặc là một tập tin (file).

Lớp File cung cấp 2 phương thức để tạo môt thư mục:
Phương thức                Mô tả
public boolean mkdir()     Tạo thư mục cho bởi đường dẫn. Chú ý thư mục chỉ được tạo ra nếu thư mục cha tồn tại.
public boolean mkdirs()    Tạo thư mục cho bởi đường dẫn, bao gồm cả các thư mục cha nếu nó không tồn tại.
*/
import java.io.File;
import java.util.Date;

public class FileInfoExample {

    public static void main(String[] args) {

        // Tạo một đối tượng File đại diện cho một đường dẫn.
        File apath = new File(System.getProperty("user.dir") + "\\Test_folder\\mytext.txt");

        // Kiểm tra sự tồn tại.
        System.out.println("Path exists? " + apath.exists());

        if (apath.exists()) {

            // Kiểm tra có phải là một thư mục
            System.out.println("Directory? " + apath.isDirectory());

            // Kiểm tra là File ẩn?
            System.out.println("Hidden? " + apath.isHidden());

            // Tên đơn giản
            System.out.println("Simple Name: " + apath.getName());

            // Đường dẫn tuyêt đối
            System.out.println("Absolute Path: " + apath.getAbsolutePath());

            // Kiểm tra kích thước (Theo đơn vị byte):
            System.out.println("Length (bytes): " + apath.length());

            // Thời điểm sửa lần cuối (Tính bằng mili giây)
            long lastMofifyInMillis = apath.lastModified();
            Date lastModifyDate = new Date(lastMofifyInMillis);

            System.out.println("Last modify date: " + lastModifyDate);

        }

    }

}
