package com.hank.hello.app;

import com.hank.hello.config.HelloWorldConfiguration;
import com.hank.hello.health.TemplateHealthCheck;
import com.hank.hello.resource.HelloWorldResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Created by Hank on 5/27/2017.
 * Application is main class of DW.
 * Need override run method: new a Jersey instance and register it to environment
 */
public class HelloWorldApplication extends Application<HelloWorldConfiguration> {

    public static void main(String[] args) throws Exception {
        new HelloWorldApplication().run(args);
    }

    @Override
    public String getName() {
        return "hello-dw";
    }

    @Override
    public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap) {
        //
    }

    @Override
    public void run(HelloWorldConfiguration helloWorldConfiguration, Environment environment) throws Exception {
        final HelloWorldResource resource = new HelloWorldResource(
                helloWorldConfiguration.getTemplate(),
                helloWorldConfiguration.getDefaultName()
        );
        final TemplateHealthCheck healthCheck = new TemplateHealthCheck(helloWorldConfiguration.getTemplate());
        environment.healthChecks().register("template", healthCheck);
        environment.jersey().register(resource);
    }
}
