package com.hank.dw.hello.health;

import com.codahale.metrics.health.HealthCheck;

/**
 * Created by Hank on 6/13/2017.
 * This is healthcheck of out-of-the-box operational tools.
 * All of which can be found on the admin port(8081 by default).
 * Check output result of template.
 */
public class TemplateHealthCheck extends HealthCheck {

    private final String template;

    public TemplateHealthCheck(String template) {
        this.template = template;
    }

    @Override
    protected Result check() throws Exception {
        final String saying = String.format(template, "TEST");
        if (!saying.contains("TEST")) {
            return Result.unhealthy("template doesn't include a name");
        }
        return Result.healthy();
    }
}
