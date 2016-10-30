package AdminService;

import AdminService.health.AdminHealth;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;

public class AdminServiceApplication extends Application<AdminServiceConfiguration> {

    public static void main(String[] args) throws Exception {
        new AdminServiceApplication().run(args);
    }

    @Override
    public String getName() {
        return "AdminService";
    }

    @Override
    public void initialize(Bootstrap<AdminServiceConfiguration> bootstrap) {
        bootstrap.addBundle(new ViewBundle());
    }

    @Override
    public void run(AdminServiceConfiguration configuration, Environment environment) {
        // register resource now
        final ProjectResource resource = new ProjectResource();

        final AdminHealth healthCheck = new AdminHealth(123);
        environment.healthChecks().register("admin", healthCheck);
        environment.jersey().register(resource);
    }
}
