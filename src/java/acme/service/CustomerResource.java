/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package acme.service;

import acme.business.CustomerMgr;
import acme.domain.Address;
import acme.domain.Customer;
import acme.stubs.CustomersStub;
import java.io.IOException;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;
import javax.xml.bind.JAXBElement;

@Path("/customers")
@RequestScoped
public class CustomerResource {

    @Inject
    private CustomerMgr mgr;
  
    
    @Path("{id}")
    @GET
    public Response getCustomer(@PathParam("id") int id, @QueryParam("format") String format)  {
        if (format == null || "xml".equalsIgnoreCase(format)) {
            ResponseBuilder builder = Response.ok(mgr.read(id)).type(MediaType.APPLICATION_XML);
            return builder.build();
        } else if ("json".equalsIgnoreCase(format)) {
            ResponseBuilder builder = Response.ok(mgr.read(id)).type(MediaType.APPLICATION_JSON);
            return builder.build();
        } else {
            //MediaType[] supportedMedia = {MediaType.APPLICATION_XML_TYPE, MediaType.APPLICATION_JSON_TYPE};
            //return Response.notAcceptable(Variant.mediaTypes(supportedMedia).build()).build();          
            throw new WebApplicationException(Status.UNSUPPORTED_MEDIA_TYPE);
        }
    } 
    
    @Path("{id}.xml")
    @GET
    public Response getCustomerInXML(@PathParam("id") int id) {
        ResponseBuilder builder = Response.ok(mgr.read(id)).type(MediaType.APPLICATION_XML);
        return builder.build(); 
    }
    
    @Path("{id}.json")
    @GET
    public Response getCustomerInJSON(@PathParam("id") int id) {
        ResponseBuilder builder = Response.ok(mgr.read(id)).type(MediaType.APPLICATION_JSON);
        return builder.build(); 
    }    

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{id}")
    public Response getCustomer(@PathParam("id") int id) {
        System.err.println("=======================================");
        ResponseBuilder builder = Response.ok(mgr.read(id));
        return builder.build();
    }

    @GET
    @Produces("application/xml")
    public Response getAllCustomers() {
        System.err.println("=======================================");
        List<Customer> list = CustomersStub.getAllCustomers();
        GenericEntity entity = new GenericEntity<List<Customer>>(list) {};
        ResponseBuilder builder = Response.ok(entity);
        return builder.build();
    }

    @POST
    @Produces("application/xml")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response createCustomer(
            @FormParam("firstNmae") String firstName,
            @FormParam("lastName") String lastName,
            @FormParam("middleInitial") String middleInital,
            @FormParam("socialSecurityNumber") String ssn,
            @FormParam("number") String number,
            @FormParam("streetAddress1") String address1,
            @FormParam("zipCode") String zipCode,
            @FormParam("city") String city,
            @FormParam("state") String state) throws IOException {
        Customer cust = new Customer();
        cust.setFirstName(firstName);
        cust.setLastName(lastName);
        cust.setMiddleInitial(middleInital);
        cust.setSocialSecurityNumber(ssn);
        
        Address addr = new Address();
        addr.setNumber(number);
        addr.setStreetAddress1(address1);
        addr.setCity(city);
        addr.setZipCode(zipCode);
        addr.setState(state);
        
        cust.setAddress(addr);
        
        cust = mgr.create(cust);
        ResponseBuilder builder = Response.ok(cust);
        return builder.build();
    }

    @PUT
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response updateCustomer(JAXBElement<Customer> cust) {
        Customer c = cust.getValue();
        c = mgr.update(c);

        ResponseBuilder builder = Response.ok(cust);
        return builder.build();
    }

    @DELETE
    @Path("{id}")
    public void deleteCustomer(@PathParam("id") int id) {
        Customer c = mgr.read(id);
        mgr.delete(c);
    }    
}
