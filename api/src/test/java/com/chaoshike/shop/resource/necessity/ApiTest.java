package com.chaoshike.shop.resource.necessity;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.DeploymentContext;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.ServletDeploymentContext;
import org.glassfish.jersey.test.grizzly.GrizzlyWebTestContainerFactory;
import org.glassfish.jersey.test.spi.TestContainerException;
import org.glassfish.jersey.test.spi.TestContainerFactory;
import org.springframework.web.context.ContextLoaderListener;

import javax.ws.rs.core.Application;


public class ApiTest extends JerseyTest {
    @Override
    protected DeploymentContext configureDeployment() {
        return ServletDeploymentContext.builder(configure())
                .contextPath("/")
                .contextParam("contextConfigLocation", "classpath:applicationContext.xml,classpath:applicationContext-test.xml")
                .contextParam("contextClass", "com.chaoshike.shop.resource.necessity.MockableContext")
                .servletClass(org.glassfish.jersey.servlet.ServletContainer.class)
                .initParam("com.sun.jersey.api.json.POJOMappingFeature", "true")
                .initParam("jersey.config.server.provider.scanning.recursive", "true")
                .initParam("jersey.config.server.provider.packages", "com.chaoshike.shop.resource;org.codehaus.jackson.jaxrs")
                .addListener(ContextLoaderListener.class)
                .build();
    }
    @Override
    protected TestContainerFactory getTestContainerFactory() throws TestContainerException {
        return new GrizzlyWebTestContainerFactory();
    }

    @Override
    protected Application configure() {
        return new ResourceConfig().packages(true, "com.chaoshike.shop.resource");
    }
}
