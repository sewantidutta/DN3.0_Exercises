/*
Exercise 5: Task Management System
Scenario: 
You are developing a task management system where tasks need to be added, deleted, and traversed efficiently.
Steps:
1.	Understand Linked Lists:
o	Explain the different types of linked lists (Singly Linked List, Doubly Linked List).
2.	Setup:
o	Create a class Task with attributes like taskId, taskName, and status.
3.	Implementation:
o	Implement a singly linked list to manage tasks.
o	Implement methods to add, search, traverse, and delete tasks in the linked list.
4.	Analysis:
o	Analyze the time complexity of each operation.
o	Discuss the advantages of linked lists over arrays for dynamic data.
*/

import java.util.*;
class Task {
    int taskId;
    String taskName;
    String status;

    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }
    public String toString(){
        return "Task ID: " + taskId + " , Name: " + taskName + "  , Status: " + status;
    }
}

class Node {
    Task task;
    Node next;

    public Node(Task task) {
        this.task = task;
        this.next = null;
    }
}

// Step 3: Implementation
class TaskLinkedList {
    Node head;
    
    // Method to add a task to the linked list
    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // Method to search for a task by taskId
    public Task searchTask(int taskId) {
        
        Node temp = head;
        while (temp != null) {
            if (temp.task.taskId == taskId) {
                return temp.task;
            }
            temp = temp.next;
        }
        return null;
    }

    // Method to traverse the linked list and print tasks
    public void traverseTasks() {
        Node temp = head;
        while (temp != null) {
            System.out.println("Task Id: " + temp.task.taskId + ", Task Name: " + temp.task.taskName + ", Status: " + temp.task.status);
            temp = temp.next;
        }
    }

    // Method to delete a task by taskId
    public void deleteTask(int taskId) {
        if (head == null) {
            return;
        }
        if (head.task.taskId == taskId) {
            head = head.next;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            if (temp.next.task.taskId == taskId) {
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }
    }
}

// Step 4: Analysis
public class TaskManagement {
    public static void main(String[] args) {
        TaskLinkedList ts = new TaskLinkedList();

        int choice;
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("\n1. Enter new task:");
            System.out.println("2. Search task:");
            System.out.println("3. Delete task:");
            choice = sc.nextInt();
            int id;
            String name; 
            String status;
            switch (choice) {
                case 1:
                System.out.println("Enter task id:");
                id = sc.nextInt();
                System.out.println("Enter task name:");
                name = sc.next();
                System.out.println("Enter task status:");
                status = sc.next();
                ts.addTask(new Task(id,name,status));
                break;

                case 2:
                System.out.println("Enter task Id to search:");
                id = sc.nextInt();
                Task t = ts.searchTask(id);
                if(t!=null) System.out.println(t);
                else System.out.println("Task not found");
                break;

                case 3:
                System.out.println("Enter task Id to delete:");
                id = sc.nextInt();
                ts.deleteTask(id);
                System.out.println("Tasks remaining after deletion :");
                ts.traverseTasks();
                break;

                case 4:
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
 Understand Linked Lists:
 A linked list is a data structure in which a sequence of nodes are linked together through pointers. Each node in 
 the list contains a value and a reference (i.e., a "link") to the next node in the list. This structure allows 
 for efficient insertion and deletion of nodes at any position in the list.

 Types of Linked Lists:

 1. Singly Linked List:
 In a singly linked list, each node only has a reference to the next node in the list. Each node typically consists of two parts: the data 
 and the reference to the next nodeThis means that each node only points to the next node, but not to the previous node.

 2. Doubly Linked List:
 In a doubly linked list, each node has references to both the next node and the previous node in the list. Each node consists of three parts : the data, 
 the reference to the previous node and the reference to the next node. This allows for efficient traversal in both forward and backward directions.

3. Circularly Linked List:
In a circularly linked list, the last node points back to the first node, forming a circle. This allows 
for efficient traversal in a circular fashion.
*/


/* 
Q4)
Time complexity analysis:
addTask: O(n) where n is the number of tasks in the list
searchTask: O(n) where n is the number of tasks in the list
traverseTasks: O(n) where n is the number of tasks in the list
deleteTask: O(n) where n is the number of tasks in the list

Advantages of linked lists over arrays for dynamic data:
Linked list allow for efficient insertion and deletion of elements at any position, without requiring shifting of elements. 
This makes them ideal for applications where data is frequently added or removed. Secondly, linked lists can allocate 
memory dynamically, which is useful when the amount of data is unknown or variable. Additionally, linked lists are suitable
for sparse data, where most elements are empty or null, as they only allocate memory for used nodes. Overall, linked lists 
provide a flexible and efficient data structure for dynamic data, making them a popular choice in many applications.
*/