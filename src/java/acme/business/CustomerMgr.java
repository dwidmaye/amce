/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package acme.business;

import acme.domain.Customer;

public interface CustomerMgr {
    public Customer create(Customer cust);
    public Customer read(int id);
    public Customer update(Customer cust);
    public void delete(Customer cust);   
}
