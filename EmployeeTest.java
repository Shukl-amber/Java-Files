import java.util.*;

class Employee_Ret {
    int employeeId;
    String name;
    int birthYear;
    int birthMonth;
    int birthDay;
    String phone;

    public void setEmployeeInfo(int employeeId, String name, int birthYear, int birthMonth, int birthDay, String phone) {
        this.employeeId = employeeId;
        this.name = name;
        this.birthYear = birthYear;
        this.birthMonth = birthMonth;
        this.birthDay = birthDay;
        this.phone = phone;
    }

    public void viewProfile() {
        System.out.println("Employee ID: " + employeeId + ", Name: " + name +
                           ", Date of Birth: " + birthYear + "-" + birthMonth + "-" + birthDay +
                           ", Phone: " + phone);
    }

    public static void sortEmployee(Employee_Ret[] employees) {
        Arrays.sort(employees, new Comparator<Employee_Ret>() {
            public int compare(Employee_Ret e1, Employee_Ret e2) {
                return e1.name.compareTo(e2.name);
            }
        });
    }

    public static void viewRetirementInfo(Employee_Ret[] employees) {
        System.out.println("Employees retiring after 2030:");
        for (Employee_Ret e : employees) {
            int retirementYear = e.birthYear + 58;
            if (retirementYear > 2030) {
                System.out.println(e.name + " will retire in " + retirementYear);
            }
        }
    }
}

public class EmployeeTest {
    public static void main(String[] args) {
        Employee_Ret[] employees = new Employee_Ret[4];
        employees[0] = new Employee_Ret();
        employees[0].setEmployeeInfo(101, "Alice", 1965, 5, 10, "1234567890");
        employees[1] = new Employee_Ret();
        employees[1].setEmployeeInfo(102, "Bob", 1975, 8, 20, "2345678901");
        employees[2] = new Employee_Ret();
        employees[2].setEmployeeInfo(103, "Charlie", 1980, 12, 15, "3456789012");
        employees[3] = new Employee_Ret();
        employees[3].setEmployeeInfo(104, "David", 1990, 3, 5, "4567890123");

        System.out.println("Before Sorting:");
        for (Employee_Ret e : employees) {
            e.viewProfile();
        }

        Employee_Ret.sortEmployee(employees);

        System.out.println("\nAfter Sorting by Name:");
        for (Employee_Ret e : employees) {
            e.viewProfile();
        }

        System.out.println();
        Employee_Ret.viewRetirementInfo(employees);
    }
}
