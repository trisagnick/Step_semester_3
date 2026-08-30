package session_4.class_problems;

class PayrollEmployee {

    private String empId;
    private double salary;

    public PayrollEmployee(String empId, double salary) {
        this.empId = empId;
        this.salary = salary;
    }

    public void raiseSalary(double salary) {
        this.salary = this.salary + salary;
    }

    public void printSalary() {
        System.out.println(
            this.empId + " | Final Salary: Rs " + this.salary
        );
    }
}

public class M2PayrollBatchBonus {

    public static void main(String[] args) {

        PayrollEmployee[] employees = {
            new PayrollEmployee("E-101", 40000),
            new PayrollEmployee("E-102", 55000),
            new PayrollEmployee("E-103", 62000),
            new PayrollEmployee("E-104", 48000)
        };

        double bonus = 5000;

        for (PayrollEmployee employee : employees) {
            employee.raiseSalary(bonus);
        }

        for (PayrollEmployee employee : employees) {
            employee.printSalary();
        }
    }
}