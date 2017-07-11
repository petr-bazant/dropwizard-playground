package MyWebAPI_Package.resources;

import MyWebAPI_Package.security.Token;
import MyWebAPI_Package.security.TokenParam;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import MyWebAPI_Package.core.User;


@Path("/secret")
@Produces(MediaType.APPLICATION_JSON)
public class SecretResource {
      
    public SecretResource() { }

    @GET
    @Timed
    public Response sayHello(@TokenParam Token token, User user) {

        Response r = Response.status(200).header(("X-TEST"), "secret").build();
        final String name = user.getName();
        return r;
    }
}