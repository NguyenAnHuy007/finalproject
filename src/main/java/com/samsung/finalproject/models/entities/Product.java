package com.samsung.finalproject.models.entities;


import jakarta.persistence.*;
import lombok.Data;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String name;
    @Column(nullable = false)
    private double price;
    private String image;

    public String getFormattedPrice() {
        NumberFormat formatter = NumberFormat.getInstance(new Locale("vi", "VN"));
        return formatter.format(this.price) + "đ";
    }


    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Cart> carts;
}
