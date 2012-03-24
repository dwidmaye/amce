/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package acme.business;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;
import junit.framework.Assert;
import org.junit.Test;

@DataSourceDefinition(
  name="java:jdbc/acme1",
  className="com.mysql.jdbc.jdbc2.optional.MysqlDataSource",
  user="root",
  password="root",
  databaseName="acme1",
  serverName="localhost",
  portNumber=3306 ) 
public class CustomerMgrBeanTest {
    
    public CustomerMgrBeanTest() {}   

    @Test
    public void shouldReturnOneCustomer() {
        try {
            EJBContainer ec = EJBContainer.createEJBContainer();

            Context ctx = ec.getContext();
            CustomerMgr manager = (CustomerMgr)
                       ctx.lookup("java:global/classes/CustomerMgrBean!acme.business.CustomerMgr");
            Assert.assertNotNull(manager.read(153));
            ec.close();
        } catch (NamingException ex) {
            Assert.fail("Failed to find customer with id: 153");
            ex.printStackTrace();
            Logger.getLogger(CustomerMgrBeanTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
