/*
Exercise 7: Financial Forecasting
Scenario: 
You are developing a financial forecasting tool that predicts future values based on past data.
Steps:
1.	Understand Recursive Algorithms:
o	Explain the concept of recursion and how it can simplify certain problems.
2.	Setup:
o	Create a method to calculate the future value using a recursive approach.
3.	Implementation:
o	Implement a recursive algorithm to predict future values based on past growth rates.
4.	Analysis:
o	Discuss the time complexity of your recursive algorithm.
o	Explain how to optimize the recursive solution to avoid excessive computation.
*/

import java.util.*;
public class financial {
    public static double calculateFutureValue(double initialValue, double growthRate, int periods) {
        if (periods == 0) {
            return initialValue;
        } else {
            double nextValue = initialValue * (1 + growthRate);
            return calculateFutureValue(nextValue, growthRate, periods - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the starting value:");
        double initialValue = sc.nextDouble(); // Initial investment
        System.out.println("Enter the growth rate:");
        double growthRate = sc.nextDouble();   // 5% annual growth rate
        System.out.println("Enter number of years:");
        int years = sc.nextInt();             // Number of years

        double fv = calculateFutureValue(initialValue, growthRate, years);
        System.out.println("The future value after " + years + " years is: " + fv);
        sc.close();
    }
}

/*
Q1)

 Understand Recursive Algorithms:
 Recursion is a programming concept where a function calls itself repeatedly until it reaches a 
 base case that stops the recursion. Recursion can simplify certain problems by breaking them down 
 into smaller sub-problems of the same type, making it easier to solve them.

 Simplifying Problems with Recursion:
 Recursion simplifies certain problems by breaking them down into smaller, more manageable sub-problems. 
 This approach is ideal for problems with a recursive structure, such as tree traversals, dynamic programming, 
 and combinatorial problems. Recursion enables the solution of complex problems by solving each sub-problem 
 only once and storing the results for future use. This reduces code complexity and improves efficiency.
 */

/*
Q4)

Time Complexity analysis:
The time complexity of this recursive function is 𝑂(𝑛)
O(n) because it makes n recursive calls to compute the final value.

Optimizing the Recursive Solution:
To optimize the recursive solution and avoid excessive computation, we can use memoization 
or dynamic programming to store the intermediate results. This way, we can avoid recalculating 
the same values multiple times.
 */