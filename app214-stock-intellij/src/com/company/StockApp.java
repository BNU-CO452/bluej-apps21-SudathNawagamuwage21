package com.company;

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

    //private StockDemo stockDemo;



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

    private void addProduct()
    {
        System.out.println("adding a new product");
        System.out.println();

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
            System.out.println("The ID already existing");
        }

    }

    private void removeProduct()
    {
        System.out.println("Removing the product");
        System.out.println();

        int id = reader.getInt("Please enter a product id>");
        Product search = stock.findProduct(id);
        if (search == null)
        {
            stock.remove(id);
        }
        else
        {
            System.out.println("non-existing ID");
        }
    }

    private void buyStock()
    {
        System.out.println("buying a new products");
        System.out.println();

        int id = reader.getInt("Please enter a product id>");
        int amount = reader.getInt("Please enter the quantity>");

        stock.buyProduct(id, amount);

        System.out.println("Product ID "+ id + " Stock increased by " + amount);
    }

    private void sellStock()
    {
        System.out.println("buying a new products");
        System.out.println();

        int id = reader.getInt("Please enter a product id>");
        int amount = reader.getInt("Please enter the quantity>");

        stock.sellProduct(id, amount);

        System.out.println("Product ID "+ id + " Stock decreased by " + amount);
    }

    private void searchStock()

    {
        System.out.println("search a new products");
        System.out.println();

        String name = reader.getString("please enter a product name>");

        stock.searchProduct(name);
    }

    private void reStock()
    {
       // int amount = reader.getInt("");

       // {
          //  if ( stock.numberInStock() <=1  ) {
                stock.reStock();
          // }
       // }

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
            stock.lowStockLevel();
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
        System.out.println("    Add Product         :     Add a new product");
        System.out.println("    Remove Product      :     Remove an old product");
        System.out.println("    Buy Product         :     Buy new product");
        System.out.println("    Sell Product        :     Sell Product");
        System.out.println("    Search Products     :     Search Products");
        System.out.println("    Low stock Products  :     Low stock Products");
        System.out.println("    Re-stock Products   :     Re-stock Products");
        System.out.println("    Print               :     Print all products");
        System.out.println("    Quit                :     Quit the program");
        System.out.println();
    }

    /**
     * Print the title of the program and the authors name
     */
    private void printHeading()
    {
        System.out.println("********************************");
        System.out.println("  App21-04: Stock Application ");
        System.out.println("      by Sudath Nawagamuwage");
        System.out.println("********************************");
    }
}