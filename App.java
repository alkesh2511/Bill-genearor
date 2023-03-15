import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class App {
 
    public static void main(String[] args) throws Exception {
       

        Scanner input = new Scanner(System.in);

        // Get customer information
        System.out.print("Enter customer name: ");
        String name = input.nextLine();
        System.out.print("Enter customer address: ");
        String address = input.nextLine();

        // Get item information
        System.out.print("Enter item name: ");
        String itemName = input.nextLine();
        System.out.print("Enter item price: ");
        double itemPrice = input.nextDouble();
        System.out.print("Enter item quantity: ");
        int itemQuantity = input.nextInt();

        // Calculate total price
        double totalPrice = itemPrice * itemQuantity;

        // Get current date and time
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        Date date = new Date();

        // Create file with current date and time as file name
        String fileName = dateFormat.format(date) + ".txt";
           
        try {

           File fileDirectory = new File(fileName);
           PrintWriter writer = new PrintWriter(fileName);
          
           if(fileDirectory.createNewFile())
           {
               writer= new PrintWriter(fileDirectory);
           }
            
           

            // Write bill information to file
            writer.write("--------------------Bill----------------------\n");
            writer.write("----------------\n");
            writer.write("Date: " + dateFormat.format(date) + "\n");
            writer.write("Customer Name: " + name + "\n");
            writer.write("Customer Address: " + address + "\n");
            writer.write("Item Name: " + itemName + "\n");
            writer.write("Item Price: " + itemPrice + "\n");
            writer.write("Item Quantity: " + itemQuantity + "\n");
            writer.write("Total Price: " + totalPrice + "\n");

            // Close file writer
            writer.close();

            System.out.println("Bill generated successdfully! File saved as " + fileName);

        } catch (IOException e) {
            System.out.println("An error occurred while generating the bill.");
            e.printStackTrace();
        }
    }
}
