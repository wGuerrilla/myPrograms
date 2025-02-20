Basic Java Fundamentals 
Youtube - broCode

public class Main{
    public static void main(String[] args)
}
























chatgpt -- 
Variables - think of them as containers that store data values
    ex. int number = 5; // number is the variable that holds integer values
Methods - Blocks of code that perform specific tasks and can be called when needed.
    ex. public void greet(){
        System.out.println("hello world.")
    }
Object-Oriented Programming (OOP) Concepts
Java is a object-oriented programming language.
which means it uses objects to model real-world entitties.
dont get it ? Classes and Objects 
Class : A blueprint for creating objects. it defines attributes(variables) and behaviors(methods).
Objects: An instance of a class. It has its own state and can perform behaviors defined by its class.
    ex. public class Unkown{
        //Attributes 
        String color;
        String model;
        //Method
        public void Beast(){
            System.out.println("The Guerrilla on Da MOVE")
        }
    }
    //Creating an object
    Guerrilla myBeast = new Unkown();
    myBeast.color = "darkPurple";
    myBeast.weight = "300Ibs";
    myBeast.move();
Inheritance : A mechanism where one class(subclass) inherits attributes and methods
