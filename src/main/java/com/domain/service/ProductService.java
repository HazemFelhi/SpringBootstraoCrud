package com.domain.service;

import com.domain.entity.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    private static List<Product> products = new ArrayList<Product>(){
        {
            add (new Product(System.currentTimeMillis(), "001", "Product 0001", 1000));
            add (new Product(System.currentTimeMillis(), "002", "Product 0002", 2000));
            add (new Product(System.currentTimeMillis(), "003", "Product 0003", 3000));
            add (new Product(System.currentTimeMillis(), "004", "Product 0004", 4000));
            add (new Product(System.currentTimeMillis(), "005", "Product 0005", 5000));
        }
    };

    public  List<Product> findAll(){
        return products;
    }

    public void addProduct(Product product){
        product.setId(System.currentTimeMillis());
        products.add(product);
    }

}
