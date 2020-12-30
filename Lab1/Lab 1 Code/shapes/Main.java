package shapes;

public class Main {

    public static void main(String[] args) {
        Shape[] shapes = new Shape[4]; // An array called "shapes" of type "Shape" with a size of 3
        // Defines what 3 shapes will be put in the array and what values they will have
        shapes[0] = new Circle(300, 100, 200);
        shapes[1] = new Rectangle(100, 100, 40, 60);
        shapes[2] = new Rectangle(200, 200, 20, 30);
        shapes[3] = new RedRectangle(200, 200, 20, 30);


        for (Shape shape : shapes) { // Iterate through the "shapes" array
            shape.printName(); // Displays shape name and colour
            shape.draw(); // Displays shape name, location and size/radius
            System.out.println();
        }
    }
}
