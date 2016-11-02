package AdminService;/*
 * Created by reg on 02/11/2016.
 */

import com.fasterxml.jackson.annotation.JsonProperty;

public class Role {
    protected static int nextId = 0;
    private String id;
    private String name;
    private String description;

    public Role() {
        //required for jackson?
    }

    public Role(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Role(String name, String description) {
        this.id = generateId();
        this.name = name;
        this.description = description;
    }

    protected synchronized String generateId() {
        return this.getClass().toString() + "." + nextId++;
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
}
