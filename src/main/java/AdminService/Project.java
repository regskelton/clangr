package AdminService;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/*
 * Created by reg on 26/10/2016.
 */
public class Project {
    private String id;
    private String name;
    private String description;
    private List<Role> roles = new ArrayList<>();

    public Project() {
        // Jackson deserialization
    }

    public Project(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    @JsonProperty
    public String getId() {
        return id;
    }

    @JsonProperty
    public String getName() {
        return name;
    }

    @JsonProperty
    public String getDescription() {
        return description;
    }

    @JsonProperty
    public List<Role> getRoles() {
        return roles;
    }

    public void addRole(Role r) {
        roles.add(r);
    }
}
