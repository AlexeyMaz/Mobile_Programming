package shapeDraw.dialogWindows;

import javax.swing.*;
import java.awt.*;

public class SquareDialogWindow {
    private int sideLength = -1;
    private final JDialog squareDialog;
    private JButton okButton;
    private JButton cancelButton;
    private JTextField sideLengthField;

    public SquareDialogWindow(JFrame frame) {
        squareDialog = buildDialogWindow(frame);
        centerDialogOnScreen(squareDialog);
        squareDialog.setVisible(true);
    }

    public int getSideLength() {
        return sideLength;
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
        JDialog dialog = new JDialog(frame, "Введите длину стороны квадрата", true);
        dialog.setLayout(new GridLayout(2, 2));
        dialog.setSize(300, 150);
        dialog.setResizable(false);

        JLabel sideLengthLabel = new JLabel("Длина:");
        sideLengthField = new JTextField();
        okButton = new JButton("Ок");
        cancelButton = new JButton("Отмена");

        dialog.add(sideLengthLabel);
        dialog.add(sideLengthField);

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
                int enteredSideLength = Integer.parseInt(sideLengthField.getText());
                if (enteredSideLength > 0) {
                    sideLength = enteredSideLength;
                    squareDialog.dispose();
                } else {
                    JOptionPane.showMessageDialog(squareDialog, "Введите положительное значение длины",
                            "Ошибка", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(squareDialog, "Введите корректное значение длины",
                        "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    private void cancelButtonListener() {
        cancelButton.addActionListener(e -> {
            sideLength = -1;
            squareDialog.dispose();
        });
    }
}
