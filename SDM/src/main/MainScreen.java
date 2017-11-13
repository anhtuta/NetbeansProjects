/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import obj.DBC;
import obj.Manager;
import obj.Room;
import obj.Student;

/**
 *
 * @author tungt
 */
public class MainScreen extends javax.swing.JFrame {

    Manager manager = null;
    DBC dbc;
    Phong phong;
    StudentInfo sInfo;
    LogIn logIn;
    Diagram dia;
    KhuNha khuNha;
    MoveTo moveTo;
    String user;
    String pass;
    String dormitory;
    String room;
    ArrayList<Student> list;

    /**
     * Creates new form MainScreen
     */
    public MainScreen() throws IOException {
        dbc = new DBC();
        dia = new Diagram();
        phong = new Phong();
        moveTo = new MoveTo(manager);
        khuNha = new KhuNha(manager);
        logIn = new LogIn();
        sInfo = new StudentInfo();
        logIn.setVisible(true);
        initComponents();
        
        jPanel_BackGround.add(logIn);
        logIn.getLogIn().addMouseListener(new MouseAdapter() {  //chú ý hàm getLogin là trả về label login nhé, chứ ko phải trả về 1 JPanel
            @Override
            public void mousePressed(MouseEvent me) {
                user = logIn.getUser();
                pass = logIn.getPassword();
                manager = dbc.checkUser(user, pass);
                if (manager == null) {
                    logIn.setPassword("");
                    JOptionPane.showMessageDialog(rootPane, "Sai tên đăng nhập hoặc mật khẩu", " Lỗi", HEIGHT);
                    return;
                }
                dia.setManager(manager);
                logIn.setVisible(false);
                dia.setVisible(true);
                jPanel_BackGround.add(dia);
            }
        });
        khuNha.getBack().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                khuNha.setVisible(false);
                dia.setVisible(true);
            }
        });
        dia.getB7().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                getB();
            }
        });
        dia.getB6().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                getB();
            }
        });
        dia.getLogOut().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                System.out.println("log out");
                int i = JOptionPane.showConfirmDialog(rootPane, "Bạn muốn đăng xuất?", " Đăng xuất", HEIGHT);
                if (i == 0) {
                    logIn.setPassword("");
                    logIn.setVisible(true);
                    dia.setVisible(false);
                    dia.setManager(null);
                }
            }
        });
        khuNha.get109().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                getR();
            }
        });
        khuNha.get108().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                getR();
            }
        });
        khuNha.get107().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                getR();
            }
        });
        phong.getBack().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                phong.setVisible(false);
                khuNha.setVisible(true);
            }
        });
        phong.getComponent1().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                infoRoom();
            }
        });
        phong.getComponent2().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                infoRoom();
            }
        });
        phong.getComponent3().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                infoRoom();
            }
        });
        phong.getComponent4().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                infoRoom();
            }
        });
        phong.getComponent5().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                infoRoom();
            }
        });
        phong.getComponent6().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                infoRoom();
            }
        });
        phong.getComponent7().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                infoRoom();
            }
        });
        phong.getComponent8().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                infoRoom();
            }
        });
        sInfo.getBack().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                if (sInfo.isChange) {
                    int i = JOptionPane.showConfirmDialog(rootPane, "Lưu những thay đổi?", " Lưu", WIDTH);
                    if (i == 0) {
                        sInfo.doSave();
                    }
                    if (i == 2) {
                        return;
                    }
                }
                sInfo.resetAll();
                getR();
                sInfo.viewMode();
                sInfo.setVisible(false);
                phong.setVisible(true);
            }
        });
        sInfo.getCancel().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                int i = 1;
                if (sInfo.cur_student != null) {
                    i = JOptionPane.showConfirmDialog(rootPane, " Hủy trọ cho sinh viên "
                            + sInfo.cur_student.getStudent_name(), " Hủy trọ", WIDTH);
                    if (i == 0) {
                        dbc = new DBC();
                        dbc.Kick(sInfo.cur_id);
                        sInfo.resetAll();
                        getR();
                        sInfo.viewMode();
                        sInfo.setVisible(false);
                        phong.setVisible(true);
                    }
                }
            }
        });
        sInfo.getMove().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                int i = 1;
                if (sInfo.cur_student != null) {
                    i = JOptionPane.showConfirmDialog(rootPane, " Chuyển sinh viên "
                            + sInfo.cur_student.getStudent_name() + " sang phòng khác?", " Chuyển trọ", WIDTH);
                    if (i == 0) {
                        moveTo.setVisible(true);
                        jPanel_BackGround.add(moveTo);
                        sInfo.setVisible(false);
                    }
                }
            }
        });
        moveTo.get107().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                moveM();
            }
        });
        moveTo.get108().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                moveM();
            }
        });
        moveTo.get109().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                moveM();
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_BackGround = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Management");
        setResizable(false);

        jPanel_BackGround.setBackground(new java.awt.Color(0, 153, 204));

        javax.swing.GroupLayout jPanel_BackGroundLayout = new javax.swing.GroupLayout(jPanel_BackGround);
        jPanel_BackGround.setLayout(jPanel_BackGroundLayout);
        jPanel_BackGroundLayout.setHorizontalGroup(
            jPanel_BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1100, Short.MAX_VALUE)
        );
        jPanel_BackGroundLayout.setVerticalGroup(
            jPanel_BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_BackGround, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_BackGround, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    void moveM() {
        dbc = new DBC();
        int i = 0;
        i = dbc.getRoomID(moveTo.selectedPhong, dormitory);
        dbc.Move(sInfo.getStudent().getStudent_code(), i, dormitory);
        room = moveTo.selectedPhong;
        getR2();
        moveTo.setVisible(false);
    }

    void getB() {
        khuNha.setLabel(dia.selectedKhuNha.toUpperCase());
        dia.resetColor();
        dormitory = dia.selectedKhuNha;
        dia.setVisible(false);
        khuNha.setVisible(true);
        jPanel_BackGround.add(khuNha);
    }

    void infoRoom() {
        int i = phong.selectedComponent - 1;
        if (i >= list.size()) {
            sInfo.resetAll();
            phong.resetBackGround();
            sInfo.editMode();
            sInfo.setjTextField_room(room + " - " + dormitory);
            sInfo.hideEdit();
            sInfo.setVisible(true);
            phong.setVisible(false);
            jPanel_BackGround.add(sInfo);
            return;
        }
        sInfo.setStudent(list.get(i));
        sInfo.setjTextField_name(list.get(i).getStudent_name());
        sInfo.setjTextField_add(list.get(i).getStudent_homeLand());
        sInfo.setjTextField_k(list.get(i).getStudent_k() + "");
        sInfo.setjTextField_mssv(list.get(i).getStudent_code());
        sInfo.setjTextField_phone(list.get(i).getStudent_phone());
        sInfo.setjTextField_room(room + " - " + dormitory);
        sInfo.setjTextField_school(list.get(i).getStudent_school());
        sInfo.setImage(list.get(i).getStudent_image());
        int j = 1;
        if (list.get(i).getStudent_gentl().equals("Nam")) {
            j = 0;
        }
        sInfo.setjComboBox(j);
        sInfo.setJTextfield_gioiTinh(list.get(i).getStudent_gentl());
        sInfo.setjNgaySinh(list.get(i).getStudent_birth());
        phong.resetBackGround();
        sInfo.setVisible(true);
        phong.setVisible(false);
        jPanel_BackGround.add(sInfo);
        sInfo.isChange = false;
    }

    void getR() {
        khuNha.resetColor();
        phong.reset();
        khuNha.setVisible(false);
        room = khuNha.selectedPhong;
        String temp = dormitory+"-"+room;
        phong.setLabel(temp.toUpperCase());
        dbc = new DBC();
        if (list != null) {
            list.clear();
        }
        int i = dbc.getRoomID(room, dormitory);
        sInfo.setRoom(new Room(i, Integer.parseInt(room), dormitory));
        list = dbc.getStudent_inRoom(i);
        int size = list.size();
        int x = size;
        if (x == 0) {
            phong.setVisible(true);
            jPanel_BackGround.add(phong);
            return;
        }
        x--;
        phong.setjLabel_name1(list.get(0).getStudent_name());
        phong.setImage(1, list.get(0).getStudent_image());
        if (x == 0) {
            phong.setVisible(true);
            jPanel_BackGround.add(phong);
            return;
        }
        x--;
        phong.setjLabel_name2(list.get(1).getStudent_name());
        phong.setImage(2, list.get(1).getStudent_image());
        if (x == 0) {
            phong.setVisible(true);
            jPanel_BackGround.add(phong);
            return;
        }
        x--;
        phong.setjLabel_name3(list.get(2).getStudent_name());
        phong.setImage(3, list.get(2).getStudent_image());
        if (x == 0) {
            phong.setVisible(true);
            jPanel_BackGround.add(phong);
            return;
        }
        x--;
        phong.setjLabel_name4(list.get(3).getStudent_name());
        phong.setImage(4, list.get(3).getStudent_image());
        if (x == 0) {
            phong.setVisible(true);
            jPanel_BackGround.add(phong);
            return;
        }
        x--;
        phong.setjLabel_name5(list.get(4).getStudent_name());
        phong.setImage(5, list.get(4).getStudent_image());
        if (x == 0) {
            phong.setVisible(true);
            jPanel_BackGround.add(phong);
            return;
        }
        x--;
        phong.setjLabel_name6(list.get(5).getStudent_name());
        phong.setImage(6, list.get(5).getStudent_image());
        if (x == 0) {
            phong.setVisible(true);
            jPanel_BackGround.add(phong);
            return;
        }
        x--;
        phong.setjLabel_name7(list.get(6).getStudent_name());
        phong.setImage(7, list.get(6).getStudent_image());
        phong.setVisible(true);
        jPanel_BackGround.add(phong);
        if (x == 0) {
            phong.setVisible(true);
            jPanel_BackGround.add(phong);
            return;
        }
        x--;
        phong.setjLabel_name8(list.get(7).getStudent_name());
        phong.setImage(8, list.get(7).getStudent_image());
        phong.setVisible(true);
        jPanel_BackGround.add(phong);
    }

    void getR2() {
        khuNha.resetColor();
        phong.reset();
        khuNha.setVisible(false);
        dbc = new DBC();
        if (list != null) {
            list.clear();
        }
        int i = dbc.getRoomID(room, dormitory);
        sInfo.setRoom(new Room(i, Integer.parseInt(room), dormitory));
        list = dbc.getStudent_inRoom(i);
        String temp = dormitory+"-"+room;
        phong.setLabel(temp.toUpperCase());
        int size = list.size();
        int x = size;
        if (x == 0) {
            phong.setVisible(true);
            jPanel_BackGround.add(phong);
            return;
        }
        x--;
        phong.setjLabel_name1(list.get(0).getStudent_name());
        phong.setImage(1, list.get(0).getStudent_image());
        if (x == 0) {
            phong.setVisible(true);
            jPanel_BackGround.add(phong);
            return;
        }
        x--;
        phong.setjLabel_name2(list.get(1).getStudent_name());
        phong.setImage(2, list.get(1).getStudent_image());
        if (x == 0) {
            phong.setVisible(true);
            jPanel_BackGround.add(phong);
            return;
        }
        x--;
        phong.setjLabel_name3(list.get(2).getStudent_name());
        phong.setImage(3, list.get(2).getStudent_image());
        if (x == 0) {
            phong.setVisible(true);
            jPanel_BackGround.add(phong);
            return;
        }
        x--;
        phong.setjLabel_name4(list.get(3).getStudent_name());
        phong.setImage(4, list.get(3).getStudent_image());
        if (x == 0) {
            phong.setVisible(true);
            jPanel_BackGround.add(phong);
            return;
        }
        x--;
        phong.setjLabel_name5(list.get(4).getStudent_name());
        phong.setImage(5, list.get(4).getStudent_image());
        if (x == 0) {
            phong.setVisible(true);
            jPanel_BackGround.add(phong);
            return;
        }
        x--;
        phong.setjLabel_name6(list.get(5).getStudent_name());
        phong.setImage(6, list.get(5).getStudent_image());
        if (x == 0) {
            phong.setVisible(true);
            jPanel_BackGround.add(phong);
            return;
        }
        x--;
        phong.setjLabel_name7(list.get(6).getStudent_name());
        phong.setImage(7, list.get(6).getStudent_image());
        phong.setVisible(true);
        jPanel_BackGround.add(phong);
        if (x == 0) {
            phong.setVisible(true);
            jPanel_BackGround.add(phong);
            return;
        }
        x--;
        phong.setjLabel_name8(list.get(7).getStudent_name());
        phong.setImage(8, list.get(7).getStudent_image());
        phong.setVisible(true);
        jPanel_BackGround.add(phong);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws IOException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MainScreen().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel_BackGround;
    // End of variables declaration//GEN-END:variables
}
