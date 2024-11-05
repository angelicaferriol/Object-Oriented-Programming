// CommonElement class to find and print common elements between two arrays
class CommonElement {
    // Main method where the program starts execution
    public static void main(String[] args) {
      
        // Initialize the first array with some integer values
        int[] num1 = {1, 3, 5, 7, 9};
        
        // Initialize the second array with some integer values
        int[] num2 = {2, 5, 9, 8, 4};
        
        // Print a message indicating that the common elements will follow
        System.out.println("Common elements:");

        // Loop through each element in the first array
        for(int i = 0; i < num1.length; i++){
            
            // For each element in the first array, loop through each element in the second array
            for(int j = 0; j < num2.length; j++){
                
                // If an element in the first array matches an element in the second array, print it
                if(num1[i] == num2[j]){
                    System.out.println(num1[i]);
                }
            }
        }
    }
}
