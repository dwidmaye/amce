/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package acme.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Phone")
@Entity
@Table(name="PHONE")
public class Phone implements Serializable {
    
    private int id;
    private int npa;
    private int nxx;
    private int line;
    private Customer customer;
    
    @ManyToOne
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public int getNpa() {
        return npa;
    }

    public void setNpa(int npa) {
        this.npa = npa;
    }

    public int getNxx() {
        return nxx;
    }

    public void setNxx(int nxx) {
        this.nxx = nxx;
    }

    @Id
    @GeneratedValue
    @Column(name="id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
       
    
}
