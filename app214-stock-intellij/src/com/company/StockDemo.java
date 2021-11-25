package com.company;

import java.util.Random;
/**
 * Demonstrate the StockManager and Product classes.
 * The demonstration becomes properly functional as
 * the StockManager class is completed.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @modified by Sudath Nawagamuwage
 * @version 2021.11.10
 */
public class StockDemo
{
    // The stock manager.
    private StockList stock;
    
    private Random generator = new Random();

    /**
     * Create a StockManager and populate it with at least
     * 10 sample products.
     */
    public StockDemo(StockList stock)
    {
        this.stock = stock;
        
        // Add at least 10 products, they must be unique to you
        // Make sure the ids are sequential numbers
        
        stock.add(new Product(101, "Toshiba Satalite L50   "));
        stock.add(new Product(102, "Apple MacBook Air      "));
        stock.add(new Product(103, "HP 250 Pro             "));
        stock.add(new Product(104, "Asus TUF Dash F15C     "));
        stock.add(new Product(105, "Lenovo V14-ADA         "));
        stock.add(new Product(106, "Dell Inspiron 15       "));
        stock.add(new Product(107, "Medion Akoya           "));
        stock.add(new Product(108, "Huawei MateBook        "));
        stock.add(new Product(109, "Samsung Galaxy Book    "));
        stock.add(new Product(110, "Microsoft Surface Go   "));
    }
    
    /**
     * Provide a demonstration of how the ProductList meets all
     * the user requirements by making a delivery of each product 
     * buying it in various amounts and then selling each
     * product by various amounts. Make sure all the requirements
     * have been demonstrated.
     */
    public void runDemo()
    {
        // Show details of all of the products before delivery.
        
        stock.print();

        buyProducts();
        stock.print();        

        sellProducts();
        stock.print();        
    }
    
    /**
     * This method will buy different quantities of
     * each of the products in the stock list
     */
    private void buyProducts()
    {
        Product product;
        int quantity = 1;
        
        for(int id = 100; id <= 110; id++)
        {
           product = stock.findProduct(id);
           if(product == null)
           {
             System.out.println(" Product " + id + " " + "Not Found");
           }
           else
           {
               quantity = generator.nextInt(20);
               stock.buyProduct(id, quantity);
           }
        }
        
    }
    
    /**
     * This method will sell different quantities of
     * each of the products in the stock list
     */
    private void sellProducts()
    {
        Product product;
        int quantity = 1;
        
        for(int id = 101; id <= 110; id++)
        {
            product = stock.findProduct(id);
            if(product == null)
            {
                System.out.println(" Product " + id + " " + " Not Found");
            }
            else
            {
               quantity = generator.nextInt(20);
               stock.sellProduct(id, quantity);
            }
        }
    }    
}
   