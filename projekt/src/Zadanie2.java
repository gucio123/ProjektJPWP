import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class Zadanie2 extends JFrame {
    private List<City> lista = new ArrayList<>();
    private JButton button =  new JButton("przycisk");
    TravellingSalesManRandom random = new TravellingSalesManRandom("1");
    private int counter;
    private Image map;
    public JPanel panel2 = new JPanel(){
        @Override
        public void paint(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            g2.drawImage(map, 0, 0, null);
            for(int i = 0; i < lista.toArray().length; i++){
                g2.setColor(Color.white);
                g2.drawString(String.valueOf(i), lista.get(i).getX(), lista.get(i).getY());
            }
            for (int i = 0; i < random.getFinalLIst().toArray().length - 1; i++) {
                g2.setColor(Color.WHITE);
                g2.drawLine(random.getFinalLIst().get(i).getX(), random.getFinalLIst().get(i).getY(),
                        random.getFinalLIst().get(i + 1).getX(), random.getFinalLIst().get(i + 1).getY());
                g2.setColor(Color.yellow);

                g2.drawString(String.valueOf(i + 1), ((random.getFinalLIst().get(i).getX()) + random.getFinalLIst().get(i + 1).getX()) / 2,
                        ((random.getFinalLIst().get(i).getY()) + random.getFinalLIst().get(i + 1).getY()) / 2);
                g2.setColor(Color.WHITE);
            }
            g2.setColor(Color.WHITE);
            g2.drawString(String.valueOf(random.getWayLenght()), 100, 10);
        }
    };

    public Zadanie2() {
        counter = 0;
        ImageIcon mapa = new ImageIcon("PROJEKT/map/black.jpg");
        map = mapa.getImage();
        panel2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println(e.getX() + " " + e.getY());
                counter ++;
                lista.add(new City(String.valueOf(counter), e.getX(), e.getY(), counter));
                panel2.repaint();
            }
        });
        panel2.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                random.setList(new ArrayList<>(lista));
                random.way();
                panel2.repaint();
            }
        });
    }

    public static void main(String[] args) {
        Zadanie2 frame = new Zadanie2();
        frame.setContentPane(frame.panel2);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(798, 570);
    }
}
