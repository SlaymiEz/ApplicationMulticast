import java.awt.Image;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class WindowTest extends JFrame {
    JFrame frame = null;
    JPanel panel = null;
    Cube BCube = null;
    Image BCubeI = null;
    Boolean up = false, down = false, right = false, left = false; // GARDER SINON CA PLANTE NULLPOINTER WTF
    int x = 0;
    int y = 0;
    static WindowTest window = new WindowTest();
    public static void main(String[] args) throws InterruptedException {
        window.variables();
        window.panelConfig();
        window.parameters(); // Garder en dernier
    }

    private void variables() {
        try {
            frame = new JFrame("Game");
            panel = new JPanel();
            BCube = new Cube("BlueCube", 255, 0, 0);
            frame.addKeyListener(BCube);
        } catch (Exception e) {
            log(e.getLocalizedMessage());
        }
    }

    private void panelConfig() {
        panel.setBackground(new Color(255, 255, 255)); //Blanc
        panel.add(BCube);
        panel.setLayout(null);
    }

    private void parameters() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setResizable(false);
        frame.add(panel);
        frame.setVisible(true); // Garder en dernier pour être sûr que ça marche
    }
    public static void log(String s) {
        System.out.println(s);
    }
}