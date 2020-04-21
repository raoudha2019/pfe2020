package com.telnet.qcm.service;

import com.telnet.qcm.entities.Permission;
import com.telnet.qcm.entities.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;
import java.util.List;

public interface UserService {

    public List<User> getAll();
    public void saveUser(@RequestBody User user);
    public void removeuser( @PathVariable("id") Long id) ;
    public void updateuser( @PathVariable("id") Long id) ;
    public User getuserbyid(Long id);
    public Collection<Permission> getPermbyUsername(String firstname);
    public User findUserByfirstname(String firstname);
    public List<User> findUserByEmail(String email);
    public User findByUsername(String username);

    // public List<User> findUserByRole (Long id);


}