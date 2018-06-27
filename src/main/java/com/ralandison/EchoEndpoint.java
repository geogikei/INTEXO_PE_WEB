package com.ralandison;

import com.ralandison.model.User;

import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import static com.ralandison.utility.MainUtility.guavaHash;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.TEXT_HTML;

@Path("/echo")
@Stateless
public class EchoEndpoint {

    @PersistenceContext(unitName = "intexopedb_pu")
    EntityManager em;

    @GET
    @Path("auth")
    @Produces(TEXT_HTML)
    public Response echo(@QueryParam("username") String username, @QueryParam("password") String password) {
        try {
            Query query = em.createNativeQuery("SELECT * FROM USER where userName=?1 AND password=?2", User.class);
            query.setParameter(1, username);
            query.setParameter(2, guavaHash(password));
            System.out.println("username : " + username + " | password : " + password);
            User u = ((User) query.getSingleResult());
            //return Response.ok().entity(username == null ? "erreur connexion" : username).build();
            return Response.status(Response.Status.ACCEPTED).entity(u.getUserName()+" vous etes loge!").build();
        } catch (NoResultException nre){
            return Response.status(Response.Status.FORBIDDEN).entity("Erreur login/mot de passe").build();
        }
    }

    @GET
    @Path("jwt")
    //@JWTTokenNeeded
    public Response echoWithJWTToken(@QueryParam("message") String message) {
        return Response.ok().entity(message == null ? "no message" : message).build();
    }
}