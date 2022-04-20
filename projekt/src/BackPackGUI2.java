import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class BackPackGUI2 {
    private JPanel panel4;
    private JButton greedy;
    private JButton dynamic;

    public BackPackGUI2() {

        greedy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new BackPackGUI();
            }
        });

        dynamic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DynamicBackpack();
            }
        });

    }


    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame("chuj");
        frame.setContentPane(new BackPackGUI2().panel4);
        frame.setVisible(true);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
    }

    public JPanel getPanel4() {
        return panel4;
    }
}
