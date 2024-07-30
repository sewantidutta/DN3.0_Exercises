/*
Scenario: 
You are working on the search functionality of an e-commerce platform. The search needs to be optimized for fast performance.
Steps:
1.	Understand Asymptotic Notation:
o	Explain Big O notation and how it helps in analyzing algorithms.
o	Describe the best, average, and worst-case scenarios for search operations.
2.	Setup:
o	Create a class Product with attributes for searching, such as productId, productName, and category.
3.	Implementation:
o	Implement linear search and binary search algorithms.
o	Store products in an array for linear search and a sorted array for binary search.
4.	Analysis:
o	Compare the time complexity of linear and binary search algorithms.
o	Discuss which algorithm is more suitable for your platform and why.

*/
import java.util.*;
class Product{
    private int productId;
    private String productName;
    private String category;
    public Product(int id,String name,String category){
        this.productId = id;
        this.productName = name;
        this.category = category;
    }
    public int getProductId(){
        return productId;
    }
    public String getProductName(){
        return productName;
    }
    public String getCategory(){
        return category;
    }

    @Override
    public String toString(){
        return "Product["+"productId="+productId+", productName="+productName+", category= "+ category+"]";
    }
}
class Linearsearch{
    public static Product linearSearch (Product[] products,int targetId){
        for(Product p : products){
            if(p.getProductId()==targetId){
                return p;
            }
        }
        return null;
    }
}
class BinarySearch{
    public static Product binarysearch(Product[] products, int targetId){
        Arrays.sort(products, (a, b) -> Integer.compare(a.getProductId(), b.getProductId()));
        int low = 0;
        int high = products.length-1;
        while(low<=high){
            int mid = low +(high-low)/2;
            if(products[mid].getProductId() == targetId) return products[mid];
            else if(products[mid].getProductId() >targetId) high = mid -1;
            else low = mid+1;
        }
        return null;
    }
}
public class Ecommerce {
    public static void main(String[] args){

    Product[] products={
        new Product(1,"Dress", "CLothing"),
        new Product(2,"Smartphone", "Electronics"),
        new Product(3,"Book", "Education"),
        new Product(4,"Shirt", "Clothing"),
        new Product(5,"Shoes", "Footwear"),
        new Product(6,"Television", "Electronics")
    };

    for(Product p : products){
        System.out.println(p);
    }

    System.out.println("Enter the product ID to search : ");
    Scanner sc = new Scanner(System.in);
    int targetID =sc.nextInt();
    Product found1 = Linearsearch.linearSearch(products, targetID);
    System.out.println("By Linear Search:");
    System.out.println(found1);
    Product found2 = BinarySearch.binarysearch(products, targetID);
    System.out.println("By Binary Search");
    System.out.println(found2);
  
    sc.close();
    }
}


/*
Q1)
Understand Asymptotic Notation:
Asymptotic notation is a way to describe the performance or complexity of an algorithm,
which is crucial in analyzing and comparing algorithms. There are three main types of 
asymptotic notation: Big O, Omega, and Thet

Big O notation :
Big O notation is a measure of the upper bound of an algorithm's complexity, 
usually expressed as a function of the input size n. It's denoted as O(f(n)), 
where f(n) is the function that describes the algorithm's complexity. 
Big O notation gives an estimate of the worst-case scenario, i.e., the maximum time 
an algorithm takes to complete. It is a mathematical notation that describes the complexity 
of an algorithm, which is the amount of time or space it requires as the input size grows. 

Best-Case Scenario :
The best-case scenario occurs when the search element is found at the first position, 
and the algorithm terminates immediately.The time complexity for the best-case scenario is 
typically O(1), indicating constant time complexity.

Average-Case Scenario :
The average-case scenario assumes that the search element is randomly located in
the data structure. The time complexity for the average-case scenario is usually O(n/2) or 
O(log n), depending on the search algorithm used.

Worst-Case Scenario :
The worst-case scenario occurs when the search element is not found in the data structure, 
and the algorithm must traverse the entire data structure. The time complexity for the 
worst-case scenario is typically O(n), indicating linear time complexity.

Linear Search:
Best Case: O(1)
Average Case: O(n)
Worst Case: O(n)

Binary Search:
Best case: O(1)
Average case: O(log n)
Worst case: O(log n)

*/

/*
Q4)
Time Complexity Analysis:
Linear Search: O(n)
Binary Search:O(log n)

Comparison and Suitability:

Linear Search: Good for small datasets or unsorted data. It's simple but inefficient 
for large datasets due to O(n) time complexity.
Binary Search: Efficient for large datasets due to O(log n) time complexity but requires the
data to be sorted. It is suitable for scenarios where search speed is critical and the dataset is large.

Comparision and Suitability for E-commerce Platform:

Linear search checks each element in the array until it finds the target element, 
resulting in a linear increase in time as the input size (n) increases.
It is simple to implement but can be slow for large input sizes.
Binary search works by dividing the search space in half at each step, resulting 
in a logarithmic decrease in time as the input size (n) increases.
It is more efficient than linear search, especially for large input sizes.

Thus, based on the time complexity comparison, binary search is more suitable 
for the e-commerce platform.It also gives the users a faster search results as well as it 
ensures that the search functionality will remain efficient and scalable, 
even with a growing product catalog. 

*/
