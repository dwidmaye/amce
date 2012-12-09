package acme.domain;

import acme.domain.Customer;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.2.0.v20110202-r8913", date="2012-11-04T09:38:41")
@StaticMetamodel(Phone.class)
public class Phone_ { 

    public static volatile SingularAttribute<Phone, Integer> id;
    public static volatile SingularAttribute<Phone, Integer> line;
    public static volatile SingularAttribute<Phone, Integer> nxx;
    public static volatile SingularAttribute<Phone, Customer> customer;
    public static volatile SingularAttribute<Phone, Integer> npa;

}