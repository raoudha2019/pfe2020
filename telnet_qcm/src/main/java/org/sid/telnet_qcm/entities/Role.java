package org.sid.telnet_qcm.entities;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.*;


@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Role implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy="role", cascade = CascadeType.REMOVE)
    private List<User> users;

    @ManyToMany
    @JoinTable(
            name = "roles_permissions",

            joinColumns = @JoinColumn (name = "role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id", referencedColumnName = "id"))

    private Collection<Permission> permissions;

    public Role(final String name) {
        super();
        this.name = name;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Collection<Permission> permissions) {
        this.permissions = permissions;
    }

    @JsonIgnore
    public List<User> getUsers() {
        return users;
    }



    @OneToMany(mappedBy="role", cascade = CascadeType.REMOVE)
    public void setUsers(List<User> people) {
        this.users = users;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public Role() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Role(Long id, String name, String description, List<User> users, Collection<Permission> permissions) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.users = users;
        this.permissions = permissions;
    }
}



