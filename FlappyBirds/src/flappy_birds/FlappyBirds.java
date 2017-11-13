/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flappy_birds;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import pkg2dgamesframework.AFrameOnImage;
import pkg2dgamesframework.Animation;
import pkg2dgamesframework.GameScreen;

/**
 *
 * @author AnhTu
 */
public class FlappyBirds extends GameScreen {

    private BufferedImage birdImage;
    private Animation bird_anim;
    private BufferedImage chimneyImage;
    
    public static float g = 0.15f; //gia tốc rơi tự do, kéo con chim xuống rơi tự do
    private Bird bird;
    private Ground ground;
    private ChimneyGroup chimneyGroup;
    
    private int BEGIN_SCREEN = 0;
    private int GAMEPLAY_SCREEN = 1;
    private int GAMEOVER_SCREEN = 2;
    private int currentScreen = BEGIN_SCREEN;
    
    private int score;
    
    public FlappyBirds() {
        super(800,600); //kich thuoc của frame: gọi hàm khởi tạo GameScreen(int w, int h)
        try {
            birdImage = ImageIO.read(new File("Assets/bird_sprite.png"));
            chimneyImage = ImageIO.read(new File("Assets/chimney.png"));
        } catch (IOException ex) {
            Logger.getLogger(FlappyBirds.class.getName()).log(Level.SEVERE, null, ex);
        }
        bird_anim = new Animation(70); //ảnh bird_sprite.png có kích thước 180x60, gồm 3 frame nhỏ, mỗi frame con đó tồn tại 100ms, sau đó frame khác xuất hiện
        //các frame thay nhau xuất hiện sẽ tạo lên ảnh động
        AFrameOnImage f;
        f = new AFrameOnImage(0, 0, 60, 60); //ảnh bird_sprite.png có kích thước 180x60, gồm 3 frame nhỏ, mỗi frame là 1 con chim có kích thước 60x60
        //f ở trên là cái frame đầu tiên tọa độ (0,0) và kích thước 60x60
        bird_anim.AddFrame(f);
        f = new AFrameOnImage(60, 0, 60, 60); //frame thứ 2
        bird_anim.AddFrame(f);
        f = new AFrameOnImage(120, 0, 60, 60); //frame thứ 3
        bird_anim.AddFrame(f);
        f = new AFrameOnImage(60, 0, 60, 60);
        bird_anim.AddFrame(f);
        
        bird = new  Bird(350, 250, 50, 50);
        ground = new Ground();
        
        chimneyGroup = new ChimneyGroup();
        
        BeginGame(); //mở cửa số game
    }
    
    public static void main(String[] args) {
        new FlappyBirds();
    }
    
    
    private void resetGame() {
        //đặt lại tọa độ và tốc độ của chim về ban đầu
        bird.setPos(350, 250);
        bird.setVt(0);
        bird.setAlive(true);
        score = 0;
        chimneyGroup.resetChimneys();
    }
    
    @Override
    public void GAME_UPDATE(long deltaTime) {
        int i;
        if(currentScreen == BEGIN_SCREEN) {
            resetGame();
        }
        else if(currentScreen == GAMEPLAY_SCREEN) {
            bird_anim.Update_Me(deltaTime);
            if(bird.getAlive()) bird.update(deltaTime);
            ground.update();
            chimneyGroup.update();
            
            for (i = 0; i < ChimneyGroup.SIZE; i++) {
                if(bird.getRect().intersects(chimneyGroup.getChimney(i).getRect())) {
                    currentScreen = GAMEOVER_SCREEN;
                    System.out.println("game over: bump to chimney");
                    bird.setAlive(false);
                    bird.bupSound.play();
                }
            }
            
            for (i = 0; i < ChimneyGroup.SIZE; i++) {
                if((bird.getPosX() > chimneyGroup.getChimney(i).getPosX()) && (!chimneyGroup.getChimney(i).getIsBehindBird()) && (i%2==0)) {
                    score++;
                    bird.scoreSound.play();
                    chimneyGroup.getChimney(i).setIsBehindBird(true);
                }
            }
            
            if(bird.getPosY() + bird.getH() > ground.getYGround()) {
                currentScreen = GAMEOVER_SCREEN;
                System.out.println("game over: bird fall into ground");
                bird.bupSound.play();
            }
            
        }
        else {
            
        }
        
    }
    
    @Override
    public void GAME_PAINT(Graphics2D g2) {
        g2.setColor(Color.decode("#b8daef"));
        g2.fillRect(0, 0, MASTER_WIDTH, MASTER_HEIGHT);
        chimneyGroup.paint2D(g2);
        
        ground.paint2D(g2);
        
        if(bird.getIsFlying()) 
           bird_anim.PaintAnims((int) bird.getPosX(), (int) bird.getPosY(), birdImage, g2, 0, -0.4f); //xoay đầu lên
        else
            bird_anim.PaintAnims((int) bird.getPosX(), (int) bird.getPosY(), birdImage, g2, 0, 0); //ko xoay đầu
        
        
        if(currentScreen == BEGIN_SCREEN) {
            g2.setColor(Color.RED);
            g2.drawString("Press any key to play game", 200, 300);
        }
        else if(currentScreen == GAMEOVER_SCREEN) {
            g2.setColor(Color.RED);
            g2.drawString("Press any key to go back begin Screen", 200, 300);
        
        }
        
        g2.setFont(new Font("Arial", Font.BOLD, 25));
        g2.setColor(Color.BLUE);
        g2.drawString("Score: "+score, 20, 30);
        
    }

    @Override
    public void KEY_ACTION(KeyEvent e, int Event) {
        if(Event == GameScreen.KEY_PRESSED) {  //có thể dùng if(Event == GameScreen.KEY_PRESSED) cũng đc, vì class này extends class GameScreen
            if(currentScreen==BEGIN_SCREEN) {
                currentScreen = GAMEPLAY_SCREEN;
            }
            else if(currentScreen==GAMEPLAY_SCREEN) {
                if(bird.getAlive()) bird.fly();
            }
            else {
                currentScreen = BEGIN_SCREEN;
            }
        }
    }
    
    
}
