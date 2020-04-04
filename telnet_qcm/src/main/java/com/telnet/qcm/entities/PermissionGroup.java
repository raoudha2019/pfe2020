package com.telnet.qcm.entities;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class PermissionGroup implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     *
     */
    private String name;


    @OneToMany(mappedBy="permissionGroup")
    private List<Permission> permission;

    public PermissionGroup(Long id, String name, List<Permission> permission) {
        this.id = id;
        this.name = name;
        this.permission = permission;
    }

    public PermissionGroup() {
        super();
        // TODO Auto-generated constructor stub
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

    public List<Permission> getpermission() {
        return permission;
    }

    public void setPremission(List<Permission> premission)
    {
        this.permission = permission;
    }



}
