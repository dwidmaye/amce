/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package acme.service;
import acme.domain.Account;
import acme.service.exception.InvalidAccountException;
import java.util.List;
import javax.jws.HandlerChain;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.DOCUMENT)
@HandlerChain(file="handler-chain.xml")
public interface GetBankAccountInformation {
    
    public Account getAccount(int accountNumber);
    public List<Account> getAllAccountsByType(String type) throws InvalidAccountException;
    
}
