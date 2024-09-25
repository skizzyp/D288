package com.example.demo.services;

import com.example.demo.dao.CartRepository;
import com.example.demo.entity.Cart;
import com.example.demo.entity.CartItem;
import com.example.demo.entity.Customer;
import com.example.demo.entity.Status;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService{


    private final CartRepository cartRepository;

    @Autowired
    public CheckoutServiceImpl(CartRepository cartRepository) {

        this.cartRepository = cartRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {
        //retrieve cart info from dto
        Cart cart = purchase.getCart();
        Customer customer = purchase.getCustomer();
        String orderTrackingNumber = generateOrderTrackingNumber();

        //populate cart with cart items
        Set<CartItem> cartItems = purchase.getCartItems();
        cartItems.forEach(item -> {
            item.setCart(cart);
            cart.addItem(item);

        });

        //check if cart is empty or party size is less than 1 and return error
        if(cart.getCartItems().isEmpty()) {
            orderTrackingNumber = "No cart items!";
        } else if (cart.getParty_size() < 1) {
            orderTrackingNumber = "Party size must be 1 or greater!";
        } else {


            //generate tracking number, set status to 'ordered'
            cart.setOrderTrackingNumber(orderTrackingNumber);
            cart.setStatus(Status.ordered);
            cart.setCustomer(customer);



            //save to database
            cartRepository.save(cart);
        }

        //return response
        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {

        //generate random UUID
        return UUID.randomUUID().toString();
    }
}
