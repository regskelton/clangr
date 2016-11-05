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

        projects.add(new Project("Gingerbread Baking", "Create twelve thousand gingerbread people"));
        projects.add(new Project("Car wash", "Clean the car using fairy liquid"));
        projects.add(new Project("Clean roof", "Get the ladders out and scrpae the mould out"));
        projects.add(new Project("Cook dinner", "Yum, roast chicken please"));
        projects.add(new Project("Book holiday", "Maybe combine with a Java course in Hania"));
        projects.add(new Project("Write code", "Combine with book a holiday?"));
        projects.add(new Project("Read book", "Anything by Neal Stephenson"));
        projects.add(new Project("Record an album", "Going to bigger than Alphaville"));

        projects.get(1).addRole(new Role("Project Manager", "Lead PM"));
    }


    @GET
    @Timed
    public ProjectsView getProjects(@QueryParam("contains") Optional<String> contains) {
        List<Project> output = new ArrayList<Project>();

        String query = contains.or("");

        for (Project p : projects) {
            if (p.getName().contains(query)) {
                output.add(p);
            }
        }

        return new ProjectsView(output);
    }


    @POST
    @Timed
    public ProjectsView postProject(@FormParam("name") Optional<String> nameParam,
                                    @FormParam("description") Optional<String> descriptionParam) {

        if (!nameParam.isPresent()) {
            throw new WebApplicationException("Name is required for a new project", 503);
        }

        if (!descriptionParam.isPresent()) {
            throw new WebApplicationException("Description is required for a new project", 503);
        }

        Project p = new Project(nameParam.get(), descriptionParam.get());

        projects.add(p);

        return new ProjectsView(projects);
    }

    @Path("/{id}")
    @Produces({MediaType.TEXT_HTML, MediaType.APPLICATION_JSON})
    @GET
    @Timed
    public ProjectView getProjectById(@PathParam("id") Optional<String> idParam) {

        String id = idParam.or("");

        for (Project p : projects) {
            System.out.println("Comparing [" + p.getId() + "] to [" + idParam + "]");

            if (p.getId().equals(id)) {
                return new ProjectView(p);
            }
        }

        throw new WebApplicationException(404);
    }
}