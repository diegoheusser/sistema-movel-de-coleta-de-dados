package br.udesc.ceavi.custovida.resource;

import br.udesc.ceavi.custovida.model.Control;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author diego
 */
@Path("/person")
public class ControlResource {

    @Context
    UriInfo uriInfo;

    @Context
    Request request;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String respondAsReady() {
        return "Custo de Vida Web Service";
    }

    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Control> getListControls() {
        
        List<Control> controls = new ArrayList<>();
        
        return controls;
    }
}
