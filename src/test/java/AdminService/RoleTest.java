package AdminService;

import org.junit.Test;

import static org.junit.Assert.assertFalse;

/*
 * Created by reg on 02/11/2016.
 */
public class RoleTest {

    @Test
    public void generateId() throws Exception {
        Role r1 = new Role("test name", "test description");
        Role r2 = new Role("test name", "test description");

        String id1 = r1.getId();
        String id2 = r2.getId();

        assertFalse("Ids should be different [" + id1 + "],[" + id2 + "]",
                id2.equals(id1));
    }

}