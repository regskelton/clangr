package AdminService;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/*
 * Created by reg on 02/11/2016.
 */
public class ProjectTest {
    @Test
    public void basicConstruction() throws Exception {
        String expectedId = "123.321";
        String expectedName = "Test project name";
        String expectedDescription = "Test project description";
        Project p = new Project(expectedId, expectedName, expectedDescription);

        assertEquals("Project id", expectedId, p.getId());
        assertEquals("Project name", expectedName, p.getName());
        assertEquals("Project description", expectedDescription, p.getDescription());
    }

    @Test
    public void addSingleRole() throws Exception {
        Project p = new Project();
        Role r = new Role();

        assertTrue("New project should be empty", p.getRoles().isEmpty());

        p.addRole(r);

        List<Role> roles = p.getRoles();

        assertEquals("Should be exactly 1 role added", 1, roles.size());
        assertEquals("Returned role is different to added", r, roles.get(0));
    }
}