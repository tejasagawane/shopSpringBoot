package com.stp.shop.service;

import com.stp.shop.domain.Product;
import com.stp.shop.exception.BadRequestException;
import com.stp.shop.repo.ShopRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ShopService {

    @Autowired
    ShopRepository shopRepository;

    public Optional<Product> getProductById(Long id) {
        return shopRepository.findById(id);
    }

    public List<Product> getAllProducts(){
        return shopRepository.findAll();
    }
    public Product addProduct(Product product){
        return shopRepository.save(product);
    }
    public List<Product> getAllSoldProducts(){
        return shopRepository.findByStatus("Sold");
    }

    public void addProducts(Product product) {
        List<Product> productList = new ArrayList<>();
        String quantityArr[] = product.getQuantity().split(",");
        int quantityIntArr[] = new int[quantityArr.length];
        for (int j = 0; j < quantityIntArr.length; j += 1)
            try {
                quantityIntArr[j] = Integer.parseInt(quantityArr[j]);
            } catch (Exception exception) {
                throw new BadRequestException(quantityArr[j] + " is not an int");
            }
        String sizeStr = product.getSize();
        String sizeArr[] = sizeStr.split(",");

        int sizeIntArr[] = new int[sizeArr.length];
        for (int j = 0; j < sizeIntArr.length; j += 1)
            try {
                sizeIntArr[j] = Integer.parseInt(sizeArr[j]);
            } catch (Exception exception) {
                throw new BadRequestException(sizeArr[j] + " is not an int");
            }
        if (quantityIntArr.length != sizeIntArr.length) {
            throw new BadRequestException("Size and Quantity does not match");
        }

        int count = sizeIntArr.length;
        for (int i = 0; i < count; i++) {    //size
            int loopQuantity = quantityIntArr[i];
            for (int j = 0; j < loopQuantity; j++) {
                Product updatedProduct = (Product) product.clone();
                updatedProduct.setSize(String.valueOf(sizeIntArr[i]));
                updatedProduct.setQuantity(String.valueOf("1"));
                productList.add(updatedProduct);
            }


        }
        shopRepository.saveAll(productList);
    }

    public Product getUpdateProductById(long id,Product product) {
       return shopRepository.findById(id)
               .map( productMap -> {
                    if( product.getSellingPrice() != 0 ) {
                        productMap.setSellingPrice(product.getSellingPrice());
                        productMap.setStatus("Sold");
                    }
                        return shopRepository.save(productMap);
               })
               .orElseGet(() -> {
                   return shopRepository.save(product);
               });


    }

    public void deleteProductById(long id) {
        shopRepository.deleteById(id);
    }
}
