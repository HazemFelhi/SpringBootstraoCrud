package com.domain.service;

import com.domain.entity.Product;
import com.domain.utils.RandomNumber;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private static List<Product> products = new ArrayList<Product>(){
        {
            add (new Product(RandomNumber.getRandom(1000, 9999), "001", "Product 0001", 1000));
            add (new Product(RandomNumber.getRandom(1000, 9999), "002", "Product 0002", 2000));
            add (new Product(RandomNumber.getRandom(1000, 9999), "003", "Product 0003", 3000));
            add (new Product(RandomNumber.getRandom(1000, 9999), "004", "Product 0004", 4000));
            add (new Product(RandomNumber.getRandom(1000, 9999), "005", "Product 0005", 5000));
        }
    };

    public  List<Product> findAll(){
        return products;
    }

    public void addProduct(Product product){
        product.setId(RandomNumber.getRandom(1000, 9999));
        products.add(product);
    }

    public void deleteById(long id){
        products.removeIf(p -> p.getId()==id);
    }

    public Optional<Product> findById(long id){
        return products.stream().filter(p -> p.getId() ==id).findFirst();
    }

    public void update(Product product){
        deleteById(product.getId());
        products.add(product);
    }

}
