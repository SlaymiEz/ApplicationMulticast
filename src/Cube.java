import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Cube extends JLabel{
    Color c;
    public Cube(Color c, String name, int width, int height){
        this.c = c;
        this.setName(name);
        this.setBounds(0, 0, width, height);
        //this.setIcon()
                this.setForeground(c);

        
    }

    public void setVolocity(int x, int y){
    }
     public void setPosition(int x, int y){
        this.setPosition(x, y);
    }
}
