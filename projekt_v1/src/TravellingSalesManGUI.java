import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.*;
import java.awt.geom.*;

public class TravellingSalesManGUI {
    private JPanel panel1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JPanel mapa;
    private JLabel mapLabel;

    public TravellingSalesManGUI() {
        mapLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println(e.getX() + " " + e.getY());

            }
        });
    }
    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame("TravellingSalesManGUI");
        frame.setContentPane(new TravellingSalesManGUI().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
