/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package billsplinter;

/**
 *
 * @author jasonfujii
 */
import java.util.Scanner;
public class BillSplitter {

    /**
     * @param args the command line arguments
     */
    /*
        BillSplitter will help large groups split their bills either evenly or item by item. 
        It includes a feature which implements tax and tip./
    */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        SOP("Split the check evenly or item by item?");
        SOP("Enter \"Evenly\" or \"Item\"");
        //this code will split the bill evenly among X number of people
        String input = sc.nextLine();
        if(input.equals("Evenly"))
            {
                SOP("Enter the total price. Include tax and tip");
                double price = sc.nextDouble();
                SOP("Enter the number of people with whom you'd like to split the check");
                int num = sc.nextInt();
                //Figure it out for money
                double result = ((price/num)*100)/100;
                SOP("The total price per person is: ");
                System.out.print("$");
                System.out.println( String.format( "%.2f", result ) );
            }
        //this code will take the price of the items, add tax to them based on the area, then add it to a total
        else if(input.equals("Item"))
        {
            double tax;
            SOP("Enter the tax rate");
            tax = sc.nextDouble();
            tax = tax/100.0;
            SOP("Enter the number of people with whom you are splitting the check");
            int num = sc.nextInt();
            for(int i = 0; i < num; i++)
            {
                double total = 0;
                SOP("Enter the number of items Person " +(i+1)+ " purchased");
                int bought = sc.nextInt();
                for(int x = 0; x < bought; x++)
                {
                    SOP("Enter the price for Item " +(x+1));
                    total += sc.nextDouble();
                }
                SOP("Need to add anything else?");
                while(sc.nextLine().equals("yes")||sc.nextLine().equals("Yes"))
                {
                    SOP("Enter the price for the next Item");
                    total += sc.nextDouble();
                    SOP("Need to add anything else?");
                }
                SOP("Please enter the tax rate");
                total = total + (total * tax);
                SOP("The total price for Person " +(i+1)+ " is: ");
                System.out.print("$");
                System.out.println( String.format( "%.2f", total ) );
            }
        }
    }
    public static void SOP(String x)
    {
        System.out.println(x);
    }
}
