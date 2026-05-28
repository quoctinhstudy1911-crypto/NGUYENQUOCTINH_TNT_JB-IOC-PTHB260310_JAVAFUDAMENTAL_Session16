package com.stu.exercise1.service;

import com.stu.exercise1.entity.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductService {

    private final Map<Integer, Product> products = new HashMap<>();

    public boolean save(Product product)
    {
        if(products.containsKey(product.getId()))
        {
            return false;
        }

        products.put(product.getId(), product);
        return true;
    }

    public boolean update(Product product) {
        if (!products.containsKey(product.getId())) {
            return false;

    }
        products.put( product.getId(), product );
        return true;
    }

    public boolean deleteById(int id)
    {
        return products.remove(id) != null;
    }

    public void displayProduct()
    {
        products.forEach((integer, product) -> System.out.println(product));
    }

    public Map<Integer,Product> filterPrice()
    {
        return products.entrySet().stream()
                .filter(integerProductEntry -> integerProductEntry.getValue().getPrice() > 100   )
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue
                ));
    }
    public double SumProduct()
    {
        return products.values().stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }


}
