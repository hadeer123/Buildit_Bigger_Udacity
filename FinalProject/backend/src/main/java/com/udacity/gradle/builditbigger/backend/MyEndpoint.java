package com.udacity.gradle.builditbigger.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import javax.inject.Named;

/** An endpoint class we are exposing */
@Api(
        name = "jokesApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "joking.all.the.time.com",
                ownerName = "Hadeer.khalifa.com",
                packagePath = ""
        )
)


public class MyEndpoint {
    /** A simple endpoint method that takes a name and says Hi back */
    @ApiMethod(name = "sayHi")
    public MyEndPointJokes sayHi(@Named("name") String name) {
        MyEndPointJokes response = new MyEndPointJokes();
        response.setData("Hi, " + name);
        return response;
    }


    @ApiMethod(name = "tellMeAJoke", httpMethod= ApiMethod.HttpMethod.GET)
    public MyEndPointJokes getAJoke(){
        MyEndPointJokes reply = new MyEndPointJokes();
        String joke = com.example.jokes.MyJokes.getGEJoke();
        reply.setData(joke);
        return  reply;
    }
}
