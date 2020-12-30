package shapes;

public abstract class Shape {

    String name = "shape";
    String color = "black";

    void printName() {
        System.out.println("I am a " + color + " " + name); // Display shape colour and name
    }

    public abstract void draw();
}
