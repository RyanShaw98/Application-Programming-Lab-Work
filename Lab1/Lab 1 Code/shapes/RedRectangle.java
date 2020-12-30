package shapes;

public class RedRectangle extends Rectangle {

    RedRectangle(int centerX, int centerY, int length, int width) { // RedRectangle constructor
        super(centerX, centerY, length, width); // Inherit values from Rectangle.java
        this.color = "red"; // Change colour to red
    }

    public void draw() {
        System.out.println("This is a " + name + " with center (" + centerX + "," + centerY + "). Its length is " + length + " and its width is " + width); // Display shape name, position and size
    }
}
