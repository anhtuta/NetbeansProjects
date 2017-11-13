/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package create_date;

import java.util.Random;
import static jdk.nashorn.internal.objects.NativeMath.random;

/**
 *
 * @author AnhTu
 */
public class Insert_students {
    //example in mysql: INSERT INTO `quan_ly_sv_ktx`.`sinhvien` (`MSSV`, `name`, `gioiTinh`, `birthday`, `khoaVien`, `khoa`, `queQuan`, `Phong_tenPhong`) VALUES ('20150026', 'Nguyễn Văn A', 'Gay', '1998-02-11', 'Viện Ngoại Ngữ', '62', 'Hà Nội', 'B10-104');

    public static void main(String[] args) {
        String [] ho = {"Nguyễn", "Tạ", "Phạm", "Trần", "Đặng", "Lê", "Phan", "Hoàng", "Kiều", "Hồ", "Nguyễn", "Tạ", "Trần", "Trần", "Nguyễn"};
        String [] dem = {"Văn", "Thị", "Minh", "Đăng", "Trọng", "Đức", "Tuấn", "Trung", "Nam", "Thu", "Thanh", "Văn", "Thị", "Văn"};
        String [] ten = {"Tú", "Tuấn", "Nam", "Lan", "Hoa", "Quỳnh", "Ngọc", "Linh", "Yến", "Huyền", "Phương", "Dũng", "Tuấn Anh", "Phương Anh",
                         "Nam Anh", "Hải Anh", "Nghĩa", "Hiếu", "Minh", "Thanh", "Vinh", "Linh", "Khánh", "Thành", "Công", "Sơn", "Hạnh"};
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
        
        int [] namSinh = {1995, 1994, 1993, 1996, 1997, 1998, 1992};
        String [] gioiTinh = {"Nam", "Nữ", "Gay", "Lesbian", "Nam", "Nam", "Nam", "Nam", "Nữ", "Nữ", "Nữ", "Nữ"};
        String [] diaChi = {"Hà Nội", "Hải Phòng", "Hà Nội", "Hà Nội", "Nam Định", "Bắc Giang", "Lạng Sơn", "Lào Cai", "Ninh Bình", "Thanh Hóa", "Nghệ An", "Hà Tĩnh", "Sơn La", "Bắc Ninh", "Hà Tĩnh", "Đà Nẵng", "Sài Gòn", "Hà Nội"};
        Random rd = new Random();
        
        int ms = 1;
        
        for (int i = 1; i <= 4; i++) {

            //example in mysql: INSERT INTO `quan_ly_sv_ktx`.`sinhvien` (`MSSV`, `name`, `gioiTinh`, `birthday`, `khoaVien`, `khoa`, `queQuan`, `Phong_tenPhong`) VALUES ('20150026', 'Nguyễn Văn A', 'Gay', '1998-02-11', 'Viện Ngoại Ngữ', '62', 'Hà Nội', 'B10-104');
            for (int j = 1; j <= 13; j++) {
               
                for (int l = 1; l <= 7; l++) {
                    String Ho = ho[rd.nextInt(ho.length)];
                    String Dem = dem[rd.nextInt(dem.length)];
                    String Ten = ten[rd.nextInt(ten.length)];
                    int K = k[rd.nextInt(k.length)];
                    String Khoa = khoa[rd.nextInt(khoa.length)];
                    int ns = namSinh[rd.nextInt(namSinh.length)];
                    String gt = gioiTinh[rd.nextInt(gioiTinh.length)];
                    String dc = diaChi[rd.nextInt(diaChi.length)];

                    System.out.println("INSERT INTO `quan_ly_sv_ktx`.`sinhvien` (`MSSV`, `name`, `gioiTinh`, `birthday`, `khoaVien`, `khoa`, `queQuan`, `Phong_tenPhong`)"
                            + "VALUES ('" + (20130200 + ms) + "', '" + Ho + " " + Dem + " " + Ten + "', '" + gt + "', '" + ns + "-" + (1 + rd.nextInt(11)) + "-" + (1 + rd.nextInt(28)) + "', '" + Khoa + "', '" + K + "', '" + dc + "', 'B9-" + ((100 * i) + j) + "');");

                    ms++;
                }

            }

        }



//        Random rd = new Random();
//        System.out.println(rd.nextInt(100));
    }
}
