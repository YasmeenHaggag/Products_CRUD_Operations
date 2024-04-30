package com.admin.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product_details")
public class Product_details {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Temporal(TemporalType.DATE)
    @Column(name = "expiration_date")
    private Date expiration;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "price")
    private String price;

//    @Column(name = "availability")
//    private Boolean availability;

    @OneToOne(mappedBy="productDetails",cascade = CascadeType.ALL)
    Product product;

}
