package com.stp.shop.service;

import com.stp.shop.domain.Product;
import com.stp.shop.repo.ShopRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ShopServiceTest {

    @Mock
    ShopRepository shopRepository;

    @Autowired
    ShopService shopService;

    @Mock
    Product product;

    @BeforeEach
    void setUp() {
        shopService = new ShopService(shopRepository);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getProductById() {
        shopService.getProductById(product.getId());
        verify(shopRepository).findById(product.getId());
    }

    @Test
    void getAllProducts() {
        shopService.getAllProducts();
        verify(shopRepository).findAll();
    }

    @Test
    void addProduct() {
        shopService.addProduct(product);
        verify(shopRepository).save(product);
    }
}