package AdminService;/*
 * Created by reg on 04/11/2016.
 */

import com.fasterxml.jackson.annotation.JsonProperty;

public class IdNameDescription {
    protected static int nextId = 0;
    protected String id;
    protected String name;
    protected String description;

    public IdNameDescription() {
        //required for jackson?
    }

    public IdNameDescription(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public IdNameDescription(String name, String description) {
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
