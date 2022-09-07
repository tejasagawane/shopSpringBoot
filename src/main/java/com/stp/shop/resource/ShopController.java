package com.stp.shop.resource;

import com.stp.shop.domain.Brand;
import com.stp.shop.domain.Product;
import com.stp.shop.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("api/v1/shop")
public class ShopController {

    @Autowired
    ShopService shopService;

    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable Long id) {
        return shopService.getProductById(id);
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product){
        return shopService.addProduct(product);
    }

    @PostMapping("/add")
    public void addProducts(@RequestBody Product product){
         shopService.addProducts(product);
    }

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return shopService.getAllProducts();
    }

    @GetMapping("/soldProducts")
    public List<Product> getAllSoldProducts(){
        return shopService.getAllSoldProducts();
    }

    @PutMapping("/products/{id}")
    public Product getAllProducts(@PathVariable long id, @RequestBody Product product){
        return shopService.getUpdateProductById(id,product);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable long id){
        shopService.deleteProductById(id);
    }

}
