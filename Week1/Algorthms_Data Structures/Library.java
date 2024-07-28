/*Exercise 6: Library Management System
Scenario: 
You are developing a library management system where users can search for books by title or author.
Steps:
1.	Understand Search Algorithms:
o	Explain linear search and binary search algorithms.
2.	Setup:
o	Create a class Book with attributes like bookId, title, and author.
3.	Implementation:
o	Implement linear search to find books by title.
o	Implement binary search to find books by title (assuming the list is sorted).
4.	Analysis:
o	Compare the time complexity of linear and binary search.
o	Discuss when to use each algorithm based on the data set size and order.

*/

import java.util.Arrays;
import java.util.Scanner;

// Book.java
class Book {
    int bookId;
     String title;
     String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public void display(){
        System.out.println("[Book id=" + bookId +", Title="+ title +", Author= " + author + "]");
    }
}

// Lib.java
class Lib {
    private Book[] books;

    public Lib(Book[] books) {
        this.books = books;
    }

    // Linear Search
    public Book findBookByTitleLinear(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    // Binary Search
    public Book findBookByTitleBinary(String title) {
        Arrays.sort(books, (a, b) -> a.getTitle().compareToIgnoreCase(b.getTitle()));
        int left = 0;
        int right = books.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = books[mid].getTitle().compareToIgnoreCase(title);
            if (cmp==0) {
                return books[mid];
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }
}

//Library.java
public class Library {
    public static void main(String[] args) {
        Book[] books = new Book[] {
            new Book(1, "Tuesdays with Morrie", "Mitch Albom"),
            new Book(2, "Wonder", "R.J. Palacio"),
            new Book(3, "The Psychology of Money", "Morgan Housel"),
            new Book(4, "The Kite Runner", "Khaled Hosseini")
        };

        for(Book b: books){
           b.display();
            }

        Lib library = new Lib(books);

        System.out.println("Enter book title to search:");
        Scanner sc = new Scanner(System.in);
        String target = sc.nextLine();
        Book result1 = library.findBookByTitleLinear(target);
        if(result1!=null){
            System.out.println("Book found by linear search : ");
            result1.display();
        }else System.out.println("Book not found");

        // Binary Search
        Book result2 = library.findBookByTitleBinary(target);
        if(result2!=null){
            System.out.println("Book found by binary search : ");
            result2.display();
        } else System.out.println("Book not found");
    }
}

/*
  Time complexity analysis:
  Linear Search : O(n)
  Binary search : O(log n)
   where n = number of books

  Discussion:
  1)Linear search is suitable for small data sets or unsorted lists.
  2) Binary search is more efficient for large data sets and sorted lists.
  If the list is not sorted, the cost of sorting the list before performing a binary search may outweigh the benefits of using binary search.
 */