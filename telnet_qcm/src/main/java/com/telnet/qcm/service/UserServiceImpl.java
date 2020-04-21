package com.telnet.qcm.service;

import com.telnet.qcm.dao.UserRepository;
import com.telnet.qcm.entities.Permission;
import com.telnet.qcm.entities.Role;
import com.telnet.qcm.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;
import java.util.List;


@Service("userservice")
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userrepository;

    @Override
    public List<User> getAll() {
        return userrepository.findAll();
    }

    @Override
    public void saveUser(User user) {
        userrepository.save(user);
    }

  /*  @Override
    public User findUserByRole(Long id)
    {
        return userRepository.findUserByRole(Role.getId());
    }*/
    /**
     * @param id
     */
    @Override
    public void removeuser(@PathVariable("id") Long id) {
        User user = userrepository.getOne(id);
        userrepository.delete(user);

    }

    @Override
    public void updateuser(Long id) {

    }

    @Override
    public User getuserbyid(Long id) {
        return userrepository.getOne(id);
    }




    @Override
    public Collection<Permission> getPermbyUsername(String firstname) {
        User user = userrepository.findUserByfirstname(firstname);
        Role role = user.getRole();
        return role.getPermissions();
    }

   /*@Override
    public Collection<Permission> getPermbyUsername(String firstname) {
        User user = personrepository.findUserByfirstname(firstname);
        Role role = user.getRole();
        return role.getPermissions();
    }*/

    @Override
    public User findUserByfirstname(String firstname) {

        return userrepository.findUserByfirstname(firstname);

    }

    @Override
    public List <User> findUserByEmail(String email) {
        return userrepository.findUserByEmail(email);

    }

    @Override
    public User findByUsername(String username) {
        return userrepository.findByUsername(username);
    }

   /* @Override
    public List <User>  findByUsername(String username) {
        return userrepository.findByUsername(username);

    }*/

    public List<Permission> findPermissionByUsername(String username){
        User user = (User) userrepository.findByUsername(username);
        return (List<Permission>) user.getRole().getPermissions();
    }




  /*  @Override
    public List <User> findUserByRole(Long id) {
        return userrepository.findUserByRole(id);
    }*/





}