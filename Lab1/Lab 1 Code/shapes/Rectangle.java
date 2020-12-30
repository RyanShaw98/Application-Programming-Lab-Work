package shapes;

public class Rectangle extends Shape {
    // Declare variables
    int centerX;
    int centerY;
    int length;
    int width;

    Rectangle(int centerX, int centerY, int length, int width) { // Rectangle constructor
        this.name = "rectangle";
        this.centerX = centerX;
        this.centerY = centerY;
        this.length = length;
        this.width = width;
    }

    public void draw() {
        System.out.println("This is a " + name + " with center (" + centerX + "," + centerY + "). Its length is " + length + " and its width is " + width); // Display shape name, position and size
    }
}
