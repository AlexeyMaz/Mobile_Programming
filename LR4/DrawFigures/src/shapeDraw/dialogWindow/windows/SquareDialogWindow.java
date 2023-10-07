package shapeDraw.dialogWindow.windows;

import shapeDraw.dialogWindow.ParentDialogWindow;

import javax.swing.*;

public class SquareDialogWindow extends ParentDialogWindow {
    public SquareDialogWindow(JFrame frame) {
        super(frame, "Введите длину стороны квадрата", "Длина стороны:  ");
    }
}