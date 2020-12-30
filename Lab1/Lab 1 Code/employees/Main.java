package employees;

public class Main {

    public static void main(String[] args) {
        Employee[] employees = new Employee[3];
        employees[0] = new Manager(25, "Michael Scott", "16/08/1962", 120000);
        employees[1] = new Sales(10,"Debby Brown", "28/01/1973", 80000);
        employees[2] = new Development("iPhone apps", "Ryan Shaw", "04/06/1998", 50000);


        for (Employee employee:employees) {
            employee.printInfo();
            employee.information();
            System.out.println();
        }
    }
}
