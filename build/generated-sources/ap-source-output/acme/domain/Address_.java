package acme.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.2.0.v20110202-r8913", date="2012-11-04T09:38:41")
@StaticMetamodel(Address.class)
public class Address_ { 

    public static volatile SingularAttribute<Address, Integer> id;
    public static volatile SingularAttribute<Address, String> streetAddress1;
    public static volatile SingularAttribute<Address, String> streetAddress2;
    public static volatile SingularAttribute<Address, String> zipCode;
    public static volatile SingularAttribute<Address, String> state;
    public static volatile SingularAttribute<Address, String> number;
    public static volatile SingularAttribute<Address, String> city;

}