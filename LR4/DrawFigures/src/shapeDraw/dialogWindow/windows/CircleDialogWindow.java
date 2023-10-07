package shapeDraw.dialogWindow.windows;

import shapeDraw.dialogWindow.ParentDialogWindow;

import javax.swing.*;

public class CircleDialogWindow extends ParentDialogWindow {
    public CircleDialogWindow(JFrame frame) {
        super(frame, "Введите радиус круга", "Радиус:  ");
    }
}