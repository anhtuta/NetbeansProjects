/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package create_data;

/**
 *
 * @author AnhTu
 */
public class Insert_room {
    //example: INSERT INTO `dormitory`.`room` (`Room_id`, `Room_name`, `Dormitory_name`) VALUES ('31', '303', 'B7');
    public static void main(String[] args) {
        for (int i = 94; i < 107; i++) {
            System.out.println("INSERT INTO `dormitory`.`room` (`Room_id`, `Room_name`, `Dormitory_name`) VALUES ('"+i+"', '"+(400+(i-93))+"', 'B6');");
        }
    }
    
}
