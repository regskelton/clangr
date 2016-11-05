package AdminService;

/*
 * Created by reg on 28/10/2016.
 */

import io.dropwizard.views.View;

import java.util.List;

public class ProjectsView extends View {
    private final List<Project> projects;


    public ProjectsView(List<Project> projects) {
        super("projects.mustache");
        this.projects = projects;
    }

    public List<Project> getProjects() {
        return projects;
    }
}
