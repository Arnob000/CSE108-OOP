public class Animal {
    private String name;
    private int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
interface Dog {
    String name;
    int age;
    Dog(String name, int age);
    
}
interface FruitBat {
    String name;
    int age;
    FruitBat(String name, int age);
    
}
interface Platypus {
    String name;
    int age;
    Platypus(String name, int age);
}
interface Human {
    String name;
    int age;
    Human(String name, int age);
    
}
class Mammal implements Dog, FruitBat, Platypus, Human {
    Mammal(String name, int age){
         FruitBat(String name, int age){
        this.name=name;
        this.int=int;
    }
        Dog(String name, int age){
        this.name=name;
        this.int=int;
    }
Platypus(String name, int age){
        this.name=name;
        this.int=int;
    }
 Human(String name, int age){
        this.name=name;
        this.int=int;
    }
    }
    printBloodType(){
        System.out.println("Warm Blooded");}
    
}
class Bird {
    String name;
    int age;
    Bird(String name, int age){
        this.name=name;
        this.int=int;
    }
    printBloodType(){
            System.out.println("Warm Blooded");}
}
class Albatros extends Bird {
    Albatros(String name, int age){
        super(name, age);
    }
    
}