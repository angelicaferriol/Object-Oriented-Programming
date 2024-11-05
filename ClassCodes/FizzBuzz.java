// FizzBuzz class to print numbers from 1 to 100 with special rules
class FizzBuzz {
    // Main method where the program starts execution
    public static void main(String[] args) {
        // Loop through numbers 1 to 100
        for(int i = 1; i <= 100; i++){
            // If the number is divisible by both 3 and 5, print "FizzBuzz"
            if(i % 3 == 0 && i % 5 == 0){
                System.out.println("FizzBuzz");
            }
            // If the number is only divisible by 3, print "Fizz"
            else if(i % 3 == 0){
                System.out.println("Fizz");
            }
            // If the number is only divisible by 5, print "Buzz"
            else if(i % 5 == 0){
                System.out.println("Buzz");
            }
            // If the number is not divisible by 3 or 5, print the number itself
            else{
                System.out.println(i);
            }
        }
    }
}
