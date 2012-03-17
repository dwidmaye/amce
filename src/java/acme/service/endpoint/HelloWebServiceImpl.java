/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package acme.service.endpoint;

import javax.jws.WebService;

@WebService(endpointInterface = "acme.service.endpoint.HelloWebService")
public class HelloWebServiceImpl implements HelloWebService {

    @Override
    public String sayHello() {
        return "Hello World - From a Web Service!";
    }
    
}
