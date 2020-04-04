package org.sid.telnet_qcm.controller;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.data.repository.query.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;



import org.sid.telnet_qcm.entities.Permission;
import org.sid.telnet_qcm.entities.Role;
import org.sid.telnet_qcm.entities.User;

import org.sid.telnet_qcm.service.PermissionService;
import org.sid.telnet_qcm.service.UserService;
import org.sid.telnet_qcm.service.RoleService;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/Role")
public class RoleController {

    @Autowired
    RoleService roleservice;
    @Autowired
    PermissionService permissionService;
    @Autowired
    UserService userService;


    @RequestMapping(value=("/allRoles"),method= RequestMethod.GET)
    public List<Role> getAllroles()
    {
        return roleservice.getAllroles();
    }




    @RequestMapping(value=("/oneRole/{id}"),method=RequestMethod.GET)
    public Role getrole(@PathVariable("id") Long id) {
        return roleservice.getRolebyid(id);
    }


    @RequestMapping(value="/deleteRole/{id}",method=RequestMethod.DELETE)
    public void removerole(@PathVariable("id") Long id) {
        Role role=roleservice.getRolebyid(id);
        if(role.getName().equals("Administrateur")) {
            System.out.println("you can't");
        }
        else {
            roleservice.removerole(id);
        }
    }


    @RequestMapping(value="/addRolee",method=RequestMethod.POST)
    public void saveRolee(@RequestBody Role role){
        roleservice.saveRole(role);
    }

    @RequestMapping(value="/updateRole/{id}",method=RequestMethod.PUT)
    public void updateRole(@RequestBody Role role, @PathVariable long id) {
        role.setId(id);
        roleservice.saveRole(role);


    }


    @RequestMapping(value="/addRole",method=RequestMethod.POST)
    public void saveRole(@Param(value = "id") long [] id, @RequestBody Role role){

        List<Permission> permission = new ArrayList<Permission>();
        for (int i = 0; i < id.length; i++) {

            Permission perm = permissionService.getpermissionbyid(id[i]);
            permission.add(perm);
        }
        role.setPermissions(permission);
        roleservice.saveRole(role);
    }

}
