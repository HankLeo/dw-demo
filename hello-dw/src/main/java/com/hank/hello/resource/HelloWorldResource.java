package com.hank.hello.resource;

import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;
import com.hank.hello.api.Saying;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Hank on 6/12/2017.
 * This is a Jersey resource. It handles http request and return an API instance.
 * Finally it writes the API to json format as response(this needs to add JsonProperty annotation for api variables).
 * Make api restful.
 */
// url of web service
@Path("/hello-dw")
// convert api instance to json format
@Produces(MediaType.APPLICATION_JSON)    // Content-Type: application/json
public class HelloWorldResource {

    private final String template;
    private final String defaultName;
    private final AtomicLong counter;

    public HelloWorldResource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();    // thread safe long
    }

    @GET    // http request method
    @Timed
    public Saying sayHello(@QueryParam("name") Optional<String> name) {    // request optional param
        final String content = String.format(template, name.or(defaultName));
        return new Saying(counter.incrementAndGet(), content);
    }
}
