
/*
 Exercise 6: Implementing the Proxy Pattern
Scenario: 
You are developing an image viewer application that loads images from a remote server. Use the Proxy Pattern to add lazy initialization and caching.
Steps:
1.	Create a New Java Project:
o	Create a new Java project named ProxyPatternExample.
2.	Define Subject Interface:
o	Create an interface Image with a method display().
3.	Implement Real Subject Class:
o	Create a class RealImage that implements Image and loads an image from a remote server.
4.	Implement Proxy Class:
o	Create a class ProxyImage that implements Image and holds a reference to RealImage.
o	Implement lazy initialization and caching in ProxyImage.
5.	Test the Proxy Implementation:
o	Create a test class to demonstrate the use of ProxyImage to load and display images.

 */

 // Image.java
interface Image {
    void display();
}

// RealImage.java
class RealImage implements Image {
    private String url;

    public RealImage(String url) {
        this.url = url;
        loadFromServer();
    }

    private void loadFromServer() {
        System.out.println("Loading image from server: " + url);
    }

    @Override
    public void display() {
        System.out.println("Displaying image: " + url);
    }
}

// ProxyImage.java
class ProxyImage implements Image {
    private String url;
    private RealImage realImage;

    public ProxyImage(String url) {
        this.url = url;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(url);
        }
        realImage.display();
    }
}

public class ProxyPatternExample {
    public static void main(String[] args) {
        // Create proxy images
        Image image1 = new ProxyImage("http://image1.jpg");
        Image image2 = new ProxyImage("http://image2.png");

        // Display images
        image1.display();
        image2.display();
        image1.display(); // Should not load from server again
        image2.display(); // Should not load from server again
    }
}