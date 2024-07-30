    /*
    Exercise 7: Implementing the Observer Pattern
    Scenario: 
    You are developing a stock market monitoring application where multiple clients need to be notified whenever stock prices change. Use the Observer Pattern to achieve this.
    Steps:
    1.	Create a New Java Project:
    o	Create a new Java project named ObserverPatternExample.
    2.	Define Subject Interface:
    o	Create an interface Stock with methods to register, deregister, and notify observers.
    3.	Implement Concrete Subject:
    o	Create a class StockMarket that implements Stock and maintains a list of observers.
    4.	Define Observer Interface:
    o	Create an interface Observer with a method update().
    5.	Implement Concrete Observers:
    o	Create classes MobileApp, WebApp that implement Observer.
    6.	Test the Observer Implementation:
    o	Create a test class to demonstrate the registration and notification of observers.
    */

    import java.util.ArrayList;
    import java.util.List;
    
    // Observer.java
    interface Observer {
        void update(double stockPrice);
    }

    // Stock.java
    interface Stock {
        void registerObserver(Observer observer);
        void deregisterObserver(Observer observer);
        void notifyObservers();
    }

    // StockMarket.java
    class StockMarket implements Stock {
        private List<Observer> observers;
        private double stockPrice;

        public StockMarket() {
            observers = new ArrayList<>();
        }

        @Override
        public void registerObserver(Observer ob) {
            observers.add(ob);
        }

        @Override
        public void deregisterObserver(Observer ob) {
            observers.remove(ob);
        }

        @Override
        public void notifyObservers() {
            for (Observer ob : observers) {
                ob.update(stockPrice);
            }
        }

        public void setStockPrice(double stockPrice) {
            this.stockPrice = stockPrice;
            notifyObservers();
        }
    }

    // MobileApp.java
    class MobileApp implements Observer {
        @Override
        public void update(double stockPrice) {
            System.out.println("Mobile App: Stock price updated to " + stockPrice);
        }
    }

    // WebApp.java
    class WebApp implements Observer {
        @Override
        public void update(double stockPrice) {
            System.out.println("Web App: Stock price updated to " + stockPrice);
        }
    }

    public class ObservePatternExample {
        public static void main(String[] args) {
            StockMarket sm = new StockMarket();

            MobileApp mobileApp = new MobileApp();
            WebApp webApp = new WebApp();

            sm.registerObserver(mobileApp);
            sm.registerObserver(webApp);

            sm.setStockPrice(100.0);
            sm.setStockPrice(120.0);

            sm.deregisterObserver(webApp);
            
            sm.setStockPrice(150.0);
        }
    }

