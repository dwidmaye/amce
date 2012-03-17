/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package acme.service;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;


@Path("helloworld")
public class HelloworldResource {

    public HelloworldResource() {
    }

    @GET
    @Produces("text/html")
    public String getHtml() {
        return "<html lang=\"en\"><body><h1>Hello World!</body></h1></html>";
    }

}
