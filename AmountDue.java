package OOPTaskPerformance;
import java.util.Scanner;

class AmountDue implements Runnable {
    
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
            int userChoice = userInput.nextInt();
            int userValue = checkIfUserValueIsValid(userChoice);
            userValueTypeOfCompute(userValue);
        } catch (Exception e) {
            printErrorInvalidInput();
            pause(1500);
            printUserInstructions();
        }
        userInput.close();
    }

    void userValueTypeOfCompute(int value) {
        //pass values to each other.
        switch(value) {
            case 1:
                checkItemPrice();
                break;
            case 2:
                checkItemQuantity();
                break;
            case 3:
                checkItemDiscountAmount();
                break;
        }
    }

    /*
     *  CHECK FOR ERROR METHODS 
     */

    void checkItemPrice() {
        Scanner userInput = new Scanner(System.in);
        while(true) {
            try {
                double itemPrice = userInput.nextDouble();
                double finalPrice = computeAmountDue(itemPrice);
                System.out.print("Amount due is " + finalPrice);
                break;
            } catch (Exception e) {
                printErrorContainsInvalidCharacters();
                continue;
            }
        }
        userInput.close();
    }

    void checkItemQuantity() {
        Scanner userInput = new Scanner(System.in);
        while(true) {
            try {
                String itemPriceAndQuantity = userInput.nextLine();
                String[] itemPriceAndQuantitySplit = itemPriceAndQuantity.split(" ");
                double itemPriceDouble = Double.parseDouble(itemPriceAndQuantitySplit[0]);
                int itemQuantity = Integer.parseInt(itemPriceAndQuantitySplit[1]);
                double finalPrice = computeAmountDue(itemPriceDouble, itemQuantity);
                System.out.print("Amount due is " + finalPrice);
                break;
            } catch (Exception e) {
                printErrorContainsInvalidCharacters();
                continue;
            }
        }
        userInput.close();
    }

    void checkItemDiscountAmount() {
        Scanner userInput = new Scanner(System.in);
        while(true) {
            try {
                String itemPriceAndQuantity = userInput.nextLine();
                String[] itemPriceAndQuantitySplit = itemPriceAndQuantity.split(" ");
                double itemPriceDouble = Double.parseDouble(itemPriceAndQuantitySplit[0]);
                int itemQuantity = Integer.parseInt(itemPriceAndQuantitySplit[1]);
                float itemDiscount = Float.parseFloat(itemPriceAndQuantitySplit[2]);
                double finalPrice = computeAmountDue(itemPriceDouble, itemQuantity, itemDiscount);
                System.out.print("Amount due is " + finalPrice);
                break;
            } catch (Exception e) {
                printErrorContainsInvalidCharacters();
                continue;
            }
        }
        userInput.close();
    }

    int checkIfUserValueIsValid(int value) {
        if(!(value == 1 || value == 2 || value == 3)){
            clearScreen();
            printErrorInvalidNumber();
            pause(1500);
            printUserInstructions();
        }
        return value;
    }

    /*
     *  COMPUTATION METHODS
     */

    double computeAmountDue(double price){
        double taxAmount = price * 0.12;
        price += taxAmount;
        return price;
    }

    double computeAmountDue(double price, int quantity) {
        double taxAmount = price * 0.12;
        double priceAndQuantity = price * quantity;
        priceAndQuantity += taxAmount;
        return priceAndQuantity;
    }

    double computeAmountDue(double price, int quantity, float discountAmount) {
        double taxAmount = price * 0.12;
        double priceAndQuantity = price * quantity;
        double discountedAmount = priceAndQuantity - discountAmount;
        discountedAmount += taxAmount;
        return discountedAmount;
    }

    /*
     *  MISC METHODS
     */

    void printErrorInvalidInput() {
        clearScreen();
        System.out.print("Invalid input, please try again. ");
        char[] characters = {'.',' ', '.', ' ', '.', ' ', '.'};

        for(int i = 0; i < characters.length; i++) {
            System.out.print(characters[i]);
            pause(300);
        }
    }

    void printErrorInvalidNumber() {
        clearScreen();
        System.out.print("Please enter a number ranging from 1 - 3, please try again. ");
        char[] characters = {'.', ' ', '.', ' ', '.', ' ', '.'};

        for(int i = 0; i < characters.length; i++) {
            System.out.print(characters[i]);
            pause(300);
        }
    }

    void printErrorContainsInvalidCharacters() {
        clearScreen();
        System.out.print("Input contains invalid characters, please try again. ");
        char[] characters = {'.', ' ', '.', ' ', '.', ' ', '.'};

        for(int i = 0; i < characters.length; i++) {
            System.out.print(characters[i]);
            pause(300);
        }
        System.out.print("\n");
    }

    @Override
    public void run() {
        pause(0);
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
