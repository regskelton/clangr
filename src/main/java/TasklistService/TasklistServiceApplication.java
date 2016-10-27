package TasklistService;

import TasklistService.health.TasklistHealth;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class TasklistServiceApplication extends Application<TasklistServiceConfiguration> {

    public static void main(String[] args) throws Exception {
        new TasklistServiceApplication().run(args);
    }

    @Override
    public String getName() {
        return "TasklistService";
    }

    @Override
    public void initialize(Bootstrap<TasklistServiceConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(TasklistServiceConfiguration configuration,
                    Environment environment) {
        // register resource now
        final TasklistResource resource = new TasklistResource(
                configuration.getMaxLength()
        );

        final TasklistHealth healthCheck =
                new TasklistHealth(configuration.getMaxLength());
        environment.healthChecks().register("tasklist", healthCheck);
        environment.jersey().register(resource);
    }
}
