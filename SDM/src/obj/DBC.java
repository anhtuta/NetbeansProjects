/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obj;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author tungt
 */
public class DBC {

    public Connection getConnection() {
        Connection con;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:" + "3306/dormitory?useSSL=false", "root", "5555");
            System.out.println("Connect successful");
            return con;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    public void exeSQL(String query, String message) {
        Connection con = getConnection();
        Statement st;
        try {
            st = con.createStatement();
            st.executeUpdate(query);
            con.close();
        } catch (SQLException e) {
        }
    }

    public void exeSQL_image(String query, String message, String code, String name, int k,
            String school, String birthday, String gentl, String home,
            String phone, int room, String dormi, FileInputStream file, long len, String oldID) {
        Connection con = getConnection();
        try {
            PreparedStatement ps;
            if (message.equals("update")) {
                if (len != 0) {
                    ps = con.prepareStatement("UPDATE `dormitory`.`student` SET "
                            + "`Student_code`=?, `Student_name`=?, "
                            + "`Student_image`=?, `Student_k`=?, "
                            + "`Student_school`=?, `Student_birth`=?, "
                            + "`Student_gentl`=?, `Student_homeLand`=?, "
                            + "`Student_phone`=? WHERE `Student_code`=?;");
                    ps.setBinaryStream(3, file, len);
                    ps.setString(1, code);
                    ps.setString(2, name);
                    ps.setInt(4, k);
                    ps.setString(5, school);
                    ps.setString(6, birthday);
                    ps.setString(7, gentl);
                    ps.setString(8, home);
                    ps.setString(9, phone);
                    ps.setString(10, oldID);
                } else {
                    ps = con.prepareStatement("UPDATE `dormitory`.`student` SET "
                            + "`Student_code`=?, `Student_name`=?, "
                            + "`Student_k`=?, "
                            + "`Student_school`=?, `Student_birth`=?, "
                            + "`Student_gentl`=?, `Student_homeLand`=?, "
                            + "`Student_phone`=? WHERE `Student_code`=?;");

                    ps.setString(1, code);
                    ps.setString(2, name);
                    ps.setInt(3, k);
                    ps.setString(4, school);
                    ps.setString(5, birthday);
                    ps.setString(6, gentl);
                    ps.setString(7, home);
                    ps.setString(8, phone);
                    ps.setString(9, oldID);
                }
                ps.executeUpdate();
                con.close();
                return;
            }
            ps = con.prepareStatement("INSERT INTO `dormitory`.`student`"
                    + " (`Student_code`, `Student_name`, `Student_image`, "
                    + "`Student_k`, `Student_school`, `Student_birth`, `Student_gentl`, "
                    + "`Student_homeLand`, `Student_phone`, `Room_id`, `Dormitory_name`) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");

            ps.setString(1, code);
            ps.setString(2, name);
            ps.setBinaryStream(3, file, len);
            ps.setInt(4, k);
            ps.setString(5, school);
            ps.setString(6, birthday);
            ps.setString(7, gentl);
            ps.setString(8, home);
            ps.setString(9, phone);
            ps.setInt(10, room);
            ps.setString(11, dormi);
            ps.executeUpdate();
            con.close();

        } catch (SQLException ex) {
        }
    }

    public ArrayList<Student> getStudentList(String orderBy) {
        ArrayList<Student> list = new ArrayList();
        Connection con = getConnection();
        ResultSet rs;
        Statement st;
        try {
            st = con.createStatement();
            rs = st.executeQuery("select * from student order by " + orderBy + ";");
            Student s;
            while (rs.next()) {
                s = new Student(rs.getString("Student_code"),
                        rs.getString("Student_name"), rs.getBlob("Student_image"),
                        rs.getInt("Student_k"), rs.getString("Student_school"),
                        rs.getString("Student_birth"), rs.getString("Student_gentl"),
                        rs.getString("Student_homeLand"), rs.getString("Student_phone"),
                        rs.getInt("Room_id"), rs.getString("Dormitory_name"));
                list.add(s);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public Student getStudent(String id) {
        Student s1 = null;
        Connection con = getConnection();
        ResultSet rs;
        Statement st;
        try {
            st = con.createStatement();
            rs = st.executeQuery("select * from student where student_id =  " + id + ";");
            Student s;
            while (rs.next()) {
                s = new Student(rs.getString("Student_code"),
                        rs.getString("Student_name"), rs.getBlob("Student_image"),
                        rs.getInt("Student_k"), rs.getString("Student_school"),
                        rs.getString("Student_birth"), rs.getString("Student_gentl"),
                        rs.getString("Student_homeLand"), rs.getString("Student_phone"),
                        rs.getInt("Room_id"), rs.getString("Dormitory_name"));
                s1 = s;
            }
            con.close();
        } catch (Exception e) {
        }
        return s1;
    }

    public Room getRoom(int id) {
        Room r;
        Connection con = getConnection();
        ResultSet rs;
        Statement st;
        try {
            st = con.createStatement();
            rs = st.executeQuery("select * from room where room_id = " + id);
            rs.next();
            r = new Room(rs.getInt("room_id"), rs.getInt("room_name"),
                    rs.getString("dormitory_name"));
            con.close();
            return r;
        } catch (Exception e) {
            return null;
        }
    }


    public ArrayList<RoomDetail> getRoomDetail(String order) {
        ArrayList<RoomDetail> list = new ArrayList<>();
        Connection con = getConnection();
        ResultSet rs;
        Statement st;
        try {
            st = con.createStatement();
            if (order.equals("joinable")) {
                rs = st.executeQuery("select room.room_id, room.room_name,"
                        + "room_Detail.room_capacity, room_detail.room_free, "
                        + "room_detail.dormitory_name from room,room_Detail "
                        + "where room.room_id=room_detail.room_id and room_detail.room_free !=0;");
            } else {

                rs = st.executeQuery("select room.room_id, room.room_name,"
                        + "room_Detail.room_capacity, room_detail.room_free, "
                        + "room_detail.dormitory_name from room,room_Detail "
                        + "where room.room_id=room_detail.room_id;");
            }
            RoomDetail r;
            while (rs.next()) {
                r = new RoomDetail(rs.getInt("room_id"), rs.getInt("room_name"),
                        rs.getInt("room_capacity"), rs.getInt("room_free"),
                        rs.getString("dormitory_name"));
                list.add(r);
            }
            con.close();
            return list;
        } catch (Exception e) {
            return null;
        }
    }

    public ArrayList<Student> searchStudent(String searchBy, String value) {
        ArrayList<Student> list = new ArrayList<>();
        Connection con = getConnection();
        Statement st;
        ResultSet rs;
        String query = "SELECT * FROM dormitory.student where " + searchBy + " like \"%" + value + "%\";";
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            Student s;
            while (rs.next()) {
                s = new Student(rs.getString("Student_code"),
                        rs.getString("Student_name"), rs.getBlob("Student_image"),
                        rs.getInt("Student_k"), rs.getString("Student_school"),
                        rs.getString("Student_birth"), rs.getString("Student_gentl"),
                        rs.getString("Student_homeLand"), rs.getString("Student_phone"),
                        rs.getInt("Room_id"), rs.getString("Dormitory_name"));
                list.add(s);
            }
            con.close();
        } catch (Exception e) {
        }

        return list;
    }

    public ArrayList<Manager> getManager() {
        ArrayList<Manager> list = new ArrayList();
        Connection con = getConnection();
        Statement st;
        ResultSet rs;
        String query = "SELECT * from domitory.manager;";
        Manager m;
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                m = new Manager(rs.getInt("Manager_id"), rs.getString("Manager_name"),
                        rs.getString("Manager_password"), rs.getString("Manager_phone"),
                        rs.getString("Manager_add"), rs.getString("dormitory_name"));
            }
            con.close();
        } catch (Exception e) {
        }
        return list;
    }

    public Manager checkUser(String User, String Password) {
        Manager m = null;
        Connection con = getConnection();
        Statement st;
        ResultSet rs;
        String query = "SELECT * from dormitory.manager where manager_id = " + User + ";";
        try {
            Manager n;
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                n = new Manager(rs.getInt("manager_id"), rs.getString("manager_name"),
                        rs.getString("manager_password"), rs.getString("manager_phone"),
                        rs.getString("manager_add"), rs.getString("dormitory_name"));
                m = n;
            }
            if (m == null) {
                con.close();
                return null;
            }
            if (!m.Manager_password.equals(Password)) {
                con.close();
                return null;
            }
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        return m;
    }

    public int getRoomID(String name, String dor) {
        int id = 0;
        Connection con = getConnection();
        Statement st;
        ResultSet rs;
        String query = "SELECT * FROM dormitory.room where Room_name = " + name + " and Dormitory_name= '" + dor + "';";
        try {
            Room n;
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                n = new Room(rs.getInt("room_id"), rs.getInt("room_name"), rs.getString("dormitory_name"));
                id = n.Room_id;
            }
            con.close();
        } catch (Exception e) {
        }
        return id;
    }

    public ArrayList<Student> getStudent_inRoom(int id) {
        ArrayList<Student> list = new ArrayList();
        Connection con = getConnection();
        Statement st;
        ResultSet rs;
        String query = "SELECT * FROM dormitory.student where Room_id = " + id + " order by Student_name;";
        try {
            Student n;
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                n = new Student(rs.getString("Student_code"), rs.getString("Student_name"),
                        rs.getBlob("Student_image"), rs.getInt("student_k"), rs.getString("student_school"),
                        rs.getString("student_birth"), rs.getString("student_gentl"),
                        rs.getString("student_homeLand"), rs.getString("student_phone"),
                        id, rs.getString("dormitory_name"));
                list.add(n);
            }
            con.close();
        } catch (Exception e) {
        }
        return list;
    }
    public void Kick(String id){
        Connection con = getConnection();
        Statement st;
        String query = "UPDATE `dormitory`.`student` SET `Room_id`='1', `Dormitory_name`='b7' WHERE `Student_code`='"+id+"';";
        try {
            st = con.createStatement();
            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void Move(String student_id, int room_id, String dor){
        Connection con = getConnection();
        Statement st;
        String query = "UPDATE `dormitory`.`student` SET `Room_id`='"+room_id+"', `Dormitory_name`='"+dor+"' WHERE `Student_code`='"+student_id+"';";
        try {
            st = con.createStatement();
            st.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static void main(String[] args) {
        new DBC().getConnection();
    }
}
