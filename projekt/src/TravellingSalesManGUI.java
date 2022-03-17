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

    private JButton Losowo = new JButton("Losowy");
    private JButton genetyczny = new JButton("Genetyczny");
    private JPanel mapPanel;
    private JLabel mapLabel;
    private Image map;
    private boolean paintcheck = false;
    private boolean geneticCheck = false;
    private int index = -1;
    private int a = 0;
    private int b = 0;
    private int c = 0;
    private int d = 0;
    private TravellingSalesManRandom random = new TravellingSalesManRandom("Waszyngton");
    private GeneticTravellingSalesman genetic = new GeneticTravellingSalesman();


    private JPanel panel1 = new JPanel() {
        @Override
        public void paint(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.drawImage(map, 0, 0, null);
            g2.setColor(Color.RED);
            if (paintcheck) {
                for (int i = 0; i < random.getFinalLIst().toArray().length - 1; i++) {
                    g2.drawLine(random.getFinalLIst().get(i).getX(), random.getFinalLIst().get(i).getY(),
                            random.getFinalLIst().get(i + 1).getX(), random.getFinalLIst().get(i + 1).getY());
                    g2.setColor(Color.BLACK);

                    g2.drawString(String.valueOf(i + 1), ((random.getFinalLIst().get(i).getX()) + random.getFinalLIst().get(i + 1).getX()) / 2,
                            ((random.getFinalLIst().get(i).getY()) + random.getFinalLIst().get(i + 1).getY()) / 2);
                    g2.setColor(Color.RED);
                }
                g2.setColor(Color.BLACK);
                g2.drawString(String.valueOf(random.getWayLenght()), 100, 10);
                g2.setColor(Color.RED);

            }


            if (geneticCheck) {
                g2.drawLine(a, b, c, d);
            }

//                    for (int j = 0; j < genetic.getList().get(index).toArray().length - 1; j++) {
//                            g2.drawLine(((City) genetic.getList().get(index).get(j)).getX(),
//                                    ((City) genetic.getList().get(index).get(j)).getY(),
//                                    ((City) genetic.getList().get(index).get(j + 1)).getX(),
//                                    ((City) genetic.getList().get(index).get(j + 1)).getY());
//
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
        genetyczny.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                genetic.firstPopulation();
                panel1.repaint();
                geneticCheck = true;
                Runnable paintController = new Runnable() {
                    @Override
                    public void run() {
                        for (int k = 0; k < 100; k++) {
                            index = k;
                            for (int i = 0; i < genetic.getList().get(index).toArray().length - 1; i++) {
                                try {
                                    Thread.sleep(100);
                                    if (genetic.getList().get(index).get(i) instanceof City) {
                                        a = ((City) genetic.getList().get(index).get(i)).getX();
                                        b = ((City) genetic.getList().get(index).get(i)).getY();
                                        c = ((City) genetic.getList().get(index).get(i + 1)).getX();
                                        d = ((City) genetic.getList().get(index).get(i + 1)).getY();
                                        panel1.repaint();
                                    }
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                };
                Thread paintThread = new Thread(paintController);
                paintThread.start();

//                for(int i = 0; i < 100; i++) {
//                    index = i;
//                    try{
//                        Thread.sleep(1);
//                        panel1.repaint();
//                    }catch (InterruptedException exc){}

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
//        Losowo.setBounds(399,550,100,50);
        panel1.add(Losowo);
        panel1.add(genetyczny);
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

