package com.ralandison;

import com.ralandison.utility.CORSResponseFilter;
import org.glassfish.jersey.server.ResourceConfig;

public class MyApplication extends ResourceConfig {

    /**
     * Register JAX-RS application components.
     */
    public MyApplication () {
        register(CORSResponseFilter.class);
    }
}
