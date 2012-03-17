package acme.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.2.0.v20110202-r8913", date="2012-03-14T18:14:33")
@StaticMetamodel(Account.class)
public class Account_ { 

    public static volatile SingularAttribute<Account, Integer> id;
    public static volatile SingularAttribute<Account, Double> balance;
    public static volatile SingularAttribute<Account, Integer> accountNumber;
    public static volatile SingularAttribute<Account, String> type;

}