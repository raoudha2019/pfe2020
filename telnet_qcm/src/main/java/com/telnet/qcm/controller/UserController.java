package com.telnet.qcm.controller;

import com.telnet.qcm.dao.UserRepository;
import com.telnet.qcm.entities.Permission;
import com.telnet.qcm.entities.Role;
import com.telnet.qcm.entities.User;
import com.telnet.qcm.service.RoleService;
import com.telnet.qcm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;
import java.util.Collection;
import java.util.List;

//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@CrossOrigin("*")
@RestController
@RequestMapping("/Utilisateur")
public class UserController {


    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleservice;
   private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserController(UserRepository userRepository,
                          BCryptPasswordEncoder bCryptPasswordEncoder) {
       this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
/*
      @RequestMapping(value="/login",method= RequestMethod.POST)
    public User findUserBynamepass(@RequestBody User u)  {

        return  userRepository.findUserBynamepass(u.getFirstname(),u.getPassword());
    }

     @RequestMapping(value="/login",method= RequestMethod.POST)
    public User findUserBynamepass (@RequestBody User u)  {

        return  userRepository.findUserBynamepass (u.getFirstname(),u.getPassword());
    }
*/



    // find by userName

    @RequestMapping(value="/auth",method=RequestMethod.GET)

    public User findUserByfirstname(Authentication auth) {
        auth = SecurityContextHolder.getContext().getAuthentication();
        String user = auth.getName();
        return userService.findUserByfirstname(user);

    }
    @GetMapping("/perissionByuserame")
    public List<Permission> PermissionUsername(Authentication auth) {

        auth = SecurityContextHolder.getContext().getAuthentication();

        String user = auth.getName();
        System.out.println(userService.findUserByfirstname(user)==null);
        return (List<Permission>) userService.findUserByfirstname(user);

    }

    @RequestMapping(value="/addUser/{Roleid}",method=RequestMethod.POST)
    public ResponseEntity<User> saveUser(@RequestBody User user, @PathVariable("Roleid")Long id) throws ValidationException {
        Role role =roleservice.getRolebyid(id);
       user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        user.setRole(role);
        if( user.getFirstname().isEmpty() )
        {
            throw new ValidationException(" Firstname is mondatery ");
        }
        if ( user.getLastname().isEmpty()){
            throw new ValidationException(" Lastname is mondatery ");
        }
        if ( user.getEmail().isEmpty()){
            throw new ValidationException(" Email is mondatery ");
        }
        if ( user.getPassword().isEmpty()){
            throw new ValidationException(" Password is mondatery ");
        }
        List<User> uuser = userRepository.findUserByEmail(user.getEmail());
        if ( uuser.size()>0){
            throw new ValidationException("user alredy exist");
        }
        else {
            userService.saveUser(user);
            return (ResponseEntity.ok(user));
        } }
    @RequestMapping(value=("/allPersons"),method=RequestMethod.GET)
    public List<User> getAll() {
        return userService.getAll();
    }

    @RequestMapping(value=("/getPersonsByID/{id}"),method=RequestMethod.GET)
    public User getuserbyid(@PathVariable("id") Long id)
    {
        return userService.getuserbyid(id);
    }

    @RequestMapping(value=("/getPermByFirstname"),method=RequestMethod.GET)
    public Collection<Permission> getPermbyUsername(@RequestBody User u) {
        User user = userRepository.findUserByfirstname(u.getFirstname());
        Role role = user.getRole();
        return role.getPermissions();
    }





    @RequestMapping(value="/deleteUser/{id}",method=RequestMethod.DELETE)
    public void removeuser(@PathVariable("id") Long id) {
        User user = userService.getuserbyid(id);
        if(user.getFirstname().equals("abc") ) {
            System.out.println("you can't");
        }
        else {
           userService.removeuser(id);
        }
        }



    @RequestMapping(value="/updateUser/{id}",method=RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable long id) throws ValidationException {
        user.setId(id);
       user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        if (user.getFirstname().isEmpty()) {
            throw new ValidationException("Firstname is mondatery ");
            // return (HttpStatus.NOT_FOUND);
        }
        if (user.getLastname().isEmpty()) {
            throw new ValidationException("Lastname is mondatery ");
            // return (HttpStatus.NOT_FOUND);
        }
        if (user.getEmail().isEmpty()  ) {
            throw new ValidationException("Email is mondatery ");
            // return (HttpStatus.NOT_FOUND);
        }
        if (user.getPassword().isEmpty()) {
            throw new ValidationException(" Password is mondatery ");
            // return (HttpStatus.NOT_FOUND);
        }
        List<User> uuser = userRepository.findUserByEmail(user.getEmail());
        if ( uuser.size()> 1) {
            throw new ValidationException("user alerdy exist!");}
         if(user.getRole()== null){
             throw new ValidationException("role is mondatery ");
         }
         else {
            userService.saveUser(user);
            return (ResponseEntity.ok(user));

        }
    }


 /*   @RequestMapping(value=("/getPersonsByEmail"),method=RequestMethod.GET)
    public Role getuserbyEmail(@RequestBody User u)
    {
       List< User >user = userRepository.findUserByEmail(u.getEmail());
        return user.getRole();
    }
*/

    @RequestMapping(value=("/getRoleByFirstname"),method=RequestMethod.GET)
    public Role getUsername(@RequestBody User u) {
        User user = userRepository.findUserByfirstname(u.getFirstname());
        return  user.getRole();
    }

   /* @RequestMapping(value = ("/getuserbyrole/{Roleid}"),method=RequestMethod.GET)
    public List<User> getuserbyrole(@PathVariable( "Roleid") Long id )

    {  Role role = roleservice.getRolebyid(id);
       List<User> listuser = userRepository.findUserByRole(role.getId());
           return listuser;
    }*/


}
