package graphInterfaceTest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Task4_4 {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame f = new JFrame();
                JPanel p = new JPanel();
                JButton b1 = new JButton("Выключить кнопку 2");
                JButton b2 = new JButton("Выключить кнопку 1");

//                Handler h1 = new Handler(b2);
//                Handler h2 = new Handler(b1);
//
//                b1.addActionListener(h1);
//                b2.addActionListener(h2);

                b1.addActionListener(new ActionListener() {
                    boolean flag = true;
                    public void actionPerformed(ActionEvent e) {
                        flag = !flag;
                        b1.setText(flag ? "Выключить кнопку 2" : "Включить кнопку 2");
                        b2.setEnabled(flag);
                    }
                });

                b2.addActionListener(new ActionListener() {
                    boolean flag = true;
                    public void actionPerformed(ActionEvent e) {
                        flag = !flag;
                        b2.setText(flag ? "Выключить кнопку 1" : "Включить кнопку 1");
                        b1.setEnabled(flag);
                    }
                });

                p.add(b1);
                p.add(b2);
                f.add(p);

                f.setSize(300, 200);
                f.setLocation(600, 200);
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setVisible(true);
            }
        });
    }
}
