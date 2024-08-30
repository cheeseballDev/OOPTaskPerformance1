package OOPTaskPerformance;
import java.util.Scanner;

class AmountDue implements Runnable {

    private int userChoice;

    void printUserInstructions() {
        clearScreen();
        System.out.println("Press any of the following then enter values separated by spaces: ");
        System.out.println("1 - Price only");
        System.out.println("2 - Price and quantity");
        System.out.println("3 - Price, quantity, and discount amount");
        userSelectValue();
    }

    void userSelectValue() {
        Scanner userInput = new Scanner(System.in);
        try {
            userChoice = userInput.nextInt();
            int userValue = checkIfUserValueIsValid(userChoice);
            userValueTypeOfCompute(userValue);
        } catch (Exception e) {
            clearScreen();
            System.out.print("Invalid input, please try again.");
            pause(3000);
            printUserInstructions();
        }
        userInput.close();
    }

    int checkIfUserValueIsValid(int value) {
        if(!(value == 1 || value == 2 || value == 3)){
            clearScreen();
            System.out.print("Please enter a number ranging from 1 - 3");
            pause(3000);
            printUserInstructions();
        }
        return value;
    }

    void userValueTypeOfCompute(int value) {
        switch(value) {
            case 1:
                System.out.println("1");
                break;
            case 2:
                System.out.println("2");
                break;
            case 3:
                System.out.println("3");
                break;
        }
    }

    /*
     *  COMPUTATION METHODS
     */

    double computeAmountDue(double price){
        
        return price;
    }

    int computeAmountDue(int quantity) {
        int total = 0;

        return total;
    }

    float computeAmountDue(float discountAmount) {
        float total = 0;

        return total;
    }

    /*
     *  MISC METHODS
     */

    @Override
    public void run() {
        pause(3000);
    }

    void pause(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  
}
