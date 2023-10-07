package shapeDraw;

import shape.shapes.*;
import shapeDraw.dialogWindow.windows.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javax.imageio.ImageIO;
import javax.swing.border.LineBorder;

public class SimpleGraphicsEditor {
    private static JFrame frame;
    private static final Map<String, Boolean> isButtonsPressedMap = new HashMap<>();
    private static final ArrayList<Integer> coords = new ArrayList<>();
    private static int clickCount = 0;
    private static final int width = 50;
    private static final int height = 50;
    private static Color selectedColor = Color.BLACK;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame = new JFrame("Графический редактор");

                JPanel mainPanel = new JPanel();
                mainPanel.setLayout(new GridBagLayout());

                JPanel buttonPanel = new JPanel();
                buttonPanel.setLayout(new BorderLayout());

                JPanel shapesPanel = new JPanel();
                shapesPanel.setLayout(new GridBagLayout());

                GridBagConstraints gbc = new GridBagConstraints();
                gbc.gridx = 0;
                gbc.gridy = 0;
                gbc.insets = new Insets(0, 0, 5, 0);


                isButtonsPressedMap.put("isCircleButtonPressed", false);
                isButtonsPressedMap.put("isSquareButtonPressed", false);
                isButtonsPressedMap.put("isTriangleButtonPressed", false);
                isButtonsPressedMap.put("isLineButtonPressed", false);


                Image circle_image;
                try {
                    circle_image = ImageIO.read(new File("LR4\\DrawFigures\\images\\circle.png")).
                            getScaledInstance(width, height, Image.SCALE_DEFAULT);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                JButton circle_button = getjButton(circle_image);
                shapesPanel.add(circle_button, gbc);
                circle_button.setPreferredSize(new Dimension(width, height));


                gbc.gridy++;
                Image square_image;
                try {
                    square_image = ImageIO.read(new File("LR4\\DrawFigures\\images\\square.png")).
                            getScaledInstance(width, height, Image.SCALE_DEFAULT);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                JButton square_button = getjButton(square_image);
                square_button.setPreferredSize(new Dimension(width, height));
                shapesPanel.add(square_button, gbc);

                gbc.gridy++;
                Image triangle_image;
                try {
                    triangle_image = ImageIO.read(new File("LR4\\DrawFigures\\images\\triangle.png")).
                            getScaledInstance(width, height, Image.SCALE_DEFAULT);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                JButton triangle_button = getjButton(triangle_image);
                triangle_button.setPreferredSize(new Dimension(width, height));
                shapesPanel.add(triangle_button, gbc);

                gbc.gridy++;
                Image line_image;
                try {
                    line_image = ImageIO.read(new File("LR4\\DrawFigures\\images\\line.png")).
                            getScaledInstance(width, height, Image.SCALE_DEFAULT);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                JButton line_button = getjButton(line_image);
                line_button.setPreferredSize(new Dimension(width, height));
                shapesPanel.add(line_button, gbc);


                gbc.gridy++;
                Image color_image;
                try {
                    color_image = ImageIO.read(new File("LR4\\DrawFigures\\images\\color.png")).
                            getScaledInstance(width, height, Image.SCALE_DEFAULT);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                JButton chooseColorButton = new JButton() {
                    @Override
                    protected void paintComponent(Graphics g) {
                        super.paintComponent(g);
                        g.drawImage(color_image, CENTER, CENTER, null);
                    }
                };
                chooseColorButton.setPreferredSize(new Dimension(width, height));
                shapesPanel.add(chooseColorButton, gbc);
                buttonPanel.add(shapesPanel, BorderLayout.CENTER);

                chooseColorButton.addActionListener(e -> {
                    Color newColor = JColorChooser.showDialog(frame, "Выберите цвет", selectedColor);
                    if (newColor != null) {
                        selectedColor = newColor;
                        System.out.println(selectedColor);
                    }
                });


                // TODO : попытаться вынести экшн листенеры в функцию
                circle_button.addActionListener(e -> {
                    resetCoordsCount();
                    for (String button : isButtonsPressedMap.keySet()) {
                        boolean value = isButtonsPressedMap.get(button);
                        if (!Objects.equals(button, "isCircleButtonPressed"))
                            isButtonsPressedMap.put(button, false);
                        else {
                            isButtonsPressedMap.put(button, !value);
                            if (!value) {
                                circle_button.setBorder(new LineBorder(Color.BLUE, 3));
                                square_button.setBorder(new LineBorder(Color.GRAY, 1));
                                triangle_button.setBorder(new LineBorder(Color.GRAY, 1));
                                line_button.setBorder(new LineBorder(Color.GRAY, 1));
                            } else
                                circle_button.setBorder(new LineBorder(Color.GRAY, 1));
                        }
                    }
                });

                square_button.addActionListener(e -> {
                    resetCoordsCount();
                    for (String button : isButtonsPressedMap.keySet()) {
                        boolean value = isButtonsPressedMap.get(button);
                        if (!Objects.equals(button, "isSquareButtonPressed"))
                            isButtonsPressedMap.put(button, false);
                        else {
                            isButtonsPressedMap.put(button, !value);
                            if (!value) {
                                circle_button.setBorder(new LineBorder(Color.GRAY, 1));
                                square_button.setBorder(new LineBorder(Color.BLUE, 3));
                                triangle_button.setBorder(new LineBorder(Color.GRAY, 1));
                                line_button.setBorder(new LineBorder(Color.GRAY, 1));
                            } else
                                square_button.setBorder(new LineBorder(Color.GRAY, 1));
                        }
                    }
                });

                triangle_button.addActionListener(e -> {
                    if (isButtonsPressedMap.get("isLineButtonPressed")) resetCoordsCount();
                    for (String button : isButtonsPressedMap.keySet()) {
                        boolean value = isButtonsPressedMap.get(button);
                        if (!Objects.equals(button, "isTriangleButtonPressed"))
                            isButtonsPressedMap.put(button, false);
                        else {
                            isButtonsPressedMap.put(button, !value);
                            if (!value) {
                                circle_button.setBorder(new LineBorder(Color.GRAY, 1));
                                square_button.setBorder(new LineBorder(Color.GRAY, 1));
                                triangle_button.setBorder(new LineBorder(Color.BLUE, 3));
                                line_button.setBorder(new LineBorder(Color.GRAY, 1));
                            } else
                                triangle_button.setBorder(new LineBorder(Color.GRAY, 1));
                        }
                    }
                });

                line_button.addActionListener(e -> {
                    if (isButtonsPressedMap.get("isTriangleButtonPressed")) resetCoordsCount();
                    for (String button : isButtonsPressedMap.keySet()) {
                        boolean value = isButtonsPressedMap.get(button);
                        if (!Objects.equals(button, "isLineButtonPressed"))
                            isButtonsPressedMap.put(button, false);
                        else {
                            isButtonsPressedMap.put(button, !value);
                            if (!value) {
                                circle_button.setBorder(new LineBorder(Color.GRAY, 1));
                                square_button.setBorder(new LineBorder(Color.GRAY, 1));
                                triangle_button.setBorder(new LineBorder(Color.GRAY, 1));
                                line_button.setBorder(new LineBorder(Color.BLUE, 3));
                            } else
                                line_button.setBorder(new LineBorder(Color.GRAY, 1));
                        }
                    }
                });


                JPanel drawPanel = new JPanel();
                drawPanel.setBackground(Color.WHITE);

                JButton clearButton = new JButton("Очистить");
                clearButton.addActionListener(e -> {
                    Graphics g = drawPanel.getGraphics();
                    g.setColor(Color.WHITE);
                    g.fillRect(0, 0, drawPanel.getWidth(), drawPanel.getHeight());

                    isButtonsPressedMap.replaceAll((b, v) -> false);
                    circle_button.setBorder(new LineBorder(Color.GRAY, 1));
                    square_button.setBorder(new LineBorder(Color.GRAY, 1));
                    triangle_button.setBorder(new LineBorder(Color.GRAY, 1));
                    line_button.setBorder(new LineBorder(Color.GRAY, 1));
                });
                buttonPanel.add(clearButton, BorderLayout.SOUTH);

                drawPanel.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        drawFigure(drawPanel, e);
                    }
                });

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
                frame.setResizable(false);
            }
        });
    }


    private static JButton getjButton(Image figure_image) {
        return new JButton() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(figure_image, CENTER, CENTER, null);
            }
        };
    }

    private static void resetCoordsCount() {
        coords.clear();
        clickCount = 0;
    }

    private static int circleInfoFromWindow() {
        CircleDialogWindow circleDialogWindow = new CircleDialogWindow(frame);
        return circleDialogWindow.getValue();
    }

    private static int squareInfoFromWindow() {
        SquareDialogWindow squareDialogWindow = new SquareDialogWindow(frame);
        return squareDialogWindow.getValue();
    }

    private static void drawFigure(JPanel drawPanel, MouseEvent e) {
        for (Map.Entry<String, Boolean> entry : isButtonsPressedMap.entrySet()) {
            String buttonName = entry.getKey();
            boolean isPressed = entry.getValue();

            switch (buttonName) {
                case "isCircleButtonPressed" -> {
                    if (isPressed) {
                        int mouseX = e.getX();
                        int mouseY = e.getY();

                        int circleRadius = circleInfoFromWindow();
                        Circle figure = new Circle(mouseX, mouseY, circleRadius, selectedColor);
                        Graphics g = drawPanel.getGraphics();
                        figure.draw(g);
                    }
                }
                case "isSquareButtonPressed" -> {
                    if (isPressed) {
                        int mouseX = e.getX();
                        int mouseY = e.getY();

                        int squareSideLength = squareInfoFromWindow();
                        Square figure = new Square(mouseX, mouseY, squareSideLength, selectedColor);
                        Graphics g = drawPanel.getGraphics();
                        figure.draw(g);
                    }
                }
                case "isTriangleButtonPressed" -> {
                    if (isPressed && clickCount != 3) {
                        coords.add(e.getX());
                        coords.add(e.getY());
                        clickCount++;
                    }
                    if (clickCount == 3) {
                        Triangle figure = new Triangle(coords.get(0), coords.get(1), coords.get(2), coords.get(3),
                                coords.get(4), coords.get(5), selectedColor);
                        Graphics g = drawPanel.getGraphics();
                        figure.draw(g);

                        resetCoordsCount();
                    }
                }
                case "isLineButtonPressed" -> {
                    if (isPressed) {
                        if (clickCount != 2) {
                            coords.add(e.getX());
                            coords.add(e.getY());
                            clickCount++;
                        }
                        if (clickCount == 2) {
                            Line figure = new Line(coords.get(0), coords.get(1), coords.get(2),
                                    coords.get(3), selectedColor);
                            Graphics g = drawPanel.getGraphics();
                            figure.draw(g);

                            resetCoordsCount();
                        }
                    }
                }
            }
        }
    }
}