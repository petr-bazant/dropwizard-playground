package MyWebAPI_Package.resources;

import MyWebAPI_Package.security.Token;
import MyWebAPI_Package.security.CustomAuth;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import MyWebAPI_Package.core.User;
import io.dropwizard.auth.Auth;


@Path("/secret")
@Produces(MediaType.APPLICATION_JSON)
public class SecretResource {
      
    public SecretResource() { }

    @GET
    @Timed
    public Response sayHello(@Auth User user /*@Context SecurityContext context*/) {

        Response r = Response.status(200).header(("X-TEST"), user.getName()).build();
        return r;
    }
}