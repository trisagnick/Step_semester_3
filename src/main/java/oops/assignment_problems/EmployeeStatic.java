package oops.assignment_problems;

class EmployeeStatic {

    String empName;
    double salary;

    static String companyName =
        "Bright Horizon Technologies";

    static int employeeCount = 0;

    EmployeeStatic(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;

        employeeCount++;
    }

    static void printCompanyInfo() {

        System.out.println(companyName);
        System.out.println(
            "Employees on record: " + employeeCount
        );
    }

    public static void main(String[] args) {

        EmployeeStatic e1 =
            new EmployeeStatic("Divya", 65000);

        EmployeeStatic e2 =
            new EmployeeStatic("Arjun", 40000);

        EmployeeStatic e3 =
            new EmployeeStatic("Meera", 55000);

        System.out.println("3 Employee objects created");

        EmployeeStatic.printCompanyInfo();
    }
}