/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package acme.stubs;

import acme.domain.Account;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author derek
 */
public class AccountStub {
    
    public static Account getAccount(int accountNumber) {
        Account acct = new Account();
        acct.setAccountNumber(accountNumber);
        acct.setBalance(23425.90);
        acct.setType(Account.AccountTypes.CHECKING.toString());
                
        return acct;
    }
    
    public static List<Account> getAllAccountsByType(String type) {
        List<Account> checking = new ArrayList<Account>();
        List<Account> savings = new ArrayList<Account>();
        
        Account acct = new Account();
        acct.setAccountNumber(12345);
        acct.setBalance(23425.90);
        acct.setType(Account.AccountTypes.CHECKING.toString());
        checking.add(acct);
        
        Account acct1 = new Account();
        acct1.setAccountNumber(54321);
        acct1.setBalance(12420.90);
        acct1.setType(Account.AccountTypes.CHECKING.toString());
        checking.add(acct1);
        
        Account acct2 = new Account();
        acct2.setAccountNumber(89076);
        acct2.setBalance(178.90);
        acct2.setType(Account.AccountTypes.CHECKING.toString());
        checking.add(acct2); 
        
        Account acct3 = new Account();
        acct3.setAccountNumber(33455);
        acct3.setBalance(15520.90);
        acct3.setType(Account.AccountTypes.SAVINGS.toString());
        savings.add(acct3);
        
        Account acct4 = new Account();
        acct4.setAccountNumber(88996);
        acct4.setBalance(12378.90);
        acct4.setType(Account.AccountTypes.SAVINGS.toString());
        savings.add(acct4);      
        
        if("checking".equalsIgnoreCase(type)) {
            return checking;
        } else if("savings".equalsIgnoreCase(type)) {
           return savings;
        } else {
           return null;
        }
        
                
        
        
    }
    
}
