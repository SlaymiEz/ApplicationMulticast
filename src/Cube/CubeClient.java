package Cube;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CubeClient extends Cube implements KeyListener{

    public CubeClient(String name, int red, int green, int blue){
        super(name, red, green, blue);
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
    public void update(){
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
