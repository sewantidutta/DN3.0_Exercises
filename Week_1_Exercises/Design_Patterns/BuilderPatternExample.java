/*
Exercise 3: Implementing the Builder Pattern
Scenario: 
You are developing a system to create complex objects such as a Computer with multiple optional parts. Use the Builder Pattern to manage the construction process.
Steps:
1.	Create a New Java Project:
o	Create a new Java project named BuilderPatternExample.
2.	Define a Product Class:
o	Create a class Computer with attributes like CPU, RAM, Storage, etc.
3.	Implement the Builder Class:
o	Create a static nested Builder class inside Computer with methods to set each attribute.
o	Provide a build() method in the Builder class that returns an instance of Computer.
4.	Implement the Builder Pattern:
o	Ensure that the Computer class has a private constructor that takes the Builder as a parameter.
5.	Test the Builder Implementation:
o	Create a test class to demonstrate the creation of different configurations of Computer using the Builder pattern.
*/

// Computer.java
class Computer {
    private String cpu;
    private int ram;
    private int storage;
    private String gpu;
    private String os;

    // Private constructor to prevent direct instantiation
    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.gpu = builder.gpu;
        this.os = builder.os;
    }

    // Static nested Builder class
    public static class Builder {
        private String cpu;
        private int ram;
        private int storage;
        private String gpu;
        private String os;

        public Builder withCpu(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public Builder withRam(int ram) {
            this.ram = ram;
            return this;
        }

        public Builder withStorage(int storage) {
            this.storage = storage;
            return this;
        }

        public Builder withGpu(String gpu) {
            this.gpu = gpu;
            return this;
        }

        public Builder withOs(String os) {
            this.os = os;
            return this;
        }

        // build() method returns an instance of Computer
        public Computer build() {
            return new Computer(this);
        }
    }

    @Override
    public String toString() {
        return "Computer { cpu= "+cpu+" , ram= "+ram+" , storage= "+storage+" , gpu="+gpu+" , os= "+os+" }";
    }
}
// BuilderPatternExample.java
public class BuilderPatternExample {
    public static void main(String[] args) {
        // Create a basic computer
        Computer basicComputer = new Computer.Builder()
                .withCpu("Intel Core i3")
                .withRam(8)
                .withStorage(256)
                .withOs("Windows 10")
                .build();

        System.out.println("Basic Computer: " + basicComputer);

        // Create a gaming computer
        Computer gamingComputer = new Computer.Builder()
                .withCpu("Intel Core i7")
                .withRam(16)
                .withStorage(512)
                .withGpu("NVIDIA GeForce GTX 1660")
                .withOs("Windows 10")
                .build();

        System.out.println("Gaming Computer: " + gamingComputer);
    }
}
