package com.example.demo.entity;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="excursions")
@Getter
@Setter
public class Excursion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="excursion_id", nullable = false, updatable = false)
    private Long id;

    @Column(name="create_date")
    @CreationTimestamp
    private Date create_date;

    @Column(name="excursion_price")
    private BigDecimal excursion_price;

    @Column(name="excursion_title")
    private String excursion_title;

    @Column(name="image_url")
    private String image_URL;

    @Column(name="last_update")
    @UpdateTimestamp
    private Date last_update;


    @ManyToMany(mappedBy = "excursions")
    private Set<CartItem> cartItems;

    @ManyToOne
    @JoinColumn(name="vacation_id")
    private Vacation vacation;

}
