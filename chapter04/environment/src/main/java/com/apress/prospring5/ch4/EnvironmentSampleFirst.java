package com.apress.prospring5.ch4;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;

import java.util.HashMap;
import java.util.Map;

public class EnvironmentSampleFirst {

    public static void main(String... args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.refresh();

        ConfigurableEnvironment env = ctx.getEnvironment();
        MutablePropertySources propertySources = env.getPropertySources();

        Map<String,Object> appMap = new HashMap<>();
        appMap.put("user.home", "application_home");

        propertySources.addFirst(new MapPropertySource("prospring5_MAP", appMap));

        System.out.println("System user.home: " + System.getProperty("user.home"));
        System.out.println("System JAVA_HOME: " + System.getenv("JAVA_HOME"));

        System.out.println("Env user.home: " + env.getProperty("user.home"));
        System.out.println("Env JAVA_HOME: " + env.getProperty("JAVA_HOME"));

        System.out.println("application.home: " + env.getProperty("application.home"));

        ctx.close();
    }
}

