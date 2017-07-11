package MyWebAPI_Package.resources;

import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



@Path("/info")
@Produces(MediaType.APPLICATION_JSON)
public class InfoResource {

    private final String verze;
    
    public InfoResource(String verze) {
        this.verze = verze;
    }

    @GET
    @Timed
    public Response sayHello() {
        Response r = Response.status(200).header(("X-TEST"), "test " + this.verze).build();
        return r;
    }
}