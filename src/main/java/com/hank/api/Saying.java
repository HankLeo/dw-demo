package com.hank.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

/**
 * Created by Hank on 6/12/2017.
 */
public class Saying {

    private long id;

    // Java Bean will check the length of content
    @Length(max = 3)
    private String content;

    public Saying() {
        // Jackson deserialization
    }

    public Saying(long id, String content) {
        this.id = id;
        this.content = content;
    }

    // Jackson will map the java object to json file
    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getContent() {
        return content;
    }
}

/**
 * RFC 1149
 * {
 *     "id": 1,
 *     "content": "Hi!"
 * }
 */