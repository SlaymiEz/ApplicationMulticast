import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Cube extends JLabel{
    Color c;
    BufferedImage img = null;
    File f = null;
    Image CubeImage;
    int red, green, blue;
    public Cube(Color c, String name, int red, int green, int blue){
        this.c = c;
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.setName(name);
        changeImage();
        this.setBounds(0, 0, 100, 100);
        
    }
    
    private void changeImage(){
        try {
            f = new File("lib/WhiteCube.png");
            img = ImageIO.read(f);
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        }

        int width = img.getWidth();
        int height = img.getHeight();

        for (int col = 0; col < width; col++){
            for (int row = 0; row < height; row++){
                int p = img.getRGB(col, row);
                int a = (p >> 24) & 0xff;
                int r = (p >> 16) & 0xff;
                int g = (p >> 8) & 0xff;
                int b = p & 0xff;
                if (r != 0 && g != 0 && b != 0){
                    a = 255;
                    r = red;
                    g = green;
                    b = blue;
                    p = (a <<24) | (r << 16) | (g << 8) | b;
                    img.setRGB(col, row, p);
                }
            }
        }

        //try {
        //    f = new File("lib/Images/TempCube.png");
        //    ImageIO.write(img, "png", f);
        //} catch (IOException e) {
        //    System.out.println(e.getLocalizedMessage());
        //}
    }
}
