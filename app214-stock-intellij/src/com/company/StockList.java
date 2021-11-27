package com.company;

import java.util.ArrayList;



/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 * @modified by Sudath Nawagamuwage 
 * @version 2021.11.10
 */
public class StockList
{
    // A list of the products.
    private ArrayList<Product> stock;
        
    /**
     * Initialise the stock manager.
     */
    public StockList()
    {
        stock = new ArrayList<Product>();
    }

    /**
     * Add a product to the list.
     * @param item The product item to be added.
     */
    public void add(Product item)
    {
        stock.add(item);
    }
    
    /**
     * A method to buy a single quantity of the product
     */
    public void buyProduct(int productID)
    {
        buyProduct(productID, 1);
    }
        
    /**
     * Find a product to match the product id,
     * if not found return null
     */
    public Product findProduct(int productID)
    {
        for(Product product : stock)        
        {
            if(product.getID() == productID)
            {
                return product;
            }
        }
        return null;
    }
    
    /**
     * Buy a quantity of a particular product.
     * Increase the quantity of the product by the given amount.
     * @paramid The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void buyProduct(int productID, int amount)
    {
        //printBoughtProduct();
        
        Product product = findProduct(productID);
        
        if(product == null) 
        {
           // printout message
           System.out.println(product + " Not Found ");
        }
        else
        {
                // printout message
                product.increaseQuantity(amount);
                System.out.println("Bought " + amount + " of " + product.getName());
        }
    }
    
    /**
     * Sell one of the given product.
     * Show the before and after status of the product.
     * @paramid The ID of the product being sold.
     */
    public void sellProduct(int productID, int sellQuantity)
    {
        Product product = findProduct(productID);
        
        //printSoldProduct();

        if(product != null) 
        {
            if(product.getQuantity() > 0 && product.getQuantity() >= sellQuantity)
            {
                product.decreaseQuantity(sellQuantity);
                // printout message
                System.out.println("Sold " + sellQuantity + " of " + product.getName());
            }
            else if(product.getQuantity() <= sellQuantity)
            {
                System.out.println(product.getName() + " You can't sell " + sellQuantity + " you have only " + product.getQuantity());
            }
            else
            {
                // printout message
                System.out.println(product.getName() + " is out of stock");
            }
        }
        else
        {
            // printout message
            System.out.println("It is not sold at this location");
        }
    }  
     
    /**
     * This metthod will find the product 
     * and remove the product.
     * @param
     * @param ProductID
     */
    public void remove(int ProductID)
    {
        Product product = findProduct(ProductID);
        if(product != null) 
        {

            stock.remove(product);
            System.out.println("Product " + product.getID()
              + " : "+product.getName()+ " : " + "product has been removed");

        }
        else
        {
            System.out.println("Invalid Product ID ");
        }
    }
    
    /**
     * This method will search the product 
     * by name print in out
     */    
    public void searchProduct(String phrase)
    {
        printSearchStock();
        
        for(Product product : stock)
        {
            if(product.getName().contains(phrase))
            {
                System.out.println(product);
            }
        }
    }
    
    /**
     * This method will show the product has 
     * stock level below 5
     */    
    public void lowStockLevel()
    {
        printLowStock();
        
        for(Product product : stock)
        {
            if(product.getQuantity() <= 5)
            {
                System.out.println(product);
            }
        }
    }
    public void reStock()
    {
        for(Product product : stock)
        {
            if(product.getQuantity() <= 5)
            {
                int id = product.getID();
                buyProduct(id, product.getQuantity());
                System.out.println(product);
            }
        }
    }
    /**
     * Locate a product with the given ID, and return how
     * many of this item are in stock. If the ID does not
     * match any product, return zero.
     * @paramid The ID of the product.
     * @return The quantity of the given product in stock.
     */
    public int numberInStock(int productID)
    {
       return 0;
    }

    /**
     * Print details of the given product. If found,
     * its name and stock quantity will be shown.
     * @paramid The ID of the product to look for.
     */
    public void printProduct(int productID)
    {
        Product product = findProduct(productID);
        
        if(product != null) 
        {
            System.out.println(product.toString());
        }
    }
    
    /**
     * Print out each product in the stock
     * in the order they are in the stock list
     */
    public void print()
    {
        printHeading();
        
        for(Product product : stock)
        {
            System.out.println(product);
        }

        System.out.println();
    }
    
    public void printHeading()
    {
        System.out.println();
        System.out.println(" Sudath's Computer Shop Stock List ");
        System.out.println(" ================================== ");
        System.out.println();
    }
    
        public void printSearchStock()
    {
        System.out.println();
        System.out.println(" Sudath's Computer Shop Search Items Found ");
        System.out.println(" ========================================= ");
        System.out.println();
    }
    
    public void printLowStock()
    {
        System.out.println();
        System.out.println(" Sudath's Computer Shop Low Stock Items ");
        System.out.println(" ======================================== ");
        System.out.println();
    }
}