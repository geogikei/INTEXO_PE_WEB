package com.ralandison;

import com.sun.org.apache.xml.internal.security.algorithms.SignatureAlgorithm;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/authentication")
//@Stateless
public class AuthenticationEndpoint {

    //@EJB
    private UserResource userResource;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response authenticateUser(@FormParam("username") String username, @FormParam("password") String password) {

        try {

            // Authenticate the user using the credentials provided
            //authenticate(username, password);
            userResource.authenticate(username,password);

            // Issue a token for the user
            String token = issueToken(username);

            // Return the token on the response
            return Response.ok(token).build();

        } catch (Exception e) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }
    }

    private void authenticate(String username, String password) throws Exception{
        // Authenticate against a database, LDAP, file or whatever
        // Throw an Exception if the credentials are invalid
        userResource.authenticate(username,password);
    }

    private String issueToken(String username) {
        // Issue a token (can be a random String persisted to a database or a JWT token)
        // The issued token must be associated to a user
        // Return the issued token

        //The JWT signature algorithm we will be using to sign the token
        //SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        return "";
    }

    //Sample method to construct a JWT
    private String createJWT(String username, String password) {

        /*
        String jwt = Jwts.builder()
                .setSubject("users/TzMUocMF4p")
                .setExpiration(new Date(1300819380))
                .claim("name", "Robert Token Man")
                .claim("scope", "self groups/admins")
                .signWith(
                        SignatureAlgorithm.HS256,
                        "secret".getBytes("UTF-8")
                )
                .compact();
        //Builds the JWT and serializes it to a compact, URL-safe string
        return builder.compact();
        */
        return "";
    }

}