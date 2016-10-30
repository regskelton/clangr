package AdminService;

/*
 * Created by reg on 28/10/2016.
 */

import io.dropwizard.views.View;

public class ProjectView extends View {
    private final Project project;

    public ProjectView(Project p) {
        super("project.mustache");
        this.project= p;
    }

    public Project getProject() {
        return project;
    }
}
