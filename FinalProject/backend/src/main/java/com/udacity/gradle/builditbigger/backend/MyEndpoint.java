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
    @ApiMethod(name = "tellMeAJoke", httpMethod= ApiMethod.HttpMethod.GET)
    public MyEndPointJokes getAJoke(){
        MyEndPointJokes reply = new MyEndPointJokes();
        String joke = com.example.jokes.MyJokes.getGEJoke();
        reply.setData(joke);
        return  reply;
    }
}
