/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stream;

import constants.Values;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author AnhTu
 */
//viết lại cho nhớ

//CHÚ Ý: ĐỌC TỪNG BYTE NÊN KO THỂ HIỂN THỊ ĐƯỢC TIẾNG VIỆT DÙ FILE ĐÃ MÃ HÓA THEO KIỂU UFT-8 HAY UNICODE, PHẢI DÙNG Reader, FileReader mới đc. Reader DÙ ĐỌC TỪNG BYTE VẪN ĐỌC ĐC TIẾNG VIỆT
public class HelloInputStream_OutputStream {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        OutputStream os = new FileOutputStream(Values.TEST_FOLDER+"\\OnePiece.txt");
        String str = "Hom nay la 29/4/2017, ta đã đọc đến tập 20 của truyện One Piece.\nCac nhan vat: Luffy, Nami, Sanji, Zozo, Ussop, Chopper, Vivi, Ms.All Sunday, Mr.Smoke. Tạ Anh Tú";
        byte [] bytes = str.getBytes();
        
        //ghi lần lượt từng phần tử của mảng trên vào luồng os:
        for (int i = 0; i < bytes.length; i++) {
            os.write(bytes[i]);
        }
        os.close();
        
        
        ////////bây giờ đọc từ file trên: cách đọc: đọc TỪNG BYTE
        InputStream is = new FileInputStream(Values.TEST_FOLDER+"\\OnePiece.txt");
        int c=is.read();    //c là giá trị đọc đc trong 1 lần, và mỗi lần chỉ đọc 1 byte
        while(c!=-1) {
            System.out.print((char)c);
            c=is.read();
        }   //chú ý: có thể cho c vào điều kiện đầu của while và bỏ lệnh c=is.read() trong thân vòng while đi: while((c=is.read()) != -1) {...}
        
        
        System.out.println();
        ////////////các đọc khác hiệu quả hơn: đọc 1 lúc 10 byte và gán vào 1 mảng kich thuoc = 10, sau đó in cả mảng đó ra:
        InputStream is2 = new FileInputStream(Values.TEST_FOLDER+"\\OnePiece.txt");
        byte []temp = new byte[10];
//        c=is2.read(temp);   //c là số byte đọc đc trong 1 lần
//        while(c != -1) {
//            String s = new String(temp, 0, c);
//            System.out.print(s);
//            c=is2.read(temp);
//        }
        //hoặc xài cách này:
        c=-1;
        while((c=is2.read(temp)) != -1) {
            String s = new String(temp,0,c);
            System.out.print(s);
        }
    }
}
