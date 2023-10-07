package shapeDraw;

import javax.swing.*;
import java.awt.*;

public class CircleDialogWindow {
    private int radius = -1;
    private final JDialog circleDialog;
    private JButton okButton;
    private JButton cancelButton;
    private JTextField radiusField;

    public CircleDialogWindow(JFrame frame) {
        circleDialog = buildDialogWindow(frame);
        centerDialogOnScreen(circleDialog);
        circleDialog.setVisible(true);
    }

    public int getRadius() {
        return radius;
    }

    private void centerDialogOnScreen(Dialog dialog) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (int) screenSize.getWidth() / 2;
        int centerY = (int) screenSize.getHeight() / 2;
        int dialogWidth = dialog.getWidth();
        int dialogHeight = dialog.getHeight();
        int x = centerX - dialogWidth / 2;
        int y = centerY - dialogHeight / 2;
        dialog.setLocation(x, y);
    }

    private JDialog buildDialogWindow(JFrame frame) {
        JDialog dialog = new JDialog(frame, "Введите радиус", true);
        dialog.setLayout(new GridLayout(2, 2));
        dialog.setSize(300, 150);
        dialog.setResizable(false);

        JLabel radiusLabel = new JLabel("Радиус:");
        radiusField = new JTextField();
        okButton = new JButton("Ок");
        cancelButton = new JButton("Отмена");

        dialog.add(radiusLabel);
        dialog.add(radiusField);

        dialog.add(okButton);
        dialog.add(cancelButton);

        okButtonListener();
        cancelButtonListener();

        // обработчик для клавиши Enter
        dialog.getRootPane().setDefaultButton(okButton);

        return dialog;
    }

    private void okButtonListener() {
        okButton.addActionListener(e -> {
            try {
                int enteredRadius = Integer.parseInt(radiusField.getText());
                if (enteredRadius > 0) {
                    radius = enteredRadius;
                    circleDialog.dispose();
                } else {
                    JOptionPane.showMessageDialog(circleDialog, "Введите положительное значение радиуса",
                            "Ошибка", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(circleDialog, "Введите корректное значение радиуса",
                        "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    private void cancelButtonListener() {
        cancelButton.addActionListener(e -> {
            radius = -1;
            circleDialog.dispose();
        });
    }
}
