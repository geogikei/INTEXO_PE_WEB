package com.ralandison;

import com.ralandison.model.User;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.sql.SQLException;
import java.util.List;

import static java.util.Collections.singletonList;

@Path("/user")
@Produces("application/json")
public class UserResource extends ResourceBase<User, Integer> {

    public UserResource() {
        super(User.class);
    }

    @Override
    protected List getTixQuery() throws SQLException, NamingException {
        return null;
    }

    @Override
    protected List getSingleQuery(int id) throws NamingException {
        return null;
    }

    @Override
    protected void createQuery(User user) throws SQLException, NamingException {

    }

    @Override
    protected void deleteQuery(int id) throws SQLException, NamingException {

    }

    @Override
    protected void updateQuery(User user, int id) throws SQLException, NamingException {

    }
}