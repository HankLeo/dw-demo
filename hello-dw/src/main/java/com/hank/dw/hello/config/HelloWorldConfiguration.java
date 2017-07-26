package com.hank.dw.hello.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by Hank on 5/27/2017.
 * When this class is deserialized from the YAML file,
 * it will pull two root-level fields from the YAML object: template and defaultName
 *
 * The mapping from YAML to your application’s Configuration instance is done by Jackson.
 * This means your Configuration class can use all of Jackson’s object-mapping annotations.
 * (http://wiki.fasterxml.com/JacksonAnnotations)
 *
 * The validation of @NotEmpty is handled by Hibernate Validator.
 */
public class HelloWorldConfiguration extends Configuration{

    @NotEmpty
    private String template;

    @NotEmpty
    private String defaultName = "Stranger";

    /**
     * @JsonProperty allows Jackson to both deserialize the properties from a YAML file but also to serialize it
     * @return
     */
    @JsonProperty
    public String getTemplate() {
        return template;
    }

    @JsonProperty
    public void setTemplate(String template) {
        this.template = template;
    }

    @JsonProperty
    public String getDefaultName() {
        return defaultName;
    }

    @JsonProperty
    public void setDefaultName(String defaultName) {
        this.defaultName = defaultName;
    }

}
