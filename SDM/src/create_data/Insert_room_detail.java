/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package create_data;

import java.util.Random;

/**
 *
 * @author AnhTu
 */
public class Insert_room_detail {
    public static void main(String[] args) {
        Random rd = new Random();
        //example: INSERT INTO `dormitory`.`room_detail` (`Room_capacity`, `Room_free`, `Room_Room_id`, `Room_Dormitory_name`) VALUES ('8', '1', '16', 'B7');
        for (int i = 55; i < 107; i++) {
            System.out.println("INSERT INTO `dormitory`.`room_detail` (`Room_capacity`, `Room_free`, `Room_Room_id`, `Room_Dormitory_name`) VALUES ('"+(5+rd.nextInt(3))+"', '"+(1+rd.nextInt(3))+"', '"+i+"', 'B6');");
        }
        
    }
}
