/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fastserve.aawp.api;

import io.swagger.annotations.Contact;
import io.swagger.models.Info;
import io.swagger.annotations.License;
import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.models.Swagger;
import io.swagger.models.auth.In;
import java.util.Set;
import javax.inject.Inject;
import javax.ws.rs.core.Application;
import org.glassfish.hk2.api.ServiceLocator;

/**
 *
 * @author user
 */
@javax.ws.rs.ApplicationPath("api")
public class ApplicationConfig extends Application {

    @Inject
    public ApplicationConfig(ServiceLocator serviceLocator) {

        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.2");
        beanConfig.setBasePath("/aawp-api/api");
        beanConfig.setResourcePackage("com.fastserve.aawp.api");
        beanConfig.setPrettyPrint(true);
        io.swagger.models.auth.ApiKeyAuthDefinition apikey = new io.swagger.models.auth.ApiKeyAuthDefinition();
        apikey.setName("Authorization");
        apikey.setIn(In.HEADER);
        beanConfig.getSwagger().securityDefinition("api_key", apikey);

        Info info = new Info()
            .title("Swagger Sample App")
            .description("This is a sample server Petstore server.  You can find out more about Swagger " +
                "at <a href=\"http://swagger.io\">http://swagger.io</a> or on irc.freenode.net, #swagger.  For this sample, " +
                "you can use the api key \"special-key\" to test the authorization filters")
            .termsOfService("http://helloreverb.com/terms/");
            

        Swagger swagger = new Swagger().info(info);
        swagger.securityDefinition("api_key", apikey);

        beanConfig.configure(swagger);
        beanConfig.setScan(true);
        

    }

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        //Swagger entries
        resources.add(io.swagger.jaxrs.listing.ApiListingResource.class);
        resources.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);

        addRestResourceClasses(resources);
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.fasterxml.jackson.jaxrs.base.JsonMappingExceptionMapper.class);
        resources.add(com.fasterxml.jackson.jaxrs.base.JsonParseExceptionMapper.class);
        resources.add(com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider.class);
        resources.add(com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider.class);
        resources.add(com.fasterxml.jackson.jaxrs.json.JsonMappingExceptionMapper.class);
        resources.add(com.fasterxml.jackson.jaxrs.json.JsonParseExceptionMapper.class);
        resources.add(com.fastserve.aawp.api.GenericResource.class);
        resources.add(com.fastserve.aawp.api.GenericResource2.class);
        resources.add(io.swagger.jaxrs.listing.AcceptHeaderApiListingResource.class);
        resources.add(io.swagger.jaxrs.listing.ApiListingResource.class);
        resources.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);
        
    }

}
