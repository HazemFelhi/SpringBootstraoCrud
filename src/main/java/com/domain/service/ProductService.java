package com.domain.service;

import com.domain.entity.Product;
import com.domain.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepo repo;

    @Autowired
    private EmailService emailService;

    public  Iterable<Product> findAll(){
        return repo.findAll();
    }

    public void addProduct(Product product){
        emailService.sendSimpleMessage("gas@gmail.com", "Product Baru Ditambahkan",
                "Berhasil Tambah "+product.getName());
        repo.save(product);
    }

    public void deleteById(long id){
        repo.deleteById(id);
    }

    public Optional<Product> findById(long id){
        return repo.findById(id);
    }

    public void update(Product product){
        repo.save(product);
    }

    public List<Product> findByName(String keyword){
        return repo.findByNameContains(keyword);
    }



}
