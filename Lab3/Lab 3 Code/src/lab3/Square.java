package lab3;

import java.awt.*;

class Square extends Shape {
    Integer sideLength;

    Square(int posX, int posY, int sideLength) {
        this.posX = posX;
        this.posY = posY;
        this.sideLength = sideLength;
    }

    int getArea() {
        return sideLength * sideLength;
    }

    void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(posX, posY, sideLength, sideLength);
    }
}
