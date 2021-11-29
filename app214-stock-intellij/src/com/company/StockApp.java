package com.company;

import java.util.Scanner;

/**
 * This app provides a user interface to the
 * stock manager so that users can add, edit,
 * print and remove stock products
 *
 * @modified by Sudath Nawagamuwage
 * @version 19/11/2021
 */
public class StockApp
{
    private InputReader reader;
    private StockList stock;
    public static final String ANSI_RESET  = "\u001B[0m";
    public static final String ANSI_BLACK  = "\u001B[30m";
    public static final String ANSI_RED    = "\u001B[31m";
    public static final String ANSI_GREEN  = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE   = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN   = "\u001B[36m";
    public static final String ANSI_WHITE  = "\u001B[37m";
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    //Scanner that values in putting.
    Scanner scan = new Scanner(System.in);

    /**
     * Constructor for objects of class StockApp
     */
    public StockApp()
    {
        reader = new InputReader();

        stock = new StockList();
        StockDemo demo = new StockDemo(stock);
    }

    /**
     *  Display a list of menu choices and execute
     *  the user's choice.
     */
    public void run()
    {
        boolean finished = false;

        while(!finished)
        {
            printHeading();
            printMenuChoices();

            String choice = reader.getString("Please enter your choice > ");

            finished = executeChoice(choice.toLowerCase());
        }
    }

    /**
     * This method will add the product
     * by name and id
     */
    private void addProduct()
    {
        System.out.println("Adding a new product");
        System.out.println("---------------------");

        int id = reader.getInt("Please enter a product id>");
        Product search = stock.findProduct(id);

        if (search == null)
        {
            String name = reader.getString("please enter a product name>");
            Product product = new Product(id, name);

            stock.add(product);
            System.out.println("Product" + product.getID()
                    + " : "+ product.getName() + " has been added ");
        }
        else
        {
            System.out.println("The ID already existing!!!");
        }

    }
    /**
     * This method will remove the product
     * by finding the id
     */
    private void removeProduct()
    {
        System.out.println("Removing the old product");
        System.out.println("--------------------------");

        int id = reader.getInt("Please enter a product id>");
        Product product = stock.findProduct(id);
        if (product != null)
        {
            String scan = reader.getString("Are you sure you want to remove this product(select Yes or No)>");
            if (scan.equals("y"))
            {
                stock.remove(id);

            }
            else if (scan.equals("n"))
            {
                System.out.println("Return to main menu");
            }
        }
        else
        {
            System.out.println("This product ID non-existing!!!");
        }
   }

    /**
     * This method will buy the product
     * amount of 10 and add to the stock list
     */
    private void buyStock()
    {
        System.out.println("Buying a new products");
        System.out.println("-----------------------");

        int id = reader.getInt("Please enter a product id>");
        int amount = reader.getInt("Please enter the buy quantity must be between 1 and 10>");
        if(1<= amount && amount <=10)
        {
            stock.buyProduct(id, amount);
            System.out.println("Product ID "+ id + " Stock increased by " + amount);
        }
        else
        {
            System.out.println("You can't buy more that 10 product!!!");
        }
    }

    /**
     * This method will sell the product
     * amount of 10 and decreased to the stock level
     */
    private void sellStock()
    {
        System.out.println("Sold products");
        System.out.println("--------------");

        int id = reader.getInt("Please enter a product id>");
        int amount = reader.getInt("Please enter the Sell quantity must be between 1 and 10)>");
        if(1<= amount && amount <=10)
        {
            stock.sellProduct(id, amount);
            System.out.println("Product ID "+ id + " Stock decreased by " + amount);
        }
        else
        {
            System.out.println("You can't sell more that 10 product!!!");
        }
    }

    /**
     * This method will search the product
     * by name
     */
    private void searchStock()
   {
        System.out.println("search a new products");
        System.out.println("---------------------");

        String name  = reader.getString("please enter a product name>");
        stock.searchProduct(name);
   }

    /**
     * This method will search the low stock
     * product by amount
     */
   private void lowStock()
    {
        System.out.println("Low stock products (1 to 5)");
        System.out.println("--------------------------");

        int amount  = reader.getInt("list of products whose stock levels are low (between 1 and 5)");
        if(1 <= amount && amount <= 5) {
            stock.lowStockLevel();
            String scan = reader.getString("Would you like to to restock (Yes or NO)");
            if (scan.equals("y")) {
                stock.reStock();
            } else if (scan.equals("n")) {
                System.out.println("Return to main menu");
            } else {
                System.out.println("Wrong quantity !!!");
            }
        }
    }
    /**
     * This method will search the re-stock
     * product by amount
     */
    private void reStock()
    {
        System.out.println("Re-stock products (1 to 5)");
        System.out.println("--------------------------");
        int amount  = reader.getInt("Restock product list (between 1 and 5)");
        if(1 <= amount && amount <= 5)
        {
            stock.reStock();
        }
    }

    private boolean executeChoice(String choice)
    {
        if(choice.equals("quit"))
        {
            return true;
        }
        else if(choice.equals("print"))
        {
             stock.print();

        }
        else if(choice.equals("add"))
        {
            addProduct();
        }
        else if(choice.equals("remove"))
        {
            removeProduct();
        }
        else if(choice.equals("buy"))
        {
            buyStock();
        }
        else if(choice.equals("sell"))
        {
            sellStock();
        }
        else if(choice.equals("search"))
        {
            searchStock();
        }
        else if(choice.equals("lowstock"))
        {
            lowStock();
        }
        else if(choice.equals("restock"))
        {
            reStock();
        }
        return false;
    }

    /**
     * Print out a menu of operation choices
     */
    private void printMenuChoices()
    {
        System.out.println();
        System.out.println(ANSI_GREEN_BACKGROUND + ANSI_RED +"    Add          :     Add a new product"+ANSI_RESET);
        System.out.println("    Remove       :     Remove an old product");
        System.out.println("    Buy          :     Buy new product");
        System.out.println("    Sell         :     Sell Product");
        System.out.println("    Search       :     Search Products");
        System.out.println("    Low stock    :     Low stock Products");
        System.out.println("    Re-stock     :     Re-stock Products");
        System.out.println("    Print        :     Print all products");
        System.out.println("    Quit         :     Quit the program");
        System.out.println();
    }

    /**
     * Print the title of the program and the authors name
     */
    private void printHeading()
    {
        System.out.println( ANSI_GREEN_BACKGROUND +"********************************"+ANSI_RESET);
        System.out.println(ANSI_GREEN_BACKGROUND + ANSI_RED + "  App21-04: Stock Application   "+ ANSI_RESET);
        System.out.println(ANSI_GREEN_BACKGROUND + ANSI_RED +"      by Sudath Nawagamuwage    "+ANSI_RESET);
        System.out.println(ANSI_GREEN_BACKGROUND +"********************************"+ANSI_RESET);
    }
}