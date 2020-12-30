package employees;

public abstract class Employee {

    String name;
    int salary;
    String dob;

    public abstract void information();

    void printInfo() {
        System.out.println("Name: " + name + " | Salary: " + salary + " | Date of birth: " + dob);
    }
}
