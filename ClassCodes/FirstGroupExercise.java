// Create a class
class StudentProfile {
    
    // Fields
    String name;
    String program;
    int year;
    String section;
    
    // Create a constructor
    StudentProfile(String name, String program, int year, String section) {
        this.name = name;
        this.program = program;
        this.year = year;
        this.section = section;
    }

    // Display Student Profile method
    void displayStudentProfile() {
        System.out.println("Name: " + name);
        System.out.println("Program: " + program);
        System.out.println("Year: " + year);
        System.out.println("Section: " + section + "\n");
    }

    // Update Program method
    void update(String newProgram, int newYear, String newSection) {
        this.program = newProgram;
        this.year = newYear;
        this.section = newSection;
    }
}


// Main class
public class FirstGroupExercise {

    public static void main(String[] args) {
       
        System.out.println("THREE AMAZING STUDENTS' PROFILE\n");

        // Create an object
        StudentProfile StudentProfile1 = new StudentProfile("Angelica Ferriol", "BS Political Science", 1, "1-5");
        StudentProfile StudentProfile2 = new StudentProfile("Kurt Viray", "BS Information Technology", 1, "1-1");
        StudentProfile StudentProfile3 = new StudentProfile("Railley Nieles", "BS Aerospace Engineering", 3, "3-6");

        System.out.println("ACADEMIC YEAR 2023-2024");
       
        // Call the display method
        StudentProfile1.displayStudentProfile();
        StudentProfile2.displayStudentProfile();
        StudentProfile3.displayStudentProfile();

        // Call the update method
        StudentProfile1.update("BS Computer Science", 2, "2-1N");
        StudentProfile2.update("BS Nursing", 2, "2-3");
        StudentProfile3.update("BS Psychology", 4, "4-5");

        System.out.println("Updated Student Profile!");
    
        System.out.println("\nACADEMIC YEAR 2024-2025");

        // Call the display method after updating
        StudentProfile1.displayStudentProfile();
        StudentProfile2.displayStudentProfile();
        StudentProfile3.displayStudentProfile();

    }
}