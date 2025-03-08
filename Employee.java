class Employee {
    String name;
    String address;
    double salary;
    String jobTitle;

    Employee(String name,String address, double salary, String jobTitle) {
        this.name = name;
        this.address= address;
        this.salary = salary;
        this.jobTitle = jobTitle;
    }
    
    public void viewProfile() {
    System.out.println("Name: " + name + ", address: " + address + ", Salary: " + salary + ", Job Title: " + jobTitle + "\n");
    }

    public void reports() {
        System.out.println("Generated Perf. Reports!\n");
    }

    public void manageproject() {
        System.out.println("Managing Projects!\n");
    }

    public void calculatebonus() {
        System.out.println("Bonus if calculated!\n");
    }

    public static void main(String[] args) {
        Manager manager = new Manager("Amber", "New York", 100000);
        Developer developer = new Developer("Pranav", "India", 80000);
        Programmer programmer = new Programmer("Mandar", "California", 70000);
    
        System.out.println("Manager Info:");
        manager.viewProfile();
        manager.reports();
        manager.manageproject();
        manager.calculatebonus();
    
        System.out.println("Developer Info:");
        developer.viewProfile();
        developer.reports();
        developer.manageproject();
        developer.calculatebonus();
    
        System.out.println("Programmer Info:");
        programmer.viewProfile();
        programmer.reports();
        programmer.manageproject();
        programmer.calculatebonus();
    }
}
class Manager extends Employee {
    Manager(String name,String address, double salary) {
        super(name, address, salary, "Manager");
    }
}
class Developer extends Employee {
    Developer(String name,String address, double salary) {
        super(name, address, salary, "Developer");
    }
}
class Programmer extends Employee {
    Programmer(String name,String address, double salary) {
        super(name, address, salary, "Programmer");
    }
}