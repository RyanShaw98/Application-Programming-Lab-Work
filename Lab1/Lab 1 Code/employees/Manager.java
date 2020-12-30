package employees;

public class Manager extends Employee {

    private int employeeCount;

    Manager(int employeeCount, String name, String dob, int salary) {
        this.name = name;
        this.dob = dob;
        this.salary = salary;
        this.employeeCount = employeeCount;
    }

    public void information() {
        System.out.println("I am a manager. I manage " + employeeCount + " employees.");
    }
}
