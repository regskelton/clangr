package AdminService;/*
 * Created by reg on 02/11/2016.
 */

public class Role extends IdNameDescription {
    public Role() {
    }

    public Role(String id, String name, String description) {
        super(id, name, description);
    }

    public Role(String name, String description) {
        super(name, description);
    }
}
