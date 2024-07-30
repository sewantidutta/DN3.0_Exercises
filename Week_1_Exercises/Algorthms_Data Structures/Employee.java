/*
Exercise 4: Employee Management System
Scenario: 
You are developing an employee management system for a company. Efficiently managing employee records is crucial.
Steps:
1.	Understand Array Representation:
o	Explain how arrays are represented in memory and their advantages.
2.	Setup:
o	Create a class Employee with attributes like employeeId, name, position, and salary.
3.	Implementation:
o	Use an array to store employee records.
o	Implement methods to add, search, traverse, and delete employees in the array.
4.	Analysis:
o	Analyze the time complexity of each operation (add, search, traverse, delete).
o	Discuss the limitations of arrays and when to use them.
 */

import java.util.Scanner;

class Emp {
    private int employeeId;
    private String name;
    private String position;
    private double salary;

    public Emp(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    // Getters 
    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

    public String toString(){
        return "Employee [ID=" + employeeId+ ", Name=" + name + ", Position=" + position + ", Salary=" + salary + "]";
    }
}

public class Employee {
    private Emp[] employees;
    private int nextIndex;

    public Employee(int size) {
        employees = new Emp[size];
        nextIndex = 0;
    }

    public void addEmployee(Emp employee) {
        if (nextIndex < employees.length) {
            employees[nextIndex] = employee;
            nextIndex++;
        } else {
            System.out.println("The array is full. Cannot add more employees.");
        }
    }

    public Emp searchEmployee(int employeeId) {
        for (int i = 0; i < nextIndex; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                return employees[i];
            }
        }

        return null;
    }

    public void traverseEmployees() {
        for (int i=0;i<nextIndex;i++) {
            System.out.println(employees[i]);
        }
    }

    public boolean deleteEmployee(int employeeId) {
        for (int i = 0; i < nextIndex; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                for (int j = i; j < nextIndex - 1; j++) {
                    employees[j] = employees[j + 1];
                }

                nextIndex--;
                return true;
            }
        }

        return false;
    }

     public static void main(String[] args) {
        System.out.println("Enter number of employees:");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
       Employee em = new Employee(size);
        for(int i=0;i<size;i++){
            int id;
            String name, pos;
            double salary;
            System.out.println("employee Id:");
            id = sc.nextInt();
            System.out.println("employee name:");
            name = sc.next();
            System.out.println("employee position:");
            pos = sc.next();
            System.out.println("employee salary:");
            salary = sc.nextDouble();
            em.addEmployee(new Emp(id,name,pos,salary));
        }
        System.out.println("\nAll Employees:");
        em.traverseEmployees();

while(true) {
    System.out.println("\nChoose an operation:");
    System.out.println("1. Search for an employee");
    System.out.println("2. Delete an employee");
    System.out.println("3. Exit");
    int choice = sc.nextInt();

    switch (choice) {
        case 1:
            System.out.println("Enter ID of employee to search:");
            int id = sc.nextInt();
            Emp e = em.searchEmployee(id);
            if (e != null) {
                System.out.println(e);
            } else {
                System.out.println("Employee not found.");
            }
            break;
        case 2:
            System.out.println("Enter ID of employee to delete:");
            id = sc.nextInt();
            em.deleteEmployee(id);
            System.out.println("\nAll Employees after deletion:");
            em.traverseEmployees();
            break;
        case 3:
            System.out.println("Exiting...");
            sc.close();
            return;
        default:
            System.out.println("Invalid choice. Please choose a valid option.");
    }
}
}
}

/*
 Q1)

 Understanding array representation :
 Arrays are represented in memory as a contiguous block of memory locations, each of 
 which holds a single element of the array. The elements are stored in a linear sequence, 
 with the first element at the lowest memory address and the last element at
 the highest memory address.

 Advantages:
 Arrays provide efficient memory usage, as the memory is allocated only once when the array is created.
 Arrays also offer fast access time, as elements can be accessed directly using their index. Additionally,
 arrays are cache-friendly, which improves performance by reducing the number of cache misses. Arrays 
 are also simple to implement and understand, making them a good choice for simple applications. Furthermore,
 arrays are good for sequential access, as elements are stored in a linear sequence, making it efficient
 to iterate over the array.
 */


/*
Q4)

Analysis:

 Add Operation: The add operation checks if the array is full, and if not, adds the new employee 
 at the next available index. Time Complexity : O(1)
 Search Operation: The search operation iterates through the array to find the employee with 
 the specified ID. Time Complexity : O(n)
 Traverse Operation: The traverse operation iterates through the entire array to print all employees.
 Time Complexity : O(n)

 Discussion:

 When to use array:
 when working with small, fixed-size data sets where the size is known in advance. Arrays provide 
 good cache efficiency, making them a good choice for performance-critical code. They are also simple 
 to implement and understand, making them a good choice for simple applications. Additionally, arrays 
 are useful when working with primitive data types, such as integers or characters, where the 
 overhead of objects is not necessary.

 Limitations of Arrays:
 They have fixed size that cannot be changed once they are created, which can lead to wasted space or errors.
 They do not support dynamic resizing, which can be a problem when dealing with large datasets.
 Arrays require contiguous memory allocation, which can be a problem for large arrays
 Arrays do not provide built-in support for common operations like sorting, searching, or inserting elements,
 making them less convenient to use.
  */