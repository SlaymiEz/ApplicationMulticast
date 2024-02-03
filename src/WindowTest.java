import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class WindowTest extends JFrame implements KeyListener{
    JFrame frame = null;
    JPanel panel = null;
    JLabel label = null;
    JLabel BCube = null;
    Image BCubeI = null;
    Boolean up = false, down = false, right = false, left = false; // GARDER SINON CA PLANTE NULLPOINTER WTF
    int x = 0;
    int y = 0;
    static WindowTest window = new WindowTest();
    public static void main(String[] args) throws InterruptedException {
        window.variables();
        window.cubesConfig();
        window.panelConfig();
        window.parameters(); // Garder en dernier
        while(true){
            Thread.sleep(16); // 60FPS
            window.updatePosition();
        }
    }

    private void variables() {
        try {
            frame = new JFrame("Game");
            label = new JLabel("Je suis un Label", JLabel.CENTER);
            panel = new JPanel();
            BCube = new Cube("BlueCube", 255, 0, 0);
            BCubeI = new ImageIcon("lib/images/BlueCube.png").getImage();
            frame.addKeyListener(this);
        } catch (Exception e) {
            log(e.getLocalizedMessage());
        }
    }

    private void panelConfig() {
        //panel.setBackground(new Color(0, 0, 0)); //Noir
        panel.setBackground(new Color(255, 255, 255)); //Blanc
        panel.add(BCube);
        panel.setLayout(null);
    }

    public void cubesConfig() {
        BCube.setName("BlueCube");
        BCubeI = BCubeI.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
        BCube.setBounds(400, 300, 100, 100);
        BCube.setIcon(new ImageIcon(BCubeI));
        //BCube.setLocation(200, 200);
    }


    private void parameters() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setResizable(false);
        frame.add(panel);
        frame.setVisible(true); // Garder en dernier pour être sûr que ça marche
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
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        keysIn(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keysOut(e);
    }

    private void updatePosition(){
        window.keysActions();
        BCube.setLocation(x, y);
    }
    public static void log(String s) {
        System.out.println(s);
    }
}