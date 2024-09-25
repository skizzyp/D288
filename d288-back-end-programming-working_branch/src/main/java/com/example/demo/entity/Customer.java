package com.example.demo.entity;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="customers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="customer_id", nullable = false)
    private Long id;

    @Column(name="address", nullable = false)
    private String address;

    @Column(name="create_date", updatable = false)
    @CreationTimestamp
    private Date create_date;

    @Column(name="customer_first_name", nullable = false)
    private String firstName;

    @Column(name="customer_last_name", nullable = false)
    private String lastName;

    @Column(name="last_update")
    @LastModifiedDate
    private Date lastUpdate;

    @Column(name="phone", nullable = false)
    private String phone;

    @Column(name="postal_code", nullable = false)
    private String postal_code;

    @ManyToOne
    @JoinColumn(name = "division_id", nullable = false, updatable = false)
    private Division division;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Cart> carts = new HashSet<>();


    //public void addCart(Cart cart) {
     //   this.carts.add(cart);
   // }
}
