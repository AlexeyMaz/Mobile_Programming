package graphInterfaceTest;

import javax.swing.*;


public class Task4_1_2 {
    public static void main(String[] args) {
        JFrame f = new JFrame("Window");
        f.setSize(500, 500);
        f.setLocation(500, 200);

        JLabel lab = new JLabel("Я метка 1");

        JPanel p = new JPanel();
        JButton b1 = new JButton("Я кнопка 1");
        JButton b2 = new JButton("Я кнопка 2");
        JButton b3 = new JButton("Я кнопка 3");
        JButton b4 = new JButton("Я кнопка 4");


        p.add(lab);
        p.add(b1);
        p.add(b2);
        p.add(b3);
        p.add(b4);
        f.add(p);

//        f.setMinimumSize(new Dimension(300, 200));
//        f.pack();

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}