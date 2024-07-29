/*Exercise 9: Implementing the Command Pattern
Scenario: You are developing a home automation system where commands can be issued to turn devices on or off. Use the Command Pattern to achieve this.
Steps:
1.	Create a New Java Project:
o	Create a new Java project named CommandPatternExample.
2.	Define Command Interface:
o	Create an interface Command with a method execute().
3.	Implement Concrete Commands:
o	Create classes LightOnCommand, LightOffCommand that implement Command.
4.	Implement Invoker Class:
o	Create a class RemoteControl that holds a reference to a Command and a method to execute the command.
5.	Implement Receiver Class:
o	Create a class Light with methods to turn on and off.
6.	Test the Command Implementation:
o	Create a test class to demonstrate issuing commands using the RemoteControl.
*/

// Command.java
interface Command {
    void execute();
}

// Light.java
class Light {
    public void turnOn() {
        System.out.println("Light is on");
    }

    public void turnOff() {
        System.out.println("Light is off");
    }
}

// LightOnCommand.java
class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}

// LightOffCommand.java
class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}

// RemoteControl.java
class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}

public class CommandPatternExample {
    public static void main(String[] args) {
        Light light = new Light();
        RemoteControl rc = new RemoteControl();

        LightOnCommand on = new LightOnCommand(light);
        rc.setCommand(on);
        rc.pressButton();
        LightOffCommand off = new LightOffCommand(light);
        rc.setCommand(off);
        rc.pressButton();
    }
}
