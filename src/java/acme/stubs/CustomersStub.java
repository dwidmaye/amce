/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package acme.stubs;

import acme.domain.Address;
import acme.domain.Customer;
import java.util.ArrayList;
import java.util.List;

public class CustomersStub {
    
    public static Customer getCustomer(int id) {
        Customer customer = new Customer();
        customer.setId(new Integer(id));
        customer.setFirstName("John");
        customer.setLastName("Doe");
        
        Address address = new Address();
        address.setNumber("123");
        address.setStreetAddress1("Main Street");
        address.setState("CO");
        address.setZipCode("12345");
        
        //customer.setAddress(address);
        //customer.setAccounts(AccountStub.getAllAccountsByType("checking"));
        
        return customer;
        
    }
    
    public static List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<Customer>();
        for(int i = 0;  i<10; i++ ) {
            customers.add(getCustomer(i));
        }
        
        return customers;
    }

    public CustomersStub() {
    }
    
}
