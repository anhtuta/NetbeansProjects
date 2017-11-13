/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2dgamesframework;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

/**
 *
 * @author phamn
 */
public class AFrameOnImage { //class này để lấy 1 ảnh để tạo ảnh động cho class Animation
                             //nghĩa là 1 Animation cần giả sử 4 ảnh để tạo ảnh động, do đó ta sẽ add lần lượt 4 ảnh vào 
                             //mảng frames bên class Animation (giống game con rắn)
                             //đối tượng đc add vào đáng ra là 1 ảnh, nhưng ta dùng đối tượng add vào thuộc lớp này
    
    private boolean enablePaintRect = false;
    
    private int []DimsBounds = new int[4];  //t nghĩ thì 
//        DimsBounds[0] = tọa độ x của hình
//        DimsBounds[1] = tọa độ y của hình
//        DimsBounds[2] = chiều rộng của hình (theo trục x)
//        DimsBounds[3] = chiều cao của hình (theo trục y)
    
    public AFrameOnImage(int xOnImage, int yOnImage, int w, int h){
        DimsBounds[0] = xOnImage;
        DimsBounds[1] = yOnImage;
        DimsBounds[2] = w;
        DimsBounds[3] = h;
    }
    public void VisibleRectDebug(boolean enable){
        enablePaintRect = enable;
    }
    public int[] GetBounds(){
        return DimsBounds;
    }
    
    //theo t nghĩ thì hàm sau vẽ 1 ảnh image tại tọa độ (x,y), hình đó đc quay 1 góc = rotation:
    public void Paint(int x, int y, BufferedImage image, Graphics2D g2, int anchor, float rotation){
        
        BufferedImage imageDraw = image.getSubimage(DimsBounds[0], DimsBounds[1], DimsBounds[2], DimsBounds[3]);
        
        AffineTransform tx = new AffineTransform();
        tx.rotate(rotation, imageDraw.getWidth() / 2, imageDraw.getHeight() / 2);

        AffineTransformOp op = new AffineTransformOp(tx,
            AffineTransformOp.TYPE_BILINEAR);
        imageDraw = op.filter(imageDraw, null);
        
        
        g2.drawImage(imageDraw, x, y, null);
        
        if(enablePaintRect) PaintBound(g2);
    }
    private void PaintBound(Graphics2D g){
        
    }
}
