/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package acme.business;

import acme.domain.Customer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.ManagedBean;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

@ManagedBean
public class CustomerMgrBean implements CustomerMgr {
    
    @PersistenceContext
    @PersistenceUnit
    EntityManagerFactory emf;
    EntityManager em;
    @Resource
    UserTransaction utx;
    
    public Customer create(Customer cust) {
        System.err.println(cust.toString());
        em = emf.createEntityManager();
        try {
            utx.begin();
            em.persist(cust);
            utx.commit();
        } catch (Exception e) {
           Logger.getLogger(
                   CustomerMgrBean.class.getName()).log(Level.SEVERE, null, e);
            try {
                utx.rollback();
            } catch (IllegalStateException ex) {
                Logger.getLogger(
                  CustomerMgrBean.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SecurityException ex) {
                Logger.getLogger(
                  CustomerMgrBean.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SystemException ex) {
                Logger.getLogger(
                  CustomerMgrBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return cust;
    }
    
    public Customer read(int id){
        em = emf.createEntityManager();
        Customer cust = em.find(Customer.class, id);
        return cust;
    }
    public Customer update(Customer cust){
        em = emf.createEntityManager();
        return em.merge(cust);
    }
    public void delete(Customer cust){
        em = emf.createEntityManager();
        em.remove(cust);
    }
     
}
