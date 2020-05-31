package com.telnet.qcm.controller;

import com.telnet.qcm.dao.UserRepository;
import com.telnet.qcm.entities.Permission;
import com.telnet.qcm.entities.Role;
import com.telnet.qcm.entities.User;
import com.telnet.qcm.exception.ValidationException;
import com.telnet.qcm.service.PermissionService;
import com.telnet.qcm.service.RoleService;
import com.telnet.qcm.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.repository.query.Param;
import org.springframework.beans.factory.annotation.Autowired;

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
    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = ("/allRoles"), method = RequestMethod.GET)
    public List<Role> getAllroles() {
        return roleservice.getAllroles();
    }


    @RequestMapping(value = ("/oneRole/{id}"), method = RequestMethod.GET)
    public Role getrole(@PathVariable("id") Long id) {
        return roleservice.getRolebyid(id);
    }

    @RequestMapping(value = ("/getRolebyname"), method = RequestMethod.GET)
    public Role getrolebyname(@PathVariable("name") String name) {
        return roleservice.getRoleByName(name);
    }


    /**
     * @param role
     */
    @RequestMapping(value = "/addRolee", method = RequestMethod.POST)
    public ResponseEntity<Role> saveRolee(@RequestBody Role role) throws ValidationException {
        if (role.getName().isEmpty()) {
            throw new ValidationException("Role name is mondatery ");
            // return (HttpStatus.NOT_FOUND);
        }
        if (role.getPermissions().isEmpty()) {
            throw new ValidationException("Role Permission is mondatery");
            // return (HttpStatus.NOT_FOUND);
        }
        Role rolee = roleservice.getRoleByName(role.getName());

        if (rolee != null) {
            throw new ValidationException("Role alredy exist");
            // return (HttpStatus.NOT_FOUND);
        }

        roleservice.saveRole(role);

        return (ResponseEntity.ok(role));
    }

    @RequestMapping(value = "/updateRole/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Role> updateRole(@RequestBody Role role, @PathVariable long id) throws ValidationException {
        role.setId(id);

        if (role.getName().isEmpty()) {
            throw new ValidationException("Role name is mondatery ");
            // return (HttpStatus.NOT_FOUND);
        }
        if (role.getPermissions().isEmpty()) {
            throw new ValidationException("Role Permission is mondatery");
            // return (HttpStatus.NOT_FOUND);
        }
        Role rolee = roleservice.getRoleByName(role.getName());

       /* if (rolee != null  ) {
            throw new ValidationException("Role alredy exist");

        }*/

        roleservice.saveRole(role);

        return (ResponseEntity.ok(role));


    }


    /**
     * @param id
     * @param role
     */
    @RequestMapping(value = "/addRole", method = RequestMethod.POST)
    public void saveRole(@Param(value = "id") long[] id, @RequestBody Role role) {

        List<Permission> permission = new ArrayList<Permission>();
        for (int i = 0; i < id.length; i++) {

            Permission perm = permissionService.getpermissionbyid(id[i]);
            permission.add(perm);
        }
        role.setPermissions(permission);
        roleservice.saveRole(role);
    }

    @RequestMapping(value = "/deleteRole/{id}", method = RequestMethod.DELETE)
    public void removerole(@PathVariable("id") Long id) throws ValidationException {
 /*  User user = userService.getuserbyid(id);
     List<User> listuser = userRepository.findUserByRole(id);

     if ( listuser.size() > 0) {
            throw new ValidationException("Role is alreday used ");
        }*/
        roleservice.removerole(id);
      //return (ResponseEntity.ok());
    }

    @RequestMapping(value="/getuser/{Roleid}",method=RequestMethod.GET)
    public List<User> getUsers(@RequestBody User client, @PathVariable("Roleid")Long id) {
        Role role = roleservice.getRolebyid(id);
        return role.getUsers() ;

    }







}



