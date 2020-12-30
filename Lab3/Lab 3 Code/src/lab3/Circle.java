package lab3;

import java.awt.*;

class Circle extends Shape {
    double radius;

    Circle(int posX, int posY, double radius) {
        this.posX = posX;
        this.posY = posY;
        this.radius = radius;
    }

    double getArea() {
        return Math.PI * radius * radius;
    }

    void draw(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillOval(posX, posY, (int) radius * 2, (int) radius * 2);
    }
}
