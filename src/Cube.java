import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Cube extends JLabel{
    BufferedImage img = null;
    File f = null;
    Image CubeImage = null;
    int red, green, blue;
    public Cube(String name, int red, int green, int blue){
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.setName(name);
        imageManagement();
    }

    private void imageManagement(){
        changeImage();
        CubeImage = new ImageIcon(img).getImage();
        CubeImage = CubeImage.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
        this.setBounds(0, 0, 100, 100);
        setIcon(new ImageIcon(CubeImage));
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
    }
}
