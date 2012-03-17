/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package acme.service.endpoint;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface HelloWebService {
    @WebMethod String sayHello();
    
}
