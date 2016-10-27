package TasklistService;

import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;


/**
 * Created by reg on 02/10/2016.
 */
@Path("/projects")
@Produces(MediaType.APPLICATION_JSON)
public class ProjectResource {
    private final List<Project> projects;

    //SLF4J is provided with dropwizard. Logback is also provided
    Logger log = LoggerFactory.getLogger(ProjectResource.class);

    public ProjectResource(int maxLength) {
        projects = new ArrayList<>();
    }

    @GET
    @Timed
    public List<Project> listProjects(@QueryParam("contains") Optional<String> contains) {
        List<Project> output = new ArrayList<Project>();

        String query = contains.or("");

        for (Project p : projects) {
            if (p.getName().contains(query)) {
                output.add(p);
            }
        }

        return output;
    }
}