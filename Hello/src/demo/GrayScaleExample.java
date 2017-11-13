/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grayscaleexample;

import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

/**
 *
 * @author TQHuy
 * điền số thread ở hàm makethread
 * hiển thi thời gian thực thi khi kết thúc app
 */
public class GrayScaleExample extends JFrame implements Runnable {

    int width, height;
    BufferedImage img = null;
    private String fileName = "";
    private String saveLocationName = "";
    boolean scanDone = false;
    long startTime, endTime;

    public GrayScaleExample() {
        //thêm giao diện
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    void makeThread(int threadNum) {
        while ((threadNum--) != 0) {
            System.out.println("new thread");
            Thread thread = new Thread(this);
            thread.start();
        }
    }

    //chọn ảnh
    void chooseImage() {
        JFileChooser chooser = new JFileChooser();
        int kq = chooser.showOpenDialog(this);
        if (kq == JFileChooser.APPROVE_OPTION) {
            fileName = chooser.getSelectedFile().getAbsolutePath();
        }
    }

    //chọn thư mục save
    void saveLocation() {
        JFileChooser chooser2 = new JFileChooser();
        chooser2.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int kq = chooser2.showOpenDialog(this);
        if (kq == JFileChooser.APPROVE_OPTION) {
            saveLocationName = chooser2.getSelectedFile().getAbsolutePath();
        }

    }

    public static void main(String[] args) {
        // TODO code application logic here

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(GrayScaleExample.class.getName()).log(Level.SEVERE, null, ex);
        }

        GrayScaleExample gc = new GrayScaleExample();

        File f = null;
        gc.chooseImage();
        f = new File(gc.fileName);
        try {
            gc.img = ImageIO.read(f);
        } catch (IOException ex) {
            Logger.getLogger(GrayScaleExample.class.getName()).log(Level.SEVERE, null, ex);
        }
        //lay chieu dai rong cua anh
        gc.width = gc.img.getWidth();
        gc.height = gc.img.getHeight();
        
        gc.makeThread(8);
        
        if (gc.scanDone) {
            System.out.println("bitch");
            gc.endTime = System.currentTimeMillis();
            gc.saveLocation();
            try {
                f = new File(gc.saveLocationName + "\\Output.jpg");
                ImageIO.write(gc.img, "jpg", f);
            } catch (IOException e) {
                System.out.println(e);
            }

            System.out.println(gc.endTime - gc.startTime);
        }

    }

    @Override
    public synchronized void run() {
        System.out.println("hey");
        startTime = System.currentTimeMillis();
        //thao tac voi tung pixel
        if (!this.scanDone) {
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    //lấy các giá trị.không biết xử lý ảnh nên k hiểu
                    int p = img.getRGB(x, y);//pixel
                    int a = (p >> 24) & 0xff;//alpha
                    int r = (p >> 16) & 0xff;//red
                    int g = (p >> 8) & 0xff;//green
                    int b = p & 0xff;//blue

                    int avg = (r + g + b) / 3;//giá trị trung bình làm cho ảnh xám
                    p = (a << 24) | (avg << 16) | (avg << 8) | avg;
                    img.setRGB(x, y, p);

                }
            }
            this.scanDone = true;

        }
        endTime = System.currentTimeMillis();
        System.out.println(scanDone);
        saveLocation();
        try {
            File f = new File(saveLocationName + "\\Output.jpg");
            ImageIO.write(img, "jpg", f);
        } catch (IOException e) {
            System.out.println(e);
        }

        System.out.println("time execute: " + (endTime - startTime));
        System.exit(0);
    }

}
