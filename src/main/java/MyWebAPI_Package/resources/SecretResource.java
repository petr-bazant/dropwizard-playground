package MyWebAPI_Package.resources;

import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import io.dropwizard.auth.Auth;
import javax.annotation.security.RolesAllowed;
import MyWebAPI_Package.auth.User;


@Path("/secret")
@Produces(MediaType.APPLICATION_JSON)
public class SecretResource {
      
    public SecretResource() { }

    @RolesAllowed({ "ADMIN" })
    @GET
    @Timed
    public Response sayHello(@Auth User user) {
        Response r = Response.status(200).header(("X-TEST"), "secret").build();
        return r;
    }
}