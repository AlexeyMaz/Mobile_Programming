package shapeDraw.dialogWindow;

import javax.swing.*;
import java.awt.*;

public class ParentDialogWindow {
    private final JDialog figureDialog;
    private JButton okButton;
    private JButton cancelButton;
    private int value = -1;
    private JTextField valueTextField;

    public ParentDialogWindow(JFrame frame, String dialogTitle, String labelTitle) {
        figureDialog = buildDialogWindow(frame, dialogTitle, labelTitle);
        centerDialogOnScreen(figureDialog);
        figureDialog.setVisible(true);
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

    private JDialog buildDialogWindow(JFrame frame, String dialogTitle, String labelTitle) {
        JDialog dialog = new JDialog(frame, dialogTitle, true);
        dialog.setLayout(new BorderLayout());
        dialog.setSize(300, 150);
        dialog.setResizable(false);

        JPanel inputPanel = new JPanel(new GridBagLayout());

        JLabel valueLabel = new JLabel(labelTitle);
        valueTextField = new JTextField(10);

        GridBagConstraints gbc = new GridBagConstraints();
        inputPanel.add(valueLabel, gbc);
        inputPanel.add(valueTextField, gbc);

        JPanel buttonPanel = new JPanel();
        okButton = new JButton("Ок");
        cancelButton = new JButton("Отмена");
        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);

        dialog.add(inputPanel, BorderLayout.CENTER);
        dialog.add(buttonPanel, BorderLayout.SOUTH);

        okButtonListener();
        cancelButtonListener();

        // Обработчик для клавиши Enter
        dialog.getRootPane().setDefaultButton(okButton);

        return dialog;
    }

    private void okButtonListener() {
        okButton.addActionListener(e -> {
            setValue();
        });
    }

    private void cancelButtonListener() {
        cancelButton.addActionListener(e -> {
            value = -1;
            figureDialog.dispose();
        });
    }

    public int getValue() {
        return value;
    }
    public void setValue() {
        try {
            int enteredValue = Integer.parseInt(valueTextField.getText());
            if (enteredValue > 0) {
                value = enteredValue;
                figureDialog.dispose();
            } else {
                JOptionPane.showMessageDialog(figureDialog, "Введите положительное значение",
                        "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(figureDialog, "Введите корректное значение",
                    "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }
}