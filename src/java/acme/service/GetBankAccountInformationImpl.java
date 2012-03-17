package acme.service;

import acme.domain.Account;
import acme.service.exception.InvalidAccountException;
import acme.stubs.AccountStub;
import java.util.List;
import javax.jws.WebService;

@WebService(endpointInterface = "acme.service.GetBankAccountInformation")
public class GetBankAccountInformationImpl implements GetBankAccountInformation {

    @Override
    public Account getAccount(int accountNumber) {
        return AccountStub.getAccount(accountNumber);
    }

    @Override
    public List<Account> getAllAccountsByType(String type) throws InvalidAccountException {
        List<Account> accounts = AccountStub.getAllAccountsByType(type);
        if(accounts == null) throw new InvalidAccountException("Account type is not recognized", type);        
        
        return accounts;
    }
    
}
