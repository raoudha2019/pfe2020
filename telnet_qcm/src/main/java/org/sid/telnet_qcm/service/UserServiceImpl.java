package org.sid.telnet_qcm.service;

import org.sid.telnet_qcm.dao.UserRepository;
import org.sid.telnet_qcm.entities.Permission;
import org.sid.telnet_qcm.entities.User;
import org.sid.telnet_qcm.entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;
import java.util.List;


@Service("personservice")
public class UserServiceImpl implements UserService {

   @Autowired
   UserRepository personrepository;

    @Override
    public List<User> getAll() {
        return personrepository.findAll();
    }

    @Override
    public void saveUser(User user) {
    personrepository.save(user);
    }

    @Override
    public void removeuser(@PathVariable("id") Long id) {
        User user = personrepository.getOne(id);
        personrepository.delete(user);
    }

    @Override
    public void updateuser(Long id) {

    }

    @Override
    public User getuserbyid(Long id) {
        return personrepository.getOne(id);
    }

    @Override
    public Collection<Permission> getPermbyUsername(String firstname) {
        User user = personrepository.findUserByfirstname(firstname);
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

        return personrepository.findUserByfirstname(firstname);

    }
}
