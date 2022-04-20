import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class dynamicGUI extends JFrame {

    private JPanel panel5 = new JPanel() {
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            int fontSize = 14;
            Font f = new Font("Arial", Font.BOLD, fontSize);
            g2d.setFont(f);
            g2d.drawString("Dynamic backpack matrix", 300, 20);
            g2d.drawLine(0, 25, 800, 25);

            g2d.drawString("ten kto slucha problemu ma chuja w uszach", 300, 300);
        }
    };

    public dynamicGUI() {
        this.setContentPane(this.panel5);
        this.pack();
        this.setVisible(true);
        this.setSize(800, 570);
    }

    public static void main(String[] args) throws IOException {
        dynamicGUI frame = new dynamicGUI();
    }
}
