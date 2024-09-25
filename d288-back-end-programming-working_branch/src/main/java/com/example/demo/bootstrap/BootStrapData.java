package com.example.demo.bootstrap;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.dao.DivisionRepository;
import com.example.demo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;

@Component
public class BootStrapData implements CommandLineRunner {

    @Autowired
    private final CustomerRepository customerRepository;
    @Autowired
    private final DivisionRepository divisionRepository;

    public BootStrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository) {
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }

    @Override
    public void run(String...args) throws Exception {

        //add sample data if it is not already stored
        //takes into account initial customer already in DB
        if(customerRepository.count() == 1) {
            // set sample customer data

            Customer customer1 = new Customer();
            customer1.setFirstName("Joe");
            customer1.setLastName("Johnson");
            customer1.setAddress("515 E Main st.");
            //division can not be set directly as it is of type-division
            customer1.setDivision(divisionRepository.findAll().get(2));
            customer1.setPostal_code("88001");
            customer1.setPhone("50551224512");
            //sets current date to creation and last update
            customer1.setLastUpdate(new Date());
            customer1.setCreate_date(new Date());

            customerRepository.save(customer1);


            Customer customer2 = new Customer();
            customer2.setFirstName("Ben");
            customer2.setLastName("Brunswick");
            customer2.setAddress("44 S Tarrington Way");
            //division can not be set directly as it is of type-division
            customer2.setDivision(divisionRepository.findAll().get(13));
            customer2.setPostal_code("21578");
            customer2.setPhone("9896523455");
            customer2.setLastUpdate(new Date());
            customer2.setCreate_date(new Date());

            customerRepository.save(customer2);

            Customer customer3 = new Customer();
            customer3.setFirstName("Shawn");
            customer3.setLastName("Roberts");
            customer3.setAddress("12 Whitehouse rd.");
            //division can not be set directly as it is of type-division
            customer3.setDivision(divisionRepository.findAll().get(36));
            customer3.setPostal_code("01254");
            customer3.setPhone("5968966632");
            customer3.setLastUpdate(new Date());
            customer3.setCreate_date(new Date());

            customerRepository.save(customer3);

            Customer customer4 = new Customer();
            customer4.setFirstName("Paul");
            customer4.setLastName("Redd");
            customer4.setAddress("2361 Random street");
            //division can not be set directly as it is of type-division
            customer4.setDivision(divisionRepository.findAll().get(22));
            customer4.setPostal_code("65984");
            customer4.setPhone("3856325698");
            customer4.setLastUpdate(new Date());
            customer4.setCreate_date(new Date());

            customerRepository.save(customer4);

            Customer customer5 = new Customer();
            customer5.setFirstName("Scotty");
            customer5.setLastName("Brown");
            customer5.setAddress("500 W 4th st.");
            //division can not be set directly as it is of type-division
            customer5.setDivision(divisionRepository.findAll().get(15));
            customer5.setPostal_code("78744");
            customer5.setPhone("2156325698");
            customer5.setLastUpdate(new Date());
            customer5.setCreate_date(new Date());

            customerRepository.save(customer5);

        }
    }
}
