package br.udesc.ceavi.custovida.resource;

import br.udesc.ceavi.custovida.model.Researcher;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author diego
 */
@Path("/researcher")
public class ResearcherResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String respondAsReady() {
        List<Researcher> researchers;
        try {
            researchers = Researcher.seekAll();
        } catch (Exception ex) {
            researchers = new ArrayList<>();
        }

        return researchers.toString();
    }

    @GET
    @Path("seekall")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Researcher> seekAll() {

        List<Researcher> researchers;
        try {
            researchers = Researcher.seekAll();
        } catch (Exception ex) {
            researchers = new ArrayList<>();
        }

        return researchers;
    }
}
