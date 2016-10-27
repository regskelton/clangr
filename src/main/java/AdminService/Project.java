package AdminService;

import com.fasterxml.jackson.annotation.JsonProperty;

/*
 * Created by reg on 26/10/2016.
 */
public class Project {
    private String id;
    private String name;
    private String description;

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

    public Project() {
        // Jackson deserialization
    }

    public Project(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
