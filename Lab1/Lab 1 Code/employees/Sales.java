package employees;

public class Sales extends Employee {

    private int salesMade;

    Sales(int salesMade, String name, String dob, int salary) {
        this.salesMade = salesMade;
        this.name = name;
        this.salary = salary;
        this.dob = dob;
    }

    public void information() {
        System.out.println("I am a sales person. I have made " + salesMade + " sales.");
    }
}
