package com.stp.shop.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private long id;
    @Column(nullable = false)
    private String productArticle;
    @Column(nullable = false)
    private String size;
    @Column(nullable = false)
    private long marketRatePrice;
    @Column(nullable = false)
    private long costOfPrice;
    private long sellingPrice;
    @Column(nullable = false)
    private String brand;
    @Column(nullable = false)
    private String color;
    @Column(nullable = false)
    private String category;
    @Column(nullable = false)
    private String stakeHolder;
    private long gst;
    @Column(nullable = false)
    private String status;
    @Column(name = "entry_date")
    private LocalDate entryDate;
    @Column(name = "selling_date")
    private LocalDate sellingDate;
    private String quantity;

    @Override
    public Object clone() {
        try {
            return (Product) super.clone();
        } catch (CloneNotSupportedException e) {
            return new Product(this.id,this.productArticle, this.size, this.marketRatePrice,this.costOfPrice,
                    this.sellingPrice,this.brand,this.color,this.category,this.stakeHolder,
                    this.gst,this.status,this.entryDate,this.sellingDate,this.quantity);
        }
    }


}
