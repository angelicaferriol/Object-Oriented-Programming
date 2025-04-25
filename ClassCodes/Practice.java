import java.util.Scanner;

public class Practice {

    public static void main(String[] args) {
        
        String email[] = {"one", "two", "three", "four", "five"};
        String username[] = {"123A", "456B", "789C", "101D", "112E"};
        int password[] = {123, 456, 789, 101, 112};
        
        int index;

        Scanner input = new Scanner(System.in);
        System.out.print("Which index would you like to access? (0-4): ");
        index = input.nextInt();

        switch(index) {
            case 0:
                System.out.println("Email: " + email[0]);
                System.out.println("Username: " + username[0]);
                System.out.println("Password: " + password[0]);
                break;
            case 1:
                System.out.println("Email: " + email[1]);
                System.out.println("Username: " + username[1]);
                System.out.println("Password: " + password[1]);
                break;
            case 2:
                System.out.println("Email: " + email[2]);
                System.out.println("Username: " + username[2]);
                System.out.println("Password: " + password[2]);
                break;
            case 3:     
                System.out.println("Email: " + email[3]);
                System.out.println("Username: " + username[3]);
                System.out.println("Password: " + password[3]);
                break;
            case 4:
                System.out.println("Email: " + email[4]);
                System.out.println("Username: " + username[4]);
                System.out.println("Password: " + password[4]);
                break;      
            default:
                System.out.println("Invalid index");
        }

    }
}



