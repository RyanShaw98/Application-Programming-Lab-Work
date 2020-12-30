package lab3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class DrawCalc extends JFrame {

    Square mySquare;
    Circle myCircle;
    JTextField inputField;

    private DrawCalc() {

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        mySquare = new Square(10, 10, 50);
        myCircle = new Circle(310, 10, 25);

        JPanel shapePanel = new JPanel() {
            public void paintComponent(Graphics g) {
                mySquare.draw(g);
                myCircle.draw(g);
            }
        };

        JPanel botPanel = new JPanel();

        inputField = new JTextField(10);

        JButton setSquareButton = new JButton("Square Length");
        JButton setCircleButton = new JButton("Circle Radius");
        JButton squareAreaButton = new JButton("Square Area");
        JButton circleAreaButton = new JButton("Circle Area");

        setSquareButton.addActionListener(new ButtonHandler(this, 1));
        squareAreaButton.addActionListener(new ButtonHandler(this, 2));
        circleAreaButton.addActionListener(new ButtonHandler(this, 3));
        setCircleButton.addActionListener(new ButtonHandler(this, 4));

        botPanel.add(inputField);
        botPanel.add(setSquareButton);
        botPanel.add(setCircleButton);
        botPanel.add(squareAreaButton);
        botPanel.add(circleAreaButton);

        add(shapePanel, BorderLayout.CENTER);
        add(botPanel, BorderLayout.SOUTH);

        setSize(600, 500);
    }

    public static void main(String[] args) {
        new DrawCalc().setTitle("Shapes and Areas");
    }
}

class ButtonHandler implements ActionListener {
    private DrawCalc theApp;
    private int action;

    ButtonHandler(DrawCalc app, int action) {
        this.theApp = app;
        this.action = action;
    }

    public void actionPerformed(ActionEvent e) {
        DecimalFormat formatter = new DecimalFormat("#.##");
        try {
            if (action == 1) {
                this.theApp.mySquare.sideLength = Integer.parseInt(theApp.inputField.getText());
                this.theApp.repaint();

            } else if (action == 2) {
                theApp.inputField.setText(formatter.format(theApp.mySquare.getArea()));
                theApp.repaint();

            } else if (action == 3) {
                theApp.inputField.setText(formatter.format(theApp.myCircle.getArea()));
                theApp.repaint();

            } else if (action == 4) {
                this.theApp.myCircle.radius = Integer.parseInt(theApp.inputField.getText());
                this.theApp.repaint();
            }
        } catch (NumberFormatException ex) {
            ex.getMessage();
        }
    }
}