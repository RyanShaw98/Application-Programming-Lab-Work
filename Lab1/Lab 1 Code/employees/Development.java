package employees;

public class Development extends Employee {

    private String typeOfDev;

    Development(String typeOfDev, String name, String dob, int salary) {
        this.typeOfDev = typeOfDev;
        this.name = name;
        this.salary = salary;
        this.dob = dob;
    }

    public void information() {
        System.out.println("I am a developer. I am developing " + typeOfDev + ".");
    }

}
