package graphInterfaceTest;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Handler implements ActionListener {
    boolean flag = true;
    JButton b;

    public Handler(JButton bb) {
        b = bb;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        flag = !flag;
        b.setText(flag ? "Hello" : "Goodbye");
    }
}
