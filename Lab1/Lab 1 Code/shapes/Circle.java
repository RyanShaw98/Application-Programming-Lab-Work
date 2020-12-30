package shapes;

public class Circle extends Shape {
    // Declare variables
    private int centerX;
    private int centerY;
    private int radius;

    Circle(int centerX, int centerY, int radius) { // Circle constructor
        this.name = "circle";
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
    }

    public void draw() {
        System.out.println("This is a " + name + " with center(" + centerX + "," + centerY + ")and radius " + radius); // Display shape name, position and size (radius)
    }
}
