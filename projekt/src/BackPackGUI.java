import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BackPackGUI extends JFrame {
    private Image[] images = new Image[8];
    private GreedyBackpack greedy = new GreedyBackpack();
    private DynamicBackpack dynamic = new DynamicBackpack();

    private JPanel panel3 = new JPanel() {
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D) g;
            int fontSize = 20;
            Font f = new Font("Arial", Font.BOLD, fontSize);

            g2d.setFont(f);
            g2d.setColor(Color.BLACK);
            g2d.setBackground(Color.BLUE);
            g2d.drawString("Items before implementing greedy backpack:", 200, 20);
            g2d.drawString("Items in backpack after solving the problem:", 200, 250);
            g2d.drawLine(0, 25, 800, 25);
            g2d.drawLine(0, 230, 800, 230);
            g2d.drawLine(0, 260, 800, 260);
            int j = 0;
            for (int k = 0; k < 8; k++) {
                if (k % 2 == 0)
                    g2d.drawImage(images[k], 0 + j, 40, null);
                else
                    g2d.drawImage(images[k], 0 + j, 120, null);
                j += 80;

            }
        }
    };


    public BackPackGUI() {
        for (int i = 0; i < 8; i++) {
            ImageIcon img = new ImageIcon("PROJEKT/items/img" + i + ".png");
            images[i] = img.getImage();
        }

        this.setContentPane(this.panel3);
        this.pack();
        this.setVisible(true);
        this.setSize(800, 570);
    }


    public static void main(String[] args) throws IOException {
        BackPackGUI frame = new BackPackGUI();
        frame.setContentPane(new BackPackGUI().panel3);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(800, 570);
        frame.setBackground(Color.CYAN);    // nie dziala to idk czemu
    }
}