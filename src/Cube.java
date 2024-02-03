import java.awt.Image;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Cube extends JLabel implements KeyListener{
    BufferedImage img = null;
    File f = null;
    Image CubeImage = null;
    int red, green, blue;
    int x = 0;
    int y = 0;
    Thread t = new Thread(() -> {movement();});
    Boolean up = false, down = false, right = false, left = false;
    public Cube(String name, int red, int green, int blue){
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.setName(name);
        imageManagement();
        t.start();
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
            f = new File("lib/Images/WhiteCube.png");
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
    private void keysIn(KeyEvent key){
        switch (key.getKeyChar()) {
            case 'z': up = true;
              break;
            case 'q': left = true;
                break;
            case 's': down = true;
                break;
            case 'd': right = true;
                break;
            default : break;   
        }
    }
    private void keysOut(KeyEvent key){
        switch (key.getKeyChar()) {
            case 'z': up = false;
                break;
            case 'q': left = false;
                break;
            case 's': down = false;
                break;
            case 'd': right = false;
                break;
            default : break;
        }
    }
    private void keysActions(){
        if (up == true) y-=5;
        if (left == true) x-=5;
        if (down == true) y+=5;
        if (right == true) x+=5;
    }
    private void updatePosition(){
        keysActions();
        setLocation(x, y);
    }
    private void movement(){
        while (true) {
            try {
            Thread.sleep(16);
            updatePosition();
            } catch (Exception e){
                System.out.println(e.getLocalizedMessage());
            } 
        }
    }
    @Override
    public void keyTyped(java.awt.event.KeyEvent e) {}
    @Override
    public void keyPressed(KeyEvent e) {
        keysIn(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keysOut(e);   
    }
}
