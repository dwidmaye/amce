/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package acme.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Customer")
@Entity
@Table(name="CUSTOMER")
public class Customer implements Serializable {
    
    private int id;
    private String firstName;
    private String lastName;
    private String middleInitial;
    private String socialSecurityNumber;
    private Address address;
    private List<Phone> phones;
    private List<Account> accounts;
    
    @OneToMany (cascade={CascadeType.ALL})
    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }   

    @OneToMany (cascade={CascadeType.ALL})
    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    @OneToOne(cascade={CascadeType.ALL})
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    @Override
    public String toString() {
        return "Customer{" + "firstName=" + firstName + ", lastName=" + lastName + ", middleInitial=" + middleInitial + ", socialSecurityNumber=" + socialSecurityNumber + ", address=" + address + ", accounts=" + accounts + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Customer other = (Customer) obj;
        if ((this.socialSecurityNumber == null) ? (other.socialSecurityNumber != null) : !this.socialSecurityNumber.equals(other.socialSecurityNumber)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + (this.socialSecurityNumber != null ? this.socialSecurityNumber.hashCode() : 0);
        return hash;
    }
    
    @Id
    @GeneratedValue
    @Column(name="ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
}
