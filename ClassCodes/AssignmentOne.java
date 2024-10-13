// Create a class named Person  
class Person {

    // Fields of the Class Person
    String name;
    int age;
    String address;

    // Constructor to initialize the fields
    Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    // Method to display the person's information
    void displayPersonInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Address: " + address);
        System.out.println(); // for better formatting
    }
}

// Main Class
public class AssignmentOne {

    // Main method
    public static void main(String[] args) {

        // Create three Person objects
        Person person1 = new Person("Angelica Ferriol", 19, "North Caloocan City");
        Person person2 = new Person("Kathlene Ferriol", 24, "Cavite");
        Person person3 = new Person("Diana Ferriol", 33, "Batangas");

        // Call the displayPersonInfo method for each object
        person1.displayPersonInfo();
        person2.displayPersonInfo();
        person3.displayPersonInfo();
    }
}
