/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_stream;

/**
 *
 * @author AnhTu
 */
/*
1. DataInputStream 
// Cấu tử
public DataInputStream(InputStream in)
 
// Đọc ra một ký tự (16 bit)
public char readChar()
// Đọc ra một số double (64 bit)
public double readDouble()
// Đọc ra một số float (32 bit)
public float readFloat()
// Đọc ra một số int (16 bit)
public int readInt()
// Đọc ra một String (mã hóa dạng UTF-8).
public String readUTF()
....

2. DataOutputStream 
// Cấu tử
public DataOutputStream(OutputStream out)
 
// Ghi một ký tự 16 bit (2 byte)
public void writeChar(int val)
// Ghi một số double 64 bit (8-byte)
public void writeDouble(double val)
// Ghi một số float 32 bit (4-byte)
public void writeFloat(float val)
// Ghi một số tự nhiên 32 bit  (4-byte)
public void writeInt(int val)
// Ghi một String mã hóa dạng UTF-8.
public void writeUTF(String obj)
....
*/
import constants.Values;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

//Vẫn phải chú ý rằng thứ tự đọc giống hệt thứ tự ghi
public class DataInputStreamExample {

    public static void main(String[] args) throws IOException {

//        // Luồng đọc dữ liệu từ file.
//        FileInputStream fis = new FileInputStream(Values.WORKING_DIR+"/Test_folder/cities.txt");
//        // Tạo đối tượng DataInputStream bao lấy 'fis'.
//        DataInputStream dis = new DataInputStream(fis);

        //hoac viet gon hon:
        DataInputStream dis = new DataInputStream(new FileInputStream(Values.WORKING_DIR+"/Test_folder/cities.txt"));
        //
        // Đọc dữ liệu.
        //
        int cityId1 = dis.readInt(); System.out.println("Id: " + cityId1);
        String cityName1 = dis.readUTF(); System.out.println("Name: " + cityName1);
        int cityPopulation1 = dis.readInt(); System.out.println("Population: " + cityPopulation1);
        float cityTemperature1 = dis.readFloat(); System.out.println("Temperature: " + cityTemperature1);

        //
        // Đọc dữ liệu.
        //
        int cityId2 = dis.readInt();
        System.out.println("Id: " + cityId2);
        String cityName2 = dis.readUTF();
        System.out.println("Name: " + cityName2);
        int cityPopulation2 = dis.readInt();
        System.out.println("Population: " + cityPopulation2);
        float cityTemperature2 = dis.readFloat();
        System.out.println("Temperature: " + cityTemperature2);

        dis.close();
    }
}
