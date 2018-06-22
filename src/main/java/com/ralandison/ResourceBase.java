package com.ralandison;

import com.ralandison.model.User;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.naming.NamingException;
import javax.persistence.*;
import javax.transaction.SystemException;
import javax.transaction.Transactional;
import javax.transaction.UserTransaction;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;

@Produces("application/json")
public abstract class ResourceBase<T,K> {

    protected Class clazz;

    @PersistenceContext(name= "intexopedb_pu")
    protected EntityManager em;

    protected abstract List getTixQuery() throws SQLException, NamingException;
    protected abstract List getSingleQuery(int id) throws NamingException;
    protected abstract void createQuery(T t) throws SQLException, NamingException;
    protected abstract void deleteQuery(int id) throws SQLException, NamingException;
    protected abstract void updateQuery(T t, int id) throws SQLException, NamingException;


    /********************* CONSTRUCTOR *******************/
    public ResourceBase() { }
    public ResourceBase(Class clazz) { this.clazz = clazz; }

    /************** GETTERS & SETTERS ********************/
    public EntityManager getEm() { return em; }
    public void setEm(EntityManager em) { this.em = em; }


    /***************************** CREATE *****************************************/
    public void create(T t) throws SystemException {
        try{
            //utx.begin();
            em.persist(t);
            //utx.commit();
        }
        catch(Exception ex) {
            //utx.rollback(); //envoi une systeme exception
        }
    }

    public void insertTix(T t) throws NamingException, SQLException {
        createQuery(t);
    }

    /***************************** READ *****************************************/
    public  T readByKey(Class<T> t,K key) { return em.find(t,key); }

    @GET
    public List<T> readAll() {
        Query query = em.createNativeQuery("SELECT * FROM "+clazz.getSimpleName().toUpperCase(), clazz);
        query.getResultList().forEach(result -> System.out.println(((User) result).getRole().getRole()));
        return query.getResultList();
    }

    //@GET
    public List<T> getList() throws SQLException, NamingException {
        List records = getTixQuery();
        return records;
    }

    @GET
    @Path("{id}")
    public List<T> getSingle(@PathParam("id") int id) throws NamingException {
        List records = getSingleQuery(id);
        return records;
    }

    /**************************** UPDATE *****************************************/
    @Transactional
    public void update(T t) { em.merge(t); }

    /**************************** DELETE *****************************************/
    public void delete(T t) {
        em.remove(t);
    }


}