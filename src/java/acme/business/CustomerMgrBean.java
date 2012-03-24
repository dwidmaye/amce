
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package acme.business;

import acme.domain.Customer;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CustomerMgrBean implements CustomerMgr {

    @PersistenceContext(unitName="amcePU")
    EntityManager em;


    public Customer create(Customer cust) {
        em.persist(cust);
        return cust;
    }

    public Customer read(int id) {
        System.err.println("================ Inside EJB" + id);
        Customer cust = em.find(Customer.class, id);
        System.err.println("================ Inside EJB" + cust);
        return cust;
    }

    public Customer update(Customer cust) {
        return em.merge(cust);
    }

    public void delete(Customer cust) {
        em.remove(cust);
    }
}
