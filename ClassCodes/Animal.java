class Animal {

    void sound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {

    @Override
    void sound() {
        System.out.println("Bark");
    }
}

public class Main {

    public static void main(String[] args) {
        Animal myDog = new Dog();
        myDog.sound();  // This will output "Bark" because of polymorphism
    }
}
