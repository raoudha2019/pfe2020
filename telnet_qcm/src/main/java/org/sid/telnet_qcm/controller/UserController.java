package org.sid.telnet_qcm.controller;
import org.sid.telnet_qcm.dao.UserRepository;
import org.sid.telnet_qcm.entities.Permission;
import org.sid.telnet_qcm.entities.User;
import org.sid.telnet_qcm.entities.Role;
import org.sid.telnet_qcm.service.UserService;
import org.sid.telnet_qcm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/Person")
public class UserController {


    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleservice;


    @RequestMapping(value="/login",method= RequestMethod.POST)
    public User findUserBynamepass(@RequestBody User u)  {
        return  userRepository.findUserBynamepass(u.getFirstname(),u.getPassword());
    }


    @RequestMapping(value="/addPerson/{Roleid}",method=RequestMethod.POST)
    public void saveUser(@RequestBody User user, @PathVariable("Roleid")Long id) {
        Role role = roleservice.getRolebyid(id);
        user.setRole(role);
        userService.saveUser(user);

    }


    @RequestMapping(value=("/allPersons"),method=RequestMethod.GET)
    public List<User> getAll() {
        return userService.getAll();
    }

    @RequestMapping(value=("/getPersonsByID/{id}"),method=RequestMethod.GET)
    public User getuserbyid(@PathVariable("id") Long id) {
        return userService.getuserbyid(id);
    }

    @RequestMapping(value=("/getPermByFirstname"),method=RequestMethod.GET)
    public Collection<Permission> getPermbyUsername(@RequestBody User u) {
        User user = userRepository.findUserByfirstname(u.getFirstname());
        Role role = user.getRole();
        return role.getPermissions();
    }


    @RequestMapping(value=("/getRoleByFirstname"),method=RequestMethod.GET)
    public Role getUsername(@RequestBody User u) {
        User user = userRepository.findUserByfirstname(u.getFirstname());
        return  user.getRole();
    }}
