/*
Exercise 3: Sorting Customer Orders
Scenario: 
You are tasked with sorting customer orders by their total price on an e-commerce platform. This helps in prioritizing high-value orders.
Steps:
1.	Understand Sorting Algorithms:
o	Explain different sorting algorithms (Bubble Sort, Insertion Sort, Quick Sort, Merge Sort).
2.	Setup:
o	Create a class Order with attributes like orderId, customerName, and totalPrice.
3.	Implementation:
o	Implement Bubble Sort to sort orders by totalPrice.
o	Implement Quick Sort to sort orders by totalPrice.
4.	Analysis:
o	Compare the performance (time complexity) of Bubble Sort and Quick Sort.
o	Discuss why Quick Sort is generally preferred over Bubble Sort.
*/

import java.util.*;

class Order {
    private int orderId;
    private String customerName;
    private double totalPrice;

    public Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String toString(){
        return "Product{ " +" productId= " + orderId +" , CustoemrName= " + customerName +" , price= " + totalPrice +" }";
    }
}

class BubbleSort {
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {
                    // swap orders[j] and orders[j + 1]
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }
}

class QuickSort {
    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }
    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].getTotalPrice();
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (orders[j].getTotalPrice() < pivot) {
                i++;
                // swap orders[i] and orders[j]
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }

        // swap orders[i + 1] and orders[high]
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;

        return i + 1;
    }
}

public class SortOrders {
    public static void main (String a[]){
        Order[] orders = {
                new Order(5, "Diya", 600.00),
                new Order(1, "Ankush", 900.50),
                new Order(7, "Dolly", 720.00),
                new Order(3, "Rahul", 850.75),
                
        };

        System.out.println("Original Orders:");
        for(Order o : orders){
            System.out.println(o);
        }

       
        BubbleSort.bubbleSort(orders);
        System.out.println("\nSorted Orders (Bubble Sort):");
        System.out.println(orders);

        
        QuickSort.quickSort(orders, 0, orders.length - 1);
        System.out.println("\nSorted Orders (Quick Sort):");
        System.out.println(orders);
    }
}

/*
Q1)
 Understand Sorting Algorithms:
 A sorting algorithm is a set of instructions that takes a list of elements as input and rearranges 
 them in a specific order, such as alphabetical or numerical order. The goal of a sorting algorithm 
 is to transform an unsorted list into a sorted list, where each element is in its correct position 
 relative to the others.

 Explain different sorting algorithms (Bubble Sort, Insertion Sort, Quick Sort, Merge Sort).

 Bubble sort : It is a simple sorting algorithm that repeatedly steps through the list, 
 compares adjacent elements, and swaps them if they are in the wrong order. The pass through 
 the list is repeated until the list is sorted. Steps:
 1)Start at the beginning of the list
 2)Compare the first two elements and swap them if they are in the wrong order
 3)Move to the next pair of elements and repeat the comparison and swap
 4)Continue this process until the end of the list is reached
 5)Repeat the entire process until no more swaps are needed, indicating that the list is sorted
 Time complexity: O(n^2)
 Space complexity: O(1)

 Insertion Sort: It is a simple sorting algorithm that builds the final sorted array (or list) 
 one item at a time. It is much less efficient on large lists than more advanced algorithms like 
 quicksort, heapsort, or merge sort. Steps:
 1)Start at the beginning of the list
 2)Take the first element and consider it sorted
 3)Take the next element and insert it into the sorted portion of the list
 4)Continue this process until the end of the list is reached
 Time complexity: O(n^2)
 Space complexity: O(1)

 Quick sort: It is a divide-and-conquer algorithm that works by selecting a 'pivot' element 
 from the array and partitioning the other elements into two sub-arrays, according to whether 
 they are less than or greater than the pivot. The sub-arrays are then recursively sorted. Steps:
 1)Select a pivot element from the array
 2)Partition the array into two sub-arrays: elements less than the pivot and elements greater than the pivot
 3)Recursively apply the quick sort algorithm to the sub-arrays
 4)Combine the results to produce the final sorted array
 Time complexity: O(n log n) on average, O(n^2) in the worst case
 Space complexity: O(log n) on average, O(n) in the worst case

 Merge sort: It is a divide-and-conquer algorithm that splits the input into several parts and then combines the 
 results. It is a top-down approach, where the list is divided into smaller sub-lists until each sub-list contains only 
 one element, and then these sub-lists are merged back together in a sorted manner. Steps:
 1)Divide the list into two halves
 2)Recursively apply the merge sort algorithm to each half
 3)Merge the two sorted halves into a single sorted list
 Time complexity: O(n log n)
 Space complexity: O(n)

 */


/*

 Time Complexity:
 Bubble sort: O(n^2)
 Quick Sort: O(n log n) on average, O(n^2) in the worst case

Q) Why Quick Sort is generally preferred over Bubble Sort.
 Quick Sort is generally preferred over Bubble Sort due to its superior efficiency and performance, particularly with 
 larger datasets. Quick Sort, a divide-and-conquer algorithm, typically has an average-case time complexity of O(n log n). 
 This efficiency arises from its strategy of partitioning the array into smaller sub-arrays around a pivot element, then 
 recursively sorting the sub-arrays. This allows Quick Sort to handle large datasets more effectively.
 In contrast, Bubble Sort has a worst-case and average-case time complexity of O(n²). It repeatedly steps through the list,
 compares adjacent elements, and swaps them if they are in the wrong order. This process continues until the list is sorted, 
 which results in significantly more comparisons and swaps compared to Quick Sort, making it inefficient for large datasets.
 Moreover, Quick Sort's space complexity is also generally better, with O(log n) auxiliary space, whereas Bubble Sort requires 
 O(1) space but at the cost of much slower execution time for non-trivial datasets. This makes Quick Sort a more practical choice 
 in most real-world applications.
 
 */