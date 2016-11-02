package AdminService;

import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by reg on 02/10/2016.
 */
@Path("/projects")
@Produces({MediaType.TEXT_HTML, MediaType.APPLICATION_JSON})
public class ProjectResource {
    private final List<Project> projects;

    //SLF4J is provided with dropwizard. Logback is also provided
    Logger log = LoggerFactory.getLogger(ProjectResource.class);

    public ProjectResource() {
        projects = new ArrayList<>();

        projects.add( new Project( "123.2", "Gingerbread Baking", "Create twelve thousand gingerbread people"));
        projects.add( new Project( "143.2", "Car wash", "Clean the car using fairy liquid"));
        projects.add( new Project( "133.2", "Clean roof", "Get the ladders out and scrpae the mould out"));
        projects.add( new Project( "126.2", "Cook dinner", "Yum, roast chicken please"));
        projects.add( new Project( "121.2", "Book holiday", "Maybe combine with a Java course in Hania"));
        projects.add( new Project( "124.2", "Write code", "Combine with book a holiday?"));
        projects.add( new Project( "127.2", "Read book", "Anything by Neal Stephenson"));
        projects.add( new Project( "123.9", "Record an album", "Going to bigger than Alphaville"));

    }


    @GET
    @Timed
    public List<Project> getProjects(@QueryParam("contains") Optional<String> contains) {
        List<Project> output = new ArrayList<Project>();

        String query = contains.or("");

        for (Project p : projects) {
            if (p.getName().contains(query)) {
                output.add(p);
            }
        }

        return output;
    }

    @Path("/{id}")
    @Produces({MediaType.TEXT_HTML, MediaType.APPLICATION_JSON})
    @GET
    @Timed
    public ProjectView getProjectById(@PathParam("id") Optional<String> idParam) {

        String id= idParam.or("");

        for (Project p : projects) {
            System.out.println("Comparing [" + p.getId() + "] to [" + idParam + "]");

            if (p.getId().equals(id)) {
                return new ProjectView(p);
            }
        }

        throw new WebApplicationException(404);
    }
}