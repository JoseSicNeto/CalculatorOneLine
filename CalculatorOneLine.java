import java.util.Scanner;
																//Functions Class EnterValue.
class EnterValue{
	Scanner scan = new Scanner(System.in);
	
	public String[] Values() {
		
		System.out.println("Defined Format: 0000 + 0000");
		System.out.print("Enter your Calculation: ");			//Inform the Format and Get the User's Typing.
		String OneLineCalc = scan.nextLine();
		
        String[] InputWords = OneLineCalc.split("\\s");			//Divide String using one or more spaces.
		
        if (InputWords.length != 3) {							//Desired Format Three Spaces (0000 + 0000).
        	HandleWrongFormat();
        	return null;
        }
        
        int FistNumSize = InputWords[0].length();		
        String FirstNum = InputWords[0];
        
        int OperatorSize = InputWords[1].length();
        
        int SecondNumSize = InputWords[2].length();		
        String SecondNum = InputWords[2];
        
        
        if (FistNumSize > 4 || SecondNumSize > 4 || OperatorSize != 1 || !isDouble(FirstNum) || !isDouble(SecondNum)) {
        	HandleWrongFormat();
        	return null;
        }														//Confirm that the Format is Right and Call a Method If It's Wrong.
        

		
        return InputWords;
	}
	
																//Method that Confirms that the Values ​​Entered is a Number.
    private static boolean isDouble(String number) {
        try {
            Double.parseDouble(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    															//Method that Informs that the Format was Wrong.
    private static void HandleWrongFormat() {
        System.out.println("\nWrong Typed Format\n");
    }
    
    public void CloseScan() {
    	scan.close();
    }
}
																//Class that Performs the Calculations Action.

class Operation{
	public void CalculationAction(double number1, String operatotr, double number2) {
		
		switch (operatotr) {
		case "+":
			System.out.println("Your Calculation Resulted: " + (number1 + number2));
			break;
		case "-":
			System.out.println("Your Calculation Resulted: " + (number1 - number2));
			break;
		case "*":
			System.out.println("Your Calculation Resulted: " + (number1 * number2));
			break;
		case "/":
			if (number2 != 0) {
				System.out.println("Your Calculation Gave: " + (number1 / number2));
				break;
			}else {
				System.out.println("Error: Impossible to Divide by Zero");
				break;
			}
		default:
			System.out.println("Invalid Operator");
		}
	}
}
																//Run the Program.

public class CalculatorOneLine {
    public static void main(String[] args) {
        Start();
    }

    public static void Start() {
        boolean wantToClose = false;
        Scanner type_it = new Scanner(System.in);
 
        EnterValue values = new EnterValue();
        Operation action = new Operation();
        
        while (!wantToClose) {
            System.out.println("Perform your calculations:\n");
            																		//Create the Continuous Loop.
            String[] item = values.Values();

            if (item == null) {
            	continue;
            }

            double FirstNum = Double.parseDouble(item[0]);
            String Operator = item[1];
            double SecondNum = Double.parseDouble(item[2]);

            action.CalculationAction(FirstNum, Operator, SecondNum);

            boolean validOption = false;
            while (!validOption) {
                System.out.println("\nDo you want to close the program? (yes/no)");
                System.out.print("Enter your choice: ");
                String input = type_it.nextLine().toLowerCase();
                																	//Close or Continue the Loop.
                if (input.equals("yes")) {
                    System.out.println("\nClosing the program...");
                    validOption = true;
                    wantToClose = true;
                } else if (input.equals("no")) {
                    System.out.println("\nContinue...\n");
                    validOption = true;
                } else {
                    System.out.println("\nInvalid option.\n");
                }
            }
        }

        System.out.println("Close the program.");
        values.CloseScan();
        type_it.close();
    }
}