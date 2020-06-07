package com.telnet.qcm.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Permission implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "permissions")
    private Collection<Role> roles;

    @JsonIgnore
    @ManyToOne
    private PermissionGroup permissionGroup;
    public Permission() {
        super();

    }

    public Permission(Long id, String name, Collection<Role> roles, PermissionGroup permissionGroup) {
        super();
        this.id = id;
        this.name = name;
        this.roles = roles;
        this.permissionGroup = permissionGroup;

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



    public Collection<Role> getRoles() {
        return roles;
    }
    @ManyToMany(mappedBy = "permissions")
    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    public PermissionGroup getPermissionGroup()
    {
        return permissionGroup;
    }
    public void setPermissionGroup(PermissionGroup permissionGroup)
    {
        this.permissionGroup = permissionGroup;
    }






    }

