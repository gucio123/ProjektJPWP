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
    public Image[] images = new Image[8];
    private GreedyBackpack greedy = new GreedyBackpack();
    private DynamicBackpack dynamic = new DynamicBackpack();

    private JPanel panel3 = new JPanel() {
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            greedy.greedyBackpack();
            Graphics2D g2d = (Graphics2D) g;
            int fontSize = 14;
            Font f = new Font("Arial", Font.BOLD, fontSize);

            g2d.setFont(f);
            g2d.setColor(Color.BLACK);
            g2d.setBackground(Color.BLUE);
            g2d.drawString("Items before implementing greedy backpack:", 200, 20);
            g2d.drawString("Items in backpack after solving the problem:", 200, 260);
            g2d.drawLine(0, 25, 800, 25);
            g2d.drawLine(0, 240, 800, 240);
            g2d.drawLine(0, 270, 800, 270);
            int j = 0;
            int m = 150;
            int n = 0;
            for (int k = 0; k < 7; k++) {
                if (k % 2 == 0) {
                    g2d.drawImage(images[k], 0 + j, 40, null);
                    g2d.drawString("Weight: " + (double)greedy.listOfItems.get(k).getWeight(), 10 + j, 130);
                    g2d.drawString("Wage: " + (double)greedy.listOfItems.get(k).getValue()/greedy.listOfItems.get(k).getWeight(), 10 + j, 150);
                } else {
                    g2d.drawImage(images[k], 0 + j, 120, null);
                    g2d.drawString("Weight: " + (double)greedy.listOfItems.get(k).getWeight(), 10 + j, 210);
                    g2d.drawString("Wage: " + (double)greedy.listOfItems.get(k).getValue()/greedy.listOfItems.get(k).getWeight(), 10 + j, 230);
                }
                j += 120;


                if (greedy.backpack.contains(greedy.listOfItems.get(k))) {
                    g2d.drawImage(images[k], m, 300, null);
                    g2d.drawString("Wage: " + greedy.backpack.get(n).getValue() / greedy.items.get(n).getWeight(), m, 450);
                    n++;
                    m += 120;
                }
            }
//            g2d.drawImage(images[2], 100, 300, null);
//            g2d.drawImage(images[6], 180, 300, null);
//            g2d.drawImage(images[4], 260, 300, null);
//            g2d.drawImage(images[5], 340, 300, null);
        }
    };


    public BackPackGUI() {
        for (int i = 0; i < 7; i++) {
            int index = i + 1;
            ImageIcon img = new ImageIcon("PROJEKT/items/img" + index + ".png");
            images[i] = img.getImage();
        }

        this.setContentPane(this.panel3);
        this.pack();
        this.setVisible(true);
        this.setSize(800, 570);
        this.setBackground(Color.cyan);
    }


    public static void main(String[] args) throws IOException {
        BackPackGUI frame = new BackPackGUI();
//        frame.setContentPane(new BackPackGUI().panel3);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.pack();
//        frame.setVisible(true);
//        frame.setSize(800, 570);
//        frame.setBackground(Color.CYAN);    // nie dziala to idk czemu
    }
}