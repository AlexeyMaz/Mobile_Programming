package shapeDraw;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class SimpleGraphicsEditor {
    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame("Простой (даже слишком) графический редактор");

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout());

        JPanel shapesPanel = new JPanel();
        shapesPanel.setLayout(new GridBagLayout());

        int width = 50;
        int height = 50;

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 5, 0);


        Image circle_image = ImageIO.read(new File("LR4\\DrawFigures\\images\\circle.png")).getScaledInstance(width, height, Image.SCALE_DEFAULT);
        JButton circle_button = new JButton() {
            // TODO : добавить вызов функции рисования
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(circle_image, CENTER, CENTER, null);
            }
        };
        circle_button.setPreferredSize(new Dimension(width, height));
        shapesPanel.add(circle_button, gbc);

        gbc.gridy++;
        Image square_image = ImageIO.read(new File("LR4\\DrawFigures\\images\\square.png")).getScaledInstance(width, height, Image.SCALE_DEFAULT);
        JButton square_button = new JButton() {
            // TODO : добавить вызов функции рисования
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(square_image, CENTER, CENTER, null);
            }
        };
        square_button.setPreferredSize(new Dimension(width, height));
        shapesPanel.add(square_button, gbc);

        gbc.gridy++;
        Image triangle_image = ImageIO.read(new File("LR4\\DrawFigures\\images\\triangle.png")).getScaledInstance(width, height, Image.SCALE_DEFAULT);
        JButton triangle_button = new JButton() {
            // TODO : добавить вызов функции рисования
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(triangle_image, CENTER, CENTER, null);
            }
        };
        triangle_button.setPreferredSize(new Dimension(width, height));
        shapesPanel.add(triangle_button, gbc);

        gbc.gridy++;
        Image line_image = ImageIO.read(new File("LR4\\DrawFigures\\images\\line.png")).getScaledInstance(width, height, Image.SCALE_DEFAULT);
        JButton line_button = new JButton() {
            // TODO : добавить вызов функции рисования
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(line_image, CENTER, CENTER, null);
            }
        };
        line_button.setPreferredSize(new Dimension(width, height));
        shapesPanel.add(line_button, gbc);
        buttonPanel.add(shapesPanel, BorderLayout.CENTER);


        JPanel drawPanel = new JPanel();
        drawPanel.setBackground(Color.BLACK);

        GridBagConstraints gbcMain = new GridBagConstraints();
        gbcMain.gridx = 0;
        gbcMain.gridy = 0;
        gbcMain.weightx = 0.01;
        gbcMain.fill = GridBagConstraints.BOTH;
        gbcMain.weighty = 1.0;
        mainPanel.add(buttonPanel, gbcMain);

        gbcMain.gridx = 1;
        gbcMain.weightx = 0.99;
        mainPanel.add(drawPanel, gbcMain);
        frame.add(mainPanel);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
}