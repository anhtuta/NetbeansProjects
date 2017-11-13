/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package create_data;

import java.util.Random;
import static jdk.nashorn.internal.objects.NativeMath.random;

/**
 *
 * @author AnhTu
 */
public class Insert_students {
    //example in mysql: INSERT INTO `dormitory`.`student` (`Student_code`, `Student_name`, `Student_k`, `Student_school`, `Student_birth`, `Student_gentl`, `Student_homeLand`, `Student_phone`, `Room_Room_id`, `Room_Dormitory_name`) VALUES ('20130001', 'Nguyễn Văn A', '58', 'CNTT', '12/12/1995', 'nữ', 'Sài Gòn', '0976233222', '28', 'B7');

    public static void main(String[] args) {
        String [] ho = {"Nguyễn", "Tạ", "Phạm", "Trần", "Đặng", "Lê", "Phan", "Hoàng", "Thu"};
        String [] dem = {"Văn", "Thị", "Minh", "Đăng", "Trọng", "Đức", "Tuấn", "Trung"};
        String [] ten = {"Tú", "Tuấn", "Nam", "Lan", "Hoa", "Quỳnh", "Ngọc", "Linh", "yến", "Huyền", "Phương", "Dũng", "Tuấn Anh", "Phương Anh", "Nam Anh", "Hải Anh", "Nghĩa", "Hiếu", "Minh", "Thanh"};
        int [] k = {56,57,58,59};
        String [] khoa = {
        "Viện Cơ khí",
        "Viện Dệt may - Da giầy và Thời trang",
        "Viện Công nghệ Thông tin và Truyền thông",
        "Viện Kỹ thuật Hoá học",
        "Viện Điện",
        "Viện Điện tử - Viễn thông",
        "Khoa Giáo dục Quốc phòng",
        "Viện Kinh tế & Quản lý",
        "Viện Khoa học và Kỹ thuật Vật liệu",
        "Khoa Lý luận chính trị",
        "Viện Ngoại ngữ",
        "Viện Sư phạm Kỹ thuật",
        "Viện Toán ứng dụng và Tin học"};
        
        int [] namSinh = {1995, 1994, 1993, 1996, 1997};
        String [] gioiTinh = {"Nam", "Nữ"};
        String [] diaChi = {"Hà Nội", "Hải Phòng", "Nam Định", "Bắc Giang", "Lạng Sơn", "Lào Cai", "Ninh Bình", "Thanh Hóa", "Nghệ An", "Hà Tĩnh", "Sơn La", "Bắc Ninh"};
        Random rd = new Random();
        
        for (int i = 0; i < 100; i++) {
            String Ho = ho[rd.nextInt(ho.length)];
            String Dem = dem[rd.nextInt(dem.length)];
            String Ten = ten[rd.nextInt(ten.length)];
            int K = k[rd.nextInt(k.length)];
            String Khoa = khoa[rd.nextInt(khoa.length)];
            int ns = namSinh[rd.nextInt(namSinh.length)];
            String gt = gioiTinh[rd.nextInt(gioiTinh.length)];
            String dc = diaChi[rd.nextInt(diaChi.length)];
            
            System.out.println("INSERT INTO `dormitory`.`student` (`Student_code`, `Student_name`, `Student_k`, `Student_school`, `Student_birth`, `Student_gentl`, `Student_homeLand`, `Student_phone`, `Room_Room_id`, `Room_Dormitory_name`) "
                    + "VALUES ('"+(20140001+i)+"', '"+Ho+" "+Dem+" "+Ten+"', '"+K+"', '"+Khoa+"', '"+(1+rd.nextInt(30))+"/"+(1+rd.nextInt(11))+"/"+ns+"', '"+gt+"', '"+dc+"', '0976233"+(100+i)+"', '"+(1+rd.nextInt(30))+"', 'B7');");
            
        }



//        Random rd = new Random();
//        System.out.println(rd.nextInt(100));
    }
}
