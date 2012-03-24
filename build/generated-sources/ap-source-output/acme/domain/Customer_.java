package acme.domain;

import acme.domain.Account;
import acme.domain.Address;
import acme.domain.Phone;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.2.0.v20110202-r8913", date="2012-03-18T09:27:53")
@StaticMetamodel(Customer.class)
public class Customer_ { 

    public static volatile SingularAttribute<Customer, Integer> id;
    public static volatile SingularAttribute<Customer, String> lastName;
    public static volatile ListAttribute<Customer, Account> accounts;
    public static volatile SingularAttribute<Customer, Address> address;
    public static volatile SingularAttribute<Customer, String> socialSecurityNumber;
    public static volatile SingularAttribute<Customer, String> middleInitial;
    public static volatile SingularAttribute<Customer, String> firstName;
    public static volatile ListAttribute<Customer, Phone> phones;

}