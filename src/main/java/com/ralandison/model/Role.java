package com.ralandison.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.eclipse.persistence.oxm.annotations.XmlInverseReference;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.List;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String role;

    @OneToMany(mappedBy="role", fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    //@JsonManagedReference("group-user")
    @XmlElement
    @XmlInverseReference(mappedBy="role")
    private List<User> users;


    public Role() { }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
