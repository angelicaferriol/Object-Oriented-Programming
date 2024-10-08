class Student {
    String name;
    int age;
    String StudentID;

    Student(String name, int age, String StudentID) {
        this.name = name;
        this.age = age;
        this.StudentID = StudentID;
    }
    void displayInfo() {
        System.out.println("Student Name: " + name);
        System.out.println("Student Age: " + age);
        System.out.println("Student ID: " + StudentID);
    }

    void attendClass() {
        System.out.println(name + " is attending class. ");
    }
}

class Teacher {
        String name;
        String subject;

        Teacher(String name, String subject) {
            this.name = name;
            this.subject = subject;
        }

        void displayInfo() {
            System.out.println("Teacher Name: " + name);
            System.out.println("Subject: " + subject);
        }

        void conductClass(){
            System.out.println(name + " is teaching " + subject + ".");
        }
}

public class Sample {
    public static void main(String[] args) {
        Student student1 = new Student("John", 20, "1234");
        student1.displayInfo();
        student1.attendClass(); 

        Teacher teacher1 = new Teacher("Kris", "OOP");
        teacher1.displayInfo();
        teacher1.conductClass();

    }
}

