import java.util.*;

// Employee Management System using ArrayList
class Employee {
    int id;
    String name;
    double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Salary: " + salary;
    }
}

public class EmployeeManagement {
    private static List<Employee> employees = new ArrayList<>();
    
    public static void addEmployee(int id, String name, double salary) {
        employees.add(new Employee(id, name, salary));
        System.out.println("Employee added successfully.");
    }
    
    public static void updateEmployee(int id, String name, double salary) {
        for (Employee emp : employees) {
            if (emp.id == id) {
                emp.name = name;
                emp.salary = salary;
                System.out.println("Employee updated successfully.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }
    
    public static void removeEmployee(int id) {
        employees.removeIf(emp -> emp.id == id);
        System.out.println("Employee removed successfully.");
    }
    
    public static void searchEmployee(int id) {
        for (Employee emp : employees) {
            if (emp.id == id) {
                System.out.println(emp);
                return;
            }
        }
        System.out.println("Employee not found.");
    }
    
    public static void displayEmployees() {
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Add Employee\n2. Update Employee\n3. Remove Employee\n4. Search Employee\n5. Display All\n6. Exit");
            int choice = scanner.nextInt();
            if (choice == 6) break;
            
            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Salary: ");
                    double salary = scanner.nextDouble();
                    addEmployee(id, name, salary);
                    break;
                case 2:
                    System.out.print("Enter ID to update: ");
                    int uid = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter New Name: ");
                    String uname = scanner.nextLine();
                    System.out.print("Enter New Salary: ");
                    double usalary = scanner.nextDouble();
                    updateEmployee(uid, uname, usalary);
                    break;
                case 3:
                    System.out.print("Enter ID to remove: ");
                    int rid = scanner.nextInt();
                    removeEmployee(rid);
                    break;
                case 4:
                    System.out.print("Enter ID to search: ");
                    int sid = scanner.nextInt();
                    searchEmployee(sid);
                    break;
                case 5:
                    displayEmployees();
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
        scanner.close();
    }
}
