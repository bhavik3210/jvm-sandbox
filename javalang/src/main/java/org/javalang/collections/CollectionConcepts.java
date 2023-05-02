package org.javalang.collections;


import org.javalang.model.Product;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionConcepts
{
    public static void main(String[] args)
    {
        var door = new Product("Wooden Door", 35);
        var floorPanel = new Product("Floor Panel", 25);
        var window = new Product("Glass Window", 10);

        Collection<Product> products = new ArrayList<>();
        products.add(door);
        products.add(floorPanel);
        products.add(window);

       // need to go over each type that was cover in Collection Behaviors Demo

        var toRemove = new ArrayList<Product>();
        toRemove.add(door);
        toRemove.add(floorPanel);

        products.removeAll(toRemove);
        System.out.println(products);
    }
}
