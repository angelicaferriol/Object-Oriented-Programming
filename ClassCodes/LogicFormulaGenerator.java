import java.util.Scanner;

public class LogicFormulaGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] inputs = new int[8];
        
        System.out.println("Enter 8 binary values (0 or 1):");
        for (int i = 0; i < 8; i++) {
            while (true) {
                System.out.print("Input " + (i+1) + ": ");
                int value = scanner.nextInt();
                if (value == 0 || value == 1) {
                    inputs[i] = value;
                    break;
                } else {
                    System.out.println("Invalid input. Please enter 0 or 1.");
                }
            }
        }
        
        String formula = generateFormula(inputs);
        System.out.println("\nLogical Formula: " + formula);
    }
    
    public static String generateFormula(int[] inputs) {
        boolean A = inputs[0] == 1;
        boolean B = inputs[1] == 1;
        boolean C = inputs[2] == 1;
        
        boolean result = 
            (A && B) || 
            (!(C)) || 
            (A ^ B);
        
        return String.format(
            "Formula: ((A AND B) OR (NOT C) OR (A XOR B)) = %s\n" +
            "Where A=%s, B=%s, C=%s\n" +
            "Additional inputs (not used in formula): [%d, %d, %d, %d, %d]",
            result, A, B, C, inputs[3], inputs[4], inputs[5], inputs[6], inputs[7]
        );
    }
}