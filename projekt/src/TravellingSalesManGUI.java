import javax.imageio.ImageIO;
import javax.print.attribute.standard.RequestingUserName;
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

    private JButton Losowo = new JButton("Kliknij");
    private JPanel mapPanel;
    private JLabel mapLabel;
    private Image map;
    private boolean paintcheck = false;
    private TravellingSalesManRandom random = new TravellingSalesManRandom("Waszyngton");
//    private int a = 0;
//    private int b = 0;
//    private int c = 0;
//    private int d = 0;

    private JPanel panel1 = new JPanel() {
        @Override
        public void paint(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.drawImage(map, 0, 0, null);
            g2.setColor(Color.RED);
//            g2.drawLine(a, b, c, d);
            if(paintcheck){
                for(int i = 0; i < random.getFinalLIst().toArray().length - 1; i++){
                    g2.drawLine(random.getFinalLIst().get(i).getX(), random.getFinalLIst().get(i).getY(),
                            random.getFinalLIst().get(i+1).getX(), random.getFinalLIst().get(i + 1).getY());
                    g2.setColor(Color.BLACK);

                    g2.drawString(String.valueOf(i+1),((random.getFinalLIst().get(i).getX())+random.getFinalLIst().get(i+1).getX())/2,
                            ((random.getFinalLIst().get(i).getY())+random.getFinalLIst().get(i+1).getY())/2 );
                    g2.setColor(Color.RED);
                }
                g2.setColor(Color.BLACK);
                g2.drawString(String.valueOf(random.getWayLenght()), 100, 10);
                g2.setColor(Color.RED);
            }
        }
    };

    public TravellingSalesManGUI() {
        ImageIcon mapa = new ImageIcon("PROJEKT/map/mapka.png");
        map = mapa.getImage();
        panel1.addMouseListener(new MouseAdapter() {
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
//                Runnable paintController = new Runnable() {
//                    @Override
//                    public void run() {
////                        for (int i = 0; i < random.getFinalLIst().toArray().length - 1; i++) {
////                            try {
////                                Thread.sleep(500);
////                                a = random.getFinalLIst().get(i).getX();
////                                b = random.getFinalLIst().get(i).getY();
////                                c = random.getFinalLIst().get(i + 1).getX();
////                                d = random.getFinalLIst().get(i + 1).getY();
//                                panel1.repaint();
////                            } catch (InterruptedException e) {
////                                e.printStackTrace();
////                            }
////                        }
//                    }
//                };
//                Thread paintThread = new Thread(paintController);
//                paintThread.start();

            }

        });
//        Losowo.setBounds(399,550,100,50);
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

