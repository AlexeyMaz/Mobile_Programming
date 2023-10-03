package graphInterfaceTest;

import javax.swing.*;
import java.awt.event.*;

public class Task4_3 {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        JPanel p = new JPanel();
        JButton b = new JButton("10");

        b.addActionListener(new ActionListener() {
            int num = 9;
            public void actionPerformed(ActionEvent e) {
                if (num != 0)
                    ((JButton) e.getSource()).setText(Integer.toString(num--));
                else System.exit(0);
            }
        });

        p.add(b);
        f.add(p);

        f.setSize(300, 200);
        f.setLocation(600, 200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
