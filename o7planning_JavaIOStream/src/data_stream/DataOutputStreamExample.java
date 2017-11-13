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
import constants.Values;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputStreamExample {

    public static void main(String[] args) throws IOException {
        int cityIdA = 1;
        String cityNameA = "Green Lake City";
        int cityPopulationA = 500000;
        float cityTempA = 15.50f;

        int cityIdB = 2;
        String cityNameB = "Hà Nội";
        int cityPopulationB = 250000;
        float cityTempB = 10.45f;

        File dir = new File(Values.WORKING_DIR+"/Test_folder");
        if(!dir.exists()) {
            dir.mkdirs();
        }
        

        //
        // Tạo đối tượng FileOutputStream để ghi xuống file.
        //
//        FileOutputStream fos = new FileOutputStream(dir+"/cities.txt");
//
//        // Tạo đối tượng DataOutputStream bao lấy 'fos'.
//        // Dữ liệu ghi vào 'dos' sẽ được đẩy sang 'fos'.
//        DataOutputStream dos = new DataOutputStream(fos);

        //Hoac viet don gian hon:
        DataOutputStream dos = new DataOutputStream(new FileOutputStream(dir+"/cities.txt"));
        //
        // Ghi các dữ liệu vào luồng.
        //
        dos.writeInt(cityIdA);
        dos.writeUTF(cityNameA);
        dos.writeInt(cityPopulationA);
        dos.writeFloat(cityTempA);

        dos.writeInt(cityIdB);
        dos.writeUTF(cityNameB);
        dos.writeInt(cityPopulationB);
        dos.writeFloat(cityTempB);

        dos.flush();    //Flushes this output stream and forces any buffered output bytes to be written out to the stream.
                        // Phương thức này xả sạch dòng.Đệm dữ liệu được ghi ra dòng.
        
        dos.close();
    }

}
