/*
 Exercise 11: Implementing Dependency Injection
Scenario: 
You are developing a customer management application where the service class depends on a repository class. Use Dependency Injection to manage these dependencies.
Steps:
1.	Create a New Java Project:
o	Create a new Java project named DependencyInjectionExample.
2.	Define Repository Interface:
o	Create an interface CustomerRepository with methods like findCustomerById().
3.	Implement Concrete Repository:
o	Create a class CustomerRepositoryImpl that implements CustomerRepository.
4.	Define Service Class:
o	Create a class CustomerService that depends on CustomerRepository.
5.	Implement Dependency Injection:
o	Use constructor injection to inject CustomerRepository into CustomerService.
6.	Test the Dependency Injection Implementation:
o	Create a main class to demonstrate creating a CustomerService with CustomerRepositoryImpl and using it to find a customer.
 */

 // CustomerRepository.java

import java.util.HashMap;
import java.util.Map;

interface CustomerRepository {
    Customer findCustomerById(int id);
}

// Customer.java

class Customer {
    private int id;
    private String name;

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

// CustomerRepositoryImpl.java
class CustomerRepositoryImpl implements CustomerRepository {
    private Map<Integer, Customer> customers = new HashMap<>();

    public CustomerRepositoryImpl() {
        // Initialize customers map for demonstration purposes
        customers.put(1, new Customer(1, "Sewanti Dutta"));
        customers.put(2, new Customer(2, "Diya Dutta"));
    }

    @Override
    public Customer findCustomerById(int id) {
        return customers.get(id);
    }
}

// CustomerService.java
class CustomerService {
    private CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public Customer findCustomerById(int id) {
        return repository.findCustomerById(id);
    }
}

public class DependencyInjectionExample {
    public static void main(String[] args) {
        // Create a customer repository implementation
        CustomerRepository repository = new CustomerRepositoryImpl();

        // Create a customer service with the repository
        CustomerService service = new CustomerService(repository);

        // Find a customer using the service
        Customer customer = service.findCustomerById(1);

        System.out.println("Customer Name: " + customer.getName());
    }
}   
