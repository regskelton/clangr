package AdminService;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/*
 * Created by reg on 26/10/2016.
 */
public class Project extends IdNameDescription {
    private List<Role> roles = new ArrayList<>();

    public Project() {
    }

    public Project(String id, String name, String description) {
        super(id, name, description);
    }

    public Project(String name, String description) {
        super(name, description);
    }

    @JsonProperty
    public List<Role> getRoles() {
        return roles;
    }

    public void addRole(Role r) {
        roles.add(r);
    }
}
