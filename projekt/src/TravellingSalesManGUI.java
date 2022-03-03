import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.*;
import java.awt.geom.*;
import java.awt.*;

public class TravellingSalesManGUI extends JFrame {

    private JButton Losowo;
    private JButton button2;
    private JButton button3;
    private JPanel mapPanel;
    private JLabel mapLabel;
    private Image map;
    private boolean paintcheck = true;
    private TravellingSalesManRandom random = new TravellingSalesManRandom("Waszyngton");

    private JPanel panel1 = new JPanel(){
        @Override
        public void paintComponent(Graphics g) {
//            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.drawImage(map, 0, 0, null);
            g2.setColor(Color.RED);
            if (paintcheck) {
                for (int i = 0; i < random.getFinalLIst().toArray().length - 1; i++) {
                    g2.drawLine(random.getFinalLIst().get(i).getX(), random.getFinalLIst().get(i).getY(), random.getFinalLIst().get(i + 1).getX(), random.getFinalLIst().get(i + 1).getY());
                }
            }
        }
    };

    public TravellingSalesManGUI() {

        ImageIcon mapa = new ImageIcon("PROJEKT/map/mapka.png");
        map = mapa.getImage();
        mapPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println(e.getX() + " " + e.getY());
            }
        });
        Losowo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                random.way();
                paintcheck = true;
                panel1.repaint();

            }

        });
        panel1.add(Losowo);
    }

    public static void main(String[] args) throws IOException {
//        JFrame frame = new JFrame("TravellingSalesManGUI");
        TravellingSalesManGUI frame = new TravellingSalesManGUI();
        frame.setContentPane(new TravellingSalesManGUI().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(798, 570);
    }
}

